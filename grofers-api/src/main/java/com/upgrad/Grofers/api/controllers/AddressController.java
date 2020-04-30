package com.upgrad.Grofers.api.controllers;

import com.upgrad.Grofers.api.*;
import com.upgrad.Grofers.service.business.AddressService;
import com.upgrad.Grofers.service.business.CustomerAddressService;
import com.upgrad.Grofers.service.business.CustomerService;
import com.upgrad.Grofers.service.entity.AddressEntity;
import com.upgrad.Grofers.service.entity.CustomerAddressEntity;
import com.upgrad.Grofers.service.entity.CustomerEntity;
import com.upgrad.Grofers.service.entity.StateEntity;
import com.upgrad.Grofers.service.exception.AddressNotFoundException;
import com.upgrad.Grofers.service.exception.AuthorizationFailedException;
import com.upgrad.Grofers.service.exception.SaveAddressException;
import com.upgrad.Grofers.service.exception.SignUpRestrictedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

public class AddressController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private CustomerAddressService customerAddressService;

    /**
     * A controller method to save an address in the database.
     *
     * @body SaveAddressRequest - This argument contains all the attributes required to store address details in the database.
     * @param authorization - A field in the request header which contains the JWT token.
     * @return - ResponseEntity<SaveAddressResponse> type object along with Http status CREATED.
     * @throws AuthorizationFailedException
     * @throws SaveAddressException
     * @throws AddressNotFoundException
     */

    /**
     * A controller method to delete an address from the database.
     *
     * @param addressId    - The uuid of the address to be deleted from the database.
     * @param authorization - A field in the request header which contains the JWT token.
     * @return - ResponseEntity<DeleteAddressResponse> type object along with Http status OK.
     * @throws AuthorizationFailedException
     * @throws AddressNotFoundException
     */

    /**
     * A controller method to get all address from the database.
     *
     * @param authorization - A field in the request header which contains the JWT token.
     * @return - ResponseEntity<AddressListResponse> type object along with Http status OK.
     * @throws AuthorizationFailedException
     */

    @RequestMapping(method = RequestMethod.POST, path = "/address", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<SaveAddressResponse> saveAddress(final SaveAddressRequest saveAddressRequest, @RequestHeader("authorization") final String authorization)
            throws SaveAddressException, AuthorizationFailedException, AddressNotFoundException, SignUpRestrictedException {

        String[] bearerToken = authorization.split("Bearer ");
        final CustomerEntity customerEntity = customerService.getCustomer(bearerToken[1]);
        final StateEntity stateEntity = addressService.getStateByUUID(saveAddressRequest.getStateUuid());
        final AddressEntity addressEntity = new AddressEntity();
        final CustomerAddressEntity customerAddressEntity = new CustomerAddressEntity();

        addressEntity.setUuid(UUID.randomUUID().toString());
        addressEntity.setFlatBuilNo(saveAddressRequest.getFlatBuildingName());
        addressEntity.setLocality(saveAddressRequest.getLocality());
        addressEntity.setCity(saveAddressRequest.getCity());
        addressEntity.setPinCode(saveAddressRequest.getPincode());
        addressEntity.setState(stateEntity);
        customerAddressEntity.setAddress(addressEntity);


        final AddressEntity savedAddressEntity = addressService.saveAddress(addressEntity, customerAddressEntity);

        List<CustomerAddressEntity> customerAddressEntities = new ArrayList<>();
        customerAddressEntity.setCustomer(customerEntity);
        customerAddressEntity.setAddress(savedAddressEntity);
        final CustomerEntity savedCustomerAddressEntity = customerService.saveCustomer(customerEntity);
        customerAddressEntities.add(customerAddressEntity);
        customerAddressService.saveCustomerAddress(customerAddressEntity);

        SaveAddressResponse saveAddressResponse = new SaveAddressResponse()
                .id(customerEntity.getUuid())
                .status("ADDRESS SUCCESSFULLY REGISTERED");
        return new ResponseEntity<>(saveAddressResponse, HttpStatus.CREATED);

    }


    @RequestMapping(method = RequestMethod.DELETE, path = "address/{addressId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<DeleteAddressResponse> deleteAddress(@PathVariable("addressId") final String addressID, @RequestHeader("authorization") final String authorization)
            throws AuthorizationFailedException, AddressNotFoundException {

        String[] bearerToken = authorization.split("Bearer ");
        final CustomerEntity signedinCustomerEntity = customerService.getCustomer(bearerToken[1]);
        final AddressEntity addressEntityToDelete = addressService.getAddressByUUID(addressID, signedinCustomerEntity);
        final String Uuid = addressService.deleteAddress(addressEntityToDelete, authorization);

        DeleteAddressResponse deleteAddressResponse = new DeleteAddressResponse()
                .id(UUID.fromString(Uuid))
                .status("ADDRESS DELETED SUCCESSFULLY");
        return new ResponseEntity<DeleteAddressResponse>(deleteAddressResponse, HttpStatus.OK);

    }

    //getallsavedaddresses endpoint retrieves all the addresses of a valid customer present in the database
    @RequestMapping(method = RequestMethod.GET, path = "/address/customer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<AddressListResponse> getAddressByUUID(@RequestHeader("authorization") final String authorization) throws AuthorizationFailedException {

        String[] bearerToken = authorization.split("Bearer ");
        final CustomerEntity customerEntity = customerService.getCustomer(bearerToken[1]);
        final List<CustomerAddressEntity> customerAddressEntities = addressService.getAllAddress(customerEntity);

        List<AddressEntity> addressEntities = new ArrayList<>();
        for (CustomerAddressEntity customerAddressEntity : customerAddressEntities) {
            AddressEntity addressEntitiy = customerAddressEntity.getAddress();
            addressEntities.add(addressEntitiy);
        }

        Comparator<AddressEntity> compareBySavedTime = new Comparator<AddressEntity>() {
            @Override
            public int compare(AddressEntity a1, AddressEntity a2) {
                return a1.getId().compareTo(a2.getId());
            }
        };
        Collections.sort(addressEntities, compareBySavedTime);


        AddressListResponse addressListResponse = new AddressListResponse();

        for (AddressEntity address : addressEntities) {
            AddressList addressList = new AddressList();
            addressList.id(UUID.fromString(address.getUuid()));
            addressList.flatBuildingName(address.getFlatBuilNo());
            addressList.locality(address.getLocality());
            addressList.pincode(address.getPinCode());
            addressList.city(address.getCity());

            AddressListState addressListState = new AddressListState();
            addressListState.id(UUID.fromString(address.getState().getUuid()));
            addressListState.stateName(address.getState().getStateName());

            addressList.state(addressListState);

            addressListResponse.addAddressesItem(addressList);
        }

        return new ResponseEntity<AddressListResponse>(addressListResponse, HttpStatus.OK);
    }
}

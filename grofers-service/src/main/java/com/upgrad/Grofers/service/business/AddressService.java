package com.upgrad.Grofers.service.business;


import com.upgrad.Grofers.service.entity.AddressEntity;
import com.upgrad.Grofers.service.entity.CustomerAddressEntity;
import com.upgrad.Grofers.service.entity.CustomerEntity;
import com.upgrad.Grofers.service.entity.StateEntity;
import com.upgrad.Grofers.service.exception.AddressNotFoundException;
import com.upgrad.Grofers.service.exception.AuthorizationFailedException;
import com.upgrad.Grofers.service.exception.SaveAddressException;

import java.util.List;

/*
 * This AddressService interface gives the list of all the service that exist in the address service implementation class.
 * Controller class will be calling the service methods by this interface.
 */
public interface AddressService {

    AddressEntity saveAddress(AddressEntity addressEntity, CustomerAddressEntity customerAddressEntity) throws
            SaveAddressException;

    AddressEntity getAddressByUUID(String addressId, CustomerEntity customerEntity) throws AuthorizationFailedException, AddressNotFoundException;

    String deleteAddress(AddressEntity addressEntity, String authorization) throws AuthorizationFailedException;

    List<CustomerAddressEntity> getAllAddress(CustomerEntity customer);

    StateEntity getStateByUUID(String uuid) throws AddressNotFoundException, SaveAddressException;
}

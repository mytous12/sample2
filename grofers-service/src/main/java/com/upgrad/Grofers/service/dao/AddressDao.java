package com.upgrad.Grofers.service.dao;


import com.upgrad.Grofers.service.entity.AddressEntity;
import com.upgrad.Grofers.service.entity.CustomerAddressEntity;
import com.upgrad.Grofers.service.entity.CustomerEntity;
import com.upgrad.Grofers.service.entity.StateEntity;

import java.util.List;

/*
 * This AddressDao interface gives the list of all the dao methods that exist in the address dao implementation class.
 * Service class will be calling the dao methods by this interface.
 */
public interface AddressDao {

    AddressEntity saveAddress(AddressEntity addressEntity);

    AddressEntity getAddressByUUID(String addressId);

    CustomerAddressEntity getCustomerByAddress(String addressId);

    CustomerAddressEntity saveCustomerAddress(CustomerAddressEntity customerAddressEntity);

    String deleteAddress(AddressEntity addressEntity);

    List<AddressEntity> getAllAddress(CustomerEntity customer);

    StateEntity getStateByUUID(String uuid);
}

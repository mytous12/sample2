package com.upgrad.Grofers.service.dao;


import com.upgrad.Grofers.service.entity.CustomerAuthEntity;
import com.upgrad.Grofers.service.entity.CustomerEntity;

/*
 * This CustomerDao interface gives the list of all the dao methods that exist in the customer dao implementation class.
 * Service class will be calling the dao methods by this interface.
 */
public interface CustomerDao {

    CustomerEntity saveCustomer(CustomerEntity customerEntity);
    CustomerEntity getCustomerByContactNumber(String customername);
    CustomerAuthEntity createCustomerAuth(CustomerAuthEntity customerAuthEntity);
    CustomerAuthEntity getCustomerAuthByAccesstoken(String accesstoken);
    CustomerAuthEntity updateCustomerAuth(CustomerAuthEntity customerAuthEntity);
    CustomerEntity updateCustomer(CustomerEntity customerEntity);
    CustomerEntity getCustomerById(final String uuid);
}

package com.upgrad.Grofers.service.business;

import com.upgrad.Grofers.service.dao.CustomerAddressDao;
import com.upgrad.Grofers.service.entity.CustomerAddressEntity;
import com.upgrad.Grofers.service.exception.SaveAddressException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerAddressService {

    @Autowired
    private CustomerAddressDao customerAddressDao;


    @Transactional(propagation = Propagation.REQUIRED)
    public CustomerAddressEntity saveCustomerAddress(final CustomerAddressEntity customerAddressEntity) throws SaveAddressException {
        return customerAddressDao.createCustomerAddress(customerAddressEntity);
    }

}

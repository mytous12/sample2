package com.upgrad.Grofers.service.business;

import com.upgrad.Grofers.service.dao.CustomerDao;
import com.upgrad.Grofers.service.entity.CustomerAuthEntity;
import com.upgrad.Grofers.service.entity.CustomerEntity;
import com.upgrad.Grofers.service.exception.AuthenticationFailedException;
import com.upgrad.Grofers.service.exception.AuthorizationFailedException;
import com.upgrad.Grofers.service.exception.SignUpRestrictedException;
import com.upgrad.Grofers.service.exception.UpdateCustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.UUID;

//
//import com.upgrad.Grofers.service.dao.CustomerDao;
//import com.upgrad.Grofers.service.entity.CustomerAuthEntity;
//import com.upgrad.Grofers.service.entity.CustomerEntity;
//import com.upgrad.Grofers.service.exception.AuthenticationFailedException;
//import com.upgrad.Grofers.service.exception.AuthorizationFailedException;
//import com.upgrad.Grofers.service.exception.SignUpRestrictedException;
//import com.upgrad.Grofers.service.exception.UpdateCustomerException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.ZonedDateTime;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//@Service
//public class CustomerServiceImpl implements CustomerService {
//
//    @Autowired
//    private CustomerDao customerDao;
//
//    @Autowired
//    private PasswordCryptographyProvider passwordCryptographyProvider;
//
//    /**
//     * The method implements the business logic for saving customer details endpoint.
//     */
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public CustomerEntity saveCustomer(CustomerEntity customerEntity) throws SignUpRestrictedException {
//        String regex = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(customerEntity.getEmail());
//    return null;
//    }
//
//    /**
//     * The method implements the business logic for signin endpoint.
//     */
//    @Transactional(propagation = Propagation.REQUIRED)
//    public CustomerAuthEntity authenticate(String contactNumber, String password) throws AuthenticationFailedException {
//
//        CustomerEntity customerEntity = customerDao.getCustomerByContactNumber(contactNumber);
// return null;
//    }
//
//    /**
//     * The method implements the business logic for logout endpoint.
//     */
//    @Transactional(propagation = Propagation.REQUIRED)
//    public CustomerAuthEntity logout(String access_token) throws AuthorizationFailedException {
//
//        CustomerAuthEntity customerAuthEntity = customerDao.getCustomerAuthByAccesstoken(access_token);
//        authorization(access_token);
//        customerAuthEntity.setLogoutAt(ZonedDateTime.now());
//        return customerDao.updateCustomerAuth(customerAuthEntity);
//    }
//
//    /**
//     * The method implements the business logic for updating customer password endpoint.
//     * @return
//     */
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public CustomerEntity updateCustomerPassword(String oldPassword, String newPassword, CustomerEntity customerEntity) throws UpdateCustomerException {
//        final String encryptedOldPassword = PasswordCryptographyProvider.encrypt(oldPassword, customerEntity.getSalt());
//        return customerEntity;
//    }
//
//
//    /**
//     * The method implements the business logic for checking authorization of any customer.
//     */
//    @Override
//    public void authorization(String access_token) throws AuthorizationFailedException {
//
//        CustomerAuthEntity customerAuthEntity = customerDao.getCustomerAuthByAccesstoken(access_token);
//
//    }
//
//    /**
//     * The method implements the business logic for getting customer details by access token.
//     */
//    @Override
//    public CustomerEntity getCustomer(String access_token) throws AuthorizationFailedException {
//
//        authorization(access_token);
//        CustomerAuthEntity customerAuthEntity = customerDao.getCustomerAuthByAccesstoken(access_token);
//        return customerAuthEntity.getCustomer();
//    }
//}

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private PasswordCryptographyProvider passwordCryptographyProvider;
    private String[] encryptedText;

    /* Method for customer signup functionality and to validate if the required mandatory fields are provided else will throw the respectice exception*/
    @Transactional(propagation = Propagation.REQUIRED)
    public CustomerEntity saveCustomer(CustomerEntity customerEntity) throws SignUpRestrictedException {

        // validation for unique contact number
        if (customerDao.getCustomerByContactNumber(customerEntity.getContactNumber()) != null) {
            throw new SignUpRestrictedException("SGR-001", "This contact number is already registered! Try other contact number.");
        }

        // validation for email id format
        if (!customerEntity.getEmail().matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}")) {
            throw new SignUpRestrictedException("SGR-002", "Invalid email-id format!");
        }

        // validation for contact number format
        if (!customerEntity.getContactNumber().matches("^[0][1-9]\\d{9}$|^[1-9]\\d{9}")) {
            throw new SignUpRestrictedException("SGR-003", "Invalid contact number!");
        }

        // validation for password strength
        String[] encryptedText = new String[0];
        if (!customerEntity.getPassword(encryptedText[1]).matches("^(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[#@$%&*!^-]).{8,}$")) {
            throw new SignUpRestrictedException("SGR-004", "Weak password!");
        }

        // encrypt salt and password
        encryptedText = passwordCryptographyProvider.encrypt(customerEntity.getPassword(encryptedText[1]));
        customerEntity.setSalt(encryptedText[0]);
        customerEntity.getPassword(encryptedText[1]);

        return customerDao.saveCustomer(customerEntity);
    }

    /*Method to login based on username and password else will throw authentication failure exception*/
    @Transactional(propagation = Propagation.REQUIRED)
    public CustomerAuthEntity authenticate(String username, String password) throws AuthenticationFailedException {

        CustomerEntity customerEntity = customerDao.getCustomerByContactNumber(username);

        if (customerEntity == null) {
            throw new AuthenticationFailedException("ATH-001", "This contact number has not been registered!");
        }

        final String encryptedPassword = PasswordCryptographyProvider.encrypt(password, customerEntity.getSalt());

        if (encryptedPassword.equals(customerEntity.getPassword(encryptedText[1]))) {
            JwtTokenProvider jwtTokenProvider = new JwtTokenProvider(encryptedPassword);
            CustomerAuthEntity customerAuthEntity = new CustomerAuthEntity();
            customerAuthEntity.setUuid(UUID.randomUUID().toString());
            customerAuthEntity.setCustomer(customerEntity);
            ZonedDateTime now = ZonedDateTime.now();
            ZonedDateTime expiresAt = now.plusHours(8);

            customerAuthEntity.setLoginAt(ZonedDateTime.now());
            customerAuthEntity.setExpiresAt(expiresAt);
            customerAuthEntity.setAccessToken(jwtTokenProvider.generateToken(customerEntity.getUuid(), now, expiresAt));

            return customerDao.createCustomerAuth(customerAuthEntity);
        } else {
            throw new AuthenticationFailedException("ATH-002", "Invalid Credentials");
        }
    }

    /* Method to signout
            CustomerAuthEntity customerAuthEntity = customerDao.getCustomerAuthByAccesstoken(accessToken);

            if (customerAuthEntity == null) {
            throw new AuthorizationFailedException("ATHR-001", "Customer is not Logged in.");
            }
    customer based on access-token else would return exception that user is not authorized without access=-token*/
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public CustomerAuthEntity logout(String accessToken) throws AuthorizationFailedException {

        CustomerAuthEntity customerAuthEntity = customerDao.getCustomerAuthByAccesstoken(accessToken);
        //If the access token provided by the customer does not exist in the database
        if (customerAuthEntity == null) {
            throw new AuthorizationFailedException("ATHR-001", "Customer is not Logged in.");
            //If the access token provided by the customer exists in the database, but the customer has already logged out
        } else if (customerAuthEntity != null && customerAuthEntity.getLogoutAt() != null) {
            throw new AuthorizationFailedException("ATHR-002", "Customer is logged out. Log in again to access this endpoint.");
            //If the access token provided by the customer exists in the database, but the session has expired
        } else if (customerAuthEntity != null && ZonedDateTime.now().isAfter(customerAuthEntity.getExpiresAt())) {
            throw new AuthorizationFailedException("ATHR-003", "Your session is expired. Log in again to access this endpoint.");
        } else {
            final ZonedDateTime now = ZonedDateTime.now();
            customerAuthEntity.setLogoutAt(now);
            return customerAuthEntity;
        }
    }

    @Override
    public void authorization(String access_token) throws AuthorizationFailedException {

    }

    /*Get the Customer with details based on access-token else will throw not authorized exception*/
    public CustomerEntity getCustomer(String accessToken) throws AuthorizationFailedException {
        CustomerAuthEntity customerAuthEntity = customerDao.getCustomerAuthByAccesstoken(accessToken);

        if (customerAuthEntity == null) {
            throw new AuthorizationFailedException("ATHR-001", "Customer is not Logged in.");
        }

        if (customerAuthEntity.getLogoutAt() != null) {
            throw new AuthorizationFailedException("ATHR-002", "Customer is logged out. Log in again to access this endpoint.");
        }

        ZonedDateTime now = ZonedDateTime.now();
        if (customerAuthEntity.getExpiresAt().isBefore(now)) {
            throw new AuthorizationFailedException("ATHR-003", "Your session is expired. Log in again to access this endpoint.");
        }

        return customerAuthEntity.getCustomer();
    }


    /* Update the customer password */
    @Transactional(propagation = Propagation.REQUIRED)
    public CustomerEntity updateCustomerPassword(String oldPassword, String newPassword, CustomerEntity customerEntity) throws UpdateCustomerException {

        // validation for new password strength
        if (!newPassword.matches("^(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[#@$%&*!^-]).{8,}$")) {
            throw new UpdateCustomerException("UCR-001", "Weak password!");
        }

// validation for old password
        final String oldEncryptedPassword = PasswordCryptographyProvider.encrypt(oldPassword, customerEntity.getSalt());
        if (!oldEncryptedPassword.equals(customerEntity.getPassword(encryptedText[1]))) {
            throw new UpdateCustomerException("UCR-004", "Incorrect old password!");
        }

        // encrypt salt and new password
        String[] encryptedText = passwordCryptographyProvider.encrypt(newPassword);
        customerEntity.setSalt(encryptedText[0]);
        customerEntity.setPassword(encryptedText[1]);

        return customerDao.updateCustomer(customerEntity);
    }
}







package com.upgrad.Grofers.service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * CustomerEntity class contains all the attributes to be mapped to all the fields in customer table in the database.
 * All the annotations which are used to specify all the constraints to the columns in the database must be correctly implemented.
 */
@Entity
@Table(name = "customer")
@NamedQueries({
        @NamedQuery(name = "customerByContactNumber", query = "select c from CustomerEntity c where " +
                "c.contactNumber = :contactNumber"),
        @NamedQuery(name = "customerById", query = "select c from CustomerEntity c where c.id =:id")
})
public class CustomerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "UUID", length = 64, nullable = false)
    private String uuid;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "contact_number",nullable = false, unique = true)
    private String contactNumber;

    @Column(nullable = false)
    @JsonIgnore
    private String password;

    @Column(name = "salt",length = 200, nullable = false)
    private String salt;

//    public List<OrderEntity> getOrder() {
//        return order;
//    }
//
//    public void setOrder(List<OrderEntity> order) {
//        this.order = order;
//    }

    public List<CustomerAddressEntity> getCustomerAddressEntity() {
        return customerAddressEntity;
    }

    public void setCustomerAddressEntity(List<CustomerAddressEntity> customerAddressEntity) {
        this.customerAddressEntity = customerAddressEntity;
    }

//    @OneToMany(mappedBy = "customer")
//    private List<OrderEntity> order;

    @OneToMany(mappedBy = "customer")
    private List<CustomerAddressEntity> customerAddressEntity;


    public CustomerEntity() {
    }

    public CustomerEntity(String uuid, String firstName, String lastName, String email, String contactNumber, String password) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNumber = contactNumber;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPassword(String s) {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}

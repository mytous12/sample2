package com.upgrad.Grofers.service.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * AddressEntity class contains all the attributes to be mapped to all the fields in address table in the database.
 * All the annotations which are used to specify all the constraints to the columns in the database must be correctly implemented.
 */
@Entity
@Table(name = "address")
@NamedQueries({
        @NamedQuery(name = "getAllAddress", query = "select b from CustomerAddressEntity a inner join a.address b where " +
                "a.customer = :customer order by b.id desc"),
        @NamedQuery(name = "getAddressByUUID", query = "select b from CustomerAddressEntity a inner join a.address b where " +
                "b.uuid = :uuid")
})
public class AddressEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "UUID", length = 64, nullable = false)
    private String uuid;

    @Column(name = "FLAT_BUIL_NUMBER", nullable = false)
    private String flatBuilNo;

    @Column(name = "LOCALITY", nullable = false)
    private String locality;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "PINCODE", nullable = false)
    private String pincode;

    @OneToOne
    @NotNull
    private StateEntity state;

    public AddressEntity(String uuid, String flatBuilNo, String locality, String city, String pincode, StateEntity state) {
        this.uuid = uuid;
        this.flatBuilNo = flatBuilNo;
        this.locality = locality;
        this.city = city;
        this.pincode = pincode;
        this.state = state;
    }

    public AddressEntity() {
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

    public String getFlatBuilNo() {
        return flatBuilNo;
    }

    public void setFlatBuilNo(String flatBuilNo) {
        this.flatBuilNo = flatBuilNo;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinCode() {
        return pincode;
    }

    public void setPinCode(String pincode) {
        this.pincode = pincode;
    }

    public StateEntity getState() {
        return state;
    }

    public void setState(StateEntity state) {
        this.state = state;
    }

//    public List<CustomerAddressEntity> getCustomerAddressEntity() {
//        return customerAddressEntity;
//    }
//
//    public void setCustomerAddressEntity(List<CustomerAddressEntity> customerAddressEntity) {
//        this.customerAddressEntity = customerAddressEntity;
//    }
//
//    public List<OrderEntity> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(List<OrderEntity> orders) {
//        this.orders = orders;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        return new EqualsBuilder().append(this, obj).isEquals();
//    }
//
//    @Override
//    public int hashCode() {
//        return new HashCodeBuilder().append(this).hashCode();
//    }
//
//    @Override
//    public String toString() {
//        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
//    }


}

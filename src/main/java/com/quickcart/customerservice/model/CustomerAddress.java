package com.quickcart.customerservice.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Customer_address ")
public class CustomerAddress implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "city")
    private String city;

    @Column(name = "state_province")
    private String stateProvince;

    @Column(name = "postal_code")
    private String postalCode;

    public CustomerAddress() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerAddress(Long addressId, String streetAddress, String city, String stateProvince, String postalCode) {
        this.addressId = addressId;
        this.streetAddress = streetAddress;
        this.city = city;
        this.stateProvince = stateProvince;
        this.postalCode = postalCode;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }


    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}


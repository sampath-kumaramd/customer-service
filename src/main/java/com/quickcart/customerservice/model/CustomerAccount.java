package com.quickcart.customerservice.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "customer_account ")
public class CustomerAccount implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;

    public CustomerAccount() {
    }

    public CustomerAccount(Long accountId, String username, String password) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


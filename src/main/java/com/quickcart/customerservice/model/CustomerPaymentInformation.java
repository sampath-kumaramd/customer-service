package com.quickcart.customerservice.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Customer_payment_information")
public class CustomerPaymentInformation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "expiration_date")
    private Date expirationDate;

    public CustomerPaymentInformation() {

    }

    public CustomerPaymentInformation(Long paymentId, String customerId, String paymentMethod, String cardNumber, Date expirationDate) {
        this.paymentId = paymentId;
        this.paymentMethod = paymentMethod;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}


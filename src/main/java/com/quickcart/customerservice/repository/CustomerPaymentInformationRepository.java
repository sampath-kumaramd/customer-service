package com.quickcart.customerservice.repository;

import com.quickcart.customerservice.model.CustomerPaymentInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CustomerPaymentInformationRepository extends JpaRepository<CustomerPaymentInformation,Long> {

    void deletePaymentInformationByPaymentId(Long paymentId);
    Optional<CustomerPaymentInformation> findPaymentInformationByPaymentId(Long paymentId);

}
package com.quickcart.customerservice.service;

import com.quickcart.customerservice.exception.ItemNotFoundException;
import com.quickcart.customerservice.model.CustomerPaymentInformation;
import com.quickcart.customerservice.repository.CustomerPaymentInformationRepository;
import com.quickcart.customerservice.repository.CustomerPaymentInformationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerPaymentInformationService {
    private final com.quickcart.customerservice.repository.CustomerPaymentInformationRepository customerPaymentInformationRepository;

    @Autowired
    public CustomerPaymentInformationService(CustomerPaymentInformationRepository customerPaymentInformationRepository) {
        this.customerPaymentInformationRepository= customerPaymentInformationRepository;
    }

    public CustomerPaymentInformation addPaymentInformation(CustomerPaymentInformation CustomerPaymentInformation){
        return customerPaymentInformationRepository.save(CustomerPaymentInformation);
    }

    public List<CustomerPaymentInformation> findAllCustomerPaymentInformation(){
        return customerPaymentInformationRepository.findAll();
    }
    public CustomerPaymentInformation Address(CustomerPaymentInformation CustomerPaymentInformation){
        return customerPaymentInformationRepository.save(CustomerPaymentInformation);
    }
    public CustomerPaymentInformation findCustomerPaymentInformationByCustomerPaymentInformationId(Long paymentId){
        return customerPaymentInformationRepository.findPaymentInformationByPaymentId(paymentId)
                .orElseThrow(()-> new ItemNotFoundException(" Address  by id"+ paymentId + "was not found"));
    }

    public CustomerPaymentInformation updateCustomerPaymentInformation(CustomerPaymentInformation CustomerPaymentInformation){
        return customerPaymentInformationRepository.save(CustomerPaymentInformation);
    }
    @Transactional
    public void deleteCustomerPaymentInformationByPaymentId(Long id){
        customerPaymentInformationRepository.deletePaymentInformationByPaymentId(id);
    }
}
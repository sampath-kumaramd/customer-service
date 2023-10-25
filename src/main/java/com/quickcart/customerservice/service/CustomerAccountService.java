package com.quickcart.customerservice.service;

import com.quickcart.customerservice.exception.ItemNotFoundException;
import com.quickcart.customerservice.model.Customer;
import com.quickcart.customerservice.model.CustomerAccount;
import com.quickcart.customerservice.repository.CustomerAccountRepository;
import com.quickcart.customerservice.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerAccountService {
    private final com.quickcart.customerservice.repository.CustomerAccountRepository CustomerAccountRepository;
    private final com.quickcart.customerservice.repository.CustomerRepository CustomerRepository;
    @Autowired
    public CustomerAccountService(CustomerAccountRepository customerAccountRepository , CustomerRepository customerRepository) {
        this.CustomerAccountRepository= customerAccountRepository;
        this.CustomerRepository = customerRepository;
    }
    public Customer findCustomerByCustomerId(Long id){
        return CustomerRepository.findCustomerByCustomerId(id)
                .orElseThrow(()-> new ItemNotFoundException(" customer by id"+ id + "was not found"));
    }
    public CustomerAccount addCustomerAccount(CustomerAccount customerAccount , Long id){
        customerAccount.setCustomer(findCustomerByCustomerId(id));
        return CustomerAccountRepository.save(customerAccount);
    }

    public List<CustomerAccount> findAllCustomerAccounts(){
        return CustomerAccountRepository.findAll();
    }
    public CustomerAccount Account(CustomerAccount customerAccount){
        return CustomerAccountRepository.save(customerAccount);
    }
    public CustomerAccount findCustomerAccountByAccountId(Long AccountId){
        return CustomerAccountRepository.findCustomerAccountByAccountId(AccountId)
                .orElseThrow(()-> new ItemNotFoundException(" Account  by id"+ AccountId + "was not found"));
    }

    public CustomerAccount updateCustomerAccount(CustomerAccount customerAccount){
        return CustomerAccountRepository.save(customerAccount);
    }
    @Transactional
    public void deleteCustomerAccountById(Long id){
        CustomerAccountRepository.deleteCustomerAccountByAccountId(id);
    }
}
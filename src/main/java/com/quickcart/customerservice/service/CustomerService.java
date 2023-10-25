package com.quickcart.customerservice.service;

import com.quickcart.customerservice.exception.ItemNotFoundException;
import com.quickcart.customerservice.model.Customer;
import com.quickcart.customerservice.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final com.quickcart.customerservice.repository.CustomerRepository CustomerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.CustomerRepository= customerRepository;
    }

    public Customer addCustomer(Customer customer){
        return CustomerRepository.save(customer);
    }

    public List<Customer> findAllCustomers(){
        return CustomerRepository.findAll();
    }
    public Customer updateCustomer(Customer customer){
        return CustomerRepository.save(customer);
    }
    public Customer findCustomerByCustomerId(Long id){
        return CustomerRepository.findCustomerByCustomerId(id)
                .orElseThrow(()-> new ItemNotFoundException(" customer by id"+ id + "was not found"));
    }
//    public Optional<Customer> getCustomerWithAddresses(Long customerId) {
//        return CustomerRepository.findByIdWithAddresses(customerId);
//    }
    @Transactional
    public void deleteCustomerById(Long id){
        CustomerRepository.deleteCustomerByCustomerId(id);
    }
}
package com.quickcart.customerservice.service;

import com.quickcart.customerservice.exception.ItemNotFoundException;
import com.quickcart.customerservice.model.Customer;
import com.quickcart.customerservice.model.CustomerAddress;
import com.quickcart.customerservice.repository.CustomerAddressRepository;
import com.quickcart.customerservice.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerAddressService {
    private final com.quickcart.customerservice.repository.CustomerAddressRepository CustomerAddressRepository;
    private final com.quickcart.customerservice.repository.CustomerRepository CustomerRepository;

    @Autowired
    public CustomerAddressService(CustomerAddressRepository customerAddressRepository , CustomerRepository customerRepository) {
        this.CustomerAddressRepository= customerAddressRepository;
        this.CustomerRepository = customerRepository;
    }
    public Customer findCustomerByCustomerId(Long id){
        return CustomerRepository.findCustomerByCustomerId(id)
                .orElseThrow(()-> new ItemNotFoundException(" customer by id"+ id + "was not found"));
    }

    public CustomerAddress addCustomerAddress(CustomerAddress customerAddress ,Long id){
        customerAddress.setCustomer(findCustomerByCustomerId(id));
        return CustomerAddressRepository.save(customerAddress);
    }

    public List<CustomerAddress> findAllCustomerAddresss(){
        return CustomerAddressRepository.findAll();
    }
    public CustomerAddress Address(CustomerAddress customerAddress){
        return CustomerAddressRepository.save(customerAddress);
    }
    public CustomerAddress findCustomerAddressByCustomerAddressId(Long AddressId){
        return CustomerAddressRepository.findCustomerAddressByAddressId(AddressId)
                .orElseThrow(()-> new ItemNotFoundException(" Address  by id"+ AddressId + "was not found"));
    }

    public CustomerAddress updateCustomerAddress(CustomerAddress customerAddress){
        return CustomerAddressRepository.save(customerAddress);
    }
    @Transactional
    public void deleteCustomerAddressById(Long id){
        CustomerAddressRepository.deleteCustomerAddressByAddressId(id);
    }
}
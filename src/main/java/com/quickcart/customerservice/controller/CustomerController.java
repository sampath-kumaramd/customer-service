package com.quickcart.customerservice.controller;

import com.quickcart.customerservice.model.Customer;
import com.quickcart.customerservice.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.findAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerByCustomerId(@PathVariable("id") Long customerId) {
        Customer customer = customerService.findCustomerByCustomerId(customerId);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomerById(@PathVariable("id") Long customerId, @RequestBody Customer customer) {
        Customer existingCustomer = customerService.findCustomerByCustomerId(customerId);

        if (existingCustomer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setEmailAddress(customer.getEmailAddress());
        existingCustomer.setPhoneNumber(customer.getPhoneNumber());

        Customer updatedCustomer = customerService.updateCustomer(existingCustomer);

        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable("id") Long customerId) {
        Customer existingCustomer = customerService.findCustomerByCustomerId(customerId);

        if (existingCustomer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        customerService.deleteCustomerById(customerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


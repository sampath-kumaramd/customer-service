package com.quickcart.customerservice.controller;

import com.quickcart.customerservice.model.Customer;
import com.quickcart.customerservice.model.CustomerAddress;
import com.quickcart.customerservice.service.CustomerAddressService;
import com.quickcart.customerservice.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerAddressController {
    private final CustomerAddressService customerAddressService;
    private final CustomerService customerService;

    public CustomerAddressController(CustomerAddressService customerAddressService , CustomerService customerService) {
        this.customerAddressService = customerAddressService;
        this.customerService = customerService;
    }

    @GetMapping("/customer-Address")
    public ResponseEntity<List<CustomerAddress>> getAllCustomerAddress() {
        List<CustomerAddress> customerAddress = customerAddressService.findAllCustomerAddresss();
        return new ResponseEntity<>(customerAddress, HttpStatus.OK);
    }

    @GetMapping("/customer-Address/{id}")
    public ResponseEntity<CustomerAddress> getCustomerAddressByCustomerId(@PathVariable("id") Long AddressId) {
        CustomerAddress customerAddress = customerAddressService.findCustomerAddressByCustomerAddressId(AddressId);

        if (customerAddress == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customerAddress, HttpStatus.OK);
    }

    @PostMapping("/customer-Address/{id}")
    public ResponseEntity<CustomerAddress> createCustomerAddress(@RequestBody CustomerAddress customerAddress ,@PathVariable("id") Long id) {
        CustomerAddress newCustomerAddress = customerAddressService.addCustomerAddress(customerAddress ,id);
        return new ResponseEntity<>(newCustomerAddress, HttpStatus.CREATED);
    }

    @PutMapping("/customer-Address/{id}")
    public ResponseEntity<CustomerAddress> updateCustomerAddressByAddressId(@PathVariable("id") Long AddressId, @RequestBody CustomerAddress customerAddress) {
        CustomerAddress existingCustomerAddress = customerAddressService.findCustomerAddressByCustomerAddressId(AddressId);

        if (existingCustomerAddress == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        CustomerAddress updatedCustomerAddress = customerAddressService.updateCustomerAddress
(existingCustomerAddress
);

        return new ResponseEntity<>(updatedCustomerAddress, HttpStatus.OK);
    }

    @DeleteMapping("/customer-Address/{id}")
    public ResponseEntity<Void> deleteCustomerAddressByAddressId(@PathVariable("id") Long AddressId) {
        CustomerAddress existingCustomerAddress = customerAddressService.findCustomerAddressByCustomerAddressId(AddressId);

        if (existingCustomerAddress == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        customerAddressService.deleteCustomerAddressById(AddressId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


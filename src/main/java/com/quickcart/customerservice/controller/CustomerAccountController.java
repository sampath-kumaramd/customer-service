package com.quickcart.customerservice.controller;

import com.quickcart.customerservice.model.Customer;
import com.quickcart.customerservice.model.CustomerAccount;
import com.quickcart.customerservice.service.CustomerAccountService;
import com.quickcart.customerservice.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerAccountController {
    private final CustomerAccountService customerAccountService;

    public CustomerAccountController(CustomerAccountService customerAccountService) {
        this.customerAccountService = customerAccountService;
    }

    @GetMapping("/customer-account")
    public ResponseEntity<List<CustomerAccount>> getAllCustomerAccounts() {
        List<CustomerAccount> customerAccounts = customerAccountService.findAllCustomerAccounts();
        return new ResponseEntity<>(customerAccounts, HttpStatus.OK);
    }

    @GetMapping("/customer-account/{id}")
    public ResponseEntity<CustomerAccount> getCustomerAccountByCustomerId(@PathVariable("id") Long AccountId) {
        CustomerAccount customerAccount = customerAccountService.findCustomerAccountByAccountId(AccountId);

        if (customerAccount == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customerAccount, HttpStatus.OK);
    }

    @PostMapping("/customer-account/{id}")
    public ResponseEntity<CustomerAccount> createCustomerAccount(@RequestBody CustomerAccount customerAccount ,@PathVariable("id") Long id ) {
        CustomerAccount newCustomerAccount = customerAccountService.addCustomerAccount(customerAccount ,id);
        return new ResponseEntity<>(newCustomerAccount, HttpStatus.CREATED);
    }

    @PutMapping("/customer-account/{id}")
    public ResponseEntity<CustomerAccount> updateCustomerAccountByAccountId(@PathVariable("id") Long AccountId, @RequestBody CustomerAccount customerAccount) {
        CustomerAccount existingCustomerAccount = customerAccountService.findCustomerAccountByAccountId(AccountId);

        if (existingCustomerAccount == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        existingCustomerAccount.setPassword(customerAccount.getPassword());
        existingCustomerAccount.setUsername(customerAccount.getUsername());

        CustomerAccount updatedCustomerAccount = customerAccountService.updateCustomerAccount
(existingCustomerAccount
);

        return new ResponseEntity<>(updatedCustomerAccount, HttpStatus.OK);
    }

    @DeleteMapping("/customer-account/{id}")
    public ResponseEntity<Void> deleteCustomerAccountByAccountId(@PathVariable("id") Long AccountId) {
        CustomerAccount existingCustomerAccount = customerAccountService.findCustomerAccountByAccountId(AccountId);

        if (existingCustomerAccount == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        customerAccountService.deleteCustomerAccountById(AccountId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


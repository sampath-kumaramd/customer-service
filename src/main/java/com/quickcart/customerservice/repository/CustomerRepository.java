package com.quickcart.customerservice.repository;

import com.quickcart.customerservice.model.Customer;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface CustomerRepository extends JpaRepository<Customer,Long> {

    void deleteCustomerByCustomerId(Long customerId);
    Optional<Customer> findCustomerByCustomerId(Long customerId);


//    @Query("SELECT c FROM Customer c JOIN FETCH c.addresses WHERE c.customerId = :customerId")
//    Optional<Customer> findByIdWithAddresses(@Param("customerId") Long customerId);
}
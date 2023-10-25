package com.quickcart.customerservice.repository;

import com.quickcart.customerservice.model.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CustomerAddressRepository extends JpaRepository<CustomerAddress,Long> {

    void deleteCustomerAddressByAddressId(Long AddressId);
    Optional<CustomerAddress> findCustomerAddressByAddressId(Long AddressId);

}
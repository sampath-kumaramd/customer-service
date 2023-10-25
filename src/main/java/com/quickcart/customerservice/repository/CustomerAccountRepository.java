package com.quickcart.customerservice.repository;

import com.quickcart.customerservice.model.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface CustomerAccountRepository extends JpaRepository<CustomerAccount,Long> {

    void deleteCustomerAccountByAccountId(Long AccountId);
    Optional<CustomerAccount> findCustomerAccountByAccountId(Long AccountId);

}
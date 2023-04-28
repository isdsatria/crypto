package com.achsat.crypto.customer.repository;

import com.achsat.crypto.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findCustomerByEmail(String email);
    Customer findCustomerById(Integer id);
}

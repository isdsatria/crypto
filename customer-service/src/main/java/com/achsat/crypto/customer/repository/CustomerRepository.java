package com.achsat.crypto.customer.repository;

import com.achsat.crypto.customer.model.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Integer> {
}

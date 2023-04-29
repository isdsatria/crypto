package com.achsat.crypto.payment.repository;

import org.springframework.data.repository.CrudRepository;
import com.achsat.crypto.payment.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}

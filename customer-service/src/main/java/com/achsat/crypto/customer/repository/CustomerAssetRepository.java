package com.achsat.crypto.customer.repository;

import com.achsat.crypto.customer.model.Customer;
import com.achsat.crypto.customer.model.CustomerAssets;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerAssetRepository extends ReactiveCrudRepository<CustomerAssets, Integer> {

}

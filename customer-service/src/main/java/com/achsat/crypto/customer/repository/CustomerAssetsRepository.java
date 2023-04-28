package com.achsat.crypto.customer.repository;

import com.achsat.crypto.customer.model.CustomerAssets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


import java.util.List;

public interface CustomerAssetsRepository extends JpaRepository<CustomerAssets, Integer> {
    List<CustomerAssets> findByCustomerId(Integer customerId);
}

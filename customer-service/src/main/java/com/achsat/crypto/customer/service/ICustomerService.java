package com.achsat.crypto.customer.service;

import com.achsat.crypto.customer.model.Customer;
import com.achsat.crypto.customer.model.CustomerAssets;
import com.achsat.crypto.customer.model.dto.AssetDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICustomerService {

    Mono<Customer> findCustomerById();

    Flux<CustomerAssets> getAllCustomerAssets();

    Mono<Void> addNewAsset(AssetDTO dto);

    Mono<Void> updateExistingAsset(AssetDTO dto);

}

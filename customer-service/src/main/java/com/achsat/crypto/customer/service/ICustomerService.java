package com.achsat.crypto.customer.service;

import com.achsat.crypto.customer.model.Customer;
import com.achsat.crypto.customer.model.CustomerAssets;
import com.achsat.crypto.dto.AssetDTO;
import com.achsat.crypto.dto.CustomerDTO;


import java.util.List;

public interface ICustomerService {

    CustomerDTO findCustomerById(Integer id);

    CustomerDTO findCustomerByEmail(String email);

    void addNewCustomer(CustomerDTO dto);

}

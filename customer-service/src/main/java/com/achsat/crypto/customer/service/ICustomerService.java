package com.achsat.crypto.customer.service;

import com.achsat.crypto.entity.dto.CustomerDTO;

public interface ICustomerService {

    CustomerDTO findCustomerById(Integer id);

    CustomerDTO findCustomerByEmail(String email);

    void addNewCustomer(CustomerDTO dto);

}

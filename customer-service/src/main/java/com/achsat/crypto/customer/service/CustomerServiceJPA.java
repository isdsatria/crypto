package com.achsat.crypto.customer.service;

import com.achsat.crypto.customer.model.Customer;
import com.achsat.crypto.customer.repository.CustomerRepository;
import com.achsat.crypto.entity.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CustomerServiceJPA implements ICustomerService{

    @Autowired
    CustomerRepository custRepo;


    @Override
    public CustomerDTO findCustomerById(Integer id) {
        Customer cust =  custRepo.findCustomerById(id);
        return new CustomerDTO(cust.getId(), cust.getName(), cust.getEmail());
    };

    @Override
    public CustomerDTO findCustomerByEmail(String email) {
        Customer cust =  custRepo.findCustomerByEmail(email);
        return new CustomerDTO(cust.getId(), cust.getName(), cust.getEmail());
    }

    @Override
    public void addNewCustomer(CustomerDTO dto) {
        Customer cust = new Customer();
        cust.setName(dto.getName());
        cust.setEmail(dto.getEmail());

        custRepo.save(cust);
    }


}

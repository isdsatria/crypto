package com.achsat.crypto.customer.controller;

import com.achsat.crypto.customer.service.ICustomerService;
import com.achsat.crypto.entity.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    ICustomerService service;

    @GetMapping("/byid")
    public ResponseEntity<?> getCustomerById(@RequestParam Integer id ) {
        return ResponseEntity.ok(service.findCustomerById(id));
    }

    @GetMapping("/byemail")
    public ResponseEntity<?> getCustomerByEmail(@RequestParam String email ){
        return ResponseEntity.ok(service.findCustomerByEmail(email));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerDTO data){
        try{
            service.addNewCustomer(data);
            return ResponseEntity.ok("Success");

        } catch(Exception e){
            return ResponseEntity.ok("Process Failed");
        }
    }


}

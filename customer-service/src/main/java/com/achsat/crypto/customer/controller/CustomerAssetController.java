package com.achsat.crypto.customer.controller;

import com.achsat.crypto.customer.service.ICustomerAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("assets")
public class CustomerAssetController {

    @Autowired
    ICustomerAssetService service;

    @GetMapping("/bycust")
    public ResponseEntity<?> getCustomerAssets(@RequestParam Integer id){
        return ResponseEntity.ok(service.getAllCustomerAssets(id));
    }
}

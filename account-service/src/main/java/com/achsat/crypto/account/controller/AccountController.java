package com.achsat.crypto.account.controller;

import com.achsat.crypto.entity.model.CashAccount;
import com.achsat.crypto.entity.dto.TransactionDTO;
import com.achsat.crypto.account.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    private IAccountService service;

    @GetMapping("/inq/bo/all")
    //@PreAuthorize("#oauth2.hasScope('account-inquiry')")
    private ResponseEntity<Flux<CashAccount>> getAll(){
        return ResponseEntity.ok(service.getAllAccount());
    }

    @PostMapping("/fin/topup")
    private ResponseEntity<Mono<Void>> Topup(@RequestBody TransactionDTO txn){
        return ResponseEntity.ok(service.increaseBalance(txn.getAccountID(), txn.getAmount()));
    }

    @PostMapping("/fin/withdraw")
    private ResponseEntity<Mono<Void>> Withdraw(@RequestBody TransactionDTO txn){
        return ResponseEntity.ok(service.decreaseBalance(txn.getAccountID(), txn.getAmount()));
    }

}

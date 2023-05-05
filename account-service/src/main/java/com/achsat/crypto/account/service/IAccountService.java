package com.achsat.crypto.account.service;

import com.achsat.crypto.entity.model.CashAccount;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public interface IAccountService {

    Flux<CashAccount> getAllAccount();

    Mono<Void> increaseBalance(Integer accountId, BigDecimal amount );

    Mono<Void> decreaseBalance(Integer accountId, BigDecimal amount);

    /*
    Mono<Void> reserve(Order o);

    Mono<Void> confirm(Order o);
    */

    Mono<CashAccount> findAccountById(Integer id);
}

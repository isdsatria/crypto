package com.achsat.crypto.account.service;

import com.achsat.crypto.account.model.CashAccount;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public interface IAccountService {

    Flux<CashAccount> getAllAccount();

    Mono<Void> IncreaseBalance(Integer accountId, BigDecimal amount );

    Mono<Void> DecreaseBalance(Integer accountId, BigDecimal amount);

    Mono<CashAccount> findAccountById(Integer id);
}

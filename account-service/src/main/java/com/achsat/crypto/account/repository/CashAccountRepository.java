package com.achsat.crypto.account.repository;

import com.achsat.crypto.account.model.CashAccount;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface CashAccountRepository extends ReactiveCrudRepository<CashAccount, Integer> {

    Mono<CashAccount> findCashAccountByAccountId(Integer id);
    Mono<CashAccount> findCashAccountByCustomerId(Integer id);
}

package com.achsat.crypto.account.service;

import com.achsat.crypto.entity.model.CashAccount;
import com.achsat.crypto.entity.model.TransactionHistory;
import com.achsat.crypto.account.repository.CashAccountRepository;
import com.achsat.crypto.account.repository.TransactionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@Primary
public class AccountServiceR2DBC implements IAccountService {

    @Autowired
    private CashAccountRepository accountRepository;

    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;


    @Override
    public Flux<CashAccount> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    @Transactional
    public Mono<Void> increaseBalance(Integer accountId, BigDecimal amount) {

        LocalDateTime time = LocalDateTime.now();
        TransactionHistory txnObj = new TransactionHistory(accountId, "Credit", amount,time);

        return accountRepository
                .findCashAccountByAccountId(accountId)
                .doOnNext(e-> e.setCashBalance(e.getCashBalance().add(amount)))
                .flatMap(e -> accountRepository.save(e))
                .then(transactionHistoryRepository.save(txnObj)).then();

    }

    @Override
    @Transactional
    public Mono<Void> decreaseBalance(Integer accountId, BigDecimal amount) {

        LocalDateTime time = LocalDateTime.now();
        TransactionHistory txnObj = new TransactionHistory(accountId, "Debit", amount,time);

        return accountRepository
                .findCashAccountByAccountId(accountId)
                .doOnNext(e-> e.setCashBalance(e.getCashBalance().subtract(amount)))
                .flatMap(e -> accountRepository.save(e))
                .then(transactionHistoryRepository.save(txnObj)).then();
    }

    /*
    @Override

    public Mono<String> reserve(Order o) {
        return accountRepository
                .findCashAccountByCustomerId(o.getCustomerId())
                .flatMap(e -> {
                                if (e.getCashBalance().compareTo(BigDecimal.valueOf(o.getPrice()))<0) {
                                    return "INADEQUATE";
                                }else{
                                    return "ADEQUATE";
                                }

                            }  )
                .doOnNext(e -> e.setCashBalance(e.getCashBalance().subtract(BigDecimal.valueOf(o.getPrice()))))
                .doOnNext(e-> e.setReservedBalance(BigDecimal.valueOf(o.getPrice())))
                .flatMap(e-> accountRepository.save(e))
                .just("ACCEPT");

    }

    @Override
    public Mono<Void> confirm(Order o) {
        return null;
    }
    */


    @Override
    public Mono<CashAccount> findAccountById(Integer id) {
        return accountRepository.findCashAccountByAccountId(id);
    }

}

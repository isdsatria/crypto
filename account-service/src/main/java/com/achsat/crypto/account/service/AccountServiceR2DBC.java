package com.achsat.crypto.account.service;

import com.achsat.crypto.account.model.CashAccount;
import com.achsat.crypto.account.model.TransactionHistory;
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
    public Mono<Void> IncreaseBalance(Integer accountId, BigDecimal amount) {

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
    public Mono<Void> DecreaseBalance(Integer accountId, BigDecimal amount) {

        LocalDateTime time = LocalDateTime.now();
        TransactionHistory txnObj = new TransactionHistory(accountId, "Debit", amount,time);

        return accountRepository
                .findCashAccountByAccountId(accountId)
                .doOnNext(e-> e.setCashBalance(e.getCashBalance().subtract(amount)))
                .flatMap(e -> accountRepository.save(e))
                .then(transactionHistoryRepository.save(txnObj)).then();
    }


    @Override
    public Mono<CashAccount> findAccountById(Integer id) {
        return accountRepository.findCashAccountByAccountId(id);
    }
}

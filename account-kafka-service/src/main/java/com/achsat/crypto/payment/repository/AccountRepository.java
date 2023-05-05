package com.achsat.crypto.payment.repository;

import com.achsat.crypto.payment.model.CashAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<CashAccount, Integer> {
    Optional<CashAccount> findByCustomerId(Long customerId);
}

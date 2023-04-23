package com.achsat.crypto.account.repository;

import com.achsat.crypto.account.model.TransactionHistory;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TransactionHistoryRepository extends ReactiveCrudRepository<TransactionHistory, Integer> {
}

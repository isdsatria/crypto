package com.achsat.crypto.entity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.relational.core.mapping.Column;
//import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="transaction_history")
public class TransactionHistory {

    @Id
    @Column(name="transaction_history_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer transactionHistoryId;

    @Column(name="account_id")
    @NonNull
    private Integer accountId;

    @Column(name="transaction_type")
    @NonNull
    private String transactionType;

    @Column(name="transaction_amount")
    @NonNull
    private BigDecimal transactionAmount;

    @Column(name="transaction_date")
    @NonNull
    private LocalDateTime transactionDate;


}

package com.achsat.crypto.entity.model;

//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="transaction_history")
public class TransactionHistory {

    @Id
    @Column("transaction_history_id")
    private Integer transactionHistoryId;

    @Column("account_id")
    @NonNull
    private Integer accountId;

    @Column("transaction_type")
    @NonNull
    private String transactionType;

    @Column("transaction_amount")
    @NonNull
    private BigDecimal transactionAmount;

    @Column("transaction_date")
    @NonNull
    private LocalDateTime transactionDate;


}

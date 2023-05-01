package com.achsat.crypto.payment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="cash_account")
public class CashAccount {

    @Id
    @Column(name="account_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer accountId;
    @Column(name="customer_id")
    private Long customerId;
    @Column(name="cash_balance")
    private BigDecimal cashBalance;
    @Column(name="date_created")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateCreated;
    @Column(name="reserved_balance")
    private BigDecimal reservedBalance;
}

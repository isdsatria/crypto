package com.achsat.crypto.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import lombok.Data;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.relational.core.mapping.Column;
//import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="cash_account")
public class CashAccount {

    @Id
    @Column(name="account_id")
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

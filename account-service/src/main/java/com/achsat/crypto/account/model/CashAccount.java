package com.achsat.crypto.account.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Table("cash_account")
public class CashAccount {

    @Id
    @Column("account_id")
    private Integer accountId;
    @Column("customer_id")
    private Integer customerId;
    @Column("cash_balance")
    private BigDecimal cashBalance;
    @Column("date_created")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateCreated;
}

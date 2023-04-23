package com.achsat.crypto.account.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionDTO {

    private Integer accountID;
    private BigDecimal amount;

}

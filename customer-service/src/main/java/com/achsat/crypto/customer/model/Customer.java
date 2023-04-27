package com.achsat.crypto.customer.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("customer")
public class Customer {
    @Id
    @Column("customer_id")
    private Integer customerId;

    @Column("name")
    private String name;

    @Column("email")
    private String email;
}

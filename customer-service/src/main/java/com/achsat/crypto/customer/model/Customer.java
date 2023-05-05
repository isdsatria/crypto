package com.achsat.crypto.customer.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Table(name="customer")
@Entity
public class Customer {
    @Id
    @Column(name="customer_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;
}

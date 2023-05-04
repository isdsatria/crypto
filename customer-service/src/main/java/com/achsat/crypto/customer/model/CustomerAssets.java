package com.achsat.crypto.customer.model;

import jakarta.persistence.*;
import lombok.Data;


import java.math.BigDecimal;

@Data
@Table(name="customer_assets")
@Entity
public class CustomerAssets {

    @Id
    @Column(name="asset_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="customer_id")
    private Long customerId;

    @Column(name="coin_id")
    private Long coinId;

    @Column(name="qty")
    private BigDecimal qty;

}

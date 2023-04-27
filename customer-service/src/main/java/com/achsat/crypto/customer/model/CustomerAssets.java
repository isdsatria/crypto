package com.achsat.crypto.customer.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Data
@Table("customer_assets")
public class CustomerAssets {

    @Id
    @Column("asset_id")
    private Integer assetId;

    @Column("customer_id")
    private Integer customerId;

    @Column("coin_id")
    private Integer coinId;

    @Column("qty")
    private BigDecimal qty;

}

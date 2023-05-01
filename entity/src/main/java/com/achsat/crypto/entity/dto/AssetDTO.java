package com.achsat.crypto.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetDTO {

    private Integer assetId;

    private Integer customerId;

    private Integer coinId;

    private BigDecimal qty;

}

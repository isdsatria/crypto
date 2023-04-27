package com.achsat.crypto.customer.model.dto;

import lombok.Data;

@Data
public class AssetDTO {

    private Integer assetId;

    private Integer customerId;

    private Integer coinId;

    private Integer qty;

}

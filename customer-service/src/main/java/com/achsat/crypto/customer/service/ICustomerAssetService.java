package com.achsat.crypto.customer.service;

import com.achsat.crypto.entity.dto.AssetDTO;

import java.util.List;

public interface ICustomerAssetService {

    List<AssetDTO> getAllCustomerAssets(Integer id);

    void addAsset(AssetDTO dto);

}

package com.achsat.crypto.customer.service;

import com.achsat.crypto.customer.model.CustomerAssets;
import com.achsat.crypto.customer.repository.CustomerAssetsRepository;
import com.achsat.crypto.dto.AssetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class CustomerAssetServiceJPA implements ICustomerAssetService {


    @Autowired
    CustomerAssetsRepository custAsset;
    @Override
    public List<AssetDTO> getAllCustomerAssets(Integer id) {
        List<AssetDTO> dto = new ArrayList<>();
        for(CustomerAssets a : custAsset.findByCustomerId(id)){
            AssetDTO b = new AssetDTO(a.getId(),a.getCustomerId(),a.getCoinId(),a.getQty());
            dto.add(b);
        }
        return dto;
    }

    @Override
    @Transactional
    public void addNewAsset(AssetDTO dto) {
        CustomerAssets a= new CustomerAssets();
        a.setCustomerId(dto.getCustomerId());
        a.setCoinId(dto.getCoinId());
        a.setQty(dto.getQty());
    }

    @Transactional
    @Override
    public void updateExistingAsset(AssetDTO dto) {
        Optional<CustomerAssets> a = custAsset.findById(dto.getAssetId());
        a.get().setQty(dto.getQty());
        custAsset.save(a.get());
    }

}

package com.achsat.crypto.customer.service;

import com.achsat.crypto.customer.model.CustomerAssets;
import com.achsat.crypto.customer.repository.CustomerAssetsRepository;
import com.achsat.crypto.entity.dto.AssetDTO;
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
    public void addAsset(AssetDTO dto) {
        Optional<CustomerAssets> current = custAsset.findByCoinId(dto.getCoinId());
        if (current.isPresent()){
            current.get().setQty(current.get().getQty().add(dto.getQty()));
            custAsset.save(current.get());
        }else {
            CustomerAssets _new = new CustomerAssets();
            _new.setCustomerId(dto.getCustomerId());
            _new.setCoinId(dto.getCoinId());
            _new.setQty(dto.getQty());
            custAsset.save(_new);
        }
    }



}

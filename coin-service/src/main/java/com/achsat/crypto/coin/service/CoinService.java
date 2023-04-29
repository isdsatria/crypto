package com.achsat.crypto.coin.service;

import com.achsat.crypto.coin.domain.Coin;
import com.achsat.crypto.coin.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoinService implements ICoinService{

    @Autowired
    private CoinRepository coinRepository;

    @Override
    public Coin addCoin(Coin coin) {
        return coinRepository.save(coin);
    }

    @Override
    public List<Coin> getAllCoins() {
        return (List<Coin>) coinRepository.findAll();
    }

    @Override
    public Coin getCoinByName(String name) {
        return coinRepository.findByName(name);
    }

    @Override
    public Coin updateCoin(Long id, Coin coin) {
        Optional<Coin> optionalCoin = coinRepository.findById(id);
        if (optionalCoin.isPresent()) {
            Coin existingCoin = optionalCoin.get();
            existingCoin.setName(coin.getName());
            existingCoin.setPrice(coin.getPrice());
            existingCoin.setReservedItems(coin.getReservedItems());
            existingCoin.setAvailableItems(coin.getAvailableItems());
            return coinRepository.save(existingCoin);
        } else {
            throw new NotFoundException("Coin not found with id: " + id);
        }
    }
}

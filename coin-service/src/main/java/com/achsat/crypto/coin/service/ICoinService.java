package com.achsat.crypto.coin.service;

import com.achsat.crypto.coin.domain.Coin;

import java.util.List;

public interface ICoinService {
    Coin addCoin(Coin coin);

    List<Coin> getAllCoins();

    Coin getCoinByName(String name);

    Coin updateCoin(Long id, Coin coin);
}

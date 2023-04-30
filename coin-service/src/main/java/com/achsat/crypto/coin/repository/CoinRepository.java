package com.achsat.crypto.coin.repository;

import com.achsat.crypto.coin.domain.Coin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinRepository extends CrudRepository<Coin, Long> {
    Coin findByName(String name);
}

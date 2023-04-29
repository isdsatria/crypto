package com.achsat.crypto.coin.controller;
import com.achsat.crypto.coin.domain.Coin;
import com.achsat.crypto.coin.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coins")
public class CoinController {

    @Autowired
    private CoinService coinService;

    @PostMapping
    public Coin addCoin(@RequestBody Coin coin) {
        return coinService.addCoin(coin);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCoins() {
        return ResponseEntity.ok(coinService.getAllCoins());
    }

    @GetMapping("/name")
    public ResponseEntity<?> getCoinByName(@RequestParam String name) {
        return ResponseEntity.ok(coinService.getCoinByName(name));
    }

    @PutMapping("/{id}")
    public Coin updateCoin(@PathVariable Long id, @RequestBody Coin coin) {
        return coinService.updateCoin(id, coin);
    }

}

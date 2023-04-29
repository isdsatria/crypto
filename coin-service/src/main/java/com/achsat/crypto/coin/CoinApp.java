package com.achsat.crypto.coin;

import com.achsat.crypto.dto.Order;
import com.achsat.crypto.coin.domain.Coin;
import com.achsat.crypto.coin.repository.CoinRepository;
import com.achsat.crypto.coin.service.OrderManageService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.Random;

@SpringBootApplication
@EnableKafka
public class CoinApp {

    private static final Logger LOG = LoggerFactory.getLogger(CoinApp.class);

    public static void main(String[] args) {
        SpringApplication.run(CoinApp.class, args);
    }

    @Autowired
    OrderManageService orderManageService;

    @KafkaListener(id = "orders", topics = "orders", groupId = "coin")
    public void onEvent(Order o) {
        LOG.info("Received: {}", o);
        if (o.getStatus().equals("NEW"))
            orderManageService.reserve(o);
        else
            orderManageService.confirm(o);
    }

    @Autowired
    private CoinRepository coinRepository;

    @PostConstruct
    public void generateData() {
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            int count = r.nextInt(10, 1000);
            Coin c = new Coin(null, "Coin" + i, count, 0);
            coinRepository.save(c);
        }
    }

}

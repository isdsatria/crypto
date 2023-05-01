package com.achsat.crypto.coin.service;

import com.achsat.crypto.entity.dto.Order;
import com.achsat.crypto.coin.domain.Coin;
import com.achsat.crypto.coin.repository.CoinRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderManageService {

    private static final String SOURCE = "coin";
    private static final Logger LOG = LoggerFactory.getLogger(OrderManageService.class);
    private CoinRepository repository;
    private KafkaTemplate<Long, Order> template;

    public OrderManageService(CoinRepository repository, KafkaTemplate<Long, Order> template) {
        this.repository = repository;
        this.template = template;
    }

    public void reserve(Order order) {
        Coin coin = repository.findById(order.getCoinId()).orElseThrow();
        LOG.info("Found: {}", coin);
        if (order.getStatus().equals("NEW")) {
            if (order.getCoinCount() < coin.getAvailableItems()) {
                coin.setReservedItems(coin.getReservedItems() + order.getCoinCount());
                coin.setAvailableItems(coin.getAvailableItems() - order.getCoinCount());
                order.setStatus("ACCEPT");
                repository.save(coin);
            } else {
                order.setStatus("REJECT");
            }
            template.send("coin-orders", order.getId(), order);
            LOG.info("Sent: {}", order);
        }
    }

    public void confirm(Order order) {
        Coin coin = repository.findById(order.getCoinId()).orElseThrow();
        LOG.info("Found: {}", coin);
        if (order.getStatus().equals("CONFIRMED")) {
            coin.setReservedItems(coin.getReservedItems() - order.getCoinCount());
            repository.save(coin);
        } else if (order.getStatus().equals("ROLLBACK") && !order.getSource().equals(SOURCE)) {
            coin.setReservedItems(coin.getReservedItems() - order.getCoinCount());
            coin.setAvailableItems(coin.getAvailableItems() + order.getCoinCount());
            repository.save(coin);
        }
    }

}

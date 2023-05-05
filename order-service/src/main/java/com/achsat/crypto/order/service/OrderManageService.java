package com.achsat.crypto.order.service;

import com.achsat.crypto.entity.dto.Order;
import com.achsat.crypto.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderManageService {

    @Autowired
    OrderRepository orderRepository;

    public Order confirm(Order orderPayment, Order orderStock) {
        Order o = new Order(orderPayment.getId(),
                orderPayment.getCustomerId(),
                orderPayment.getCoinId(),
                orderPayment.getCoinCount(),
                orderPayment.getPrice(),
                orderPayment.getTransactionDate(),
                orderPayment.getSource(),
                orderPayment.getStatus()
                );
        if (orderPayment.getStatus().equals("ACCEPT") &&
                orderStock.getStatus().equals("ACCEPT")) {
            o.setStatus("CONFIRMED");
        } else if (orderPayment.getStatus().equals("REJECT") &&
                orderStock.getStatus().equals("REJECT")) {
            o.setStatus("REJECTED");
        } else if (orderPayment.getStatus().equals("REJECT") ||
                orderStock.getStatus().equals("REJECT")) {
            String source = orderPayment.getStatus().equals("REJECT")
                    ? "PAYMENT" : "COIN";
            o.setStatus("ROLLBACK");
            o.setSource(source);
        }
        orderRepository.save(o);
        return o;
    }

}

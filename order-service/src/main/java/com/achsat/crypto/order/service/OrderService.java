package com.achsat.crypto.order.service;

import com.achsat.crypto.entity.dto.Order;
import com.achsat.crypto.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getOrdersByStatus(String status) {
        List<Order> filteredOrders = new ArrayList<>();
        List<Order> orders = (List<Order>) orderRepository.findAll();
        for (Order order : orders) {
            if (order.getStatus().equalsIgnoreCase(status)) {
                filteredOrders.add(order);
            }
        }
        return filteredOrders;
    }

    @Override
    public Order addOrder(Order order) {
        order.setTransactionDate(new Date());
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }
}
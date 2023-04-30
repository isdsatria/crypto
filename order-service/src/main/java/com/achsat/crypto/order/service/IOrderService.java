package com.achsat.crypto.order.service;

import com.achsat.crypto.dto.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    List<Order> getOrdersByStatus(String status);

    Order addOrder(Order order);
    List<Order> getAllOrders();

    Optional<Order> getOrderById(Long orderId);
}

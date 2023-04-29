package com.achsat.crypto.order.service;

import com.achsat.crypto.dto.Order;

import java.util.List;

public interface IOrderService {
    Order createOrder(Order order);
    Order getOrderById(Long orderId);
    List<Order> getOrdersByStatus(String status);
}

package com.achsat.crypto.order.service;

import com.achsat.crypto.dto.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    private final List<Order> orders = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public Order createOrder(Order order) {
        order.setId(nextId++);
        order.setTransactionDate(new Date());
        orders.add(order);
        return order;
    }

    @Override
    public Order getOrderById(Long orderId) {
        for (Order order : orders) {
            if (order.getId().equals(orderId)) {
                return order;
            }
        }
        return null;
    }

    @Override
    public List<Order> getOrdersByStatus(String status) {
        List<Order> filteredOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getStatus().equalsIgnoreCase(status)) {
                filteredOrders.add(order);
            }
        }
        return filteredOrders;
    }
}
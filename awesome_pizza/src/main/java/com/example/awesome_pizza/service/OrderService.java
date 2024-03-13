package com.example.awesome_pizza.service;


import com.example.awesome_pizza.model.Order;
import com.example.awesome_pizza.model.OrderStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class OrderService {

    private Map<String, Order> orders = new HashMap<>();

    public Order placeOrder() {
        String orderId = UUID.randomUUID().toString();
        Order order = new Order(orderId, OrderStatus.PENDING);
        orders.put(orderId, order);
        return order;
    }

    public Order getOrder(String orderId) {
        return orders.get(orderId);
    }

    public Order updateOrderStatus(String orderId, OrderStatus newStatus) {
        Order order = orders.get(orderId);
        if (order != null) {
            order.setStatus(newStatus);
            return order;
        } else {
            return null;
        }
    }
}
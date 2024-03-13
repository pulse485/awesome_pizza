package com.example.awesome_pizza.service;


import com.example.awesome_pizza.model.Order;
import com.example.awesome_pizza.model.OrderStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    private final Queue<Order> orderQueue = new LinkedList<>();
    private final Map<String, Order> orderMap = new HashMap<>();

    public Order placeOrder() {
        String orderId = UUID.randomUUID().toString();
        Order order = new Order(orderId, OrderStatus.PENDING);
        orderQueue.offer(order); // Add order to the end of the queue
        orderMap.put(orderId, order); // Add order to the map
        return order;
    }

    public Order fulfillNextOrder() {
        return orderQueue.poll(); // Retrieve and remove the head of the queue
    }

    public Order getOrder(String orderId) {
        return orderMap.get(orderId); // Retrieve order directly from the map
    }

    public void updateOrderStatus(String orderId, OrderStatus newStatus) {
        Order order = orderMap.get(orderId);
        if (order != null) {
            order.setStatus(newStatus);
        }
    }
}

package com.example.awesome_pizza.service;


import com.example.awesome_pizza.model.Order;
import com.example.awesome_pizza.model.OrderStatus;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class OrderService {

    Queue<Order> orderQueue = new LinkedList<>();
    Map<String, Order> orderMap = new HashMap<>();

    public Order placeOrder() {
        String orderId = UUID.randomUUID().toString();
        Order order = new Order(orderId, OrderStatus.PENDING);
        orderQueue.offer(order);
        orderMap.put(orderId, order);
        return order;
    }

    public Order fulfillNextOrder() {
        return orderQueue.poll();
    }

    public Order getOrder(String orderId) {
        return orderMap.get(orderId);
    }

    public List<Order> getAllOrders() {
        return orderMap.values().stream().toList();
    }

    public void updateOrderStatus(String orderId, OrderStatus newStatus) {
        Order order = orderMap.get(orderId);
        if (order != null) {
            order.setStatus(newStatus);
        }
    }
}

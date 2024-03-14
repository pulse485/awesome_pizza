package com.example.awesome_pizza.core;

import com.example.awesome_pizza.service.OrderService;
import org.springframework.stereotype.Component;


import com.example.awesome_pizza.model.Order;
import com.example.awesome_pizza.model.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

@Component
public class OrderProcessingSimulator {
    private final OrderService orderService;

    @Autowired
    public OrderProcessingSimulator(OrderService orderService) {
        this.orderService = orderService;
    }

    @Scheduled(fixedRate = 5000)
    public void processNextOrder() {
        Order nextOrder = orderService.fulfillNextOrder();
        if (nextOrder != null) {
            System.out.println("Processing order: " + nextOrder.getId());

            orderService.updateOrderStatus(nextOrder.getId(), OrderStatus.IN_PROGRESS);

            simulatePizzaPreparation();

            orderService.updateOrderStatus(nextOrder.getId(), OrderStatus.COMPLETED);

            System.out.println("Order completed: " + nextOrder.getId());

        } else {
            System.out.println("No pending orders to process.");
        }
    }

    private void simulatePizzaPreparation() {
        try {
            Thread.sleep(3000);
            System.out.println("Order in progress");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Interrupted while simulating pizza preparation.");
        }
    }
}


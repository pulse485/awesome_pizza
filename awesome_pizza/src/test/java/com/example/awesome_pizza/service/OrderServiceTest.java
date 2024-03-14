package com.example.awesome_pizza.service;

import com.example.awesome_pizza.model.Order;
import com.example.awesome_pizza.model.OrderStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrderServiceTest {

    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        orderService = new OrderService();
    }

    @Test
    public void testPlaceOrder() {

        Order order = orderService.placeOrder();

        assertNotNull(order);
        assertEquals(OrderStatus.PENDING, order.getStatus());
    }

    @Test
    public void testGetOrder() {

        Order order = orderService.placeOrder();

        Order retrievedOrder = orderService.getOrder(order.getId());

        assertEquals(retrievedOrder,order);
    }
}


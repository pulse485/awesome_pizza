package com.example.awesome_pizza.controller;

import com.example.awesome_pizza.model.Order;
import com.example.awesome_pizza.model.OrderStatus;
import com.example.awesome_pizza.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @Test
    void testPlaceOrder() {

        Order mockOrder = new Order("1", OrderStatus.PENDING);
        when(orderService.placeOrder()).thenReturn(mockOrder);

        ResponseEntity<Order> responseEntity = orderController.placeOrder();

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(mockOrder, responseEntity.getBody());
        verify(orderService, times(1)).placeOrder();
    }

    @Test
    void testGetOrderFound() {
        Order mockOrder = new Order("1", OrderStatus.PENDING);
        String orderId = "1";
        when(orderService.getOrder(orderId)).thenReturn(mockOrder);

        ResponseEntity<Order> responseEntity = orderController.getOrder(orderId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockOrder, responseEntity.getBody());
        verify(orderService, times(1)).getOrder(orderId);
    }

    @Test
    void testGetOrderNotFound() {
        String orderId = "1";
        when(orderService.getOrder(orderId)).thenReturn(null);

        ResponseEntity<Order> responseEntity = orderController.getOrder(orderId);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        verify(orderService, times(1)).getOrder(orderId);
    }

    @Test
    void testGetOrdersWhenOrdersExist() {
        // Mocking behavior of orderService
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("1", OrderStatus.PENDING ));
        when(orderService.getAllOrders()).thenReturn(orders);

        // Calling the controller method
        ResponseEntity<List<Order>> responseEntity = orderController.getOrders();

        // Validating the response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(orders, responseEntity.getBody());
    }

    @Test
    void testGetOrdersWhenNoOrdersExist() {

        when(orderService.getAllOrders()).thenReturn(emptyList());

        ResponseEntity<List<Order>> responseEntity = orderController.getOrders();

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals(null, responseEntity.getBody());
    }
}


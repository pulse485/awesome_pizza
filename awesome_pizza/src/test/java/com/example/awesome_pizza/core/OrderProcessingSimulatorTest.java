package com.example.awesome_pizza.core;

import com.example.awesome_pizza.model.Order;
import com.example.awesome_pizza.model.OrderStatus;
import com.example.awesome_pizza.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class OrderProcessingSimulatorTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderProcessingSimulator orderProcessingSimulator;

    @Test
    public void testProcessNextOrder() {

        Order order = new Order("1", OrderStatus.PENDING);
        when(orderService.fulfillNextOrder()).thenReturn(order).thenReturn(null);

        orderProcessingSimulator.processNextOrder();

        verify(orderService, times(1)).fulfillNextOrder();
        verify(orderService, times(1)).updateOrderStatus("1", OrderStatus.IN_PROGRESS);
        verify(orderService, times(1)).updateOrderStatus("1", OrderStatus.COMPLETED);
    }

    @Test
    public void testProcessNextOrderWhenNoPendingOrders() {

        when(orderService.fulfillNextOrder()).thenReturn(null);

        orderProcessingSimulator.processNextOrder();

        verify(orderService, never()).updateOrderStatus(anyString(), any());
    }

}



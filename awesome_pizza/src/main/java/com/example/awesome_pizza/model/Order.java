package com.example.awesome_pizza.model;


import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class Order {
    private String id;
    private OrderStatus status;
}
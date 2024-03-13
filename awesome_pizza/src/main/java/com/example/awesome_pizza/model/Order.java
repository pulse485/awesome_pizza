package com.example.awesome_pizza.model;

// Order.java
public class Order {

    private String id;
    private OrderStatus status;

    public Order(String id, OrderStatus status) {
        this.id = id;
        this.status = status;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
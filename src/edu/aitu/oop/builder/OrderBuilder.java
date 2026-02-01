package edu.aitu.oop.builder;


import edu.aitu.oop.entity.Order;

public class OrderBuilder {

    private int id;
    private int customerId;
    private String status;

    public OrderBuilder id(int id) {
        this.id = id;
        return this;
    }

    public OrderBuilder customerId(int customerId) {
        this.customerId = customerId;
        return this;
    }

    public OrderBuilder status(String status) {
        this.status = status;
        return this;
    }

    public Order build() {
        return new Order(id, customerId, status);
    }
}




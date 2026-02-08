package edu.aitu.oop.builder;

import edu.aitu.oop.entity.Order;
import edu.aitu.oop.factory.OrderFactory;

public class OrderBuilder {
    private int customerId;
    private String customerName;
    private double totalPrice;
    private String type;

    public OrderBuilder customerId(int customerId) { this.customerId = customerId; return this; }
    public OrderBuilder customerName(String name) { this.customerName = name; return this; }
    public OrderBuilder totalPrice(double price) { this.totalPrice = price; return this; }
    public OrderBuilder type(String type) { this.type = type; return this; }

    public Order build() {
        return OrderFactory.createOrder(type, customerId, customerName, totalPrice);
    }
}





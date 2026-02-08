package edu.aitu.oop.component;

import edu.aitu.oop.builder.OrderBuilder;
import edu.aitu.oop.entity.Order;

public class OrderingComponent {

    public Order createOrder(String type, int customerId, String customerName, double totalPrice) {
        return new OrderBuilder()
                .type(type)
                .customerId(customerId)
                .customerName(customerName)
                .totalPrice(totalPrice)
                .build();
    }
}




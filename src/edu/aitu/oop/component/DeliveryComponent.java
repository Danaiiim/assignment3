package edu.aitu.oop.component;

import edu.aitu.oop.entity.Order;

public class DeliveryComponent {

    public void process(Order order) {
        System.out.println("Processing " + order.getType() +
                " for customer " + order.getCustomerName() +
                " | Total: " + order.getTotalPrice());
    }
}

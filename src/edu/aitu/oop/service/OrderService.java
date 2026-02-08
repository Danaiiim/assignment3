package edu.aitu.oop.service;

import edu.aitu.oop.builder.OrderBuilder;
import edu.aitu.oop.entity.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
    private final List<Order> orders = new ArrayList<>();
    private int nextId = 1;

    public Order createOrder(String type, int customerId, String customerName, double totalPrice) {
        Order order = new OrderBuilder()
                .id(nextId++)
                .customerId(customerId)
                .customerName(customerName)
                .totalPrice(totalPrice)
                .type(type)
                .build();
        orders.add(order);
        return order;
    }

    public void showActiveOrders() {
        List<Order> active = orders.stream()
                .filter(o -> o.getStatus().equalsIgnoreCase("ACTIVE"))
                .collect(Collectors.toList());
        if (active.isEmpty()) {
            System.out.println("No active orders");
        } else {
            active.forEach(o -> System.out.printf(
                    "Order ID: %d, Customer: %s, Total: %.2f, Status: %s, Type: %s%n",
                    o.getId(), o.getCustomerName(), o.getTotalPrice(), o.getStatus(), o.getType()));
        }
    }

    public void completeOrder(int orderId) {
        orders.stream()
                .filter(o -> o.getId() == orderId)
                .findFirst()
                .ifPresentOrElse(
                        o -> {
                            o.setStatus("COMPLETED");
                            System.out.println("Order " + orderId + " completed");
                        },
                        () -> System.out.println("Order not found: " + orderId)
                );
    }
}

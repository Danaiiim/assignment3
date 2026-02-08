package edu.aitu.oop.service;

import edu.aitu.oop.builder.OrderBuilder;
import edu.aitu.oop.entity.Order;
import edu.aitu.oop.repository.OrderRepository;

import java.util.List;

public class OrderService {
    private final OrderRepository repository = new OrderRepository();
    private int nextId = 1;

    public Order createOrder(String type, int customerId, String customerName, double totalPrice) {
        int id = repository.createOrder(customerId, customerName, type, totalPrice);
        Order order = new OrderBuilder()
                .id(id)
                .customerId(customerId)
                .customerName(customerName)
                .totalPrice(totalPrice)
                .type(type)
                .status("ACTIVE")
                .build();
        return order;
    }

    public void showActiveOrders() {
        List<String> activeOrders = repository.findActiveOrders();
        if (activeOrders.isEmpty()) System.out.println("No active orders");
        else activeOrders.forEach(System.out::println);
    }

    public void completeOrder(int orderId) {
        repository.completeOrder(orderId);
        System.out.println("Order " + orderId + " completed");
    }
}


package edu.aitu.oop.factory;

import edu.aitu.oop.entity.*;

public class OrderFactory {
    private static int nextId = 1;

    public static Order createOrder(String type, int customerId, String customerName, double totalPrice) {
        int id = nextId++;
        String status = "ACTIVE";

        return switch (type.toLowerCase()) {
            case "dinein" -> new DineInOrder(id, customerId, customerName, status, totalPrice);
            case "delivery" -> new DeliveryOrder(id, customerId, customerName, status, totalPrice);
            case "pickup" -> new PickupOrder(id, customerId, customerName, status, totalPrice);
            default -> throw new IllegalArgumentException("Unknown order type");
        };
    }
}

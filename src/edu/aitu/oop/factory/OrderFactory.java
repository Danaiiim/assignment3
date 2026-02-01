package edu.aitu.oop.factory;

import edu.aitu.oop.entity.*;

public class OrderFactory {
    public static Order createOrder(String type, int id, int customerId, String customerName, double totalPrice) {
        return switch (type.toLowerCase()) {
            case "dinein" -> new DineInOrder(id, customerId, customerName, totalPrice);
            case "delivery" -> new DeliveryOrder(id, customerId, customerName, totalPrice);
            case "pickup" -> new PickupOrder(id, customerId, customerName, totalPrice);
            default -> throw new IllegalArgumentException("Unknown order type: " + type);
        };
    }
}

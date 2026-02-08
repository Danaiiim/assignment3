package edu.aitu.oop.factory;

import edu.aitu.oop.entity.*;

public class OrderFactory {

    public static Order createOrder(
            String type,
            int id,
            int customerId,
            String customerName,
            double totalPrice,
            String status
    ) {
        return switch (type.toLowerCase()) {
            case "dinein" -> new DineInOrder(id, customerId, customerName, totalPrice, status);
            case "delivery" -> new DeliveryOrder(id, customerId, customerName, totalPrice, status);
            case "pickup" -> new PickupOrder(id, customerId, customerName, totalPrice, status);
            default -> throw new IllegalArgumentException("Unknown order type");
        };
    }
}


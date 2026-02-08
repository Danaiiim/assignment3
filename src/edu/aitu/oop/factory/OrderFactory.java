package edu.aitu.oop.factory;

import edu.aitu.oop.entity.*;

public class OrderFactory {

    public static Order createOrder(
            int id,
            String type,
            int customerId,
            String customerName,
            double totalPrice
    ) {
        String status = "ACTIVE";

        return switch (type.toLowerCase()) {
            case "dinein" -> new DineInOrder(id, customerId, customerName, status, totalPrice);
            case "delivery" -> new DeliveryOrder(id, customerId, customerName, status, totalPrice);
            case "pickup" -> new PickupOrder(id, customerId, customerName, status, totalPrice);
            default -> throw new IllegalArgumentException("Unknown order type: " + type);
        };
    }
}

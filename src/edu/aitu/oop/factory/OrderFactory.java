package edu.aitu.oop.factory;


import edu.aitu.oop.entity.Order;
import edu.aitu.oop.entity.DeliveryOrder;
import edu.aitu.oop.entity.PickupOrder;
import edu.aitu.oop.entity.DineInOrder;

public class OrderFactory {

    public static Order createOrder(String type) {
        return switch(type.toUpperCase()) {
            case "DELIVERY" -> new DeliveryOrder();
            case "PICKUP" -> new PickupOrder();
            case "DINEIN" -> new DineInOrder();
            default -> throw new IllegalArgumentException("Unknown order type: " + type);
        };
    }
}



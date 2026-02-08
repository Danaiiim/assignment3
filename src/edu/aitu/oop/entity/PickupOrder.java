package edu.aitu.oop.entity;

public class PickupOrder extends Order {
    public PickupOrder(int id, int customerId, String customerName, String status, double totalPrice) {
        super(id, customerId, customerName, status, totalPrice);
    }

    @Override
    public String getType() { return "PickupOrder"; }
}

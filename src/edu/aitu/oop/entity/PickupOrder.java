package edu.aitu.oop.entity;

public class PickupOrder extends Order {
    public PickupOrder(int id, int customerId, String customerName, double totalPrice) {
        super(id, customerId, customerName, totalPrice);
    }
    @Override
    public String getType() { return "PickupOrder"; }
}
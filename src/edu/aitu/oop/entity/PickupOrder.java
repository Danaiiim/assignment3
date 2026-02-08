package edu.aitu.oop.entity;

public class PickupOrder extends Order {
    public PickupOrder(int id, int customerId, String customerName, double totalPrice, String status) {
        super(id, customerId, customerName, totalPrice, status);
    }
    @Override
    public String getType() { return "Pickup"; }
}
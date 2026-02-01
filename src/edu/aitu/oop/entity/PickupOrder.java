package edu.aitu.oop.entity;

public class PickupOrder extends Order {
    @Override
    public String getOrderType() { return "Pickup"; }

    @Override
    public String toString() {
        return "Order [Type: Pickup, Customer: " + getCustomerName() + ", Total: " + getTotalPrice() + "]";
    }
}
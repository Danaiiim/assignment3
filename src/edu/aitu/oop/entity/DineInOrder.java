package edu.aitu.oop.entity;

public class DineInOrder extends Order {
    @Override
    public String getOrderType() { return "Dine-In"; }

    @Override
    public String toString() {
        return "Order [Type: Dine-In, Customer: " + getCustomerName() + ", Total: " + getTotalPrice() + "]";
    }
}
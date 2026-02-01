package edu.aitu.oop.entity;

public class DeliveryOrder extends Order {
    @Override
    public String getOrderType() { return "Delivery"; }

    @Override
    public String toString() {
        return "Order [Type: Delivery, Customer: " + getCustomerName() + ", Total: " + getTotalPrice() + "]";
    }
}
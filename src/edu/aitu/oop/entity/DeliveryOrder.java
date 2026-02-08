package edu.aitu.oop.entity;

public class DeliveryOrder extends Order {
    public DeliveryOrder(int id, int customerId, String customerName, double totalPrice, String status) {
        super(id, customerId, customerName, totalPrice, status);
    }
    @Override
    public String getType() { return "Delivery"; }
}

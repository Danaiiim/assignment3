package edu.aitu.oop.entity;

public class DeliveryOrder extends Order {
    public DeliveryOrder(int id, int customerId, String customerName, double totalPrice) {
        super(id, customerId, customerName, totalPrice);
    }
    @Override
    public String getType() { return "DeliveryOrder"; }
}
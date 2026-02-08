package edu.aitu.oop.entity;

public class DeliveryOrder extends Order {
    public DeliveryOrder(int id, int customerId, String customerName, String status, double totalPrice) {
        super(id, customerId, customerName, status, totalPrice);
    }

    @Override
    public String getType() { return "DeliveryOrder"; }
}

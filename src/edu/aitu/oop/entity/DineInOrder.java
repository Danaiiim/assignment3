package edu.aitu.oop.entity;

public class DineInOrder extends Order {
    public DineInOrder(int id, int customerId, String customerName, double totalPrice) {
        super(id, customerId, customerName, totalPrice);
    }
    @Override
    public String getType() { return "DineInOrder"; }
}
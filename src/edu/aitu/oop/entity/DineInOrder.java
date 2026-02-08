package edu.aitu.oop.entity;

public class DineInOrder extends Order {
    public DineInOrder(int id, int customerId, String customerName, double totalPrice, String status) {
        super(id, customerId, customerName, totalPrice, status);
    }
    @Override
    public String getType() { return "Dine-In"; }
}
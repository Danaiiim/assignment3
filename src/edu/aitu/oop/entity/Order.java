package edu.aitu.oop.entity;

public abstract class Order {
    private int id;
    private int customerId;
    private String customerName;
    private double totalPrice;
    private String status;

    public Order(int id, int customerId, String customerName, double totalPrice, String status) {
        this.id = id;
        this.customerId = customerId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public int getId() { return id; }
    public int getCustomerId() { return customerId; }
    public String getCustomerName() { return customerName; }
    public double getTotalPrice() { return totalPrice; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public abstract String getType();
}
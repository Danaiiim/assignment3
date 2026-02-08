package edu.aitu.oop.entity;

public abstract class Order {
    private final int id;
    private final int customerId;
    private final String customerName;
    private String status;
    private final double totalPrice;

    public Order(int id, int customerId, String customerName, String status, double totalPrice) {
        this.id = id;
        this.customerId = customerId;
        this.customerName = customerName;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    public int getId() { return id; }
    public int getCustomerId() { return customerId; }
    public String getCustomerName() { return customerName; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public double getTotalPrice() { return totalPrice; }

    public abstract String getType();
}

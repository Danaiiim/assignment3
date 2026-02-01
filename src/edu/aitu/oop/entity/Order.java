package edu.aitu.oop.entity;

public abstract class Order {
    private final int id;
    private final int customerId;
    private final String customerName;
    private final double totalPrice;
    private String status = "ACTIVE";

    public Order(int id, int customerId, String customerName, double totalPrice) {
        this.id = id;
        this.customerId = customerId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public int getId() { return id; }
    public int getCustomerId() { return customerId; }
    public String getCustomerName() { return customerName; }
    public double getTotalPrice() { return totalPrice; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public abstract String getType();
}

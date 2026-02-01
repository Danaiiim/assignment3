package edu.aitu.oop.entity;

public abstract class Order {
    private String customerName;
    private double totalPrice;

    // ОБЯЗАТЕЛЬНО: Пустой конструктор (чтобы ошибки на скрине исчезли)
    public Order() {}

    // Геттеры и сеттеры (проверь, чтобы имена совпадали!)
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

    public abstract String getOrderType(); // Абстрактный метод
}
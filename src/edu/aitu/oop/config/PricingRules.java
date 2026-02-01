package edu.aitu.oop.config;

public class PricingRules {
    private static PricingRules instance;
    private double taxRate = 0.12;

    private PricingRules() {}

    public static synchronized PricingRules getInstance() {
        if (instance == null) instance = new PricingRules();
        return instance;
    }

    public double getTaxRate() { return taxRate; }
}
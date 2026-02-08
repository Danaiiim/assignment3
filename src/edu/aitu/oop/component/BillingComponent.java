package edu.aitu.oop.component;

import edu.aitu.oop.config.PricingRules;
import edu.aitu.oop.entity.Order;

public class BillingComponent {

    public void bill(Order order) {
        double taxRate = PricingRules.getInstance().getTaxRate();
        double totalWithTax = order.getTotalPrice() * (1 + taxRate);
        System.out.println("Billing " + order.getType() +
                " | Customer: " + order.getCustomerName() +
                " | Total with tax: " + totalWithTax);
    }
}

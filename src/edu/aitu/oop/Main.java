package edu.aitu.oop;

import edu.aitu.oop.component.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderingComponent ordering = new OrderingComponent();
        MenuManagementComponent menu = new MenuManagementComponent();
        DeliveryComponent delivery = new DeliveryComponent();
        BillingComponent billing = new BillingComponent();

        while (true) {
            System.out.println("\n=== FOOD ORDERING SYSTEM (Endterm) ===");
            System.out.println("1. Create Dine-In Order");
            System.out.println("2. Create Delivery Order");
            System.out.println("3. Create Pickup Order");
            System.out.println("4. Show Menu");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1", "2", "3" -> {
                    String type = switch (option) {
                        case "1" -> "dinein";
                        case "2" -> "delivery";
                        default -> "pickup";
                    };
                    System.out.print("Customer ID: ");
                    int customerId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Customer Name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Total Price: ");
                    double totalPrice = Double.parseDouble(scanner.nextLine());

                    var order = ordering.createOrder(type, customerId, customerName, totalPrice);
                    delivery.process(order);
                    billing.bill(order);
                    System.out.println(order.getType() + " created. ID: " + order.getId());
                }
                case "4" -> {
                    System.out.println("Available Menu:");
                    menu.getAvailableMenu().forEach(System.out::println);
                }
                case "0" -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }
}


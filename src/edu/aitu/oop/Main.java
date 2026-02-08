package edu.aitu.oop;

import edu.aitu.oop.service.OrderService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderService orderService = new OrderService();

        while (true) {
            System.out.println("\n=== FOOD ORDERING SYSTEM (Endterm) ===");
            System.out.println("1. Create Dine-In Order");
            System.out.println("2. Create Delivery Order");
            System.out.println("3. Create Pickup Order");
            System.out.println("4. Show Active Orders");
            System.out.println("5. Complete Order");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            String option = scanner.nextLine();

            try {
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

                        var order = orderService.createOrder(type, customerId, customerName, totalPrice);
                        System.out.println(order.getType() + " created. ID: " + order.getId());
                    }
                    case "4" -> orderService.showActiveOrders();
                    case "5" -> {
                        System.out.print("Order ID to complete: ");
                        int orderId = Integer.parseInt(scanner.nextLine());
                        orderService.completeOrder(orderId);
                    }
                    case "0" -> { System.out.println("Exiting..."); return; }
                    default -> System.out.println("Invalid option");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}


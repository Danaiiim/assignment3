package edu.aitu.oop;

import edu.aitu.oop.entity.MenuItem;
import edu.aitu.oop.service.MenuService;
import edu.aitu.oop.service.OrderService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MenuService menuService = new MenuService();
        OrderService orderService = new OrderService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== FOOD ORDERING SYSTEM (AITU OOP) ===");
            System.out.println("1. View menu");
            System.out.println("2. Place order");
            System.out.println("3. View active orders");
            System.out.println("4. Complete order");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1 -> {
                        List<MenuItem> menu = menuService.getMenu();
                        for (MenuItem item : menu) {
                            System.out.println(item.getId() + ". "
                                    + item.getName() + " - $" + item.getPrice());
                        }
                    }
                    case 2 -> {
                        System.out.print("Customer ID: ");
                        int customerId = scanner.nextInt();

                        System.out.print("Menu item ID: ");
                        int itemId = scanner.nextInt();

                        System.out.print("Quantity: ");
                        int qty = scanner.nextInt();

                        int orderId =
                                orderService.placeOrder(customerId, itemId, qty);
                        System.out.println("Order placed. ID = " + orderId);
                    }
                    case 3 -> orderService.showActiveOrders();
                    case 4 -> {
                        System.out.print("Order ID: ");
                        int id = scanner.nextInt();
                        orderService.completeOrder(id);
                        System.out.println("Order completed.");
                    }
                    case 0 -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid option");
                }
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }
}

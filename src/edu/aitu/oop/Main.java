package edu.aitu.oop;

import edu.aitu.oop.service.MenuService;
import edu.aitu.oop.service.OrderService;
import edu.aitu.oop.exceptions.InvalidQuantityException;
import edu.aitu.oop.exceptions.MenuItemNotAvailableException;
import edu.aitu.oop.exceptions.OrderNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuService menuService = new MenuService();
        OrderService orderService = new OrderService();

        while (true) {
            System.out.println("\n=== FOOD ORDERING SYSTEM (AITU OOP) ===");
            System.out.println("1. View menu");
            System.out.println("2. Place order");
            System.out.println("3. View active orders");
            System.out.println("4. Complete order");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            String option = scanner.nextLine();

            try {
                switch (option) {
                    case "1":
                        List<?> menu = menuService.getMenu();
                        for (Object item : menu) {
                            System.out.println(item);
                        }
                        break;
                    case "2":
                        System.out.print("Customer ID: ");
                        int customerId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Menu item ID: ");
                        int itemId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Quantity: ");
                        int quantity = Integer.parseInt(scanner.nextLine());

                        try {
                            int orderId = orderService.placeOrder(customerId, itemId, quantity);
                            System.out.println("Order placed. ID = " + orderId);
                        } catch (InvalidQuantityException | MenuItemNotAvailableException e) {
                            System.out.println("ERROR: " + e.getMessage());
                        }
                        break;
                    case "3":
                        orderService.showActiveOrders();
                        break;
                    case "4":
                        System.out.print("Order ID to complete: ");
                        int orderId = Integer.parseInt(scanner.nextLine());
                        try {
                            orderService.completeOrder(orderId);
                            System.out.println("Order completed: " + orderId);
                        } catch (OrderNotFoundException e) {
                            System.out.println("ERROR: " + e.getMessage());
                        }
                        break;
                    case "0":
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option");
                }
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }
}

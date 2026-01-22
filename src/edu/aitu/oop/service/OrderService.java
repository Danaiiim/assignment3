package edu.aitu.oop.service;

import edu.aitu.oop.exceptions.InvalidQuantityException;
import edu.aitu.oop.repository.OrderItemRepository;
import edu.aitu.oop.repository.OrderRepository;

public class OrderService {

    private final OrderRepository orderRepo = new OrderRepository();
    private final OrderItemRepository itemRepo = new OrderItemRepository();

    public int placeOrder(int customerId, int itemId, int quantity) throws Exception {
        if (quantity <= 0) {
            throw new InvalidQuantityException("Quantity must be greater than 0");
        }
        int orderId = orderRepo.createOrder(customerId);
        itemRepo.addItem(orderId, itemId, quantity);
        return orderId;
    }

    public void showActiveOrders() throws Exception {
        for (String order : orderRepo.findActiveOrders()) {
            System.out.println(order);
        }
    }

    public void completeOrder(int orderId) throws Exception {
        orderRepo.completeOrder(orderId);
    }
}


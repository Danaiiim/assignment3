package edu.aitu.oop.service;

import edu.aitu.oop.entity.MenuItem;
import edu.aitu.oop.exceptions.InvalidQuantityException;
import edu.aitu.oop.exceptions.MenuItemNotAvailableException;
import edu.aitu.oop.repository.MenuItemRepository;
import edu.aitu.oop.repository.OrderItemRepository;
import edu.aitu.oop.repository.OrderRepository;

public class OrderService {

    private final OrderRepository orderRepo = new OrderRepository();
    private final OrderItemRepository itemRepo = new OrderItemRepository();
    private final MenuItemRepository menuRepository = new MenuItemRepository();

    public int placeOrder(int customerId, int itemId, int quantity) throws Exception {
        if (quantity <= 0) {
            throw new InvalidQuantityException("Quantity must be greater than 0");
        }

        MenuItem menuItem = menuRepository.findById(itemId);
        if (menuItem == null || !menuItem.isAvailable()) {
            throw new MenuItemNotAvailableException("Menu item not available");
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

package edu.aitu.oop.repository;

import edu.aitu.oop.entity.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryMemory {

    private final List<Order> orders = new ArrayList<>();

    public void save(Order order) {
        orders.add(order);
    }

    public List<Order> findAll() {
        return new ArrayList<>(orders);
    }

    public Order findById(int id) {
        for (Order o : orders) {
            if (o.getId() == id) return o;
        }
        return null;
    }

    public void completeOrder(int id) {
        Order o = findById(id);
        if (o != null) {
            o.setStatus("COMPLETED");
        }
    }
}

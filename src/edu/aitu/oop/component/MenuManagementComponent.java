package edu.aitu.oop.component;

import edu.aitu.oop.entity.MenuItem;
import edu.aitu.oop.repository.MenuItemRepository;

import java.util.List;

public class MenuManagementComponent {
    private final MenuItemRepository menuRepo = new MenuItemRepository();

    public List<MenuItem> getAvailableMenu() {
        return menuRepo.findAvailable();
    }
}

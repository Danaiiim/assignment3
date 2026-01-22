package edu.aitu.oop.service;

import edu.aitu.oop.entity.MenuItem;
import edu.aitu.oop.repository.MenuItemRepository;

import java.sql.SQLException;
import java.util.List;

public class MenuService {

    private final MenuItemRepository repository = new MenuItemRepository();

    public List<MenuItem> getMenu() throws SQLException {
        return repository.findAvailable();
    }
}

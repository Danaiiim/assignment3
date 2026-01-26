package edu.aitu.oop.service;



import edu.aitu.oop.entity.MenuItem;
import edu.aitu.oop.repository.MenuItemRepository;
import java.util.List;

public class MenuService {

    private final MenuItemRepository repository = new MenuItemRepository();

    public List<MenuItem> getMenu() {
        try {
            return repository.findAvailable();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
}


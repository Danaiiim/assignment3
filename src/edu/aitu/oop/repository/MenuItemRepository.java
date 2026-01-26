package edu.aitu.oop.repository;

import edu.aitu.oop.config.DatabaseConfig;
import edu.aitu.oop.entity.MenuItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuItemRepository {

    private final Connection connection = DatabaseConfig.getConnection();

    public MenuItem findById(int id) {
        try {
            String sql = "SELECT * FROM menu_items WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new MenuItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getBoolean("available")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<MenuItem> findAvailable() {
        List<MenuItem> menu = new ArrayList<>();
        try {
            String sql = "SELECT * FROM menu_items WHERE available = true";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                menu.add(new MenuItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getBoolean("available")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menu;
    }
}




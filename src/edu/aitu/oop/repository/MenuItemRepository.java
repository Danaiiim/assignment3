package edu.aitu.oop.repository;

import edu.aitu.oop.config.DatabaseConfig;
import edu.aitu.oop.entity.MenuItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuItemRepository {

    public List<MenuItem> findAvailable() throws SQLException {
        List<MenuItem> list = new ArrayList<>();
        String sql = "SELECT * FROM menu_items WHERE available = true";

        try (Connection conn = DatabaseConfig.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new MenuItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getBoolean("available")
                ));
            }
        }
        return list;
    }
}

package edu.aitu.oop.repository;

import edu.aitu.oop.config.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderItemRepository {

    public void addItem(int orderId, int itemId, int quantity) throws SQLException {
        String sql =
                "INSERT INTO order_items (order_id, menu_item_id, quantity) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, orderId);
            ps.setInt(2, itemId);
            ps.setInt(3, quantity);
            ps.executeUpdate();
        }
    }
}

package edu.aitu.oop.repository;

import edu.aitu.oop.config.DatabaseConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    public int createOrder(int customerId) throws SQLException {
        String sql =
                "INSERT INTO orders (customer_id, status) VALUES (?, 'ACTIVE') RETURNING id";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
    }

    public void completeOrder(int orderId) throws SQLException {
        String sql = "UPDATE orders SET status = 'COMPLETED' WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, orderId);
            ps.executeUpdate();
        }
    }

    public List<String> findActiveOrders() throws SQLException {
        List<String> list = new ArrayList<>();
        String sql = """
                SELECT o.id, c.name
                FROM orders o
                JOIN customers c ON o.customer_id = c.id
                WHERE o.status = 'ACTIVE'
                """;

        try (Connection conn = DatabaseConfig.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add("Order #" + rs.getInt("id")
                        + " | Customer: " + rs.getString("name"));
            }
        }
        return list;
    }
}


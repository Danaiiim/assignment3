package edu.aitu.oop.repository;

import edu.aitu.oop.config.DatabaseConfig;
import edu.aitu.oop.exceptions.OrderNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    public int createOrder(int customerId) {
        String sql =
                "INSERT INTO orders (customer_id, status) VALUES (?, 'ACTIVE') RETURNING id";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void completeOrder(int orderId) {
        String sql =
                "UPDATE orders SET status = 'COMPLETED' WHERE id = ? AND status = 'ACTIVE'";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, orderId);
            int updated = ps.executeUpdate();

            if (updated == 0) {
                throw new OrderNotFoundException("Order not found: " + orderId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> findActiveOrders() {
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

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}



package edu.aitu.oop.repository;

import edu.aitu.oop.config.DatabaseConfig;
import edu.aitu.oop.exceptions.OrderNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    public int createOrder(int customerId, String customerName, String type, double totalPrice) {
        String sql = "INSERT INTO orders (customer_id, customer_name, type, total_price, status) " +
                "VALUES (?, ?, ?, ?, 'ACTIVE') RETURNING id";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, customerId);
            ps.setString(2, customerName);
            ps.setString(3, type);
            ps.setDouble(4, totalPrice);

            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void completeOrder(int orderId) {
        String sql = "UPDATE orders SET status = 'COMPLETED' WHERE id = ? AND status = 'ACTIVE'";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, orderId);
            int updated = ps.executeUpdate();

            if (updated == 0) throw new OrderNotFoundException("Order not found: " + orderId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> findActiveOrders() {
        List<String> list = new ArrayList<>();
        String sql = "SELECT id, customer_name, type, total_price FROM orders WHERE status='ACTIVE'";

        try (Connection conn = DatabaseConfig.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add("Order #" + rs.getInt("id") +
                        " | Customer: " + rs.getString("customer_name") +
                        " | Type: " + rs.getString("type") +
                        " | Total: " + rs.getDouble("total_price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

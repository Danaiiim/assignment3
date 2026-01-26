package edu.aitu.oop.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    private static final String URL =
            "jdbc:postgresql://aws-1-ap-southeast-1.pooler.supabase.com:5432/postgres";
    private static final String USER = "postgres.gvivkovrvjofrgarcbme";
    private static final String PASSWORD = "Danaim0801**";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

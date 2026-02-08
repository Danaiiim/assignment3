package edu.aitu.oop.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DatabaseConfig {
    private static final String ENV_PATH = ".env"; // путь к твоему .env
    private static String URL;
    private static String USER;
    private static String PASSWORD;

    static {
        Map<String, String> env = loadEnv(ENV_PATH);
        URL = env.get("DB_URL");
        USER = env.get("DB_USER");
        PASSWORD = env.get("DB_PASSWORD");
    }

    private static Map<String, String> loadEnv(String path) {
        Map<String, String> map = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    map.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to read " + path + ": " + e.getMessage());
        }
        return map;
    }

    public static Connection getConnection() {
        try {
            if (URL == null || USER == null || PASSWORD == null) {
                System.err.println("Database environment variables are not set!");
                return null;
            }
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to PostgreSQL successfully!");
            return conn;
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        getConnection();
    }
}
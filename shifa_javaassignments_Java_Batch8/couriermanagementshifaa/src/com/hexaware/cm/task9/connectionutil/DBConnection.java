package com.hexaware.cm.task9.connectionutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class DBConnection {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Properties props = new Properties();

                InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("db.properties");

                if (input == null) {
                    throw new RuntimeException("Property file not found!");
                }

                props.load(input);

                String url = props.getProperty("db.url");
                String username = props.getProperty("db.username");
                String password = props.getProperty("db.password");

                connection = DriverManager.getConnection(url, username, password);
                System.out.println("✅ Database connected successfully!");

            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}

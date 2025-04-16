package com.hexaware.hm.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnUtil {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Properties props = new Properties();
            InputStream input = DBConnUtil.class.getClassLoader().getResourceAsStream("db.properties");
            
            if (input == null) {
                System.out.println("db.properties file not found!");
                return null;
            }

            props.load(input);

            String url = props.getProperty("url");
            String user = props.getProperty("username");
            String pass = props.getProperty("password");

            conn = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("❌ Database connection failed. Exiting...");
            e.printStackTrace();
        }

        return conn;
    }
}

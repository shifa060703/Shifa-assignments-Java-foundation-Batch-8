package com.hexaware.hm.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {
    public static String getDBUrl(String fileName) {
        Properties props = new Properties();
        String dbUrl = null;

        try (FileInputStream fis = new FileInputStream(fileName)) {
            props.load(fis);
            dbUrl = props.getProperty("db.url");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dbUrl;
    }

    public static String getUsername(String fileName) {
        Properties props = new Properties();
        String user = null;

        try (FileInputStream fis = new FileInputStream(fileName)) {
            props.load(fis);
            user = props.getProperty("db.username");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return user;
    }

    public static String getPassword(String fileName) {
        Properties props = new Properties();
        String password = null;

        try (FileInputStream fis = new FileInputStream(fileName)) {
            props.load(fis);
            password = props.getProperty("db.password");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return password;
    }
}

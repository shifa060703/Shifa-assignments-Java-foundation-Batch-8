package com.hexware.cm.task9.dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.cm.task9.connectionutil.DBConnection;

public class CourierServiceDb {
    private static Connection connection;

    public CourierServiceDb() {
        connection = DBConnection.getConnection();
    }

    // 1. Insert new courier
    public void insertCourier(int id, String sender, String receiver, String status, double price) throws SQLException {
        String query = "INSERT INTO courier (id, sender, receiver, status, price) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.setString(2, sender);
        ps.setString(3, receiver);
        ps.setString(4, status);
        ps.setDouble(5, price);
        ps.executeUpdate();
        System.out.println("Courier inserted successfully.");
    }

    // 2. Update courier status
    public void updateCourierStatus(int id, String newStatus) throws SQLException {
        String query = "UPDATE courier SET status = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, newStatus);
        ps.setInt(2, id);
        ps.executeUpdate();
        System.out.println("Courier status updated.");
    }

    // 3. Retrieve courier by ID
    public void getCourierById(int id) throws SQLException {
        String query = "SELECT * FROM courier WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Sender: " + rs.getString("sender"));
            System.out.println("Receiver: " + rs.getString("receiver"));
            System.out.println("Status: " + rs.getString("status"));
            System.out.println("Price: " + rs.getDouble("price"));
        }
    }

    // 4. Delivery history
    public void getDeliveryHistory(int parcelId) throws SQLException {
        String query = "SELECT * FROM delivery_history WHERE parcel_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, parcelId);
        ResultSet rs = ps.executeQuery();

        System.out.println("Delivery History for Parcel ID: " + parcelId);
        while (rs.next()) {
            System.out.println("Date: " + rs.getDate("delivery_date") +
                               ", Status: " + rs.getString("status"));
        }
    }

    // 5. Shipment status report
    public void generateShipmentStatusReport() throws SQLException {
        String query = "SELECT status, COUNT(*) AS count FROM courier GROUP BY status";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        System.out.println("Shipment Status Report:");
        while (rs.next()) {
            System.out.println("Status: " + rs.getString("status") +
                               " | Count: " + rs.getInt("count"));
        }
    }

    // 6. Revenue report
    public void generateRevenueReport() throws SQLException {
        String query = "SELECT SUM(price) AS totalRevenue FROM courier";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        if (rs.next()) {
            System.out.println("Total Revenue: ₹" + rs.getDouble("totalRevenue"));
        }
    }
}


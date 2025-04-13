package com.hexaware.cm.task9.connectionutil;



import com.hexware.cm.task9.dao.CourierServiceDb;

public class Task9 {
    public static void main(String[] args) {
        CourierServiceDb service = new CourierServiceDb();

        try {
            // Insert sample data
            service.insertCourier(101, "Alice", "Bob", "Shipped", 500.0);

            // Update courier status
            service.updateCourierStatus(101, "Delivered");

            // Retrieve courier info
            service.getCourierById(101);

            // View delivery history
            service.getDeliveryHistory(101);

            // Shipment status report
            service.generateShipmentStatusReport();

            // Revenue report
            service.generateRevenueReport();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


package com.hexaware.cm.task9.connectionutil;



import com.hexware.cm.task9.dao.CourierServiceDb;

public class Task9 {
    public static void main(String[] args) {
        CourierServiceDb service = new CourierServiceDb();

        try {
            // Insert sample data
            service.insertCourier(107, "Alice", "Bob", "Shipped", 500.0);

            // Update courier status
            service.updateCourierStatus(107, "Delivered");

            // Retrieve courier info
            service.getCourierById(107);

            // View delivery history
            service.getDeliveryHistory(107);

            // Shipment status report
            service.generateShipmentStatusReport();

            // Revenue report
            service.generateRevenueReport();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


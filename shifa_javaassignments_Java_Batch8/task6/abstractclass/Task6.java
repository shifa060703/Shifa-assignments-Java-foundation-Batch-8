package com.hexaware.cm.task6.abstractclass;

import com.hexaware.cm.task5.oops.*;

public class Task6 {
    public static void main(String[] args) {
        
        // Creating Employee and Courier objects
        Employee emp1 = new Employee(1, "Michael Brown", "michael@example.com", "1234567890", "Driver", 50000);
        Courier courier1 = new Courier(101, "John Doe", "123 Main St", "Alice Green", "789 Oak St", 2.5, "Shipped", "2025-04-14", 1);

        // Create an instance of CourierCompany
        CourierCompany company = new CourierCompany();

        // Creating service instances, passing the CourierCompany instance to the CourierAdminService constructor
        ICourierUserService userService = new CourierUserService();
        ICourierAdminService adminService = new CourierAdminService(company);  // Pass the company instance

        // Place a new courier order
        String trackingNumber = userService.placeOrder(courier1);
        System.out.println("Tracking Number for Courier Order: " + trackingNumber);

        // Get the status of the courier order
        System.out.println("Order Status: " + userService.getOrderStatus(trackingNumber));

        // Cancel the courier order
        boolean isCancelled = userService.cancelOrder(trackingNumber);
        System.out.println("Order Cancelled: " + isCancelled);

        // Add courier staff
        int employeeID = adminService.addCourierStaff(emp1); // ✅
        System.out.println("New Employee Added with ID: " + employeeID);
    }
}

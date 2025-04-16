package com.hexware.cm.task8.collections;

import com.hexaware.cm.task5.oops.Courier;
import com.hexaware.cm.task5.oops.Employee;
import com.hexaware.cm.task5.oops.Location;
import com.hexaware.cm.task6.abstractclass.ICourierUserService;
import java.util.ArrayList;
import java.util.List;

public class Task8 {

    public static void main(String[] args) {
        // Create sample couriers
        Courier courier1 = new Courier(101, "John Doe", "123 Main St", "Alice Green", "789 Oak St", 2.5, "Shipped",  "2025-04-14", 1);
        Courier courier2 = new Courier(102, "Jane Smith", "456 Elm St", "Bob White", "123 Pine St", 3.0, "In Transit", "2025-04-15", 2);
        
        // Create sample employees and locations (you can reuse the classes from earlier)
        Employee employee1 = new Employee(201, "Michael Brown", "michael@example.com", "1122334455", "Driver", 50000);
        Location location1 = new Location(301, "Warehouse 1", "123 Industrial Rd");

        // Create lists for couriers, employees, and locations
        List<Courier> courierList = new ArrayList<>();
        courierList.add(courier1);
        courierList.add(courier2);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);

        List<Location> locationList = new ArrayList<>();
        locationList.add(location1);

        // Create CourierCompanyCollection instance
        CourierCompanyCollection company = new CourierCompanyCollection("FastTrack Couriers", courierList, employeeList, locationList);

        // Create CourierUserServiceCollectionImpl instance
        ICourierUserService userService = new CourierUserServiceCollectionImpl(company);

        // Place a new order
        Courier newCourier = new Courier(103, "Tom Green", "789 Pine St", "Jerry White", "456 Oak St", 5.0, "Shipped", "2025-04-16", 1);
        userService.placeOrder(newCourier);

        // Get assigned orders for courier staff with ID 1
        List<Courier> assignedOrders = userService.getAssignedOrder(1); // Corrected method name
        System.out.println("\nAssigned Orders for Courier Staff ID 1:");
        for (Courier order : assignedOrders) {
            System.out.println(order);
        }
    }
}

package com.hexaware.cm.task5.oops;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        
        // Creating instances of User class
        User user1 = new User(1, "Shifa", "john@example.com", "password123", "1234567890", "123 Main St");
        User user2 = new User(2, "Fathima", "jane@example.com", "password456", "9876543210", "456 Elm St");

        // Creating instances of Courier class
        Courier courier1 = new Courier(101, "Rifa", "123 Main St", "Alice Green", "789 Oak St", 2.5, "Shipped", "2025-04-14", 1);
        Courier courier2 = new Courier(102, "Zainab", "456 Elm St", "Bob White", "123 Pine St", 3.0, "In Transit", "2025-04-15", 2);

        // Creating instances of Employee class
        Employee employee1 = new Employee(201, "Michael Brown", "michael@example.com", "1122334455", "Driver", 50000);
        Employee employee2 = new Employee(202, "Sarah Black", "sarah@example.com", "2233445566", "Manager", 70000);

        // Creating instances of Location class
        Location location1 = new Location(301, "Warehouse 1", "123 Industrial Rd");
        Location location2 = new Location(302, "Warehouse 2", "456 Commercial Blvd");

        // Creating list of Courier, Employee, and Location objects
        List<Courier> courierList = new ArrayList<>();
        courierList.add(courier1);
        courierList.add(courier2);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);

        List<Location> locationList = new ArrayList<>();
        locationList.add(location1);
        locationList.add(location2);

        // Creating instance of CourierCompany class
        CourierCompany company = new CourierCompany("FastTrack Couriers", courierList, employeeList, locationList);

        // Creating instance of Payment class
        Payment payment1 = new Payment(1001, 101, 50.75, new Date());
        Payment payment2 = new Payment(1002, 102, 60.00, new Date());

        // Printing the created objects to verify
        System.out.println("User Details:");
        System.out.println(user1);
        System.out.println(user2);
        
        System.out.println("\nCourier Details:");
        System.out.println(courier1);
        System.out.println(courier2);
        
        System.out.println("\nEmployee Details:");
        System.out.println(employee1);
        System.out.println(employee2);
        
        System.out.println("\nLocation Details:");
        System.out.println(location1);
        System.out.println(location2);
        
        System.out.println("\nCourier Company Details:");
        System.out.println(company);
        
        System.out.println("\nPayment Details:");
        System.out.println(payment1);
        System.out.println(payment2);
    }
}


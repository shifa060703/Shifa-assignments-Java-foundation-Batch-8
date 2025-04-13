package com.hexaware.cm.task2.loops;

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n==== Loop Task Menu ====");
            System.out.println("1. Display Orders for Customer");
            System.out.println("2. Track Courier Location");
            System.out.println("3. Exit");
            System.out.print("Choose a task (1-3): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    displayOrdersForCustomer(scanner);
                    break;
                case 2:
                    trackCourier(scanner);
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting Loop Task Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    // Task 5: For loop - Display all orders for a customer
    public static void displayOrdersForCustomer(Scanner scanner) {
        System.out.print("Enter number of orders for the customer: ");
        int numOrders = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String[] orders = new String[numOrders];
        for (int i = 0; i < numOrders; i++) {
            System.out.print("Enter order " + (i + 1) + " ID: ");
            orders[i] = scanner.nextLine();
        }

        System.out.println("\nOrders for the customer:");
        for (int i = 0; i < orders.length; i++) {
            System.out.println("Order " + (i + 1) + ": " + orders[i]);
        }
    }

    // Task 6: While loop - Track courier location
    public static void trackCourier(Scanner scanner) {
        System.out.println("Tracking courier... Type 'Arrived' to stop tracking.");
        String location = "";

        while (!location.equalsIgnoreCase("Arrived")) {
            System.out.print("Enter current location (or type 'Arrived' if reached): ");
            location = scanner.nextLine();
            if (!location.equalsIgnoreCase("Arrived")) {
                System.out.println("Courier is at: " + location);
            }
        }

        System.out.println("Courier has reached the destination.");
    }
}


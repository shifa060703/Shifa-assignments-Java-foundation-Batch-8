package com.hexaware.cm.task1.control;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n==== Control Flow Task Menu ====");
            System.out.println("1. Check Order Status");
            System.out.println("2. Parcel Weight Category");
            System.out.println("3. User Authentication");
            System.out.println("4. Exit");
            System.out.print("Choose a task (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    checkOrderStatus(scanner);
                    break;
                case 2:
                    categorizeParcelWeight(scanner);
                    break;
                case 3:
                    authenticateUser(scanner);
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting Task Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    // Task 1
    public static void checkOrderStatus(Scanner scanner) {
        System.out.print("Enter order status (Processing / Delivered / Cancelled): ");
        String status = scanner.nextLine();

        if (status.equalsIgnoreCase("Processing")) {
            System.out.println("Your order is still being processed.");
        } else if (status.equalsIgnoreCase("Delivered")) {
            System.out.println("Your order has been delivered.");
        } else if (status.equalsIgnoreCase("Cancelled")) {
            System.out.println("Your order has been cancelled.");
        } else {
            System.out.println("Invalid status entered.");
        }
    }

    // Task 2
    public static void categorizeParcelWeight(Scanner scanner) {
        System.out.print("Enter parcel weight in kg: ");
        double weight = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        int category;
        if (weight < 2) {
            category = 1; // Light
        } else if (weight < 5) {
            category = 2; // Medium
        } else {
            category = 3; // Heavy
        }

        switch (category) {
            case 1:
                System.out.println("The parcel is Light.");
                break;
            case 2:
                System.out.println("The parcel is Medium.");
                break;
            case 3:
                System.out.println("The parcel is Heavy.");
                break;
            default:
                System.out.println("Invalid weight.");
        }
    }

    // Task 3
    public static void authenticateUser(Scanner scanner) {
        String validUsername = "employee123";
        String validPassword = "password123";

        System.out.print("Enter username: ");
        String inputUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();

        if (inputUsername.equals(validUsername) && inputPassword.equals(validPassword)) {
            System.out.println("Login successful! Welcome, " + inputUsername + ".");
        } else {
            System.out.println("Invalid credentials. Access denied.");
        }
    }
}

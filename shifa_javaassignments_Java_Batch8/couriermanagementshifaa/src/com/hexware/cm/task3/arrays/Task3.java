package com.hexware.cm.task3.arrays;


import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n==== Array & Data Structure Task Menu ====");
            System.out.println("1. Track Parcel History");
            System.out.println("2. Find Nearest Courier");
            System.out.println("3. Exit");
            System.out.print("Choose a task (1-3): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    trackParcelHistory(scanner);
                    break;
                case 2:
                    findNearestCourier(scanner);
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting Array Tasks Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    // Task 7: Store tracking history of a parcel
    public static void trackParcelHistory(Scanner scanner) {
        System.out.print("Enter number of tracking updates: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String[] trackingHistory = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter location update " + (i + 1) + ": ");
            trackingHistory[i] = scanner.nextLine();
        }

        System.out.println("\nTracking History:");
        for (int i = 0; i < trackingHistory.length; i++) {
            System.out.println((i + 1) + ". " + trackingHistory[i]);
        }
    }

    // Task 8: Find nearest available courier
    public static void findNearestCourier(Scanner scanner) {
        System.out.print("Enter number of couriers: ");
        int count = scanner.nextInt();

        String[] courierNames = new String[count];
        int[] distances = new int[count];

        scanner.nextLine(); // consume newline

        for (int i = 0; i < count; i++) {
            System.out.print("Enter courier name " + (i + 1) + ": ");
            courierNames[i] = scanner.nextLine();

            System.out.print("Enter distance (in km) from delivery location: ");
            distances[i] = scanner.nextInt();
            scanner.nextLine(); // consume newline
        }

        // Find the courier with the minimum distance
        int minIndex = 0;
        for (int i = 1; i < count; i++) {
            if (distances[i] < distances[minIndex]) {
                minIndex = i;
            }
        }

        System.out.println("\nNearest available courier: " + courierNames[minIndex] +
                " (Distance: " + distances[minIndex] + " km)");
    }
}


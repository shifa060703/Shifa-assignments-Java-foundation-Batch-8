package com.hexware.cm.task4.strhashuserdefn;


import java.util.*;
import java.util.regex.*;

public class Task4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n==== Task 4 Menu ====");
            System.out.println("1. Parcel Tracking");
            System.out.println("2. Customer Data Validation");
            System.out.println("3. Address Formatting");
            System.out.println("4. Order Confirmation Email");
            System.out.println("5. Calculate Shipping Costs");
            System.out.println("6. Password Generator");
            System.out.println("7. Find Similar Addresses");
            System.out.println("8. Exit");
            System.out.print("Choose a task (1-8): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    parcelTracking(scanner);
                    break;
                case 2:
                    customerDataValidation(scanner);
                    break;
                case 3:
                    addressFormatting(scanner);
                    break;
                case 4:
                    orderConfirmationEmail(scanner);
                    break;
                case 5:
                    calculateShippingCost(scanner);
                    break;
                case 6:
                    passwordGenerator();
                    break;
                case 7:
                    findSimilarAddresses(scanner);
                    break;
                case 8:
                    System.out.println("Exiting Task 4 Menu.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }

    public static void parcelTracking(Scanner scanner) {
        String[][] parcels = {
            {"123", "In Transit"},
            {"456", "Out for Delivery"},
            {"789", "Delivered"}
        };

        System.out.print("Enter tracking number: ");
        String input = scanner.nextLine();

        boolean found = false;
        for (String[] parcel : parcels) {
            if (parcel[0].equals(input)) {
                System.out.println("Status: " + parcel[1]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Tracking number not found.");
        }
    }

    public static void customerDataValidation(Scanner scanner) {
        System.out.print("Enter detail type (name/address/phone): ");
        String detail = scanner.nextLine().toLowerCase();
        System.out.print("Enter data: ");
        String data = scanner.nextLine();

        boolean isValid = false;

        switch (detail) {
            case "name":
                isValid = data.matches("[A-Z][a-z]+( [A-Z][a-z]+)*");
                break;
            case "address":
                isValid = !data.matches(".*[^a-zA-Z0-9\\s].*");
                break;
            case "phone":
                isValid = data.matches("\\d{3}-\\d{3}-\\d{4}");
                break;
            default:
                isValid = false;
        }

        if (isValid) {
            System.out.println("Valid " + detail);
        } else {
            System.out.println("Invalid " + detail);
        }
    }

    public static void addressFormatting(Scanner scanner) {
        System.out.print("Enter street: ");
        String street = scanner.nextLine();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        System.out.print("Enter state: ");
        String state = scanner.nextLine();
        System.out.print("Enter zip code: ");
        String zip = scanner.nextLine();

        String fullAddress = capitalizeWords(street) + ", " +
                             capitalizeWords(city) + ", " +
                             capitalizeWords(state) + " - " + zip;

        System.out.println("Formatted Address: " + fullAddress);
    }

    public static String capitalizeWords(String input) {
        String[] words = input.toLowerCase().split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty())
                result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
        }

        return result.toString().trim();
    }

    public static void orderConfirmationEmail(Scanner scanner) {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter order number: ");
        String orderNumber = scanner.nextLine();
        System.out.print("Enter delivery address: ");
        String address = scanner.nextLine();
        System.out.print("Enter expected delivery date: ");
        String date = scanner.nextLine();

        System.out.println("\n=== Order Confirmation Email ===");
        System.out.println("Dear " + name + ",");
        System.out.println("Your order #" + orderNumber + " has been confirmed.");
        System.out.println("It will be delivered to: " + address);
        System.out.println("Expected Delivery Date: " + date);
        System.out.println("Thank you for choosing our service!");
    }

    public static void calculateShippingCost(Scanner scanner) {
        System.out.print("Enter source address: ");
        String source = scanner.nextLine();
        System.out.print("Enter destination address: ");
        String destination = scanner.nextLine();
        System.out.print("Enter parcel weight (kg): ");
        double weight = scanner.nextDouble();

        double baseCost = 50;
        double distanceFactor = 10;
        double estimatedDistance = Math.random() * 100;

        double totalCost = baseCost + (estimatedDistance * distanceFactor * weight) / 100;
        System.out.printf("Estimated shipping cost from %s to %s is ₹%.2f\n", source, destination, totalCost);
    }

    public static void passwordGenerator() {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String special = "!@#$%^&*()";
        String combined = upper + lower + digits + special;

        Random rand = new Random();
        StringBuilder password = new StringBuilder();

        password.append(upper.charAt(rand.nextInt(upper.length())));
        password.append(lower.charAt(rand.nextInt(lower.length())));
        password.append(digits.charAt(rand.nextInt(digits.length())));
        password.append(special.charAt(rand.nextInt(special.length())));

        for (int i = 4; i < 10; i++) {
            password.append(combined.charAt(rand.nextInt(combined.length())));
        }

        System.out.println("Generated Secure Password: " + password);
    }

    public static void findSimilarAddresses(Scanner scanner) {
        String[] addresses = {
            "123 Park Avenue",
            "123 Park Ave",
            "456 Elm Street",
            "456 Elm St",
            "789 Pine Lane"
        };

        System.out.print("Enter address to search similar: ");
        String input = scanner.nextLine().toLowerCase();

        System.out.println("Similar addresses found:");
        for (String addr : addresses) {
            if (addr.toLowerCase().contains(input) || input.contains(addr.toLowerCase())) {
                System.out.println("- " + addr);
            }
        }
    }
}


package com.hexaware.cm.task7.exceptionhandling;

import java.util.ArrayList;
import java.util.List;

public class Task7 {
    
    // Simulating a list of employee IDs to check against
    static List<Integer> employeeIds = new ArrayList<>();
    
    static {
        // Initializing the list of employee IDs (for demonstration)
        employeeIds.add(101);
        employeeIds.add(102);
        employeeIds.add(103);
        employeeIds.add(104);
    }

    public static void main(String[] args) {
        
        // Handling TrackingNumberNotFoundException
        try {
            System.out.println("Checking tracking number...");
            checkTrackingNumber("T123456789");  // Example: Existing tracking number
            checkTrackingNumber("T987654321");  // Example: Non-existing tracking number
        } catch (TrackingNumberNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Handling InvalidEmployeeIdException
        try {
            System.out.println("\nValidating employee ID...");
            validateEmployeeId(101);  // Example: Existing employee ID
            validateEmployeeId(999);  // Example: Invalid employee ID
        } catch (InvalidEmployeeIdException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Handling other exceptions with finally block
        try {
            System.out.println("\nPerforming operations...");
            // Example of throwing checked exception
            withdrawAmount(1000);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Execution completed. Resources closed.");
        }
    }

    // Method that throws TrackingNumberNotFoundException if tracking number is invalid
    public static void checkTrackingNumber(String trackingNumber) throws TrackingNumberNotFoundException {
        // Simulating the case where tracking number "T987654321" is not found
        if (trackingNumber.equals("T987654321")) {
            throw new TrackingNumberNotFoundException("Tracking number " + trackingNumber + " not found in the system.");
        } else {
            System.out.println("Tracking number " + trackingNumber + " is valid.");
        }
    }

    // Method that throws InvalidEmployeeIdException if employee ID is not found
    public static void validateEmployeeId(int employeeId) throws InvalidEmployeeIdException {
        if (!employeeIds.contains(employeeId)) {
            throw new InvalidEmployeeIdException("Employee ID " + employeeId + " does not exist.");
        } else {
            System.out.println("Employee ID " + employeeId + " is valid.");
        }
    }

    // Method simulating a bank transaction that throws an exception
    public static void withdrawAmount(int amount) throws Exception {
        // Simulating an exception during a transaction
        if (amount < 5000) {
            throw new Exception("Amount is below the minimum withdrawal limit.");
        } else {
            System.out.println("Amount " + amount + " withdrawn successfully.");
        }
    }
}


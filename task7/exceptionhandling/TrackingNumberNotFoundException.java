package com.hexaware.cm.task7.exceptionhandling;

public class TrackingNumberNotFoundException extends Exception {
    // Default constructor
    public TrackingNumberNotFoundException() {
        super("Tracking number not found in the system.");
    }
    
    // Constructor with a custom message
    public TrackingNumberNotFoundException(String message) {
        super(message);
    }
}


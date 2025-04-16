package com.hexaware.cm.task7.exceptionhandling;

public class InvalidEmployeeIdException extends Exception {
    // Default constructor
    public InvalidEmployeeIdException() {
        super("Employee ID does not exist in the system.");
    }
    
    // Constructor with a custom message
    public InvalidEmployeeIdException(String message) {
        super(message);
    }
}

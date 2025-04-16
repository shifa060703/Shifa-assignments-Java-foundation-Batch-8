package com.hexaware.hm.exception;

public class PatientNumberNotFoundException extends Exception {
    public PatientNumberNotFoundException() {
        super("Patient number not found in the database.");
    }

    public PatientNumberNotFoundException(String message) {
        super(message);
    }
}

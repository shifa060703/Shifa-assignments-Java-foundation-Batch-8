package com.hexaware.cm.task5.oops;

import java.util.ArrayList;
import java.util.List;

public class CourierCompany {
    private String companyName;
    private List<Courier> courierDetails;
    private List<Employee> employeeDetails;
    private List<Location> locationDetails;

    // Default constructor
    public CourierCompany() {
        // Initialize the lists to avoid NullPointerException
        courierDetails = new ArrayList<>();
        employeeDetails = new ArrayList<>();
        locationDetails = new ArrayList<>();
    }

    // Parametrized constructor
    public CourierCompany(String companyName, List<Courier> courierDetails, List<Employee> employeeDetails, List<Location> locationDetails) {
        this.companyName = companyName;
        this.courierDetails = courierDetails;
        this.employeeDetails = employeeDetails;
        this.locationDetails = locationDetails;
    }

    // Getters and Setters
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Courier> getCourierDetails() {
        return courierDetails;
    }

    public void setCourierDetails(List<Courier> courierDetails) {
        this.courierDetails = courierDetails;
    }

    public List<Employee> getEmployeeDetails() {
        return employeeDetails;
    }

    public void setEmployeeDetails(List<Employee> employeeDetails) {
        this.employeeDetails = employeeDetails;
    }

    public List<Location> getLocationDetails() {
        return locationDetails;
    }

    public void setLocationDetails(List<Location> locationDetails) {
        this.locationDetails = locationDetails;
    }

    // Method to add an employee to the company
    public void addEmployee(Employee employee) {
        employeeDetails.add(employee);
    }

    // Method to add a courier to the company
    public void addCourier(Courier courier) {
        courierDetails.add(courier);
    }

    // Method to retrieve all employees
    public List<Employee> getAllEmployees() {
        return employeeDetails;
    }

    // Method to retrieve all couriers
    public List<Courier> getAllCouriers() {
        return courierDetails;
    }

    // New method to remove a courier by tracking number
    public boolean removeCourier(String trackingNumber) {
        // Loop through the list of couriers and remove the one with the matching tracking number
        for (Courier courier : courierDetails) {
            if (courier.getTrackingNumber().equals(trackingNumber)) {
                courierDetails.remove(courier);
                return true; // Courier removed successfully
            }
        }
        return false; // Courier with that tracking number was not found
    }

    // toString method
    @Override
    public String toString() {
        return "CourierCompany [companyName=" + companyName + ", courierDetails=" + courierDetails + ", employeeDetails=" + employeeDetails + ", locationDetails=" + locationDetails + "]";
    }
}

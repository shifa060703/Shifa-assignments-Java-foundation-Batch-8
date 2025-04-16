package com.hexware.cm.task8.collections;

import com.hexaware.cm.task5.oops.Courier;
import com.hexaware.cm.task5.oops.Employee;
import com.hexaware.cm.task5.oops.Location;
import java.util.List;

public class CourierCompanyCollection {
    
    private String companyName;
    private List<Courier> courierList;
    private List<Employee> employeeList;
    private List<Location> locationList;

    // Constructor to initialize company with couriers, employees, and locations
    public CourierCompanyCollection(String companyName, List<Courier> courierList, 
                                    List<Employee> employeeList, List<Location> locationList) {
        this.companyName = companyName;
        this.courierList = courierList;
        this.employeeList = employeeList;
        this.locationList = locationList;
    }

    // Getters and setters
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Courier> getCourierList() {
        return courierList;
    }

    public void setCourierList(List<Courier> courierList) {
        this.courierList = courierList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }
}

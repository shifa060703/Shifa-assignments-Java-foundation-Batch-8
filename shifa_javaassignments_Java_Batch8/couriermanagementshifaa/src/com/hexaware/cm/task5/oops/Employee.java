package com.hexaware.cm.task5.oops;

public class Employee {
    private int empId;
    private String empName;
    private String email;
    private String phone;
    private String role;
    private double salary;

    // Constructor
    public Employee(int empId, String empName, String email, String phone, String role, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.salary = salary;
    }

    // Getters
    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getRole() {
        return role;
    }

    public double getSalary() {
        return salary;
    }

   
    // Override toString for easy printing of Employee details
    @Override
    public String toString() {
        return "Employee [ID=" + empId + ", Name=" + empName + ", Role=" + role + "]";
    }
}

package com.hexaware.cm.task6.abstractclass;

import java.util.List;
import com.hexaware.cm.task5.oops.Employee;

public interface ICourierAdminService {
    
    // Add an employee
    int addCourierStaff(Employee e);
    
    // Display all employees (staff)
    void displayAllStaff();
    
    // Display employees by role
    void displayStaffByRole(String role);
}


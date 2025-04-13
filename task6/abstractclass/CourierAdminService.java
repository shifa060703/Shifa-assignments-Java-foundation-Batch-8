package com.hexaware.cm.task6.abstractclass;


import java.util.List;
import java.util.stream.Collectors;
import com.hexaware.cm.task5.oops.Employee;
import com.hexaware.cm.task5.oops.CourierCompany;
import com.hexaware.cm.task6.abstractclass.ICourierAdminService;

public class CourierAdminService implements ICourierAdminService {

    private CourierCompany companyObj; // Reference to CourierCompany object

    // Constructor to initialize CourierCompany object
    public CourierAdminService(CourierCompany companyObj) {
        this.companyObj = companyObj;
    }

    // Implementation of addCourierStaff method
    @Override
    public int addCourierStaff(Employee e) {
        companyObj.addEmployee(e); // Adds an employee to the company
        System.out.println("Employee added: " + e.getEmpName());
        return e.getEmpId(); // Return the employee ID
    }

    // Implementation of displayAllStaff method
    @Override
    public void displayAllStaff() {
        List<Employee> employees = companyObj.getAllEmployees(); // Fetch all employees from the company
        System.out.println("Displaying all staff:");
        for (Employee emp : employees) {
            System.out.println(emp); // Print employee details
        }
    }

    // Implementation of displayStaffByRole method
    @Override
    public void displayStaffByRole(String role) {
        List<Employee> employees = companyObj.getAllEmployees().stream()
                .filter(emp -> emp.getRole().equals(role)) // Filter employees by role
                .collect(Collectors.toList());

        System.out.println("Displaying staff with role " + role + ":");
        for (Employee emp : employees) {
            System.out.println(emp); // Print employee details
        }
    }
}

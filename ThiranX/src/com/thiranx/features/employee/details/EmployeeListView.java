package com.thiranx.features.employee.details;

import com.thiranx.data.dto.Employee;

import java.util.List;

public class EmployeeListView {

    private final EmployeeListModel model;

    public EmployeeListView() {
        this.model = new EmployeeListModel(this);
    }

    public void showAllEmployees() {
        List<Employee> employees = model.getAllEmployees();
        System.out.println("\n--- Employees (" + employees.size() + ") ---");
        if (employees.isEmpty()) {
            System.out.println("No employees yet.");
            return;
        }
        for (Employee e : employees) {
            System.out.println(
                    e.getEmployeeId() + " | " + e.getName() + " | " + e.getEmailId() + " | " + e.getMobileNo()
            );
        }
    }
}

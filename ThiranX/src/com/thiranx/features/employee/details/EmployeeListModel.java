package com.thiranx.features.employee.details;

import com.thiranx.data.dto.Employee;
import com.thiranx.data.repository.ThiranXDB;

import java.util.List;

public class EmployeeListModel {

    private final EmployeeListView view;
    private final ThiranXDB db;

    public EmployeeListModel(EmployeeListView view) {
        this.view = view;
        this.db = ThiranXDB.getInstance();
    }

    public List<Employee> getAllEmployees() {
        return db.getEmployees();
    }
}

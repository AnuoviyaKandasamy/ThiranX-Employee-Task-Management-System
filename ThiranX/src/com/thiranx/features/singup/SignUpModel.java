package com.thiranx.features.singup;

import com.thiranx.data.dto.Employee;
import com.thiranx.data.repository.ThiranXDB;

public class SignUpModel {

    private final SignUpView signUpView;
    private final ThiranXDB db;

    public SignUpModel(SignUpView signUpView) {
        this.signUpView = signUpView;
        this.db = ThiranXDB.getInstance();
    }

    public void createUser(Employee employee) {
        if (employee == null) {
            signUpView.showError("Invalid user.");
            return;
        }
        if (employee.getEmailId() == null || employee.getEmailId().isBlank()) {
            signUpView.showError("Email is required.");
            return;
        }
        if (db.emailExists(employee.getEmailId())) {
            signUpView.showError("Email already exists.");
            return;
        }

        if (employee.getEmployeeId() == null || employee.getEmployeeId().isBlank()) {
            employee.setEmployeeId("EMP" + (db.getEmployees().size() + 1));
        }

        db.addEmployee(employee);
        signUpView.showUserCreated(employee);
    }
}

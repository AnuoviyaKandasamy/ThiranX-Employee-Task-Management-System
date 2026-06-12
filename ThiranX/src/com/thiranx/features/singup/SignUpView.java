package com.thiranx.features.singup;

import com.thiranx.data.dto.Employee;

import java.util.Scanner;

public class SignUpView {

    private final SignUpModel signUpModel;

    public SignUpView() {
        this.signUpModel = new SignUpModel(this);
    }

    public void init(Scanner sc) {
        System.out.println("\n--- Sign Up ---");

        System.out.print("Name: ");
        String name = sc.nextLine().trim();

        System.out.print("Email: ");
        String email = sc.nextLine().trim();

        System.out.print("Mobile No: ");
        String mobile = sc.nextLine().trim();

        System.out.print("Password: ");
        String password = sc.nextLine();

        Employee employee = new Employee();
        employee.setName(name);
        employee.setEmailId(email);
        employee.setMobileNo(mobile);
        employee.setPassword(password);

        signUpModel.createUser(employee);
    }

    public void showUserCreated(Employee employee) {
        System.out.println("User created: " + employee.getEmailId());
    }

    public void showError(String message) {
        System.out.println("Error: " + message);
    }
}

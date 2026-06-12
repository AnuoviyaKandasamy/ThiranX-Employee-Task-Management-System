package com.thiranx.features.singin;

import com.thiranx.data.dto.Employee;

import java.util.Scanner;

public class SignInView {

    private final SignInModel signInModel;

    public SignInView() {
        this.signInModel = new SignInModel(this);
    }

    public void init(Scanner sc) {
        System.out.println("\n--- Sign In ---");

        System.out.print("Email: ");
        String email = sc.nextLine().trim();

        System.out.print("Password: ");
        String password = sc.nextLine();

        signInModel.signIn(email, password);
    }

    public void showSignedIn(Employee employee) {
        System.out.println("Signed in as: " + employee.getName() + " (" + employee.getEmailId() + ")");
    }

    public void showError(String message) {
        System.out.println("Error: " + message);
    }
}

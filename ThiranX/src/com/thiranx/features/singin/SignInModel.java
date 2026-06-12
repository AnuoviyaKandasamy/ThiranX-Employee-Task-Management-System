package com.thiranx.features.singin;

import com.thiranx.data.dto.Employee;
import com.thiranx.data.repository.ThiranXDB;

public class SignInModel {

    private final SignInView signInView;
    private final ThiranXDB db;

    public SignInModel(SignInView signInView) {
        this.signInView = signInView;
        this.db = ThiranXDB.getInstance();
    }

    public void signIn(String email, String password) {
        if (email == null || email.isBlank()) {
            signInView.showError("Email is required.");
            return;
        }
        if (password == null) {
            signInView.showError("Password is required.");
            return;
        }

        Employee employee = db.authenticate(email, password);
        if (employee == null) {
            signInView.showError("Invalid credentials.");
            return;
        }
        signInView.showSignedIn(employee);
    }
}

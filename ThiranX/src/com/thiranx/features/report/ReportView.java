package com.thiranx.features.report;

public class ReportView {

    private final ReportModel model;

    public ReportView() {
        this.model = new ReportModel(this);
    }

    public void showSummary() {
        System.out.println("\n--- Report ---");
        System.out.println("Employees: " + model.employeeCount());
        System.out.println("Tasks: " + model.taskCount());
        System.out.println("Notifications: " + model.notificationCount());
    }
}

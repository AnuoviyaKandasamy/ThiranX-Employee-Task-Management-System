package com.thiranx.features.report;

import com.thiranx.data.repository.ThiranXDB;

public class ReportModel {

    private final ReportView view;
    private final ThiranXDB db;

    public ReportModel(ReportView view) {
        this.view = view;
        this.db = ThiranXDB.getInstance();
    }

    public int employeeCount() {
        return db.getEmployees().size();
    }

    public int taskCount() {
        return db.getTasks().size();
    }

    public int notificationCount() {
        return db.getNotifications().size();
    }
}

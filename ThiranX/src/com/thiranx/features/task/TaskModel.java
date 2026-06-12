package com.thiranx.features.task;

import com.thiranx.data.dto.Employee;
import com.thiranx.data.dto.Task;
import com.thiranx.data.repository.ThiranXDB;

public class TaskModel {
    private final TaskView view;
    private final ThiranXDB db;

    public TaskModel(TaskView view) {
        this.view = view;
        this.db = ThiranXDB.getInstance();
    }

    public Task createTask(String title, String description, String assignedToEmail, String assignedByEmail) {
        if (title == null || title.isBlank()) return null;
        if (assignedToEmail == null || assignedToEmail.isBlank()) return null;

        Employee assignee = db.findEmployeeByEmail(assignedToEmail.trim());
        if (assignee == null) return null;

        Task t = new Task();
        t.setId(db.getTasks().size() + 1);
        t.setTitle(title.trim());
        t.setDescription(description == null ? "" : description.trim());
        t.setAssignedTo(assignee.getEmailId());
        t.setAssignedBy(assignedByEmail == null ? "SYSTEM" : assignedByEmail.trim());
        t.setCreatedTime(System.currentTimeMillis());
        db.addTask(t);
        return t;
    }
}


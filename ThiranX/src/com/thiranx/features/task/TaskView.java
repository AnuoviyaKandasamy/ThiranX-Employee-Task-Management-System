package com.thiranx.features.task;

import com.thiranx.data.dto.Task;
import com.thiranx.data.repository.ThiranXDB;

import java.util.List;
import java.util.Scanner;

public class TaskView {
    private final TaskModel model;
    private final ThiranXDB db;

    public TaskView() {
        this.model = new TaskModel(this);
        this.db = ThiranXDB.getInstance();
    }

    public void menu(Scanner sc) {
        while (true) {
            System.out.println("\n--- Tasks ---");
            System.out.println("1. Create task");
            System.out.println("2. List tasks");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    create(sc);
                    break;
                case "2":
                    list();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void create(Scanner sc) {
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Description: ");
        String desc = sc.nextLine();
        System.out.print("Assign to (email): ");
        String assignedTo = sc.nextLine();

        Task t = model.createTask(title, desc, assignedTo, "SYSTEM");
        if (t == null) {
            System.out.println("Error: title + valid assignee email required.");
        } else {
            System.out.println("Task created #" + t.getId());
        }
    }

    private void list() {
        List<Task> tasks = db.getTasks();
        System.out.println("\nTasks (" + tasks.size() + "):");
        if (tasks.isEmpty()) {
            System.out.println("No tasks.");
            return;
        }
        for (Task t : tasks) {
            System.out.println("#" + t.getId() + " | " + t.getTitle() + " | to: " + t.getAssignedTo());
        }
    }
}


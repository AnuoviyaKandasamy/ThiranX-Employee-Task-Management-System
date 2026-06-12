package com.thiranx.data.repository;

import com.thiranx.data.dto.Employee;
import com.thiranx.data.dto.Notification;
import com.thiranx.data.dto.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ThiranXDB {

    private ThiranXDB() {
        this.employees = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    private static ThiranXDB thiranXDB = null;

    public static ThiranXDB getInstance() {
        if (thiranXDB == null) {
            thiranXDB = new ThiranXDB();
        }
        return thiranXDB;
    }

    private final List<Employee> employees;
    private final List<Task> tasks;
    private final List<Notification> notifications;

    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(employees);
    }

    public List<Task> getTasks() {
        return Collections.unmodifiableList(tasks);
    }

    public List<Notification> getNotifications() {
        return Collections.unmodifiableList(notifications);
    }

    public Employee addEmployee(Employee employee) {
        if (employee == null) return null;
        employees.add(employee);
        return employee;
    }

    public boolean emailExists(String emailId) {
        if (emailId == null) return false;
        for (Employee e : employees) {
            if (emailId.equalsIgnoreCase(e.getEmailId())) return true;
        }
        return false;
    }

    public Employee findEmployeeByEmail(String emailId) {
        if (emailId == null) return null;
        for (Employee e : employees) {
            if (emailId.equalsIgnoreCase(e.getEmailId())) return e;
        }
        return null;
    }

    public Employee authenticate(String emailId, String password) {
        Employee e = findEmployeeByEmail(emailId);
        if (e == null) return null;
        if (Objects.equals(e.getPassword(), password)) return e;
        return null;
    }

    public Task addTask(Task task) {
        if (task == null) return null;
        tasks.add(task);
        return task;
    }

    public Notification addNotification(Notification notification) {
        if (notification == null) return null;
        notifications.add(notification);
        return notification;
    }
}

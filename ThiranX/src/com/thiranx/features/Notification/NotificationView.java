package com.thiranx.features.Notification;

import com.thiranx.data.dto.Notification;

import java.util.List;
import java.util.Scanner;

public class NotificationView {

    private final NotificationModel model;

    public NotificationView() {
        this.model = new NotificationModel(this);
    }

    public void menu(Scanner sc) {
        while (true) {
            System.out.println("\n--- Notifications ---");
            System.out.println("1. Add notification");
            System.out.println("2. List notifications");
            System.out.println("3. Mark as read");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.print("Message: ");
                    String msg = sc.nextLine();
                    Notification n = model.add(msg);
                    if (n == null) System.out.println("Error: message required.");
                    else System.out.println("Added notification #" + n.getId());
                    break;
                case "2":
                    showAll();
                    break;
                case "3":
                    System.out.print("Notification id: ");
                    String raw = sc.nextLine().trim();
                    try {
                        int id = Integer.parseInt(raw);
                        boolean ok = model.markRead(id);
                        System.out.println(ok ? "Marked read." : "Not found.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid id.");
                    }
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void showAll() {
        List<Notification> list = model.list();
        System.out.println("\nNotifications (" + list.size() + "):");
        if (list.isEmpty()) {
            System.out.println("No notifications.");
            return;
        }
        for (Notification n : list) {
            String status = n.isRead() ? "READ" : "UNREAD";
            System.out.println("#" + n.getId() + " [" + status + "] " + n.getMessage());
        }
    }
}

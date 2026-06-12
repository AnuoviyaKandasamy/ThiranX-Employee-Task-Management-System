package com.thiranx.features.Notification;

import com.thiranx.data.dto.Notification;
import com.thiranx.data.repository.ThiranXDB;

import java.util.List;

public class NotificationModel {

    private final NotificationView view;
    private final ThiranXDB db;

    public NotificationModel(NotificationView view) {
        this.view = view;
        this.db = ThiranXDB.getInstance();
    }

    public Notification add(String message) {
        if (message == null || message.isBlank()) return null;
        Notification n = new Notification();
        n.setId(db.getNotifications().size() + 1);
        n.setMessage(message.trim());
        n.setCreatedAt(System.currentTimeMillis());
        n.setRead(false);
        return db.addNotification(n);
    }

    public List<Notification> list() {
        return db.getNotifications();
    }

    public boolean markRead(int id) {
        for (Notification n : db.getNotifications()) {
            if (n.getId() != null && n.getId() == id) {
                n.setRead(true);
                return true;
            }
        }
        return false;
    }
}

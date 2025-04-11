package net.javaguides.springboot.strategy;

import net.javaguides.springboot.model.UserRole;

public interface NotificationHandler {

    void handleNotification(UserRole user);
}

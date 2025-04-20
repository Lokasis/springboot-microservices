package net.javaguides.springboot.factory;

import net.javaguides.springboot.exception.InvalidUserRoleException;
import net.javaguides.springboot.model.UserRole;
import net.javaguides.springboot.strategy.AdminNotificationHandler;
import net.javaguides.springboot.strategy.ModeratorNotificationHandler;
import net.javaguides.springboot.strategy.NotificationHandler;
import net.javaguides.springboot.strategy.UserNotificationHandler;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class NotificationHandlerFactory {

    private final Map<UserRole, NotificationHandler> notificationHandlerMap;

    public NotificationHandlerFactory(
            AdminNotificationHandler adminNotificationHandler,
            ModeratorNotificationHandler moderatorNotificationHandler,
            UserNotificationHandler userNotificationHandler
            ) {
        notificationHandlerMap = Map.of(
                UserRole.ADMIN, adminNotificationHandler,
                UserRole.MODERATOR, moderatorNotificationHandler,
                UserRole.USER, userNotificationHandler
        );
    }

    public NotificationHandler getNotificationHandler(UserRole userRole) {
        if (!notificationHandlerMap.containsKey(userRole)) throw new InvalidUserRoleException("Invalid UserType");
        return notificationHandlerMap.get(userRole);
    }
}

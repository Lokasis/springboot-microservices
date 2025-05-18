package net.loanmanagement.factory;

import net.loanmanagement.exception.InvalidUserRoleException;
import net.loanmanagement.model.UserRole;
import net.loanmanagement.strategy.AdminNotificationHandler;
import net.loanmanagement.strategy.ModeratorNotificationHandler;
import net.loanmanagement.strategy.NotificationHandler;
import net.loanmanagement.strategy.UserNotificationHandler;
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

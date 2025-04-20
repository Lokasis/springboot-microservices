package net.javaguides.springboot.factory;

import net.javaguides.springboot.exception.InvalidUserRoleException;
import net.javaguides.springboot.model.UserRole;
import net.javaguides.springboot.strategy.AdminHandler;
import net.javaguides.springboot.strategy.ModeratorHandler;
import net.javaguides.springboot.strategy.UserHandler;
import net.javaguides.springboot.strategy.UserRoleHandler;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserRoleHandlerFactory {

    private final Map<UserRole, UserRoleHandler> handlerMap;

    public UserRoleHandlerFactory(AdminHandler adminHandler,
                                  ModeratorHandler moderatorHandler,
                                  UserHandler userHandler) {
        handlerMap = Map.of(
                UserRole.ADMIN, adminHandler,
                UserRole.MODERATOR,moderatorHandler,
                UserRole.USER, userHandler
        );
    }

    public UserRoleHandler getUserRoleHandler(UserRole userRole) {
        if (!handlerMap.containsKey(userRole)) throw new InvalidUserRoleException("Invalid UserType");
        return handlerMap.get(userRole);
    }
}

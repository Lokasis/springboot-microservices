package net.loanmanagement.factory;

import net.loanmanagement.exception.InvalidUserRoleException;
import net.loanmanagement.model.UserRole;
import net.loanmanagement.strategy.AdminHandler;
import net.loanmanagement.strategy.ModeratorHandler;
import net.loanmanagement.strategy.UserHandler;
import net.loanmanagement.strategy.UserRoleHandler;
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

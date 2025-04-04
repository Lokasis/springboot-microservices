package net.javaguides.springboot.strategy;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.model.UserAction;

public interface UserRoleHandler {

    void handleRoleSpecificLogic(User user);

    void performUserSpecificAction(Long userId);
}

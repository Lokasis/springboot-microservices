package net.javaguides.springboot.strategy;

import net.javaguides.springboot.model.User;

public interface UserRoleHandler {

    void handleRoleSpecificLogic(User user);
}

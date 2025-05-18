package net.loanmanagement.strategy;

import net.loanmanagement.model.User;

public interface UserRoleHandler {

    void handleRoleSpecificLogic(User user);

    void performUserSpecificAction(Long userId);
}

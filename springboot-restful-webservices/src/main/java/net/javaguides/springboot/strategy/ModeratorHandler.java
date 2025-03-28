package net.javaguides.springboot.strategy;

import net.javaguides.springboot.model.User;
import org.springframework.stereotype.Component;

@Component
public class ModeratorHandler implements UserRoleHandler{
    @Override
    public void handleRoleSpecificLogic(User user) {

    }
}

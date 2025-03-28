package net.javaguides.springboot.strategy;

import net.javaguides.springboot.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserHandler implements UserRoleHandler{
    @Override
    public void handleRoleSpecificLogic(User user) {

    }
}

package net.javaguides.springboot.strategy;

import jakarta.persistence.Column;
import net.javaguides.springboot.model.User;
import org.springframework.stereotype.Component;

@Component
public class AdminHandler implements UserRoleHandler{

    @Override
    public void handleRoleSpecificLogic(User user) {

    }
}

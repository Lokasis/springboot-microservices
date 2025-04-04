package net.javaguides.springboot.strategy;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.model.UserAction;
import net.javaguides.springboot.model.UserRole;
import net.javaguides.springboot.repository.UserActionRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class AdminHandler implements UserRoleHandler{

    private final UserActionRepository userActionRepository;

    @Override
    public void handleRoleSpecificLogic(User user) {

    }

    @Override
    public void performUserSpecificAction(Long userId) {
        UserAction action = new UserAction(userId, UserRole.ADMIN, "ADMIN_ACTION", LocalDateTime.now());
        userActionRepository.save(action);
        System.out.println("Admin action executed and logged.");
    }
}

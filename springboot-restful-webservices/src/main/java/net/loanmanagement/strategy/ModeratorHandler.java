package net.loanmanagement.strategy;

import lombok.AllArgsConstructor;
import net.loanmanagement.model.User;
import net.loanmanagement.model.UserAction;
import net.loanmanagement.model.UserRole;
import net.loanmanagement.repository.UserActionRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
@AllArgsConstructor
public class ModeratorHandler implements UserRoleHandler{

    private final UserActionRepository userActionRepository;
    @Override
    public void handleRoleSpecificLogic(User user) {

    }

    @Override
    public void performUserSpecificAction(Long userId) {
        UserAction action = new UserAction(userId, UserRole.MODERATOR, "MODERATOR_ACTION", LocalDateTime.now());
        userActionRepository.save(action);
        System.out.println("Admin action executed and logged.");
    }
}

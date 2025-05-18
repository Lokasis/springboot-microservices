package net.loanmanagement.strategy;

import lombok.AllArgsConstructor;
import net.loanmanagement.dto.NotificationRequestDto;
import net.loanmanagement.repository.NotificationRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ModeratorNotificationHandler implements NotificationHandler {

    private final NotificationRepository notificationRepository;

    @Override
    public String handleNotification(NotificationRequestDto request) {
        return "Moderator fucked you";
    }
}

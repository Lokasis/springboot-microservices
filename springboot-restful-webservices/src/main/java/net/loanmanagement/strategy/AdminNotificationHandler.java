package net.loanmanagement.strategy;

import lombok.AllArgsConstructor;
import net.loanmanagement.dto.NotificationRequestDto;
import net.loanmanagement.repository.NotificationRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AdminNotificationHandler implements NotificationHandler {

    private final NotificationRepository notificationRepository;
    @Override
    public String handleNotification(NotificationRequestDto request) {
        return "Admin fucked you";
    }
}

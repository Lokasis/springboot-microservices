package net.javaguides.springboot.strategy;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.NotificationRequestDto;
import net.javaguides.springboot.repository.NotificationRepository;
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

package net.javaguides.springboot.strategy;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.NotificationRequestDto;
import net.javaguides.springboot.repository.NotificationRepository;
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

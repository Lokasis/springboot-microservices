package net.javaguides.springboot.strategy;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.NotificationRequestDto;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserNotificationHandler implements NotificationHandler {
    @Override
    public String handleNotification(NotificationRequestDto request) {
        return "User fucked you";
    }
}

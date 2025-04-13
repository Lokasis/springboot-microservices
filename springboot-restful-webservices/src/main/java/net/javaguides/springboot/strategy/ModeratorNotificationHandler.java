package net.javaguides.springboot.strategy;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.NotificationRequestDto;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ModeratorNotificationHandler implements NotificationHandler {
    @Override
    public String handleNotification(NotificationRequestDto request) {
        return "Moderator fucked you";
    }
}

package net.javaguides.springboot.strategy;

import net.javaguides.springboot.dto.NotificationRequestDto;

public interface NotificationHandler {

    String handleNotification(NotificationRequestDto request);
}

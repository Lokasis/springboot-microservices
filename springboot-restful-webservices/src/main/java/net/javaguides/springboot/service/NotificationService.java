package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.NotificationRequestDto;

public interface NotificationService {
    String sendNotification(NotificationRequestDto request);
}

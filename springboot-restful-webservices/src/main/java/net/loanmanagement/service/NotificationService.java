package net.loanmanagement.service;

import net.loanmanagement.dto.NotificationRequestDto;

public interface NotificationService {
    String sendNotification(NotificationRequestDto request);
}

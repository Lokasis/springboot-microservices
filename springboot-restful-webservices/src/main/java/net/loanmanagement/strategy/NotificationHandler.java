package net.loanmanagement.strategy;

import net.loanmanagement.dto.NotificationRequestDto;

public interface NotificationHandler {

    String handleNotification(NotificationRequestDto request);
}

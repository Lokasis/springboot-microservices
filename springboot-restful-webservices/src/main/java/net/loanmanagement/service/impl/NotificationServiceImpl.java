package net.loanmanagement.service.impl;

import lombok.AllArgsConstructor;
import net.loanmanagement.dto.NotificationRequestDto;
import net.loanmanagement.factory.NotificationHandlerFactory;
import net.loanmanagement.service.NotificationService;
import net.loanmanagement.strategy.NotificationHandler;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    NotificationHandlerFactory notificationHandlerFactory;

    @Override
    public String sendNotification(NotificationRequestDto request) {

        NotificationHandler handler = notificationHandlerFactory.getNotificationHandler(request.getRole());
        String response = handler.handleNotification(request);
        return response;
    }
}

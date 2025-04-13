package net.javaguides.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.NotificationRequestDto;
import net.javaguides.springboot.factory.NotificationHandlerFactory;
import net.javaguides.springboot.service.NotificationService;
import net.javaguides.springboot.strategy.NotificationHandler;
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

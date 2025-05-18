package net.loanmanagement.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.loanmanagement.dto.NotificationRequestDto;
import net.loanmanagement.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "CRUD REST APIs for User Resource",
        description = "CRUD REST APIs - Create User, Update User, Get User, Get All Users, Delete User"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/notifications")
public class NotificationController {

    NotificationService notificationService;

    @PostMapping("send")
    public ResponseEntity<String> sendNotification (@RequestBody NotificationRequestDto request) {
        String response = notificationService.sendNotification(request);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}

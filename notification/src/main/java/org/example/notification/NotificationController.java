package org.example.notification;

import lombok.AllArgsConstructor;
import org.example.clients.notification.NotificationClient;
import org.example.communicate.Notification;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class NotificationController implements NotificationClient {

    private final NotificationService notificationService;


    @Override
    @PostMapping("api/v1/notification")
    public void sendNotification(@RequestBody Notification notification) {
        notificationService.publishNotification(notification);
    }
}

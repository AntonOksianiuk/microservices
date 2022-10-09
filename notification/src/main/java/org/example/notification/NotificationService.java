package org.example.notification;

import lombok.AllArgsConstructor;
import org.example.communicate.Notification;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;
    public void publishNotification(Notification notification) {
        notificationRepository.save(
                NotificationMapper.INSTANCE.notificationToNotificationEntity(notification));
    }
}

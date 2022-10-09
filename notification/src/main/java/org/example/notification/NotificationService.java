package org.example.notification;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.communicate.Notification;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationService {
    private final NotificationRepository notificationRepository;
    public void publishNotification(Notification notification) {
        log.info("publish notification : " + notification);
        NotificationEntity notificationEntity = NotificationMapper
                .INSTANCE.notificationToNotificationEntity(notification);

        log.info("notification after mapping" + notificationEntity);

        notificationRepository.save(notificationEntity);
    }
}

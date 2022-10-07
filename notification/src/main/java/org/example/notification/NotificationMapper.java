package org.example.notification;

import org.example.communicate.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface NotificationMapper {
    NotificationMapper INSTANCE = Mappers.getMapper(NotificationMapper.class);
    NotificationEntity notificationToNotificationEntity(Notification notification);
}

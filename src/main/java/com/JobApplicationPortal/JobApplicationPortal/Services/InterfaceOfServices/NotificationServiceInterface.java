package com.JobApplicationPortal.JobApplicationPortal.Services.InterfaceOfServices;

import com.JobApplicationPortal.JobApplicationPortal.Mapper.Notification.NotficationOutgoingDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.Notification.NotificationIncomingDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NotificationServiceInterface {
    Page<NotficationOutgoingDto> getAllNotifications(int page, int size, String direction, String sortby);

    String sendNotificationRejection(NotificationIncomingDto notify);

    String removeNotification(Long id);

    List<NotficationOutgoingDto> getAllByClientId(Long clientId);

    void markNotificationAsRead(Long notificationId);
}

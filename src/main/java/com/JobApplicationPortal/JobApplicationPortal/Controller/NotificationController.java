package com.JobApplicationPortal.JobApplicationPortal.Controller;


import com.JobApplicationPortal.JobApplicationPortal.Mapper.Notification.NotficationOutgoingDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.Notification.NotificationIncomingDto;
import com.JobApplicationPortal.JobApplicationPortal.Services.NotificationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seeker")
public class NotificationController {

    @Autowired
    NotificationServices notificationServices;

    @GetMapping("/notification/allnotofications")
    public ResponseEntity<Page<NotficationOutgoingDto>> getAllNotification(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "asc") String direction,
            @RequestParam(defaultValue = "message") String sortby) {
        return ResponseEntity.status(HttpStatus.OK).body(notificationServices.getAllNotifications(page, size, direction, sortby));
    }

    @PostMapping("/notification/selected")
    public ResponseEntity<String> notify(@RequestBody NotificationIncomingDto notify) {
        return ResponseEntity.status(HttpStatus.CREATED).body(notificationServices.sendNotification(notify));
    }

    @PostMapping("/notification/Rejection")
    public ResponseEntity<String> Rejection(@RequestBody NotificationIncomingDto notify) {
        return ResponseEntity.status(HttpStatus.CREATED).body(notificationServices.sendNotificationRejection(notify));
    }

    @DeleteMapping("notification/deletenotification/{id}")
    public ResponseEntity<String> removeNotification(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(notificationServices.removeNotification(id));
    }

    @GetMapping("/notification/{clientId}")
    public ResponseEntity<List<NotficationOutgoingDto>> getAllNotificationsByClientId(@PathVariable Long clientId) {
        List<NotficationOutgoingDto> notifications = notificationServices.getAllByClientId(clientId);
        return ResponseEntity.ok(notifications);
    }

    @PutMapping("/read/{notificationId}")
    public ResponseEntity<String> markAsRead(@PathVariable Long notificationId) {
        notificationServices.markNotificationAsRead(notificationId);
        return ResponseEntity.ok("Notification marked as read.");
    }
}

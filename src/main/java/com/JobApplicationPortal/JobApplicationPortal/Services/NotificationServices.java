package com.JobApplicationPortal.JobApplicationPortal.Services;

import com.JobApplicationPortal.JobApplicationPortal.EmailService;
import com.JobApplicationPortal.JobApplicationPortal.Exception.NoAnyNotificationFoundException;
import com.JobApplicationPortal.JobApplicationPortal.Exception.NotificationNotFoundException;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.Notification.NotficationOutgoingDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.Notification.NotificationIncomingDto;
import com.JobApplicationPortal.JobApplicationPortal.Model.Application;
import com.JobApplicationPortal.JobApplicationPortal.Model.Client;
import com.JobApplicationPortal.JobApplicationPortal.Model.Enums.MessageType;
import com.JobApplicationPortal.JobApplicationPortal.Model.Enums.Status;
import com.JobApplicationPortal.JobApplicationPortal.Model.Notification;
import com.JobApplicationPortal.JobApplicationPortal.Repository.ApplicatioRepo;
import com.JobApplicationPortal.JobApplicationPortal.Repository.ClientRepo;
import com.JobApplicationPortal.JobApplicationPortal.Repository.NotificationRepo;
import com.JobApplicationPortal.JobApplicationPortal.Services.InterfaceOfServices.NotificationServiceInterface;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationServices implements NotificationServiceInterface {


    @Autowired
    NotificationRepo notifyRepo;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ApplicatioRepo applicatioRepo;
    @Autowired
    ClientRepo clientRepo;
    @Autowired
    EmailService emailService;

    @Override
    public String sendNotificationRejection(NotificationIncomingDto notify) {
        Application application = applicatioRepo.findById(notify.getApplication_id()).orElseThrow(() -> new RuntimeException("Application Not Found"));
        Client reciever = application.getClient();
        Notification notification = new Notification();
        notification.setClient(reciever);
        notification.setMessage(notify.getMessage());
        notification.setType(MessageType.INFO);
        notification.setIsread(false);
        application.setStatus(Status.REJECTED);
        applicatioRepo.save(application);
        notifyRepo.save(notification);

        return "Notification Added!";
    }

    @Override
    public String removeNotification(Long id) {
        notifyRepo.findById(id).orElseThrow(() -> new NotificationNotFoundException("NOTIFICATION NOT FOUND"));
        notifyRepo.deleteById(id);
        return "Notification Deleted Successfully";
    }


    @Transactional
    public String sendNotification(NotificationIncomingDto incomingDto) {
        Application application = applicatioRepo.findById(incomingDto.getApplication_id()).orElseThrow(() -> new RuntimeException("Application Not Found"));
        Client reciever = application.getClient();
        Notification notification = new Notification();
        notification.setClient(reciever);
        notification.setMessage(incomingDto.getMessage());
        notification.setType(MessageType.INFO);
        notification.setIsread(false);
        application.setStatus(Status.SELECTED);
        applicatioRepo.save(application);
        notifyRepo.save(notification);
        System.out.println(reciever.getEmail());
        // emailService.sendSelection(reciever.getEmail());
        return "Notification Added!";

    }

    public Page<NotficationOutgoingDto> getAllNotifications(int page, int size, String direction, String sortby) {
        Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(Sort.Direction.ASC, sortby) : Sort.by(Sort.Direction.DESC, sortby);
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Notification> notifications = notifyRepo.findAll(pageable);
        if (notifications.isEmpty()) {
            throw new NoAnyNotificationFoundException("Not Any Notification Are Found");
        }
        return notifications.map(x -> modelMapper.map(x, NotficationOutgoingDto.class));

    }


    @Override
    public List<NotficationOutgoingDto> getAllByClientId(Long clientId) {

        Client client = clientRepo.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + clientId));

        List<Notification> notifications = notifyRepo.findByClient(client);

        return notifications.stream()
                .map(notification -> modelMapper.map(notification, NotficationOutgoingDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void markNotificationAsRead(Long notificationId) {
        Notification notification = notifyRepo.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Notification not found"));

        if (!notification.isIsread()) {
            notification.setIsread(true);
            notifyRepo.save(notification);
        }
    }

}



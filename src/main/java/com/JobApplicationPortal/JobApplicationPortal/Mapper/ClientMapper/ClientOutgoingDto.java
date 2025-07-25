package com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper;

import com.JobApplicationPortal.JobApplicationPortal.Model.Application;
import com.JobApplicationPortal.JobApplicationPortal.Model.Enums.ProfileStatus;
import com.JobApplicationPortal.JobApplicationPortal.Model.Job;
import com.JobApplicationPortal.JobApplicationPortal.Model.Notification;
import com.JobApplicationPortal.JobApplicationPortal.Model.Skill;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

public class ClientOutgoingDto {


    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
    private ProfileStatus profileStatus;
    private LocalDateTime lastLogin;
    private String resumelink;
    private List<Skill> skills;
    private List<Application> applications;

}

package com.JobApplicationPortal.JobApplicationPortal.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String role;
    @Column(nullable = false)
    private String profileStatus;
    private LocalDateTime lastLogin;
    private Application applications;
    private Job jobs;
    private Skill skills;
    private Notification notifications;
}

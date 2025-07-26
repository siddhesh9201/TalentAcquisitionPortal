package com.JobApplicationPortal.JobApplicationPortal.Model;

import com.JobApplicationPortal.JobApplicationPortal.Model.Enums.ProfileStatus;
import com.JobApplicationPortal.JobApplicationPortal.Model.Enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;


    @Enumerated(EnumType.STRING)
    private Role role;


    @Enumerated(EnumType.STRING)
    private ProfileStatus profileStatus;

    @CreationTimestamp
    private LocalDateTime lastLogin;

    @OneToMany(mappedBy = "client" ,cascade= CascadeType.REMOVE,orphanRemoval = true)
    private List<Application> applications;

    @JsonIgnore
    @OneToMany(mappedBy = "recruiter",cascade = CascadeType.REMOVE,orphanRemoval = true)
    private List<Job> jobs;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Skill> skills;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Notification> notifications;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public ProfileStatus getProfileStatus() {
        return profileStatus;
    }

    public void setProfileStatus(ProfileStatus profileStatus) {
        this.profileStatus = profileStatus;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }


}

package com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper;

import com.JobApplicationPortal.JobApplicationPortal.Model.Enums.ProfileStatus;
import com.JobApplicationPortal.JobApplicationPortal.Model.Enums.Role;
import com.JobApplicationPortal.JobApplicationPortal.Model.Job;

import java.time.LocalDateTime;
import java.util.List;

public class RecruiterOutgoingDto {

    private Long id;
    private String name;
    private String email;
    private Role role;
    private LocalDateTime lastLogin;
    private ProfileStatus profileStatus;
    private List<Job> postedJobs;

    public ProfileStatus getProfileStatus() {
        return profileStatus;
    }

    public void setProfileStatus(ProfileStatus profileStatus) {
        this.profileStatus = profileStatus;
    }

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }


    public List<Job> getPostedJobs() {
        return postedJobs;
    }

    public void setPostedJobs(List<Job> postedJobs) {
        this.postedJobs = postedJobs;
    }
}

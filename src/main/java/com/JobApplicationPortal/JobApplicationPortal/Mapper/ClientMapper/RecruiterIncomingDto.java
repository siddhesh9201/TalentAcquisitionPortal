package com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper;

import com.JobApplicationPortal.JobApplicationPortal.Model.Application;
import com.JobApplicationPortal.JobApplicationPortal.Model.Enums.ProfileStatus;
import com.JobApplicationPortal.JobApplicationPortal.Model.Job;
import com.JobApplicationPortal.JobApplicationPortal.Model.Notification;
import com.JobApplicationPortal.JobApplicationPortal.Model.Skill;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

public class RecruiterIncomingDto {
    @Size(min=1,max= 50)
    @NotNull
    private String name;

    @Email
    @NotNull
    private String email;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@#$%^&+=!]{6,}$",
            message = "Password must be at least 6 characters long and contain at least one letter and one number")
    private String password;

    @NotNull
    private String role;

    public @Size(min = 1, max = 50) @NotNull String getName() {
        return name;
    }

    public void setName(@Size(min = 1, max = 50) @NotNull String name) {
        this.name = name;
    }

    public @Email @NotNull String getEmail() {
        return email;
    }

    public void setEmail(@Email @NotNull String email) {
        this.email = email;
    }

    public @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@#$%^&+=!]{6,}$",
            message = "Password must be at least 6 characters long and contain at least one letter and one number") String getPassword() {
        return password;
    }

    public void setPassword(@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@#$%^&+=!]{6,}$",
            message = "Password must be at least 6 characters long and contain at least one letter and one number") String password) {
        this.password = password;
    }

    public @NotNull String getRole() {
        return role;
    }

    public void setRole(@NotNull String role) {
        this.role = role;
    }
}

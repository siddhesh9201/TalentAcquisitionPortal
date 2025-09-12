package com.JobApplicationPortal.JobApplicationPortal.Mapper.JobMapper;

import com.JobApplicationPortal.JobApplicationPortal.Model.Enums.JobType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class JobIncomingDto {


    @NotNull
    private String title;


    @Pattern(regexp = "^[A-Za-z\\s]+$",message = "Optional")
    private String description;

    @NotNull
    private JobType type;

    @NotNull
    private String location;

    @NotNull
    private String companyName;

    @NotNull
    private String salaryRange;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expiryDate;

    @NotNull
    @Email
    private String recruiterEmail;

    @NotNull
    private String recruiterName;

    public @NotNull String getTitle() {
        return title;
    }

    public void setTitle(@NotNull String title) {
        this.title = title;
    }

    public @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Optional") String getDescription() {
        return description;
    }

    public void setDescription(@Pattern(regexp = "^[A-Za-z\\s]+$", message = "Optional") String description) {
        this.description = description;
    }

    public @NotNull JobType getType() {
        return type;
    }

    public void setType(@NotNull JobType type) {
        this.type = type;
    }

    public @NotNull String getLocation() {
        return location;
    }

    public void setLocation(@NotNull String location) {
        this.location = location;
    }

    public @NotNull String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(@NotNull String companyName) {
        this.companyName = companyName;
    }

    public @NotNull String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(@NotNull String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public @NotNull LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(@NotNull LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public @NotNull @Email String getRecruiterEmail() {
        return recruiterEmail;
    }

    public void setRecruiterEmail(@NotNull @Email String recruiterEmail) {
        this.recruiterEmail = recruiterEmail;
    }

    public @NotNull String getRecruiterName() {
        return recruiterName;
    }

    public void setRecruiterName(@NotNull String recruiterName) {
        this.recruiterName = recruiterName;
    }
}

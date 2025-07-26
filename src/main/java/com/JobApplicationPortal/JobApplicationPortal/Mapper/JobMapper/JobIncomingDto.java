package com.JobApplicationPortal.JobApplicationPortal.Mapper.JobMapper;

import com.JobApplicationPortal.JobApplicationPortal.Model.Enums.JobType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class JobIncomingDto {


    @NotNull
    @Size(min=1, max=50)
    private String title;

    @Size(max=100)
    @Pattern(regexp = "^[A-Za-z\\s]+$",message = "Optional")
    private String description;

    @NotNull
    private JobType type;

    @NotNull
    private String location;

    @NotNull
    @Size(max=50)
    private String companyName;

    @Pattern(regexp = "^[\\d\\-]+$", message = "1203-3122")
    private String salaryRange;

    @NotNull
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])[\\/\\-](0[1-9]|1[0-2])[\\/\\-]\\d{4}$",
    message = "DD-MM-YYYY")
    private LocalDate expiryDate;

    public @NotNull @Size(min = 1, max = 50) String getTitle() {
        return title;
    }

    public void setTitle(@NotNull @Size(min = 1, max = 50) String title) {
        this.title = title;
    }

    public @Size(max = 100) @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Optional") String getDescription() {
        return description;
    }

    public void setDescription(@Size(max = 100) @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Optional") String description) {
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

    public @NotNull @Size(max = 50) String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(@NotNull @Size(max = 50) String companyName) {
        this.companyName = companyName;
    }

    public @Pattern(regexp = "^[\\d\\-]+$", message = "1203-3122") String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(@Pattern(regexp = "^[\\d\\-]+$", message = "1203-3122") String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public @NotNull @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])[\\/\\-](0[1-9]|1[0-2])[\\/\\-]\\d{4}$",
            message = "DD-MM-YYYY") LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(@NotNull @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])[\\/\\-](0[1-9]|1[0-2])[\\/\\-]\\d{4}$",
            message = "DD-MM-YYYY") LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}

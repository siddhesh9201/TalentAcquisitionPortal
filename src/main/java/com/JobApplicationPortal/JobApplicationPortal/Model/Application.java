package com.JobApplicationPortal.JobApplicationPortal.Model;
import com.JobApplicationPortal.JobApplicationPortal.Model.Enums.Status;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String resumeLink;

    private String CoverLetter;
    @Column(nullable = false)
    private Status status;
    @Column(nullable = false)
    private Date appliedDate;
    @Column(nullable = false)
    private Long expectedSalary;

    @ManyToOne
    @JoinColumn(name = "job_id",nullable = false)
    private Job job;

    @ManyToOne
    @JoinColumn(name="client_id",nullable = false)
    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResumeLink() {
        return resumeLink;
    }

    public void setResumeLink(String resumeLink) {
        this.resumeLink = resumeLink;
    }

    public String getCoverLetter() {
        return CoverLetter;
    }

    public void setCoverLetter(String coverLetter) {
        CoverLetter = coverLetter;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(Date appliedDate) {
        this.appliedDate = appliedDate;
    }

    public Long getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(Long expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

package com.JobApplicationPortal.JobApplicationPortal.Mapper.ApplicationMapper;

import com.JobApplicationPortal.JobApplicationPortal.Model.Enums.Status;

public class StatusIncomingDto {
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

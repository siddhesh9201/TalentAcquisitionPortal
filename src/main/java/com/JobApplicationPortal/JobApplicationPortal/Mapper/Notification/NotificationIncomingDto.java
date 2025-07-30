package com.JobApplicationPortal.JobApplicationPortal.Mapper.Notification;

public class NotificationIncomingDto {

    private Long application_id;
    private String message;

    public Long getApplication_id() {
        return application_id;
    }

    public void setApplication_id(Long application_id) {
        this.application_id = application_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

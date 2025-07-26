package com.JobApplicationPortal.JobApplicationPortal.Exception;

public class JobAlreadyExistException extends RuntimeException {
    public JobAlreadyExistException(String message) {
        super(message);
    }
}

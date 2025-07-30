package com.JobApplicationPortal.JobApplicationPortal.Exception;

public class ApplicationAlreadyExistException extends RuntimeException {
    public ApplicationAlreadyExistException(String message) {
        super(message);
    }
}

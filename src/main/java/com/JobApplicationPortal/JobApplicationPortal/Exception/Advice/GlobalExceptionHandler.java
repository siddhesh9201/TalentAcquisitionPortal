package com.JobApplicationPortal.JobApplicationPortal.Exception.Advice;


import com.JobApplicationPortal.JobApplicationPortal.Exception.*;
import com.JobApplicationPortal.JobApplicationPortal.Model.Application;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SeekerNotFoundException.class)
    public ResponseEntity<String> userNotFound(SeekerNotFoundException exception) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(ApplicationAlreadyExistException.class)
    public ResponseEntity<String> applicationAlreadyExistException(ApplicationAlreadyExistException applicationAlreadyExistException) {
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(applicationAlreadyExistException.getMessage());
    }

    @ExceptionHandler(ApplicationNotFoundException.class)
    public ResponseEntity<String> applicationAlreadyExistException(ApplicationNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<String> clientNotFound(ClientNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<String> emailAlreadyExist(EmailAlreadyExistException exception) {
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(exception.getMessage());
    }

    @ExceptionHandler(EmailNotFoundException.class)
    public ResponseEntity<String> emailNotFoundException(EmailNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(JobAlreadyExistException.class)
    public ResponseEntity<String> jobAlreadyException(JobAlreadyExistException exception) {
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(exception.getMessage());
    }

    @ExceptionHandler(JobsNotfoundException.class)
    public ResponseEntity<String> jobNotFoundException(JobsNotfoundException exception) {
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(exception.getMessage());
    }

    @ExceptionHandler(NoAnyNotificationFoundException.class)
    public ResponseEntity<String> noAny(NoAnyNotificationFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(NotificationNotFoundException.class)
    public ResponseEntity<String> notificationNotFound(NotificationNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

}

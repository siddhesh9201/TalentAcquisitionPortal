package com.JobApplicationPortal.JobApplicationPortal.Exception;


import com.JobApplicationPortal.JobApplicationPortal.Model.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SeekerNotFoundException.class)
    public ResponseEntity<String> userNotFound(SeekerNotFoundException exception) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }


}

package com.JobApplicationPortal.JobApplicationPortal.Controller;

import com.JobApplicationPortal.JobApplicationPortal.Mapper.ApplicationMapper.IncomingApplicationDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ApplicationMapper.OutgoingApplication;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ApplicationMapper.OutgoingApplicationDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ApplicationMapper.OutgoingApplicationForRecruiter;
import com.JobApplicationPortal.JobApplicationPortal.Services.ApplicationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationController {


    @Autowired
    ApplicationServices applicationServices;


    @PostMapping("/application/apply")
    public ResponseEntity<String> addJobApplication(@RequestBody IncomingApplicationDto input){
        return ResponseEntity.status(HttpStatus.CREATED).body(applicationServices.addApplication(input));
    }

    @GetMapping("/application/client/{clientId}")
    public ResponseEntity<List<OutgoingApplicationDto>> getApplicationByClientId(@PathVariable Long clientId){
        return ResponseEntity.status(HttpStatus.OK).body(applicationServices.getApplicationById(clientId));

   }

   @GetMapping("/application/job/{jobId}")
   public ResponseEntity<List<OutgoingApplicationForRecruiter>> getApplicationByJobId(@PathVariable Long jobId){
       return ResponseEntity.status(HttpStatus.OK).body(applicationServices.getApplicationByJobId(jobId));

   }

   @GetMapping("/application/{aId}")
    public ResponseEntity<OutgoingApplication> getApplicationById(@PathVariable Long aId){
         return ResponseEntity.status(HttpStatus.OK).body(applicationServices.getApplication(aId));
   }

}

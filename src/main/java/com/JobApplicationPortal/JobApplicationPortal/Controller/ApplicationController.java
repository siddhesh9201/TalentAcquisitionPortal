package com.JobApplicationPortal.JobApplicationPortal.Controller;

import com.JobApplicationPortal.JobApplicationPortal.Mapper.ApplicationMapper.*;
import com.JobApplicationPortal.JobApplicationPortal.Services.ApplicationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ApplicationController {


    @Autowired
    ApplicationServices applicationServices;


    @PostMapping("/seeker/application/apply")
    public ResponseEntity<String> addJobApplication(@RequestBody IncomingApplicationDto input) {
        return ResponseEntity.status(HttpStatus.CREATED).body(applicationServices.addApplication(input));
    }

    @GetMapping("/seeker/application/client/{clientId}")
    public ResponseEntity<List<OutgoingApplicationDto>> getApplicationByClientId(@PathVariable Long clientId) {
        return ResponseEntity.status(HttpStatus.OK).body(applicationServices.getApplicationById(clientId));

    }

    @GetMapping("/recruiter/application/job/{jobId}")
    public ResponseEntity<List<OutgoingApplicationForRecruiter>> getApplicationByJobId(@PathVariable Long jobId) {
        return ResponseEntity.status(HttpStatus.OK).body(applicationServices.getApplicationByJobId(jobId));

    }

    @GetMapping("/seeker/application/{aId}")
    public ResponseEntity<OutgoingApplication> getApplicationById(@PathVariable Long aId) {
        return ResponseEntity.status(HttpStatus.OK).body(applicationServices.getApplication(aId));
    }

    @PutMapping("/recruiter/appliation/{aId}")
    public ResponseEntity<String> updateStatus(@PathVariable Long aId , @RequestBody StatusIncomingDto statusIncomingDto){
           String s =applicationServices.changeStatus(aId,statusIncomingDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(s);

    }

}

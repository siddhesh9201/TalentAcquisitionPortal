package com.JobApplicationPortal.JobApplicationPortal.Controller;


import com.JobApplicationPortal.JobApplicationPortal.Mapper.JobMapper.JobIncomingDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.JobMapper.JobOutgoingDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.JobMapper.JobOutgoingForRecruiter;
import com.JobApplicationPortal.JobApplicationPortal.Model.Job;
import com.JobApplicationPortal.JobApplicationPortal.Services.JobServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class JobController {

         @Autowired
         JobServices jobServices;

         @PostMapping("/recruiter/job/create")
         public ResponseEntity<String> addJobByRecruiter(@Valid @RequestBody JobIncomingDto jobInput){
             return ResponseEntity.status(HttpStatus.CREATED).body(jobServices.addNewJob(jobInput));
         }


         @GetMapping("/job/getById/{jobId}")
         public ResponseEntity<JobOutgoingDto> getjobById(@PathVariable Long jobId){
             JobOutgoingDto job= jobServices.getJobById(jobId);
             return ResponseEntity.status(HttpStatus.OK).body(job);
         }
         @GetMapping("/alljobs")
         public ResponseEntity<Page<JobOutgoingDto>> getAllJobs(
                 @RequestParam(defaultValue = "0") int page,
                 @RequestParam(defaultValue="5") int size,
                 @RequestParam(defaultValue = "asc")String direction,
                 @RequestParam(defaultValue = "id") String sortby){
             return ResponseEntity.status(HttpStatus.OK).body(jobServices.getAllJobs(page,size,direction,sortby));
         }

         @GetMapping("/recruiter/allrecruiter")
         public ResponseEntity<Page<JobOutgoingForRecruiter>> getAllJobsForRecruiter(
                 @RequestParam(defaultValue = "0") int page,
                 @RequestParam(defaultValue="5") int size,
                 @RequestParam(defaultValue = "asc")String direction,
                 @RequestParam(defaultValue = "id") String sortby){
             return ResponseEntity.status(HttpStatus.OK).body(jobServices.getAllJobsRecruiters(page,size,direction,sortby));
         }

         @DeleteMapping("/recruiter/delete/{id}")
         public ResponseEntity<String> deleteJobById(@PathVariable Long id){
             return ResponseEntity.status(HttpStatus.OK).body(jobServices.deleteJobById(id));
         }

         @GetMapping("/search")
       public ResponseEntity<Page<JobOutgoingDto>> searchBy(
               @RequestParam(defaultValue = "")String title,
               @RequestParam(defaultValue = "")String location,
               @RequestParam(defaultValue = "0")int page,
               @RequestParam(defaultValue = "5")int size,
               @RequestParam(defaultValue = "asc")String direction,
               @RequestParam(defaultValue = "companyName")String sortby){
             title = title.trim();
             location = location.trim();
             if (title.isEmpty()) {
                 throw new IllegalArgumentException("Title must not be empty");
             }

             return ResponseEntity.status(HttpStatus.OK).body(jobServices.searchBy(title,location,page,size,direction,sortby));
         }

         @PutMapping("/recruiter/update/{id}")
       public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody JobIncomingDto job){
             return ResponseEntity.ok(jobServices.updateJob(id,job));
         }


}

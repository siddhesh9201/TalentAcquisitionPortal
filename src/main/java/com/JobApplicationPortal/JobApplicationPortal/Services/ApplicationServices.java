package com.JobApplicationPortal.JobApplicationPortal.Services;

import com.JobApplicationPortal.JobApplicationPortal.Exception.ApplicationAlreadyExistException;
import com.JobApplicationPortal.JobApplicationPortal.Exception.EmailNotFoundException;
import com.JobApplicationPortal.JobApplicationPortal.Exception.JobAlreadyExistException;
import com.JobApplicationPortal.JobApplicationPortal.Exception.JobsNotfoundException;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ApplicationMapper.IncomingApplicationDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ApplicationMapper.OutgoingApplication;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ApplicationMapper.OutgoingApplicationDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ApplicationMapper.OutgoingApplicationForRecruiter;
import com.JobApplicationPortal.JobApplicationPortal.Model.Application;
import com.JobApplicationPortal.JobApplicationPortal.Model.Client;
import com.JobApplicationPortal.JobApplicationPortal.Model.Enums.Status;
import com.JobApplicationPortal.JobApplicationPortal.Model.Job;
import com.JobApplicationPortal.JobApplicationPortal.Repository.ApplicatioRepo;
import com.JobApplicationPortal.JobApplicationPortal.Repository.ClientRepo;
import com.JobApplicationPortal.JobApplicationPortal.Repository.JobRepo;
import com.JobApplicationPortal.JobApplicationPortal.Services.InterfaceOfServices.ApplicationServiceInterface;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServices implements ApplicationServiceInterface {

    @Autowired
    ApplicatioRepo applicatioRepo;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ClientRepo clientRepo;
    @Autowired
    JobRepo jobRepo;


    @Transactional
    @Override
    public String addApplication(IncomingApplicationDto input) {
        String email = input.getEmail().trim();


        Client client = clientRepo.findByEmail(email)
                .orElseThrow(() -> new EmailNotFoundException("Please Register Before Applying."));


        Job job = jobRepo.findById(input.getJobId())
                .orElseThrow(() -> new JobsNotfoundException("Job Not Found"));

        // Check if application already exists
//        boolean alreadyExists = applicatioRepo.existsByJobAndClient(job, client);
//        if (alreadyExists) {
//            throw new ApplicationAlreadyExistException("You have already applied for this job.");
//        }

        // Create and populate new Application entity
//        Application application = new Application();
//        application.setResumeLink(input.getResumeLink());
//        application.setCoverLetter(input.getCoverLetter());
//        application.setExpectedSalary(input.getExpectedSalary());



        Application application = modelMapper.map(input, Application.class);
        application.setId(null); // <-- Important: prevent accidental merge due to ID

        application.setJob(job);
        application.setClient(client);
        application.setStatus(Status.PENDING);

        // Save new application
        applicatioRepo.save(application);

        return "Application Submitted Successfully!";
    }

    @Override
    public List<OutgoingApplicationDto> getApplicationById(Long clientId) {
        Client client= clientRepo.findById(clientId).orElseThrow(()->new RuntimeException("Client not found"));
        List<Application> applications = applicatioRepo.findByClient(client);

       return applications.stream()
                .map(app -> modelMapper.map(app, OutgoingApplicationDto.class))
                .toList();
    }

    @Override
    public List<OutgoingApplicationForRecruiter> getApplicationByJobId(Long jobId) {
               Job job = jobRepo.findById(jobId).orElseThrow(()->new RuntimeException("Job Not Found"));
             List<Application> applications =  applicatioRepo.findByJob(job);
             return applications.stream().map((app)->modelMapper.map(app, OutgoingApplicationForRecruiter.class)).toList();


    }

    @Override
    public OutgoingApplication getApplication(Long aId) {
        Application application= applicatioRepo.findById(aId).orElseThrow(()->new RuntimeException("Application Not Found"));
        return modelMapper.map(application,OutgoingApplication.class);
    }

}

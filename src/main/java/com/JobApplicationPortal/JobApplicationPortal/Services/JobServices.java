package com.JobApplicationPortal.JobApplicationPortal.Services;

import com.JobApplicationPortal.JobApplicationPortal.Exception.EmailNotFoundException;
import com.JobApplicationPortal.JobApplicationPortal.Exception.JobAlreadyExistException;
import com.JobApplicationPortal.JobApplicationPortal.Exception.JobsNotfoundException;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.JobMapper.JobIncomingDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.JobMapper.JobMapper;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.JobMapper.JobOutgoingDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.JobMapper.JobOutgoingForRecruiter;
import com.JobApplicationPortal.JobApplicationPortal.Model.Client;
import com.JobApplicationPortal.JobApplicationPortal.Model.Job;
import com.JobApplicationPortal.JobApplicationPortal.Repository.ClientRepo;
import com.JobApplicationPortal.JobApplicationPortal.Repository.JobRepo;
import com.JobApplicationPortal.JobApplicationPortal.Services.InterfaceOfServices.JobServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobServices implements JobServiceInterface {

    @Autowired
    JobRepo jobRepo;

    @Autowired
    ClientRepo clientRepo;


    @Transactional
    @Override
    public String addNewJob(JobIncomingDto jobInput) {
        boolean exists = jobRepo.existsByTitleAndCompanyName(jobInput.getTitle(),jobInput.getCompanyName());
        if(exists){
            throw new JobAlreadyExistException("JOB Already Exist With Same Company");
        }
     String email = jobInput.getRecruiterEmail().trim();
      Client clientWithEmail=  clientRepo.findByEmail(email).orElseThrow(()-> new EmailNotFoundException("Recruiter with this email is not registered."));

        Job newJob= JobMapper.toEntity(jobInput);
        newJob.setRecruiter(clientWithEmail);

        jobRepo.save(newJob);
        return "JOB ADDED SUCCESSFULLY!";
    }

    @Override
    public Page<JobOutgoingDto> getAllJobs(int page, int size, String direction, String sortby) {

      Sort sort = direction.equalsIgnoreCase("asc")? Sort.by(Sort.Direction.ASC,sortby): Sort.by(Sort.Direction.DESC);
        Pageable pageable= PageRequest.of(page,size,sort);
      Page<Job> jobs = jobRepo.findAll(pageable);

      return jobs.map(JobMapper ::toDtoForSeeker);
    }

    @Transactional
    @Override
    public Page<JobOutgoingForRecruiter> getAllJobsRecruiters(int page, int size, String direction, String sortby) {
        Sort sort = direction.equalsIgnoreCase("asc")? Sort.by(Sort.Direction.ASC,sortby): Sort.by(Sort.Direction.DESC);
        Pageable pageable= PageRequest.of(page,size,sort);
        Page<Job> jobs = jobRepo.findAll(pageable);

        return jobs.map(JobMapper ::toDto2);
    }

    @Override
    public String deleteJobById(Long id) {
        jobRepo.findById(id).orElseThrow(()-> new RuntimeException("Job Not exist of given" +id));
        jobRepo.deleteById(id);
        return "Job Deleted Successfully!";
    }

    @Override
    public Page<JobOutgoingDto> searchBy(String title, String location, int page, int size, String direction, String sortby) {
        Sort sort = direction.equalsIgnoreCase("asc")? Sort.by(Sort.Direction.ASC,sortby): Sort.by(Sort.Direction.DESC);
        Pageable pageable= PageRequest.of(page,size,sort);
        Page<Job>searchedJobs=jobRepo.findByTitleContainingIgnoreCaseAndLocationContainingIgnoreCase(title, location, pageable);
        if(searchedJobs.isEmpty()){
           throw new JobsNotfoundException("Currently, there are no job opportunities available for Specfied Criteria" +title + location);
        }
        return searchedJobs.map(JobMapper ::toDtoForSeeker);
    }

    @Transactional
    @Override
    public String updateJob(Long id, JobIncomingDto job) {
       Job forupdate = jobRepo.findById(id).orElseThrow(()->new RuntimeException("Job Not Found For This "+ id));
        String email = job.getRecruiterEmail().trim();
        Client clientWithEmail=  clientRepo.findByEmail(email).orElseThrow(()-> new EmailNotFoundException("Recruiter with this email is not registered."));

        if(job.getTitle()!= null) forupdate.setTitle(job.getTitle());
        if (job.getDescription() != null) forupdate.setDescription(job.getDescription());
        if (job.getLocation() != null) forupdate.setLocation(job.getLocation());
        if (job.getCompanyName() != null) forupdate.setCompanyName(job.getCompanyName());
        if (job.getSalaryRange() != null) forupdate.setSalaryRange(job.getSalaryRange());
        if (job.getType() != null) forupdate.setType(job.getType());
        if (job.getExpiryDate() != null) forupdate.setExpiryDate(job.getExpiryDate());
        forupdate.setRecruiter(clientWithEmail);
       jobRepo.save(forupdate);
        return "Job Updated Successfully";

    }


}

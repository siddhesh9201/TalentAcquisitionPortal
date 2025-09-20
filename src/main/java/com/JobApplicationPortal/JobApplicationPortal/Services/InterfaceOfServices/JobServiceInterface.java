package com.JobApplicationPortal.JobApplicationPortal.Services.InterfaceOfServices;

import com.JobApplicationPortal.JobApplicationPortal.Mapper.JobMapper.JobIncomingDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.JobMapper.JobOutgoingDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.JobMapper.JobOutgoingForRecruiter;
import org.springframework.data.domain.Page;

import java.util.List;

public interface JobServiceInterface {
    String addNewJob(JobIncomingDto jobInput);


    List<JobOutgoingDto> getAllJobs();

    Page<JobOutgoingForRecruiter> getAllJobsRecruiters(int page, int size, String direction, String sortby);

    String deleteJobById(Long id);

    Page<JobOutgoingDto> searchBy(String title, String location, int page, int size, String direction, String sortby);

    String updateJob(Long id, JobIncomingDto job);


    JobOutgoingDto getJobById(Long jobId);
}

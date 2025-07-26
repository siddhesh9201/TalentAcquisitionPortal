package com.JobApplicationPortal.JobApplicationPortal.Mapper.JobMapper;

import com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper.ClientIncomingDto;
import com.JobApplicationPortal.JobApplicationPortal.Model.Application;
import com.JobApplicationPortal.JobApplicationPortal.Model.Client;
import com.JobApplicationPortal.JobApplicationPortal.Model.Enums.JobType;
import com.JobApplicationPortal.JobApplicationPortal.Model.Job;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class JobMapper {

    public static Job toEntity(JobIncomingDto input )
    {
            Job job = new Job();
            job.setCompanyName(input.getCompanyName());
            job.setDescription(input.getDescription());
            job.setExpiryDate(input.getExpiryDate());
            job.setSalaryRange(input.getSalaryRange());
            job.setLocation(input.getLocation());
            job.setTitle(input.getTitle());
            job.setType(input.getType());
            return job;
    }

    public static JobOutgoingDto toDto(Job job)
    {
        JobOutgoingDto output = new JobOutgoingDto();
        output.setId(job.getId());
        output.setCompanyName(job.getCompanyName());
        output.setTitle(job.getTitle());
        output.setDescription(job.getDescription());
        output.setLocation(job.getLocation());
        output.setSalaryRange(job.getSalaryRange());
        output.setType(job.getType());
        output.setPostedDate(job.getPostedDate());
        output.setExpiryDate(job.getExpiryDate());
        return output;
    }



    public static JobOutgoingForRecruiter toDto2(Job job){
        JobOutgoingForRecruiter output = new JobOutgoingForRecruiter();
        output.setId(job.getId());
        output.setCompanyName(job.getCompanyName());
        output.setTitle(job.getTitle());
        output.setDescription(job.getDescription());
        output.setLocation(job.getLocation());
        output.setSalaryRange(job.getSalaryRange());
        output.setType(job.getType());
        output.setPostedDate(job.getPostedDate());
        output.setExpiryDate(job.getExpiryDate());
        output.setApplications(job.getApplications());
        output.setRecruiter(job.getRecruiter());
        return output;
    }

}

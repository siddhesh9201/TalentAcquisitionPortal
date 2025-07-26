package com.JobApplicationPortal.JobApplicationPortal.Services.InterfaceOfServices;

import com.JobApplicationPortal.JobApplicationPortal.Mapper.JobMapper.JobIncomingDto;

public interface JobServiceInterface {
    String addNewJob(JobIncomingDto jobInput);
}

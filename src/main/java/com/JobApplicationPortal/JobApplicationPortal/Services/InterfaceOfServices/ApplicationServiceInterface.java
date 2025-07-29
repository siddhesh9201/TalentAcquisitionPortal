package com.JobApplicationPortal.JobApplicationPortal.Services.InterfaceOfServices;

import com.JobApplicationPortal.JobApplicationPortal.Mapper.ApplicationMapper.IncomingApplicationDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ApplicationMapper.OutgoingApplication;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ApplicationMapper.OutgoingApplicationDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ApplicationMapper.OutgoingApplicationForRecruiter;
import com.JobApplicationPortal.JobApplicationPortal.Model.Application;
import com.JobApplicationPortal.JobApplicationPortal.Model.Client;

import java.util.List;
import java.util.Optional;

public interface ApplicationServiceInterface {
    String addApplication(IncomingApplicationDto input);

    List<OutgoingApplicationDto> getApplicationById(Long clientId);

    List<OutgoingApplicationForRecruiter> getApplicationByJobId(Long jobId);

    OutgoingApplication getApplication(Long aId);
}

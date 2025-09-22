package com.JobApplicationPortal.JobApplicationPortal.Services.InterfaceOfServices;

import com.JobApplicationPortal.JobApplicationPortal.Mapper.ApplicationMapper.*;
import com.JobApplicationPortal.JobApplicationPortal.Model.Application;
import com.JobApplicationPortal.JobApplicationPortal.Model.Client;

import java.util.List;
import java.util.Optional;

public interface ApplicationServiceInterface {
    String addApplication(IncomingApplicationDto input);

    List<OutgoingApplicationDto> getApplicationById(Long clientId);

    List<OutgoingApplicationForRecruiter> getApplicationByJobId(Long jobId);

    OutgoingApplication getApplication(Long aId);


    String changeStatus(Long aId, StatusIncomingDto statusIncomingDto);
}

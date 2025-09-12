package com.JobApplicationPortal.JobApplicationPortal.Services.InterfaceOfServices;

import com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper.ClientIncomingDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper.RecruiterOutgoingDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper.SeekerProfileOutgoingDto;


public interface ClientServiceInterface {
    void addClient(ClientIncomingDto client);


    SeekerProfileOutgoingDto getSeeker(Long id);

    RecruiterOutgoingDto getRecruiter(Long id);

    String deleteClient(Long id);

    String updateClient(Long id,ClientIncomingDto incoming);

    Long getId(String email);
}

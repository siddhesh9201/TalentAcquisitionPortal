package com.JobApplicationPortal.JobApplicationPortal.Services.InterfaceOfServices;

import com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper.ClientIncomingDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper.RecruiterOutgoingDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper.SeekerProfileOutgoingDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ClientServiceInterface {
    void addClient(ClientIncomingDto client);


    SeekerProfileOutgoingDto getSeeker(Long id);

    RecruiterOutgoingDto getRecruiter(Long id);

    String deleteClient(Long id);

    String updateClient(Long id,ClientIncomingDto incoming);
}

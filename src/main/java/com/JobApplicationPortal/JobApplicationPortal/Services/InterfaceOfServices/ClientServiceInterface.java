package com.JobApplicationPortal.JobApplicationPortal.Services.InterfaceOfServices;

import com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper.ClientIncomingDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper.SeekerProfileOutgoingDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ClientServiceInterface {
    void addClient(ClientIncomingDto client);


    SeekerProfileOutgoingDto getSeeker(Long id);
}

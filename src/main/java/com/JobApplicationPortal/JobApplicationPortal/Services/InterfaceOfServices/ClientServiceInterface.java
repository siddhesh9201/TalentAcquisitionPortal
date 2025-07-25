package com.JobApplicationPortal.JobApplicationPortal.Services.InterfaceOfServices;

import com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper.ClientIncomingDto;
import org.springframework.stereotype.Repository;



public interface ClientServiceInterface {
    void addClient(ClientIncomingDto client);
}

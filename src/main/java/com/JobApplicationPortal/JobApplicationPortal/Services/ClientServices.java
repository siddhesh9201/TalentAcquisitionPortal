package com.JobApplicationPortal.JobApplicationPortal.Services;

import com.JobApplicationPortal.JobApplicationPortal.Exception.EmailAlreadyExistException;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper.ClientIncomingDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper.ClientMapper;
import com.JobApplicationPortal.JobApplicationPortal.Model.Client;
import com.JobApplicationPortal.JobApplicationPortal.Repository.ClientRepo;
import com.JobApplicationPortal.JobApplicationPortal.Services.InterfaceOfServices.ClientServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ClientServices implements ClientServiceInterface {

    @Autowired
    ClientRepo clientRepo;


    @Transactional
    @Override
    public void addClient(ClientIncomingDto client) {
        Optional<Client> foundClient = clientRepo.findByEmail(client.getEmail());
        if(foundClient.isPresent()){
            throw new EmailAlreadyExistException("Email Already Exist");
        }
        else{
           Client newClient = ClientMapper.toEntity(client);
            clientRepo.save(newClient);
        }

    }
}

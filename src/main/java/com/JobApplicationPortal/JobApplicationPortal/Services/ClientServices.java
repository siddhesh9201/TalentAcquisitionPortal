package com.JobApplicationPortal.JobApplicationPortal.Services;

import com.JobApplicationPortal.JobApplicationPortal.EmailService;
import com.JobApplicationPortal.JobApplicationPortal.Exception.ClientNotFoundException;
import com.JobApplicationPortal.JobApplicationPortal.Exception.EmailAlreadyExistException;
import com.JobApplicationPortal.JobApplicationPortal.Exception.EmailNotFoundException;
import com.JobApplicationPortal.JobApplicationPortal.Exception.SeekerNotFoundException;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper.ClientIncomingDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper.ClientMapper;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper.RecruiterOutgoingDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper.SeekerProfileOutgoingDto;
import com.JobApplicationPortal.JobApplicationPortal.Model.Client;
import com.JobApplicationPortal.JobApplicationPortal.Model.Enums.ProfileStatus;
import com.JobApplicationPortal.JobApplicationPortal.Model.Enums.Role;
import com.JobApplicationPortal.JobApplicationPortal.Model.Skill;
import com.JobApplicationPortal.JobApplicationPortal.Repository.ClientRepo;
import com.JobApplicationPortal.JobApplicationPortal.Repository.SkillRepo;
import com.JobApplicationPortal.JobApplicationPortal.Services.InterfaceOfServices.ClientServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class ClientServices implements ClientServiceInterface {

    @Autowired
    ClientRepo clientRepo;

    @Autowired
    private EmailService emailService;

    @Autowired
    private SkillRepo skillRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void addClient(ClientIncomingDto client) {

        if (client.getEmail() == null) {
            throw new IllegalArgumentException("Email Cannot be Null");
        }

        Optional<Client> foundClient = clientRepo.findByEmail(client.getEmail());
        if (foundClient.isPresent()) {
            throw new EmailAlreadyExistException("Email Already Exist");
        }

        Client newClient = ClientMapper.toEntity(client);
        Boolean isIncomplete = client.getName() == null || client.getRole() == null;
        newClient.setProfileStatus(isIncomplete ? ProfileStatus.INCOMPLITE : ProfileStatus.COMPLETE);
        newClient.setPassword(passwordEncoder.encode(client.getPassword()));
        clientRepo.save(newClient);

        Set<Skill> savedSkills = client.getSkills().stream().map(skillName -> {
            Skill skill = skillRepo.findByName(skillName).orElseGet(() -> new Skill(skillName));
            skill.setClient(newClient);
            return skill;
        }).collect(Collectors.toSet());

        newClient.setSkills(savedSkills);

        skillRepo.saveAll(savedSkills);

        clientRepo.save(newClient);

        //emailService.sendRegistrationEmail(client.getEmail());
    }

    @Override
    public SeekerProfileOutgoingDto getSeeker(Long id) {
        Client client = clientRepo.findById(id).orElseThrow(() -> new SeekerNotFoundException("User not Found!"));
        return ClientMapper.toDto(client);

    }

    @Override
    public RecruiterOutgoingDto getRecruiter(Long id) {
        Client client = clientRepo.findById(id).orElseThrow(() -> new SeekerNotFoundException("Recruiter Not Found!"));
        if (client.getRole() == Role.SEEKER) {
            throw new SeekerNotFoundException("Recruiter Not Found!");
        }
        return ClientMapper.toDtoForRecruiter(client);
    }

    @Override
    public String deleteClient(Long id) {
        if (!clientRepo.existsById(id)) {
            throw new ClientNotFoundException("Client not found with ID: " + id);
        } else {
            clientRepo.deleteById(id);
        }

        return "Deleted Successfully!";
    }


    @Transactional
    @Override
    public String updateClient(Long id, ClientIncomingDto incoming) {
        Client client = clientRepo.findById(id).orElseThrow(() -> new ClientNotFoundException("Client With" + id + "Not Found "));


        if (incoming.getEmail() != null && !incoming.getEmail().equals(client.getEmail())) {
            Optional<Client> existing = clientRepo.findByEmail(incoming.getEmail());
            if (existing.isPresent()) {
                throw new EmailAlreadyExistException("Email already exists");
            }

            client.setName(incoming.getName());
            client.setEmail(incoming.getEmail());
            client.setPassword(incoming.getPassword());
            client.setRole(incoming.getRole());
            clientRepo.save(client);
        }
        return "Client Updated Successfully!";
    }

    @Override
    public Long getId(String email) {
        Client c = clientRepo.findByEmail(email).orElseThrow(() -> {
            throw new EmailNotFoundException("email not exist");
        });
        return c.getId();
    }


}
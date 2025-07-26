package com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper;

import com.JobApplicationPortal.JobApplicationPortal.Model.Client;

public class ClientMapper {




    public static Client toEntity(ClientIncomingDto input ){

        Client client = new Client();
        client.setName(input.getName());
        client.setEmail(input.getEmail());;
        client.setPassword(input.getPassword());
        client.setRole(input.getRole());

        return client;
    }


    //Jobseeker  mapping entity to outDto
    public static SeekerProfileOutgoingDto toDto(Client client){

        SeekerProfileOutgoingDto output = new SeekerProfileOutgoingDto();
        output.setId(client.getId());
        output.setName(client.getName());
        output.setEmail(client.getEmail());
        output.setRole(client.getRole());
        output.setProfileStatus(client.getProfileStatus());
        output.setSkills(client.getSkills());
        output.setApplications(client.getApplications());
        output.setLastLogin(client.getLastLogin());

        return output;
    }

    //recruiter mapping entity to dto
    public static RecruiterOutgoingDto toDtoForRecruiter(Client client){

        RecruiterOutgoingDto output = new RecruiterOutgoingDto();
        output.setId(client.getId());
        output.setName(client.getName());
        output.setEmail(client.getEmail());
        output.setRole(client.getRole());
        output.setPostedJobs(client.getJobs());
        output.setLastLogin(client.getLastLogin());
        output.setProfileStatus(client.getProfileStatus());
        return output;
    }



}

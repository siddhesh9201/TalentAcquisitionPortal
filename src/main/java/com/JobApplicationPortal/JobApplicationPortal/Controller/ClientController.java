package com.JobApplicationPortal.JobApplicationPortal.Controller;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper.ClientIncomingDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper.RecruiterOutgoingDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper.SeekerProfileOutgoingDto;
import com.JobApplicationPortal.JobApplicationPortal.Services.ClientServices;
import jakarta.validation.Valid;
import org.hibernate.query.sql.spi.ParameterOccurrence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ClientController {


    @Autowired
    ClientServices clientService;

    @PostMapping("/Register")
    public ResponseEntity<String> registerClient(@RequestBody @Valid ClientIncomingDto client){
            clientService.addClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body("Registration Successfully!");
    }

    @GetMapping("/seeker/{id}")
    public ResponseEntity<SeekerProfileOutgoingDto>getSeekerProfile(@PathVariable  Long id){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getSeeker(id));
    }

    @GetMapping("/recruiter/{id}")
    public ResponseEntity<RecruiterOutgoingDto>getRecruiterProfile(@PathVariable  Long id){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getRecruiter(id));
    }

    @DeleteMapping("/DeleteClient/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.deleteClient(id));
    }

    @PutMapping("/updateClient/{id}")
    public ResponseEntity<String> updateClient(@PathVariable Long id ,@RequestBody ClientIncomingDto incoming){
       return ResponseEntity.status(HttpStatus.OK).body(clientService.updateClient(id,incoming));
    }




}

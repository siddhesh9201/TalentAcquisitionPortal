package com.JobApplicationPortal.JobApplicationPortal.Controller;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper.ClientIncomingDto;
import com.JobApplicationPortal.JobApplicationPortal.Services.ClientServices;
import org.hibernate.query.sql.spi.ParameterOccurrence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClientController {


    @Autowired
    ClientServices clientService;

    @PostMapping("/Client/Register")
    public ResponseEntity<String> registerClient(ClientIncomingDto client){
            clientService.addClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body("Registration Successfully!");
    }

}

package com.JobApplicationPortal.JobApplicationPortal.Security;


import com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper.ClientIncomingDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper.LoginRequestDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper.LoginResponseDto;
import com.JobApplicationPortal.JobApplicationPortal.Services.ClientServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {


    private final AuthService authService;
    private final ClientServices services;

    public AuthController(AuthService authService, ClientServices services) {
        this.authService = authService;
        this.services = services;
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        return ResponseEntity.ok(authService.login(loginRequestDto));
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerClient(@RequestBody @Valid ClientIncomingDto client) {
        services.addClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body("Registration Successfully!");
    }

}

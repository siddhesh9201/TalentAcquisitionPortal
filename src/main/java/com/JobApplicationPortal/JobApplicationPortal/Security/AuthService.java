package com.JobApplicationPortal.JobApplicationPortal.Security;

import com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper.LoginRequestDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper.LoginResponseDto;
import com.JobApplicationPortal.JobApplicationPortal.Model.Client;
import com.JobApplicationPortal.JobApplicationPortal.Repository.ClientRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;

    public AuthService(AuthenticationManager authenticationManager, AuthUtil authUtil) {
        this.authenticationManager = authenticationManager;
        this.authUtil = authUtil;
    }

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(), loginRequestDto.getPassword())
        );

        Client client = (Client) authentication.getPrincipal(); // works if Client implements UserDetails
        String token = authUtil.generateAccessToken(client);

        return new LoginResponseDto(token, client.getId(), client.getName());
    }
}

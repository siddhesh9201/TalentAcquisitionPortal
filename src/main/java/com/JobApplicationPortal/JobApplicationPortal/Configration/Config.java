package com.JobApplicationPortal.JobApplicationPortal.Configration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

@Configuration
public class Config {



    @Bean
     public ModelMapper modelMapper(){
         return new ModelMapper();
     }



}

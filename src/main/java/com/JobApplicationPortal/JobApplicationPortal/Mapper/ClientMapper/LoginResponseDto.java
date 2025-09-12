package com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper;

public class LoginResponseDto {
    String jwt;
    Long clientId;
    String name;

    public LoginResponseDto() {
    }

    public LoginResponseDto(String jwt, Long clientId, String name) {
        this.jwt = jwt;
        this.clientId = clientId;
        this.name =name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}

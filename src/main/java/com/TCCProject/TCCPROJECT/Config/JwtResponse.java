package com.TCCProject.TCCPROJECT.Config;

import org.springframework.security.core.parameters.P;

import java.util.List;

public class JwtResponse {

    private String email;
    private String token;
    private String tokenType="Barear";
    private String username;
    private List roles;

    public JwtResponse(String jwt, String username,String email, List roles) {
        this.token = jwt;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}


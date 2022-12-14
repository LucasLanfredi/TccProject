package com.TCCProject.TCCPROJECT.Config;

import com.TCCProject.TCCPROJECT.Models.EUserType;

import java.util.Date;
import java.util.List;

public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private Long id;
  private String username;
  private String email;
  private List<String> roles;

  private final String firstName;

  private final String lastName;

  private final Integer pontuacaoUser;

  private final EUserType EUserType;


  public JwtResponse(String accessToken, Long id, String username, String email, List<String> roles ,
                     String firstName, String lastName, Integer pontuacaoUser, EUserType EUserType) {
    this.token = accessToken;
    this.id = id;
    this.username = username;
    this.email = email;
    this.roles = roles;
    this.firstName = firstName;
    this.lastName = lastName;
    this.pontuacaoUser = pontuacaoUser;
    this.EUserType = EUserType;
  }

  public String getAccessToken() {
    return token;
  }

  public void setAccessToken(String accessToken) {
    this.token = accessToken;
  }

  public String getTokenType() {
    return type;
  }

  public void setTokenType(String tokenType) {
    this.type = tokenType;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public List<String> getRoles() {
    return roles;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Integer getPontuacaoUser() {
    return pontuacaoUser;
  }

  public com.TCCProject.TCCPROJECT.Models.EUserType getEUserType() {
    return EUserType;
  }
}

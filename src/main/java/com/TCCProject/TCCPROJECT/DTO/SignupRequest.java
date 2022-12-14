package com.TCCProject.TCCPROJECT.DTO;

import java.util.Set;
public class SignupRequest {

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String password;

    private long IdResponsavel;

    private Set<String> role;

    public Set<String> getRole() {
        return this.role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getIdResponsavel() {
        return IdResponsavel;
    }

    public void setIdResponsavel(long idResponsavel) {
        IdResponsavel = idResponsavel;
    }
}
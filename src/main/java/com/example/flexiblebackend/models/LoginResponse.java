package com.example.flexiblebackend.models;

public class LoginResponse {

    private String Email;
    private String Authorization;

    public LoginResponse(String email, String authorization) {
        Email = email;
        Authorization = authorization;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAuthorization() {
        return Authorization;
    }

    public void setAuthorization(String authorization) {
        Authorization = authorization;
    }
}

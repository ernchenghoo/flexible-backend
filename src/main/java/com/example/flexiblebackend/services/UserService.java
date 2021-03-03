package com.example.flexiblebackend.services;

import com.example.flexiblebackend.models.ApplicationUser;

public interface UserService {
    public abstract void register(ApplicationUser newApplicationUser);

    public abstract void login(ApplicationUser newApplicationUser);
}

package com.example.flexiblebackend.services;

import com.example.flexiblebackend.EmptyResponse;
import com.example.flexiblebackend.models.ApplicationUser;

public interface UserService {
    public abstract EmptyResponse register(ApplicationUser newApplicationUser);

}

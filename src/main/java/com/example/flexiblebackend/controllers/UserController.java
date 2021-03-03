package com.example.flexiblebackend.controllers;

import com.example.flexiblebackend.EmptyResponse;
import com.example.flexiblebackend.exceptions.DuplicateEmailException;
import com.example.flexiblebackend.models.ApplicationUser;
import com.example.flexiblebackend.repositories.UserRepository;
import com.example.flexiblebackend.services.UserService;
import com.example.flexiblebackend.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authentication")
public class UserController {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping("/register")
    public EmptyResponse registerUser(@RequestBody ApplicationUser newApplicationUser) {
        return userService.register(newApplicationUser);
    }

}

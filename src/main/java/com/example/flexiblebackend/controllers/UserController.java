package com.example.flexiblebackend.controllers;

import com.example.flexiblebackend.EmptyResponse;
import com.example.flexiblebackend.exceptions.DuplicateEmailException;
import com.example.flexiblebackend.models.ApplicationUser;
import com.example.flexiblebackend.repositories.UserRepository;
import com.example.flexiblebackend.services.UserService;
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
    UserRepository userRepo;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping("/register")
    public EmptyResponse registerUser(@RequestBody ApplicationUser newApplicationUser) {
        newApplicationUser.setPassword(bCryptPasswordEncoder.encode(newApplicationUser.getPassword()));
        try {
            userRepo.save(newApplicationUser);
            return new EmptyResponse(true, "User successfully registered");
        }
        catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException(newApplicationUser.getEmail());
        }
    }

}

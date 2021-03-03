package com.example.flexiblebackend.services;

import com.example.flexiblebackend.EmptyResponse;
import com.example.flexiblebackend.exceptions.DuplicateEmailException;
import com.example.flexiblebackend.models.ApplicationUser;
import com.example.flexiblebackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    UserRepository userRepo;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public EmptyResponse register(ApplicationUser newApplicationUser) {
        newApplicationUser.setPassword(bCryptPasswordEncoder.encode(newApplicationUser.getPassword()));
        try {
            userRepo.save(newApplicationUser);
            return new EmptyResponse(true, "User successfully registered");
        }
        catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException(newApplicationUser.getEmail());
        }

    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ApplicationUser applicationUser = userRepo.findByEmail(email);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(email);
        }
        return new User(applicationUser.getEmail(), applicationUser.getPassword(), emptyList());
    }
}

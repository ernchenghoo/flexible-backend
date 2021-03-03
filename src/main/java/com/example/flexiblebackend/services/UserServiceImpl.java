package com.example.flexiblebackend.services;

import com.example.flexiblebackend.models.ApplicationUser;
import com.example.flexiblebackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

//    @Override
//    public void register(ApplicationUser newApplicationUser) {
//        newApplicationUser.setPassword(new BCryptPasswordEncoder().encode(newApplicationUser.getPassword()));
//        repository.save(newApplicationUser);
//
//    }
//
//    @Override
//    public void login(ApplicationUser newApplicationUser) {
//
//    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ApplicationUser applicationUser = repository.findByEmail(email);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(email);
        }
        return new User(applicationUser.getEmail(), applicationUser.getPassword(), emptyList());
    }
}

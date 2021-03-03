package com.example.flexiblebackend.repositories;

import com.example.flexiblebackend.models.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<ApplicationUser, String> {
    ApplicationUser findByEmail(String email);
}

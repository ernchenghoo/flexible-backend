package com.example.flexiblebackend.database;

import com.example.flexiblebackend.models.Car;
import com.example.flexiblebackend.repositories.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class LoadCarDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadCarDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CarRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Car("Ferrari")));
            log.info("Preloading " + repository.save(new Car("Myvi")));
        };
    }
}
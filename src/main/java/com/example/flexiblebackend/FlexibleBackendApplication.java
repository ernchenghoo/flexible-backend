package com.example.flexiblebackend;

import java.util.Arrays;
import java.util.Collections;

import com.example.flexiblebackend.database.LoadCarDatabase;
import com.example.flexiblebackend.models.Car;
import com.example.flexiblebackend.repositories.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class FlexibleBackendApplication {

	private static final Logger log = LoggerFactory.getLogger(FlexibleBackendApplication.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(FlexibleBackendApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
        app.run(args);
	}


	@Bean public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(CarRepository repository) {
//		return args -> {
//
//			repository.save(new Car("Mercedes"));
//			repository.save(new Car("Ferrari"));
//			repository.save(new Car("Mercedes Benz"));
//			repository.save(new Car("BMW"));
//			repository.save(new Car("Audi"));
//
////			// fetch all customers
////			log.info("Customers found with findAll():");
////			log.info("-------------------------------");
////			for (Car car : repository.findAll()) {
////				log.info(car.toString());
////			}
////			log.info("");
////
////			// fetch an individual customer by ID
////			Car car = repository.findById(1L);
////			log.info("Customer found with findById(1L):");
////			log.info("--------------------------------");
////			log.info(car.toString());
////			log.info("");
////
////			// fetch customers by last name
////			log.info("Customer found with findByModelName:");
////			log.info("--------------------------------------------");
////			repository.findByModel("Ferrari").forEach(bauer -> {
////				log.info(bauer.toString());
////			});
////			log.info("");
//
//		};
//	}

}

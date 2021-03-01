package com.example.flexiblebackend.controllers;

import com.example.flexiblebackend.DataResponse;
import com.example.flexiblebackend.EmptyResponse;
import com.example.flexiblebackend.exceptions.CarNotFoundException;
import com.example.flexiblebackend.models.Car;
import com.example.flexiblebackend.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
public class MainController {

	private final CarRepository repository;

	MainController(CarRepository repository) {
		this.repository = repository;

	}

	@GetMapping("/cars")
	DataResponse all() {
		ArrayList<Car> carList = new ArrayList<Car>(repository.findAll());
		return new DataResponse(true, "Success", carList);
	}

	@PostMapping("/cars")
	EmptyResponse addCar(@RequestBody Car newCar) {
		try {
			repository.save(newCar);
			return new EmptyResponse(true, "Car successfully added");
		}
		catch (Exception e) {
			return new EmptyResponse(false, "Fail to add car");
		}
	}

	@GetMapping("/cars/{id}")
	Car one(@PathVariable Long id) {

		return repository.findById(id)
				.orElseThrow(() -> new CarNotFoundException(id));
	}

	@PutMapping("/cars/{id}")
	Car replaceCar(@RequestBody Car newCar, @PathVariable Long id) {

		return repository.findById(id)
				.map(car -> {
					car.setModelName(newCar.getModelName());
					return repository.save(car);
				})
				.orElseGet(() -> {
					newCar.setId(id);
					return repository.save(newCar);
				});
	}

	@DeleteMapping("/cars/{id}")
	void deleteCar(@PathVariable Long id) {
		repository.deleteById(id);
	}


	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}
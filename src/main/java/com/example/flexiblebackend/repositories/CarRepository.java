package com.example.flexiblebackend.repositories;

import java.util.List;

import com.example.flexiblebackend.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends JpaRepository<Car, Long> {


//    List<Car> findByModel(String modelName);
//
//    Car findById(long id);

}
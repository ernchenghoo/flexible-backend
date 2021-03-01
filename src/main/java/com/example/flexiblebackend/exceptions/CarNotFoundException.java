package com.example.flexiblebackend.exceptions;

public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException(Long id) {
        super("Could not find car " + id);
    }
}
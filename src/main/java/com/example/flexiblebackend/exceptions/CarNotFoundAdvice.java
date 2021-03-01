package com.example.flexiblebackend.exceptions;

import com.example.flexiblebackend.EmptyResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class CarNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(CarNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    EmptyResponse employeeNotFoundHandler(CarNotFoundException ex) {

        return new EmptyResponse(false, ex.getMessage());
    }
}
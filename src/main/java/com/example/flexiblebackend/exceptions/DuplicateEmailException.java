package com.example.flexiblebackend.exceptions;

import com.example.flexiblebackend.EmptyResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class DuplicateEmailException extends RuntimeException {
    public DuplicateEmailException(String email) {
        super(email + " already exist in the system");
    }
}

@ControllerAdvice
class DuplicateEmailAdvice {

    @ResponseBody
    @ExceptionHandler(DuplicateEmailException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    EmptyResponse duplicateEmailHandler(DuplicateEmailException ex) {
        return new EmptyResponse(false, ex.getMessage());
    }
}

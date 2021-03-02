package com.example.flexiblebackend.exceptions;

import com.example.flexiblebackend.EmptyResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class LoginFailureException extends RuntimeException {
    public LoginFailureException() {
        super("Username or password not valid");
    }
}

@ControllerAdvice
class LoginFailureAdvice {

    @ResponseBody
    @ExceptionHandler(LoginFailureException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    EmptyResponse duplicateEmailHandler(LoginFailureException ex) {
        return new EmptyResponse(false, ex.getMessage());
    }
}

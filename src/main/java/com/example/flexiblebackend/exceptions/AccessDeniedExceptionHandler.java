package com.example.flexiblebackend.exceptions;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccessDeniedExceptionHandler {
    @ExceptionHandler(value = AccessDeniedException.class)
    public void handleConflict(HttpServletResponse response) throws IOException {
        response.sendError(403, "No token provided");
    }
}

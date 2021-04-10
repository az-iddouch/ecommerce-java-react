package com.vash.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@ControllerAdvice
public class CustomResponseEntityExceptionHandler {
    @ExceptionHandler
    public final ResponseEntity<Object> handleUsernameException(UsernameException ex, WebRequest request) {
        UsernameExceptionResponse usernameExceptionResponse = new UsernameExceptionResponse(ex.getMessage());
        return ResponseEntity.badRequest().body(usernameExceptionResponse);
    }
    @ExceptionHandler
    public final ResponseEntity<Object> handleAuthException(AuthCustomException ex, WebRequest request) {
        AuthCustomExceptionResponse authCustomExceptionResponse = new AuthCustomExceptionResponse(ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(authCustomExceptionResponse);
    }
}

package com.vash.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AuthCustomException extends RuntimeException{
    public AuthCustomException(String message) {
        super(message);
    }
}

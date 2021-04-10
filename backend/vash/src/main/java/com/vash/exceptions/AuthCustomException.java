package com.vash.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AuthCustomException extends RuntimeException{
	private static final long serialVersionUID = -1051821395026750544L;

	public AuthCustomException(String message) {
        super(message);
    }
}

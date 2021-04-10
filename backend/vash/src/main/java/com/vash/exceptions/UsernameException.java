package com.vash.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsernameException extends RuntimeException{
	private static final long serialVersionUID = 1005280779999937235L;

	public UsernameException(String message) {
        super(message);
    }
}

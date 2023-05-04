package com.springboot.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class Resourcenotfoundexception extends NullPointerException{

	private static final long serialVersionUID = 1L;
	
	public Resourcenotfoundexception(String message) {
		super(message);
	}
}


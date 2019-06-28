package com.progesco.rh.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author emile.camara
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {

	/**
	 * 
	 * @param message
	 */
	public EmployeeNotFoundException(String message) {
        super(message);
    }
}

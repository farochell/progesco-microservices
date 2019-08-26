/**
 * 
 */
package com.progesco.progescoschooling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author emile.camara
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CourseRegistrationNotFoundException extends RuntimeException {
    public CourseRegistrationNotFoundException(String message) {
    	super(message);
    }
}

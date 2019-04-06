/**
 * 
 */
package com.progesco.schoolYear.exception;

/**
 * @author emile
 *
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SchoolYearNotFoundException extends RuntimeException {
	
	/**
	 * 
	 * @param message
	 */
	public SchoolYearNotFoundException(String message) {
        super(message);
    }
}

/**
 * 
 */
package com.progesco.pedagogy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author emile.camara
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClassroomSemesterNotFoundException  extends RuntimeException {
	
	public ClassroomSemesterNotFoundException(String message) {
		super(message);
	}

}

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
public class ClassroomSemesterCourseNotFoundException extends  RuntimeException {
	
	public ClassroomSemesterCourseNotFoundException(String message) {
		super(message);
	}

}

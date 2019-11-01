package com.progesco.pedagogy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class ClassroomSemesterCourseForbiddenException extends RuntimeException {
    public ClassroomSemesterCourseForbiddenException(String message) {
        super(message);
    }
}

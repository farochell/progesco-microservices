package com.progesco.pedagogy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class CourseForbiddenException extends RuntimeException {
    public CourseForbiddenException(String message) {
        super(message);
    }
}


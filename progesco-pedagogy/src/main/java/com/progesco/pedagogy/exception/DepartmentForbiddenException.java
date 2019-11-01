package com.progesco.pedagogy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class DepartmentForbiddenException extends RuntimeException {
    public DepartmentForbiddenException(String message) {
        super(message);
    }
}

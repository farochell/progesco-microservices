package com.progesco.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class StudentForbiddenException extends RuntimeException {
    public StudentForbiddenException(String message) {
        super(message);
    }
}

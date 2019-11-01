package com.progesco.pedagogy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class ClassroomForbiddenException extends RuntimeException {
    public ClassroomForbiddenException(String message) {
        super(message);
    }
}

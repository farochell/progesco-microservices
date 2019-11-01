package com.progesco.pedagogy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ProgramForbiddenException extends RuntimeException {
    public ProgramForbiddenException(String message) {
        super(message);
    }
}


package com.progesco.pedagogy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class LevelForbiddenException extends RuntimeException {
    public LevelForbiddenException(String message) {
        super(message);
    }
}


package com.progesco.pedagogy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class SessionForbiddenException extends RuntimeException {
    public SessionForbiddenException(String message) {
        super(message);
    }
}


package com.progesco.pedagogy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class GroupForbiddenException extends RuntimeException {
    public GroupForbiddenException(String message) {
        super(message);
    }
}

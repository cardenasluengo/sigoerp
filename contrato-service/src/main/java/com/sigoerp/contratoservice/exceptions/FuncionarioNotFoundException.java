package com.sigoerp.contratoservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FuncionarioNotFoundException extends RuntimeException {
    public FuncionarioNotFoundException() {
    }

    public FuncionarioNotFoundException(String message) {
        super(message);
    }

    public FuncionarioNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FuncionarioNotFoundException(Throwable cause) {
        super(cause);
    }
}

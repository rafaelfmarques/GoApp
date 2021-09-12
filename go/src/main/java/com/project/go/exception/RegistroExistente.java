package com.project.go.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class RegistroExistente extends RuntimeException {
    
    private static final long serialVersionUID = -3904954587935088042L;

    public RegistroExistente() {
        super();
    }

    public RegistroExistente(String message) {
        super(message);
    }

    public RegistroExistente(Throwable cause) {
        super(cause);
    }
    
    public RegistroExistente(String message, Throwable cause) {
         super(message, cause);
    }

    
}

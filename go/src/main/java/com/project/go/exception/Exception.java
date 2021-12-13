package com.project.go.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class Exception extends RuntimeException {
    
    private static final long serialVersionUID = -3904954587935088042L;

    public Exception() {
        super();
    }

    public Exception(String message) {
        super(message);
    }

    public Exception(Throwable cause) {
        super(cause);
    }
    
    public Exception(String message, Throwable cause) {
         super(message, cause);
    }

    
}

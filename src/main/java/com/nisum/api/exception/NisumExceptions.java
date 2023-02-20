package com.nisum.api.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class NisumExceptions extends RuntimeException{

    private String message;
    private HttpStatus httpStatus;

    public NisumExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

}

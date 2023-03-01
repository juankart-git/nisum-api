package com.nisum.api.exception;

import com.nisum.api.service.dto.ErrorDTO;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {


    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @org.springframework.web.bind.annotation.ExceptionHandler(NisumExceptions.class)
    protected ErrorDTO handleConflict(NisumExceptions ex, WebRequest request){
        ErrorDTO error  = new ErrorDTO();
        error.setMessage(ex.getMessage());
        return error;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDTO handleInvalidArgument(MethodArgumentNotValidException ex){
        ErrorDTO error  = new ErrorDTO();
        error.setMessage(ex.getMessage());
        return error;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class)
    public ErrorDTO handleInvalidArgument(ConstraintViolationException ex){
        ErrorDTO error  = new ErrorDTO();
        error.setMessage(((ConstraintViolationImpl) ex.getConstraintViolations().toArray()[0]).getMessageTemplate());
        return error;
    }


}

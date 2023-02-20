package com.nisum.api.exception;

import com.nisum.api.service.dto.ErrorDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(NisumExceptions.class)
    protected ResponseEntity<Object> handleConflict(NisumExceptions ex, WebRequest request){
        ErrorDTO error  = new ErrorDTO();
        error.setMessage(ex.getMessage());
        return handleExceptionInternal(ex, error, new HttpHeaders(), ex.getHttpStatus(), request);
    }
}

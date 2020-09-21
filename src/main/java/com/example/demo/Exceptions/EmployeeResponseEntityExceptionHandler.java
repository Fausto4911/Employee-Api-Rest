package com.example.demo.Exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
@RestController
public class EmployeeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
        RestException restException =
                new RestException(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR, request.getDescription(false), ex.getMessage());
       return new ResponseEntity(restException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public final ResponseEntity<Object> handleEmployeeNotFoundExceptions(Exception ex, WebRequest request) throws Exception {
        RestException restException =
                new RestException(LocalDateTime.now(), HttpStatus.NOT_FOUND, request.getDescription(false), ex.getMessage());
        return new ResponseEntity(restException, HttpStatus.NOT_FOUND);
    }

}

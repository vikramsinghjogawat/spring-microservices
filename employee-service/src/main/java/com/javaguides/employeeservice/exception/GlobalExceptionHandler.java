package com.javaguides.employeeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorDetails> handleEmailAlreadyExistsException(EmailAlreadyExistsException ex,
                                                                          WebRequest webRequest){
        ErrorDetails exception = new ErrorDetails(LocalDateTime.now(),
                                                    ex.getMessage(),
                                                    webRequest.getDescription(false),
                                                    "EMAIL ALREADY EXISTS."
        );
                return new ResponseEntity<>(exception,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGeneralException(Exception ex, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                ex.getMessage(),
                webRequest.getDescription(false),
                "INTERNAL SERVER ERROR."
        );
        return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

package com.javaguides.employeeservice.exception;

public class EmailAlreadyExistsException extends RuntimeException{

    private String email;
    public EmailAlreadyExistsException(String email){
        super(String.format("User with %s alrady exists",email));
        this.email =email;

    }
}

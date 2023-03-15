package com.javaguides.departmentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResouceNotFoundException extends RuntimeException{

    private String resourceName;
    private String fieldName;
    private String fieldValue;

    public ResouceNotFoundException(String resourceName, String fieldName, String fieldValue){
        super(String.format("%s not found with %s: '%s'",resourceName,fieldName,fieldValue));
        this.resourceName =resourceName;
        this.fieldName=fieldName;
        this.fieldValue=fieldValue;
    }

}

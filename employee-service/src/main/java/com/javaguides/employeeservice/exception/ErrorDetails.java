package com.javaguides.employeeservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorDetails {

    private LocalDateTime timeStamp;
    private String message;
    private String description;
    private String errorCode;
}

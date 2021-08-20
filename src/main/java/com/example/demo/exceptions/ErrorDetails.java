package com.example.demo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorDetails {
    HttpStatus errorCode;
    String message;
    String appName;
}

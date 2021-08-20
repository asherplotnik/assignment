package com.example.demo.advice;

import com.example.demo.exceptions.ApiException;
import com.example.demo.exceptions.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
@ResponseBody
public class ApiControllerAdvice {
    @ExceptionHandler(ApiException.class)
    public ErrorDetails apiExceptionHandler(ApiException e, HttpServletResponse response){
        ErrorDetails error = e.getErrorDetails();
        response.setStatus(error.getErrorCode().value());
        return new ErrorDetails(error.getErrorCode(), error.getMessage(), error.getAppName());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails apiExceptionHandler(Exception e){
        return new ErrorDetails(HttpStatus.BAD_REQUEST, e.getLocalizedMessage(), "my app");
    }

}

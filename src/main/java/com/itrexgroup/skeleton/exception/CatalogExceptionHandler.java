package com.itrexgroup.skeleton.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CatalogExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<UserResponse> handlerNotFoundException(UserNotFoundException userNotFoundException){
        return new ResponseEntity<>(new UserResponse(userNotFoundException.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotUniqueLoginException.class)
    protected ResponseEntity<UserResponse> handlerNotUniqueLoginException(UserNotUniqueLoginException userNotUniqueLoginException){
        return new ResponseEntity<>(new UserResponse(userNotUniqueLoginException.getMessage()), HttpStatus.CONFLICT);
    }
}

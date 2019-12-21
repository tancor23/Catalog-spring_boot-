package com.itrexgroup.skeleton.exception;

import com.itrexgroup.skeleton.dto.UserErrorMessageResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CatalogExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<UserErrorMessageResponseDto> handlerNotFoundException(UserNotFoundException userNotFoundException) {
        return new ResponseEntity<>(new UserErrorMessageResponseDto(userNotFoundException.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotUniqueLoginException.class)
    protected ResponseEntity<UserErrorMessageResponseDto> handlerNotUniqueLoginException(UserNotUniqueLoginException userNotUniqueLoginException) {
        return new ResponseEntity<>(new UserErrorMessageResponseDto(userNotUniqueLoginException.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserWasNotChangedException.class)
    protected ResponseEntity<UserErrorMessageResponseDto> handlerWasNotChangedException(UserWasNotChangedException userWasNotChangedException) {
        return new ResponseEntity<>(new UserErrorMessageResponseDto(userWasNotChangedException.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(UserIsAlreadyDeletedException.class)
    protected ResponseEntity<UserErrorMessageResponseDto> handlerIsAlreadyDeletedException(UserIsAlreadyDeletedException userIsAlreadyDeletedException) {
        return new ResponseEntity<>(new UserErrorMessageResponseDto(userIsAlreadyDeletedException.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(UserNotValidStatusError.class)
    protected ResponseEntity<UserErrorMessageResponseDto> handlerNotValidStatusException(UserNotValidStatusError userNotValidStatusError) {
        return new ResponseEntity<>(new UserErrorMessageResponseDto(userNotValidStatusError.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(UserNotValidRoleError.class)
    protected ResponseEntity<UserErrorMessageResponseDto> handlerNotValidRoleException(UserNotValidRoleError userNotValidRoleError) {
        return new ResponseEntity<>(new UserErrorMessageResponseDto(userNotValidRoleError.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(IAmTeapotException.class)
    protected ResponseEntity<UserErrorMessageResponseDto> handlerIAmTeapotException(IAmTeapotException iAmTeapotException) {
        return new ResponseEntity<>(new UserErrorMessageResponseDto(iAmTeapotException.getMessage()), HttpStatus.I_AM_A_TEAPOT);
    }
}

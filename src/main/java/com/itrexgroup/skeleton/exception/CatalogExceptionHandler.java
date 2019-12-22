package com.itrexgroup.skeleton.exception;

import com.itrexgroup.skeleton.dto.UserMessageResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CatalogExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<UserMessageResponseDto> handlerNotFoundException(UserNotFoundException userNotFoundException) {
        return new ResponseEntity<>(new UserMessageResponseDto(userNotFoundException.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotUniqueLoginException.class)
    protected ResponseEntity<UserMessageResponseDto> handlerNotUniqueLoginException(UserNotUniqueLoginException userNotUniqueLoginException) {
        return new ResponseEntity<>(new UserMessageResponseDto(userNotUniqueLoginException.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserWasNotChangedException.class)
    protected ResponseEntity<UserMessageResponseDto> handlerWasNotChangedException(UserWasNotChangedException userWasNotChangedException) {
        return new ResponseEntity<>(new UserMessageResponseDto(userWasNotChangedException.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(UserIsAlreadyDeletedException.class)
    protected ResponseEntity<UserMessageResponseDto> handlerIsAlreadyDeletedException(UserIsAlreadyDeletedException userIsAlreadyDeletedException) {
        return new ResponseEntity<>(new UserMessageResponseDto(userIsAlreadyDeletedException.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(UserNotValidStatusError.class)
    protected ResponseEntity<UserMessageResponseDto> handlerNotValidStatusException(UserNotValidStatusError userNotValidStatusError) {
        return new ResponseEntity<>(new UserMessageResponseDto(userNotValidStatusError.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(UserNotValidRoleError.class)
    protected ResponseEntity<UserMessageResponseDto> handlerNotValidRoleException(UserNotValidRoleError userNotValidRoleError) {
        return new ResponseEntity<>(new UserMessageResponseDto(userNotValidRoleError.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(IAmTeapotException.class)
    protected ResponseEntity<UserMessageResponseDto> handlerIAmTeapotException(IAmTeapotException iAmTeapotException) {
        return new ResponseEntity<>(new UserMessageResponseDto(iAmTeapotException.getMessage()), HttpStatus.I_AM_A_TEAPOT);
    }
}

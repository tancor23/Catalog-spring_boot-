package com.itrexgroup.skeleton.exception;

import com.itrexgroup.skeleton.dto.UserMessageResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CatalogExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    protected UserMessageResponseDto handlerNotFoundException(UserNotFoundException userNotFoundException) {
        return new UserMessageResponseDto(userNotFoundException.getMessage());
    }

    @ExceptionHandler(UserNotUniqueLoginException.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    protected UserMessageResponseDto handlerNotUniqueLoginException(UserNotUniqueLoginException userNotUniqueLoginException) {
        return new UserMessageResponseDto(userNotUniqueLoginException.getMessage());
    }

    @ExceptionHandler(UserWasNotChangedException.class)
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    protected UserMessageResponseDto handlerWasNotChangedException(UserWasNotChangedException userWasNotChangedException) {
        return new UserMessageResponseDto(userWasNotChangedException.getMessage());
    }

    @ExceptionHandler(UserIsAlreadyDeletedException.class)
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    protected UserMessageResponseDto handlerIsAlreadyDeletedException(UserIsAlreadyDeletedException userIsAlreadyDeletedException) {
        return new UserMessageResponseDto(userIsAlreadyDeletedException.getMessage());
    }

    @ExceptionHandler(UserNotValidStatusException.class)
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    protected UserMessageResponseDto handlerNotValidStatusException(UserNotValidStatusException userNotValidStatusException) {
        return new UserMessageResponseDto(userNotValidStatusException.getMessage());
    }

    @ExceptionHandler(UserNotValidRoleException.class)
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    protected UserMessageResponseDto handlerNotValidRoleException(UserNotValidRoleException userNotValidRoleException) {
        return new UserMessageResponseDto(userNotValidRoleException.getMessage());
    }

    @ExceptionHandler(UserNotValidPasswordException.class)
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    protected UserMessageResponseDto handlerIAmTeapotException(UserNotValidPasswordException userNotValidPasswordException) {
        return new UserMessageResponseDto(userNotValidPasswordException.getMessage());
    }

    @ExceptionHandler(UserLoginIsEmptyException.class)
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    protected UserMessageResponseDto handlerIAmTeapotException(UserLoginIsEmptyException userLoginIsEmptyException) {
        return new UserMessageResponseDto(userLoginIsEmptyException.getMessage());
    }
}

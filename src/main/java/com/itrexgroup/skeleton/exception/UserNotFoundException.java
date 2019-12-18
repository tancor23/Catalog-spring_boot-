package com.itrexgroup.skeleton.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("User by ID '" + id + "' was not found");
    }
}

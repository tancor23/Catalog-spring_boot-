package com.itrexgroup.skeleton.exception;

public class UserLoginIsNullException extends RuntimeException {
    public UserLoginIsNullException(Long id) {
        super("Login of user by ID " + id + " is NULL.");
    }
}

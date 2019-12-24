package com.itrexgroup.skeleton.exception;

public class UserLoginIsEmptyException extends RuntimeException {
    public UserLoginIsEmptyException(Long id) {
        super("Login of user by ID " + id + " is Empty.");
    }
}

package com.itrexgroup.skeleton.exception;

public class UserEmailIsEmptyException extends RuntimeException {
    public UserEmailIsEmptyException(){
        super("Email of user entity is Empty.");
    }

    public UserEmailIsEmptyException(Long id) {
        super("Email of user by ID " + id + " is Empty.");
    }
}

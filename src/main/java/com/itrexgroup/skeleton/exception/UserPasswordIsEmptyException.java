package com.itrexgroup.skeleton.exception;

public class UserPasswordIsEmptyException extends RuntimeException {
    public UserPasswordIsEmptyException(){
        super("Password of user entity is Empty.");
    }

    public UserPasswordIsEmptyException(Long id) {
        super("Password of user by ID " + id + " is Empty.");
    }
}

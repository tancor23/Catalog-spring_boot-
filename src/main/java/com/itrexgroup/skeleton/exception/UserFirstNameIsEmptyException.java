package com.itrexgroup.skeleton.exception;

public class UserFirstNameIsEmptyException extends RuntimeException {

    public UserFirstNameIsEmptyException() {
        super("First Name of user is Empty.");
    }

    public UserFirstNameIsEmptyException(Long id) {
        super("First Name of user by ID " + id + " is Empty.");
    }
}

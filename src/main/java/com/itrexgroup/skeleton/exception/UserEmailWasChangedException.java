package com.itrexgroup.skeleton.exception;

public class UserEmailWasChangedException extends RuntimeException {
    public UserEmailWasChangedException(Long id) {
        super("The email of user by ID '" + id + "' was changed");
    }
}

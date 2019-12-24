package com.itrexgroup.skeleton.exception;

public class UserEmailConfirmWasChangedException extends RuntimeException {
    public UserEmailConfirmWasChangedException(Long id) {
        super("The email confirm of user by ID '" + id + "' was changed");
    }
}

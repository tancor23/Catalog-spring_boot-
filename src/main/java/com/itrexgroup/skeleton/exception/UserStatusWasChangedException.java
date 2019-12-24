package com.itrexgroup.skeleton.exception;

public class UserStatusWasChangedException extends RuntimeException {
    public UserStatusWasChangedException(Long id) {
        super("Status of user by ID " + id + " was changed.");
    }
}

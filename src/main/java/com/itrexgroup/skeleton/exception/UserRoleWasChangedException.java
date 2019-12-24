package com.itrexgroup.skeleton.exception;

public class UserRoleWasChangedException extends RuntimeException {
    public UserRoleWasChangedException(Long id) {
        super("Role of user by ID " + id + " was changed.");
    }
}

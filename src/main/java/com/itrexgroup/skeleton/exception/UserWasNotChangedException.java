package com.itrexgroup.skeleton.exception;

public class UserWasNotChangedException extends RuntimeException {
    public UserWasNotChangedException(Long id, String login) {
        super("The login '" + login + "' of user by ID '" + id + "' was not changed");
    }
}

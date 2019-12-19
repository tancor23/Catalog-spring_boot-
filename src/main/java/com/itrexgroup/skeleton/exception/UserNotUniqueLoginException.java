package com.itrexgroup.skeleton.exception;

public class UserNotUniqueLoginException extends RuntimeException {
    public UserNotUniqueLoginException(String login) {
        super("User by login '" + login + "' is already exist");
    }
}

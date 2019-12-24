package com.itrexgroup.skeleton.exception;

public class UserNotValidStatusException extends RuntimeException {
    public UserNotValidStatusException(long id, String login, String status) {
        super("The status '" + status + "' of user by ID '" + id + "' and login '" + login + "' is not correct");
    }
}

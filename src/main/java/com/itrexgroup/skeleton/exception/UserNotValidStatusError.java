package com.itrexgroup.skeleton.exception;

public class UserNotValidStatusError extends RuntimeException {
    public UserNotValidStatusError(long id, String login, String status) {
        super("The status '" + status + "' of user by ID '" + id + "' and login '" + login + "' is not correct");
    }
}

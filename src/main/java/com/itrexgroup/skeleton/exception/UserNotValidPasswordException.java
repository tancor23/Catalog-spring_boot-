package com.itrexgroup.skeleton.exception;

public class UserNotValidPasswordException extends RuntimeException {
    public UserNotValidPasswordException(String login) {
        super("The password of user by login " + login + " is not correct");
    }
}

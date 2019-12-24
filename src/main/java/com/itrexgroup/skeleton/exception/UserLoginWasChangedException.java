package com.itrexgroup.skeleton.exception;

public class UserLoginWasChangedException extends RuntimeException {
    public UserLoginWasChangedException(Long id, String login) {
        super("User by ID " + id + " and login " + login + " .Not allowed to change login of this user.");
    }
}

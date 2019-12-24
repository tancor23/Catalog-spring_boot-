package com.itrexgroup.skeleton.exception;

public class UserNotValidRoleException extends RuntimeException {
    public UserNotValidRoleException(long id, String login, String role) {
        super("The role '" + role + "' of user by ID '" + id + "' and login '" + login + "' is not correct");
    }
}

package com.itrexgroup.skeleton.exception;

public class UserNotValidRoleError extends RuntimeException {
    public UserNotValidRoleError(long id, String login, String role) {
        super("The role '" + role + "' of user by ID '" + id + "' and login '" + login + "' is not correct");
    }
}

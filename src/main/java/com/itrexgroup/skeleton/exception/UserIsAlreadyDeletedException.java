package com.itrexgroup.skeleton.exception;

public class UserIsAlreadyDeletedException extends RuntimeException {
    public UserIsAlreadyDeletedException(Long id, String login) {
        super("The User by ID '" + id + "' and login '" + login + "' is already deleted");
    }
}

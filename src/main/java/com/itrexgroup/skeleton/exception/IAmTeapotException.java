package com.itrexgroup.skeleton.exception;

public class IAmTeapotException extends RuntimeException {
    public IAmTeapotException(String login) {
        super("User by login '" + login + "' was not created, because I am a Teapot");
    }
}

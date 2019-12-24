package com.itrexgroup.skeleton.exception;

public class MessageDigestException extends RuntimeException {
    public MessageDigestException(String messageException) {
        super("Sorry, issue with MessageDigest Exception: " + messageException);
    }
}

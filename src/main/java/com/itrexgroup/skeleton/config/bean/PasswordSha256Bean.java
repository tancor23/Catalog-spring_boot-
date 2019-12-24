package com.itrexgroup.skeleton.config.bean;

import java.security.MessageDigest;

public interface PasswordSha256Bean {

    MessageDigest getMessageDigest();

    String getEncryptedPassword (String password);

    boolean compareEncryptedPasswords(String password1, String password2);

}

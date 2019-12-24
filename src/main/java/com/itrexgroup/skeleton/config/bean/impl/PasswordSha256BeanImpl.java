package com.itrexgroup.skeleton.config.bean.impl;

import com.itrexgroup.skeleton.config.bean.PasswordSha256Bean;
import com.itrexgroup.skeleton.exception.MessageDigestException;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class PasswordSha256BeanImpl implements PasswordSha256Bean {

    @Override
    public MessageDigest getMessageDigest() {
        try {
            return MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new MessageDigestException(e.getMessage());
        }
    }

    @Override
    public String getEncryptedPassword(String password) {
        return new String(getMessageDigest().digest(password.getBytes()));
    }

    @Override
    public boolean compareEncryptedPasswords(String password1, String password2) {
        return password1.equals(password2);
    }
}

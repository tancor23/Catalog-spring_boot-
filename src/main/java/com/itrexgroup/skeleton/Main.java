package com.itrexgroup.skeleton;

import java.util.Arrays;
import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        String encodeToString = Base64.getEncoder().encodeToString("userEntity".getBytes());
        String decodeToString = new String(Base64.getDecoder().decode(encodeToString));
        System.out.println(decodeToString);
    }
}

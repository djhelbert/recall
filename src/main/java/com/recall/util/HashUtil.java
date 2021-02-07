package com.recall.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {
    private MessageDigest messageDigest;

    public HashUtil() {
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException err) {
        }
    }

    public final String hash(String value) {
        messageDigest.reset();
        messageDigest.update(value.getBytes());
        return new String(messageDigest.digest());
    }
}

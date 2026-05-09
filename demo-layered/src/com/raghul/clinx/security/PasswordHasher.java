package com.raghul.clinx.security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher {

    private static final String ALGORITHM = "SHA-256";
    private static final String SALT = "clinx-demo-salt";

    private PasswordHasher() {
    }

    public static String hash(String value) {
        try {
            MessageDigest digest = MessageDigest.getInstance(ALGORITHM);
            byte[] bytes = digest.digest((SALT + value).getBytes(StandardCharsets.UTF_8));
            return toHex(bytes);
        } catch (NoSuchAlgorithmException ex) {
            throw new IllegalStateException("Missing hash algorithm: " + ALGORITHM, ex);
        }
    }

    public static boolean matches(String plainText, String expectedHash) {
        return hash(plainText).equals(expectedHash);
    }

    private static String toHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}

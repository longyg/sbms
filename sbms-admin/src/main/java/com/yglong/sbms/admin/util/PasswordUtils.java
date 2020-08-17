package com.yglong.sbms.admin.util;

import java.util.UUID;

public class PasswordUtils {

    public static boolean matches(String salt, String password, String encodedPassword) {
        return new PasswordEncoder(salt).matches(encodedPassword, password);
    }

    public static String encode(String password, String salt) {
        return new PasswordEncoder(salt).encode(password);
    }

    public static String getSalt() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
    }
}

package com.himawari.kakehashi.util;

import java.util.UUID;

public class GenUUID {

    public static String generate() {
        final String uuid = UUID.randomUUID().toString();
        return uuid.replace("-", "");
    }
}

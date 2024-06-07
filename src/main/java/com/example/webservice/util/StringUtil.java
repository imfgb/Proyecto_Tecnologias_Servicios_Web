package com.example.webservice.util;

public class StringUtil {
    public static String sanitize(String input) {
        if (input == null) {
            return null;
        }
        return input.replace("\u0000", "");
    }
}

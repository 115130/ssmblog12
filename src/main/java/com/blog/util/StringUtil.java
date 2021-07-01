package com.blog.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtil {
    public static boolean checkString(String obj) {
        return obj != null && !obj.equals("");
    }

    public static boolean checkInt(Integer obj) {
        return obj != null && obj != 0;
    }

    public static String toSHA1(byte[] convertme) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
        }
        catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new String(md.digest(convertme));
    }
}

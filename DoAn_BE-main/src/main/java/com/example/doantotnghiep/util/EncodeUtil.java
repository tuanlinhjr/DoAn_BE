package com.example.doantotnghiep.util;

import java.util.Base64;

public class EncodeUtil {
    public static String EncodeBase64PassWord(String passWord){
        return Base64.getEncoder().encodeToString(passWord.getBytes());
    }
}

package com.xyz.util.CommonUtil;

public class StringUtils {

    public static String capitalizeTheFirstLetter(String words){
        String substring = words.substring(0, 1).toUpperCase();
        return substring+words.substring(1);
    }
}

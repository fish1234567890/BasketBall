package com.xyz.util.CommonUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static String capitalizeTheFirstLetter(String words){
        String substring = words.substring(0, 1).toUpperCase();
        return substring+words.substring(1);
    }

    public static Map<String,Object> getPatternList(String sqlPattern,String matcher){
        Map<String,Object> map = new HashMap<>();
        if("#{}".equals(matcher)){
            String begin="#\\{";
            String end="\\}";
            Matcher m = Pattern.compile(begin+"(.*)"+end).matcher(sqlPattern);
            while(m.find()) {
                map.put(m.group(1),null);
            }
        }else{

        }
        return map;
    }
}

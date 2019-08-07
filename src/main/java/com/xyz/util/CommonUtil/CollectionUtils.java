package com.xyz.util.CommonUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CollectionUtils {

    public static Map<String,Object> convertToMap(Object params) throws Exception {
        Map<String,Object> map = new HashMap<>();

        Class<?> clazz = params.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if(Integer.class == field.getType()){
                Method declaredMethod = clazz.getDeclaredMethod("get" + StringUtils.capitalizeTheFirstLetter(field.getName()));
                Integer invoke = (Integer)declaredMethod.invoke(params);
                map.put(field.getName(),invoke);
            }
            if(String.class == field.getType()){
                Method declaredMethod = clazz.getDeclaredMethod("get" + StringUtils.capitalizeTheFirstLetter(field.getName()));
                String invoke = (String)declaredMethod.invoke(params);
                map.put(field.getName(),invoke);
            }
            if(Long.class == field.getType()){
                Method declaredMethod = clazz.getDeclaredMethod("get" + StringUtils.capitalizeTheFirstLetter(field.getName()));
                Long invoke = (Long)declaredMethod.invoke(params);
                map.put(field.getName(),invoke);
            }
            if(Short.class == field.getType()){
                Method declaredMethod = clazz.getDeclaredMethod("get" + StringUtils.capitalizeTheFirstLetter(field.getName()));
                Short invoke = (Short)declaredMethod.invoke(params);
                map.put(field.getName(),invoke);
            }
            if(Date.class == field.getType()){
                Method declaredMethod = clazz.getDeclaredMethod("get" + StringUtils.capitalizeTheFirstLetter(field.getName()));
                Date invoke = (Date)declaredMethod.invoke(params);
                map.put(field.getName(),invoke);
            }

        }


        return map;
    }
}

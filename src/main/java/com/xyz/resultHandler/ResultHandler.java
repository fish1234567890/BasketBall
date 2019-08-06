package com.xyz.resultHandler;


import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResultHandler {

    public static <T> List<T> formateResult(ResultSet result, Class<T> resultType) throws Exception {
        ArrayList<T> list = new ArrayList<>();
        HashMap<String ,Method> methodMap = getDeclaredFieldMap(resultType);

        ResultSetMetaData metaData = result.getMetaData();
        int count = metaData.getColumnCount();

        while (result.next()) {
            //创建对象
            T instance= resultType.newInstance();
            for (int i = 1; i <= count; i++) {
                //获得数据库的字段名
                String columnName = result.getMetaData().getColumnLabel(i);
                //根据数据库的字段名找到set方法
                Method method = methodMap.get(columnName);
                //执行set方法赋值
                Class<?>[] parameterTypes = method.getParameterTypes();
                Class<?> parameterType = parameterTypes[0];
                if(String.class == parameterType){
                    String s = (String) result.getObject(i);
                    method.invoke(instance,s);
                }else if(Integer.class == parameterType){
                    Integer s = (Integer) result.getObject(i);
                    method.invoke(instance,s);
                }else{
                    throw new RuntimeException("不支持的数据类型");
                }

            }
            list.add(instance);
        }

        return list;
    }

    private static <T> HashMap<String,Method> getDeclaredFieldMap(Class<T> resultType) {
        HashMap<String ,Method> map = new HashMap<>();
        for(Method method : resultType.getDeclaredMethods()){
            String name = method.getName();
            if(name.startsWith("set")){
                map.put(method.getName().toLowerCase().substring(3),method);
            }
        }
        return map;
    }
}

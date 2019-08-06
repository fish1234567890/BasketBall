package com.xyz.controller;

import com.xyz.Translator.Translator;
import com.xyz.entity.RunableSql;
import com.xyz.executor.ModifyExecutor;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModifyTemplete {

    final ModifyExecutor executor = new ModifyExecutor();

    /**
     * 根据一个sql的id进行查询
     *
     * @param id  sql的id
     * @param resultType  这个查询要返回的类型
     * @return  一个list，list里面的类型是resultType中指定的类型
     * @throws Exception
     */
    public Integer execute(String id) throws Exception{
        return baseExecute(id,null,Integer.class);
    }

    /**
     * 根据一个sql的id进行查询
     *
     * @param id  sql的id
     * @param resultType  这个查询要返回的类型
     * @param params  这个sql中要传递的参数
     * @return  返回list，list里面的类型是resultType中指定的类型
     * @throws Exception
     */
    public Integer execute(String id, Map<String,Object> params) throws Exception {
        return baseExecute(id,params,Integer.class);
    }

    /**
     * 根据一个sql的id进行查询
     *
     * @param id  sql的id
     * @param resultType  这个查询要返回的类型
     * @param params  这个sql中要传递的参数，这里是一个可变参数，可以接收任意个字符串
     * @return  返回list，list里面的类型是resultType中指定的类型
     * @throws Exception
     */
    public Integer execute(String id,String ... params) throws Exception{
        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        for(String s : params){
            map.put("-",s);
        }
        return baseExecute(id,map,Integer.class);
    }

    private <T> Integer baseExecute(String id, Map<String,Object> params,Class<T> resultType) throws Exception {
        //预编译sql，获取最终可执行的sql
        RunableSql<T> runableSql = Translator.translateSql(id, params,resultType);
        //执行sql
        return executor.execute(runableSql);
    }
}

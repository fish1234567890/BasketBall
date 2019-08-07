package com.xyz.controller;


import java.util.List;
import java.util.Map;

public interface QueryTempleteInterface {
    /**
     * 根据一个sql的id进行查询
     *
     * @param id  sql的id
     * @param resultType  这个查询要返回的类型
     * @return  一个list，list里面的类型是resultType中指定的类型
     * @throws Exception
     */
    public <T> List<T> query(String id,Class<T> resultType) throws Exception;


    /**
     * 根据一个sql的id进行查询
     *
     * @param id  sql的id
     * @param resultType  这个查询要返回的类型
     * @return  一个list，list里面的类型是resultType中指定的类型
     * @throws Exception
     */
    public <T> List<T> query(String id,Object params,Class<T> resultType) throws Exception;


    /**
     * 根据一个sql的id进行查询
     *
     * @param id  sql的id
     * @param resultType  这个查询要返回的类型
     * @param params  这个sql中要传递的参数
     * @return  返回list，list里面的类型是resultType中指定的类型
     * @throws Exception
     */
    public <T> List<T> query(String id, Class<T> resultType,Map<String,Object> params) throws Exception;


    /**
     * 根据一个sql的id进行查询
     *
     * @param id  sql的id
     * @param resultType  这个查询要返回的类型
     * @param params  这个sql中要传递的参数，这里是一个可变参数，可以接收任意个字符串
     * @return  返回list，list里面的类型是resultType中指定的类型
     * @throws Exception
     */
    //public <T> List<T> query(String id,Class<T> resultType,String ... params) throws Exception;


    /**
     * 根据一个sql的id进行查询，如果这个sql会查询出多个结果，只会返回第一个结果
     *
     * @param id  sql的id
     * @param resultType  这个查询要返回的类型
     * @return  单个对象
     * @throws Exception
     */
    public <T> T querySingle(String id,Class<T> resultType) throws Exception;


    /**
     * 根据一个sql的id进行查询，如果这个sql会查询出多个结果，只会返回第一个结果
     *
     * @param id  sql的id
     * @param resultType  这个查询要返回的类型
     * @param params  这个sql中要传递的参数
     * @return  单个对象
     * @throws Exception
     */
    public <T> T querySingle(String id, Class<T> resultType,Map<String,Object> params) throws Exception;


    /**
     * 根据一个sql的id进行查询，如果这个sql会查询出多个结果，只会返回第一个结果。
     *
     *
     * @param id  sql的id
     * @param resultType  这个查询要返回的类型
     * @param params  这个sql中要传递的参数，这里是一个可变参数，可以接收任意个字符串
     * @return  单个对象
     * @throws Exception
     */
    //public <T> T querySingle(String id,Class<T> resultType,String ... params) throws Exception;


}

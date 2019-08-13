package com.xyz.Translator;


import com.xyz.entity.RunableSql;

import java.util.Map;

public interface Translator {

    <T> RunableSql<T> getRunableSql(String id, Map<String,Object> params, Class<T> resultType);


}

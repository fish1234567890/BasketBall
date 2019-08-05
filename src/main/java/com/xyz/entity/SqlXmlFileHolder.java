package com.xyz.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 	Copyright (C), 2006-2010, Xu.
 * 
 * 	文件名 : SqlXmlFileHolder.java
 * 
 * 	sql xml文件的实体类，每一个.xml文件对应一个SqlConfiguration
 * 
 * 	@author xuchongguang
 * 	@since 2018-11-11
 * 	@version 1.0.0
 * */
public class SqlXmlFileHolder {

    public String fileName;

    public Map<String,SqlDefinition> map = new HashMap<>();

    public void addToMap(String id,SqlDefinition definition){
        map.put(id,definition);
    }
}

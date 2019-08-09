package com.xyz.util.CommonUtil;

import java.io.File;

public class FileUtils {

    public static File getFromClassPathByName(String path){
        final String absolutePath = FileUtils.class.getResource(path).getFile();
        final File sqlFiles = new File(absolutePath);
        if(!sqlFiles.exists()) {
            throw new RuntimeException("文件路径不存在");
        }
        return sqlFiles;
    }
}

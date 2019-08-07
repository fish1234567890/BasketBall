package com.xyz.entity;

import java.io.File;

public class XmlFileInfo {

    private String name;

    private File file;

    private Long lastModifyTime;

    public XmlFileInfo(String name, File file, Long lastModifyTime) {
        this.name = name;
        this.file = file;
        this.lastModifyTime = lastModifyTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Long getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Long lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}

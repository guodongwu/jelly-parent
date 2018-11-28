package com.jelly.mybatis.pojo;

import java.util.Arrays;

public class FileBean {
    private  Long id;
    private  byte[] file;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FileBean{" +
                "id=" + id +
                ", file=" + Arrays.toString(file) +
                '}';
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}

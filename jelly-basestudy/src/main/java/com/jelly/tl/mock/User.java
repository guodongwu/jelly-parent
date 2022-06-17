package com.jelly.tl.mock;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int age;
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", info='" + info + '\'' +
                '}';
    }
}

package com.jelly.spring.study.config.pojo;

import java.util.Objects;

public class User {
    private  String usename;
    private String password;

    public String getUsename() {
        return usename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(usename, user.usename) &&
                Objects.equals(password, user.password);
    }

    public  User(){}
    public User(String usename, String password) {
        this.usename = usename;
        this.password = password;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    @Override
    public String toString() {
        return "User{" +
                "usename='" + usename + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

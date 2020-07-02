package com.jelly.jellyspringboot.view;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class User {

    public  String name;
    public String password;

    public User(){}
    public User(String name,String password){
        this.password=password;
        this.name=name;
    }
    public User buildName(String name){
        this.name=name;
        return this;
    }
    public User buildPassword(String password){
        this.password=password;
        return this;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

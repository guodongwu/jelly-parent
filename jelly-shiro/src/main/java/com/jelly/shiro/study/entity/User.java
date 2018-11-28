package com.jelly.shiro.study.entity;

import java.io.Serializable;

public class User implements Serializable {
    public User(String username, String password, String salt, Boolean locked) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.locked = locked;
    }
    public  User(String username,String password){
        this.username=username;
        this.password=password;
    }
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getCredentialsSalt(){
        return  username+salt;
    }
    private String username;
    private String password;
    private String salt;
    private Boolean locked=Boolean.FALSE;
    public  User(){}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", locked=" + locked +
                '}';
    }
}

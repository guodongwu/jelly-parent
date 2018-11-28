package com.jelly.shiro.study.entity;

import java.io.Serializable;

public class Role implements Serializable {
    private Long id;
    //角色标识 程序中判断使用,如"admin"
    private String role;
    //角色描述,UI界面显示使用
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Role(String role, String description, Boolean available) {
        this.role = role;
        this.description = description;
        this.available = available;
    }

    public Role(){}
    //是否可用,如果不可用将不会添加给用户
    private Boolean available = Boolean.FALSE;
}

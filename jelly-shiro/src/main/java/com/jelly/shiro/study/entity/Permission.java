package com.jelly.shiro.study.entity;

import java.io.Serializable;

public class Permission implements Serializable {
    private Long id;
    //权限标识 程序中判断使用,如"user:create"
    private String permission;
    //权限描述,UI界面显示使用
    private String description;
    //是否可用,如果不可用将不会添加给用户
    private Boolean available = Boolean.FALSE;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
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

    public Permission(){}
    public Permission(String permission, String description, Boolean available) {
        this.permission = permission;
        this.description = description;
        this.available = available;
    }
}

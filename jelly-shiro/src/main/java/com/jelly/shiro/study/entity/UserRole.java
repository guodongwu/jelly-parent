package com.jelly.shiro.study.entity;

import java.io.Serializable;
import java.util.Objects;

public class UserRole implements Serializable {
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    private Long roleId;

}

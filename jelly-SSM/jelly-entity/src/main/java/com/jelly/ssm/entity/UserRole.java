package com.jelly.ssm.entity;


import java.io.Serializable;

/**
 * <p>
 * 用户角色关联表
 * </p>
 *
 * @author will
 * @since 2018-11-05
 */

public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

        /**
     * 编号
     */

    private Integer userRoleId;

        /**
     * 用户编号
     */
         private Integer userId;

        /**
     * 角色编号
     */
         private Integer roleId;


    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
        "userRoleId=" + userRoleId +
        ", userId=" + userId +
        ", roleId=" + roleId +
        "}";
    }
}

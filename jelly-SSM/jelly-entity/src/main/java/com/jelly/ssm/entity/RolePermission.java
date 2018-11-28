package com.jelly.ssm.entity;


import java.io.Serializable;

/**
 * <p>
 * 角色权限关联表
 * </p>
 *
 * @author will
 * @since 2018-11-05
 */

public class RolePermission implements Serializable {

    private static final long serialVersionUID = 1L;

        /**
     * 编号
     */

    private Integer rolePermissionId;

        /**
     * 角色编号
     */
         private Integer roleId;

        /**
     * 权限编号
     */
         private Integer permissionId;




    public Integer getRolePermissionId() {
        return rolePermissionId;
    }

    public void setRolePermissionId(Integer rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
        "rolePermissionId=" + rolePermissionId +
        ", roleId=" + roleId +
        ", permissionId=" + permissionId +
        "}";
    }
}

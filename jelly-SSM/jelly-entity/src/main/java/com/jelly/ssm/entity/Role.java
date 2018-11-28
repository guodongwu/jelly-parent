package com.jelly.ssm.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author will
 * @since 2018-11-05
 */

public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

        /**
     * 编号
     */

    private Integer roleId;

        /**
     * 角色名称
     */
         private String name;

        /**
     * 角色标题
     */
         private String title;

        /**
     * 角色描述
     */
         private String description;

        /**
     * 创建时间
     */
         private LocalDateTime ctime;

        /**
     * 排序
     */
         private Long orders;

    /**
     * 用户角色
     */
    private UserRole userRole;
    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }



    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCtime() {
        return ctime;
    }

    public void setCtime(LocalDateTime ctime) {
        this.ctime = ctime;
    }

    public Long getOrders() {
        return orders;
    }

    public void setOrders(Long orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Role{" +
        "roleId=" + roleId +
        ", name=" + name +
        ", title=" + title +
        ", description=" + description +
        ", ctime=" + ctime +
        ", orders=" + orders +
        "}";
    }
}

package com.jelly.ssm.entity;


import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 权限
 * </p>
 *
 * @author will
 * @since 2018-11-05
 */

public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

        /**
     * 编号
     */

    private Integer permissionId;

        /**
     * 所属上级
     */
         private Integer pid;

        /**
     * 名称
     */
         private String name;

        /**
     * 类型(1:目录,2:菜单,3:按钮)
     */
         private Integer type;

        /**
     * 权限值
     */
         private String permissionValue;

        /**
     * 路径
     */
         private String uri;

        /**
     * 图标
     */
         private String icon;

        /**
     * 状态(0:禁止,1:正常)
     */
         private Integer status;

        /**
     * 创建时间
     */
         private LocalDateTime ctime;

        /**
     * 排序
     */
         private Long orders;


    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPermissionValue() {
        return permissionValue;
    }

    public void setPermissionValue(String permissionValue) {
        this.permissionValue = permissionValue;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        return "Permission{" +
        "permissionId=" + permissionId +
        ", pid=" + pid +
        ", name=" + name +
        ", type=" + type +
        ", permissionValue=" + permissionValue +
        ", uri=" + uri +
        ", icon=" + icon +
        ", status=" + status +
        ", ctime=" + ctime +
        ", orders=" + orders +
        "}";
    }
}

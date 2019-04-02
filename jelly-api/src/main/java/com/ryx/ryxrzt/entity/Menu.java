package com.ryx.ryxrzt.entity;

import java.io.Serializable;

public class Menu  implements Serializable {
    private String id;

    private String name;

    private String url;

    private String pid;

    private String permission;

    private String iconCls;

    private String available;

    private String type;

    private Short sort;

    private String state;

    private String remark;

    private String logAvailable;

    private String reqLog;

    private String repLog;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls == null ? null : iconCls.trim();
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available == null ? null : available.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Short getSort() {
        return sort;
    }

    public void setSort(Short sort) {
        this.sort = sort;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getLogAvailable() {
        return logAvailable;
    }

    public void setLogAvailable(String logAvailable) {
        this.logAvailable = logAvailable == null ? null : logAvailable.trim();
    }

    public String getReqLog() {
        return reqLog;
    }

    public void setReqLog(String reqLog) {
        this.reqLog = reqLog == null ? null : reqLog.trim();
    }

    public String getRepLog() {
        return repLog;
    }

    public void setRepLog(String repLog) {
        this.repLog = repLog == null ? null : repLog.trim();
    }
}
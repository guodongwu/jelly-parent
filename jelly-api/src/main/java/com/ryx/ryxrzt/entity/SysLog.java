package com.ryx.ryxrzt.entity;


import java.io.Serializable;

public class SysLog  implements Serializable {
    private String userId;

    private String loginName;

    private String reqUrl;

    private String reqMethd;

    private String reqName;

    private String reqTimestamp;

    private String reqParams;

    private String repCode;

    private String repMsg;

    private String repParams;

    private String repTimestamp;

    private Integer timeLen;

    private String inTimestamp;

    private String browser;

    private String ip;

    private static final long serialVersionUID = 1L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getReqUrl() {
        return reqUrl;
    }

    public void setReqUrl(String reqUrl) {
        this.reqUrl = reqUrl == null ? null : reqUrl.trim();
    }

    public String getReqMethd() {
        return reqMethd;
    }

    public void setReqMethd(String reqMethd) {
        this.reqMethd = reqMethd == null ? null : reqMethd.trim();
    }

    public String getReqName() {
        return reqName;
    }

    public void setReqName(String reqName) {
        this.reqName = reqName == null ? null : reqName.trim();
    }

    public String getReqTimestamp() {
        return reqTimestamp;
    }

    public void setReqTimestamp(String reqTimestamp) {
        this.reqTimestamp = reqTimestamp == null ? null : reqTimestamp.trim();
    }

    public String getReqParams() {
        return reqParams;
    }

    public void setReqParams(String reqParams) {
        this.reqParams = reqParams == null ? null : reqParams.trim();
    }

    public String getRepCode() {
        return repCode;
    }

    public void setRepCode(String repCode) {
        this.repCode = repCode == null ? null : repCode.trim();
    }

    public String getRepMsg() {
        return repMsg;
    }

    public void setRepMsg(String repMsg) {
        this.repMsg = repMsg == null ? null : repMsg.trim();
    }

    public String getRepParams() {
        return repParams;
    }

    public void setRepParams(String repParams) {
        this.repParams = repParams == null ? null : repParams.trim();
    }

    public String getRepTimestamp() {
        return repTimestamp;
    }

    public void setRepTimestamp(String repTimestamp) {
        this.repTimestamp = repTimestamp == null ? null : repTimestamp.trim();
    }

    public Integer getTimeLen() {
        return timeLen;
    }

    public void setTimeLen(Integer timeLen) {
        this.timeLen = timeLen;
    }

    public String getInTimestamp() {
        return inTimestamp;
    }

    public void setInTimestamp(String inTimestamp) {
        this.inTimestamp = inTimestamp == null ? null : inTimestamp.trim();
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser == null ? null : browser.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }
}
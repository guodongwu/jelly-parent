package com.jelly.ssm.entity;

import java.time.LocalDate;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author will
 * @since 2018-11-05
 */
public class PUser implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer userId;

    private String userName;

    private String userPassword;

    private String userSex;

    private String userPhone;

    private String userAddress;

    private String userSalt;

    private LocalDate userBirthday;

    private Integer userAge;

    private String userEmail;

    private String userQq;

    private String userWxToken;

    private Boolean userStatus;

    private LocalDate userLastLoginTime;

    private String userLastLoginIp;

    private String userRealname;

    private String userIdcard;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserSalt() {
        return userSalt;
    }

    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
    }

    public LocalDate getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(LocalDate userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserQq() {
        return userQq;
    }

    public void setUserQq(String userQq) {
        this.userQq = userQq;
    }

    public String getUserWxToken() {
        return userWxToken;
    }

    public void setUserWxToken(String userWxToken) {
        this.userWxToken = userWxToken;
    }

    public Boolean getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Boolean userStatus) {
        this.userStatus = userStatus;
    }

    public LocalDate getUserLastLoginTime() {
        return userLastLoginTime;
    }

    public void setUserLastLoginTime(LocalDate userLastLoginTime) {
        this.userLastLoginTime = userLastLoginTime;
    }

    public String getUserLastLoginIp() {
        return userLastLoginIp;
    }

    public void setUserLastLoginIp(String userLastLoginIp) {
        this.userLastLoginIp = userLastLoginIp;
    }

    public String getUserRealname() {
        return userRealname;
    }

    public void setUserRealname(String userRealname) {
        this.userRealname = userRealname;
    }

    public String getUserIdcard() {
        return userIdcard;
    }

    public void setUserIdcard(String userIdcard) {
        this.userIdcard = userIdcard;
    }

    @Override
    public String toString() {
        return "PUser{" +
        "userId=" + userId +
        ", userName=" + userName +
        ", userPassword=" + userPassword +
        ", userSex=" + userSex +
        ", userPhone=" + userPhone +
        ", userAddress=" + userAddress +
        ", userSalt=" + userSalt +
        ", userBirthday=" + userBirthday +
        ", userAge=" + userAge +
        ", userEmail=" + userEmail +
        ", userQq=" + userQq +
        ", userWxToken=" + userWxToken +
        ", userStatus=" + userStatus +
        ", userLastLoginTime=" + userLastLoginTime +
        ", userLastLoginIp=" + userLastLoginIp +
        ", userRealname=" + userRealname +
        ", userIdcard=" + userIdcard +
        "}";
    }
}

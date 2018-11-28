package com.jelly.ssm.entity;


import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 管理员用户
 * </p>
 *
 * @author will
 * @since 2018-11-05
 */

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

        /**
     * 编号
     */

    private Integer userId;

        /**
     * 帐号
     */
         private String username;

        /**
     * 密码MD5(密码+盐)
     */
         private String password;

        /**
     * 盐
     */
         private String salt;

        /**
     * 姓名
     */
         private String realname;

        /**
     * 头像
     */
         private String avatar;

        /**
     * 电话
     */
         private String phone;

        /**
     * 邮箱
     */
         private String email;

        /**
     * 性别(1:男,2:女)
     */
         private Integer sex;

        /**
     * 状态(0:正常,1:锁定)
     */
         private Integer locked;

        /**
     * 创建时间
     */
         private LocalDateTime ctime;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public LocalDateTime getCtime() {
        return ctime;
    }

    public void setCtime(LocalDateTime ctime) {
        this.ctime = ctime;
    }
    public String getCredentialsSalt() {
        return username+salt;
    }

    @Override
    public String toString() {
        return "User{" +
        "userId=" + userId +
        ", username=" + username +
        ", password=" + password +
        ", salt=" + salt +
        ", realname=" + realname +
        ", avatar=" + avatar +
        ", phone=" + phone +
        ", email=" + email +
        ", sex=" + sex +
        ", locked=" + locked +
        ", ctime=" + ctime +
        "}";
    }
}

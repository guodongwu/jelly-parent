package com.ryx.ryxrzt.vo;

/**
 * 登录
 */
public class UserLoginVo {
    //用户名
    private String username;
    //密码
    private String password;
    //验证码
    private String captcha;

    //验证码token
    private String cToken;

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getcToken() {
        return cToken;
    }

    public void setcToken(String cToken) {
        this.cToken = cToken;
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


}

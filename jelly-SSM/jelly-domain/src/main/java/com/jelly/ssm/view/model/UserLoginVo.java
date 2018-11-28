package com.jelly.ssm.view.model;


import net.sf.oval.constraint.MatchPattern;
import net.sf.oval.constraint.NotNull;


public class UserLoginVo {
    @NotNull(message = "请输入用户名!")
   /* @MatchPattern(pattern = "^1[34578]\\d{9}$",message = "请输入正确的手机号")*/
    private   String account;
    @NotNull(message = "请输入密码!")
    private  String password;
    @NotNull(message = "请输入验证码")
    private  String code;

    public String getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(String rememberMe) {
        this.rememberMe = rememberMe;
    }
    private  String rememberMe;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "UserLoginVo{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", code='" + code + '\'' +
                ", rememberMe='" + rememberMe + '\'' +
                '}';
    }
}

package com.jelly.utils;

/**
 * Created by wu on 2018/7/12.
 */
public enum ResultCode {
    SUCCESS("200","请求成功"),
    FAIL("500","内部错误");

    private ResultCode(String value, String msg){
        this.val = value;
        this.msg = msg;
    }

    public String val() {
        return val;
    }

    public String msg() {
        return msg;
    }

    private String val;
    private String msg;

}

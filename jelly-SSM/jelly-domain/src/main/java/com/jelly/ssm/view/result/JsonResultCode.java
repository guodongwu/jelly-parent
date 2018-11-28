package com.jelly.ssm.view.result;

public enum JsonResultCode {
    SUCCESS(200,"OK"),
    CODE_FAIL(300,"验证码输入错误"),
    FAIL(400,"失败"),
    LOGINED(201,"已经登录")
    ;

    private  final Integer value;
    private final String name;
    JsonResultCode(Integer value,String name) {
       this.value=value;
       this.name=name;
    }

    public Integer getValue() {
        return value;
    }



    public String getName() {
        return name;
    }



}

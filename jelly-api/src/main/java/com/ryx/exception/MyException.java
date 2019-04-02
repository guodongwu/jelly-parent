package com.ryx.exception;

public class MyException extends RuntimeException {
    public MyException(String msg){
        super(msg);
        this.code="1000";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String code;
    public MyException() {
        super();
    }
}

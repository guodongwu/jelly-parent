package com.jelly.utils;

/**
 * Created by wu on 2018/7/12.
 */
public class JsonResult {
    public  String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public  String url;
    public  String message;
    public  Object data;
    public  JsonResult(){}
    public  JsonResult(String code,String message){
        this.code=code;this.message=message;
    }
    public  JsonResult(String code,String message,Object data){
        this.code=code;
        this.message=message;
        this.data=data;
    }
    public  JsonResult (ResultCode resultCode,Object data){
        this.code=resultCode.val();
        this.message=resultCode.msg();
        this.data=data;
    }
    public  JsonResult (ResultCode resultCode){
        this.code=resultCode.val();
        this.message=resultCode.msg();
    }



}

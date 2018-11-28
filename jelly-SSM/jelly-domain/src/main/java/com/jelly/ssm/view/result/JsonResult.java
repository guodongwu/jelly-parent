package com.jelly.ssm.view.result;

import org.springframework.http.HttpStatus;

public class JsonResult {
    private  Integer code;
    private String message;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

    public  JsonResult(){
        this.code= JsonResultCode.FAIL.getValue();
        this.message=JsonResultCode.FAIL.getName();
    }
    public JsonResult(JsonResultCode jsonResultCode){
        this.code=jsonResultCode.getValue();
        this.message=jsonResultCode.getName();
    }
    public  JsonResult(Integer code,String message){
        this.code=code;
        this.message=message;

    }
    public  JsonResult(JsonResultCode httpStatus,Object data){
        this.code=httpStatus.getValue();
        this.message=httpStatus.getName();
        this.data=data;
    }



    public static void main(String[] args) {
        JsonResult jsonResult=new JsonResult();
        System.out.println(jsonResult.code+":"+jsonResult.message);
    }
}

package com.ryx.utils;

public class JsonResult {
    private String code;
    private String msg;
    private Object result;

    public JsonResult() {

    }

    public  static  JsonResult SUCCESS(){
    	return new JsonResult(ConstantUtil.SUCCESS_CODE,ConstantUtil.QUERY_SUCCESS_MSG);
	}
	public  static JsonResult FAIL(){
		return new JsonResult(ConstantUtil.FAIL_CODE,ConstantUtil.QUERY_FAIL_MSG);

	}
	public JsonResult(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "JsonResult [code=" + code + ", msg=" + msg + ", result="
				+ result + "]";
	}
}

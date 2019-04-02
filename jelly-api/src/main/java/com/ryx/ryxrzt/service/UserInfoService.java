package com.ryx.ryxrzt.service;


import com.ryx.ryxrzt.entity.UserInfo;
import com.ryx.utils.JsonResult;

import java.util.Map;

public interface UserInfoService {
	
	public JsonResult add(UserInfo userInfo);

	public JsonResult find(UserInfo userInfo) throws IllegalAccessException, InstantiationException;
	
	public JsonResult findUserInfo(UserInfo userInfo);
	
	public JsonResult update(UserInfo userInfo);

	public UserInfo findByLoginName(String loginName) throws IllegalAccessException, InstantiationException;

	public JsonResult updatePwd(UserInfo userInfo);

    public JsonResult updatePwdIndex(Map<String, String> userInfo);
	
}

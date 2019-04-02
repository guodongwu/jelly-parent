package com.ryx.ryxrzt.mapper;

import com.ryx.ryxrzt.entity.UserInfo;
import com.ryx.ryxrzt.entity.UserInfoExpand;

import java.util.List;

public interface UserInfoMapperExp {
	
	List<UserInfoExpand> selectUserInfo(UserInfo userInfo);
	
	long selectUserInfoCnt(UserInfo userInfo);


}

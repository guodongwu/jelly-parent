package com.ryx.ryxrzt.mapper;


import com.ryx.ryxrzt.entity.RoleAndMenu;
import com.ryx.ryxrzt.entity.UserInfo;

import java.util.List;

public interface RoleAndMenuMapper {
	
	List<RoleAndMenu> selectByRoleId(RoleAndMenu roleAndMenu);
	
	List<RoleAndMenu> selectPermissionByLoginName(UserInfo userInfo);

	List<RoleAndMenu> selectPermissionByLoginNameForCustomer(UserInfo userInfo);


	

}

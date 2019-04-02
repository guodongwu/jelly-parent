package com.ryx.ryxrzt.service;


import com.ryx.ryxrzt.entity.RoleAndMenu;
import com.ryx.ryxrzt.entity.UserRole;
import com.ryx.ryxrzt.entity.UserRoleMenu;
import com.ryx.utils.JsonResult;

import java.util.List;

public interface UserRoleService {

	
	public List<UserRole> FindUserRole(UserRole userRole);
	
	public JsonResult findOne(UserRole userRole);
	
	public List<UserRole> FindUserRoleByPid(UserRole userRole);
	
	public JsonResult addUserRole(UserRole userRole);
	
	public JsonResult updateUserRole(UserRole userRole);
	
	public List<RoleAndMenu> findRoleMenu(RoleAndMenu roleMenu);
	
	public JsonResult addRoleMenu(UserRoleMenu roleMenu);
	
	public JsonResult deleteRoleMenu(UserRoleMenu roleMenu);
	
	
	
	
}

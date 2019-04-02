package com.ryx.ryxrzt.service;

 
import com.ryx.ryxrzt.entity.UserOrg;
import com.ryx.utils.JsonResult;

import java.util.List;

public interface OrgService {
	
	
	public JsonResult addUserOrg(UserOrg userOrg) ;
	
	public JsonResult updateUserOrg(UserOrg userOrg) ;
	
	public List<UserOrg> findUserOrg(UserOrg userOrg) ;
	
	public JsonResult  findById(UserOrg userOrg) ;
	
	public List<UserOrg> findUserOrgByPid(UserOrg userOrg) ;
	
	public String getFatherIds(UserOrg userOrg) ;
	
	public JsonResult  upadteUserOrg(UserOrg userOrg) ;

}

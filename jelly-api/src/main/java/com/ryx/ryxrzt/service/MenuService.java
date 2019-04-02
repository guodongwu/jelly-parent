package com.ryx.ryxrzt.service;

import com.ryx.ryxrzt.entity.Menu;
import com.ryx.ryxrzt.entity.RoleAndMenu;
import com.ryx.ryxrzt.entity.UserInfo;
import com.ryx.utils.JsonResult;

import java.util.List;

public interface MenuService {
	
	public JsonResult addMenu(Menu menu) ;
	
	public JsonResult updateMenu(Menu menu) ;
	
	public List<Menu> findMenu(Menu menu) ;
	
	public JsonResult  findById(Menu menu) ;
	
	public JsonResult  findMenuByPid(Menu menu) ;
	
	public String getFatherIds(Menu menu) ;
	
	public JsonResult  upadteMenu(Menu menu) ;

	public List<RoleAndMenu> selectPermissionByLoginName(UserInfo userinfo);


	public Menu getMenuByUrl(String url);






}

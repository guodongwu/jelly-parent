package com.ryx.ryxrzt.entity;

import java.io.Serializable;

public class RoleAndMenu extends Menu implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String accessAuth;
    
    private String roleId;
    
    private String menuId;
    
    

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}


	public String getAccessAuth() {
		return accessAuth;
	}

	public void setAccessAuth(String accessAuth) {
		this.accessAuth = accessAuth;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
package com.jelly.shiro.study.service;

import com.jelly.shiro.study.entity.Role;

public interface RoleService {
    public Role createRole(Role role);
    public void deleteRole(Long roleId);
    public void correlationPermission(Long roleId,Long...permissionIds);
    public  void uncorrelationPermission(Long roleId,Long...permissionIds);
}

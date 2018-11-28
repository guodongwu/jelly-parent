package com.jelly.shiro.study.service;

import com.jelly.shiro.study.entity.Permission;

public interface PermissionService {
    public Permission createPermission(Permission permission);
    public int deletePermission(Long permissionId);
}

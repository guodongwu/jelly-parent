package com.jelly.ssm.service;

import com.jelly.ssm.entity.Permission;

import java.util.List;

/**
 * <p>
 * 权限 服务类
 * </p>
 *
 * @author will
 * @since 2018-11-05
 */
public interface PermissionService extends BaseService<Permission,Integer> {

    List<Permission> permissionList(Integer roleId);
}

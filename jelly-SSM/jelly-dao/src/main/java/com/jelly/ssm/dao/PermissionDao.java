package com.jelly.ssm.dao;

import com.jelly.ssm.entity.Permission;

import java.util.List;

/**
 * <p>
 * 权限 Mapper 接口
 * </p>
 *
 * @author will
 * @since 2018-11-05
 */
public interface PermissionDao extends BaseMapper<Permission,Integer> {

    List<Permission> permissionList(Integer roleId);
}

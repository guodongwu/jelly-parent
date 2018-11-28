package com.jelly.ssm.service;

import com.jelly.ssm.entity.Role;

import java.util.List;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author will
 * @since 2018-11-05
 */
public interface RoleService extends BaseService<Role,Integer> {
   List<Role> roleList(Integer userId);
}

package com.jelly.ssm.dao;

import com.jelly.ssm.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author will
 * @since 2018-11-05
 */
public interface RoleDao extends BaseMapper<Role,Integer> {
    List<Role> roleList(@Param(value = "userId") Integer userId);
}

package com.ryx.ryxrzt.mapper;


import com.ryx.ryxrzt.entity.UserRoleMenu;
import com.ryx.ryxrzt.entity.UserRoleMenuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleMenuMapper {
    long countByExample(UserRoleMenuExample example);

    int deleteByExample(UserRoleMenuExample example);

    int insert(UserRoleMenu record);

    int insertSelective(UserRoleMenu record);

    List<UserRoleMenu> selectByExample(UserRoleMenuExample example);

    int updateByExampleSelective(@Param("record") UserRoleMenu record, @Param("example") UserRoleMenuExample example);

    int updateByExample(@Param("record") UserRoleMenu record, @Param("example") UserRoleMenuExample example);
}
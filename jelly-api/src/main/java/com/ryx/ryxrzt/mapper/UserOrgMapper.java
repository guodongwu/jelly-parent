package com.ryx.ryxrzt.mapper;


import com.ryx.ryxrzt.entity.UserOrg;
import com.ryx.ryxrzt.entity.UserOrgExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserOrgMapper {
    long countByExample(UserOrgExample example);

    int deleteByExample(UserOrgExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserOrg record);

    int insertSelective(UserOrg record);

    List<UserOrg> selectByExample(UserOrgExample example);

    UserOrg selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserOrg record, @Param("example") UserOrgExample example);

    int updateByExample(@Param("record") UserOrg record, @Param("example") UserOrgExample example);

    int updateByPrimaryKeySelective(UserOrg record);

    int updateByPrimaryKey(UserOrg record);
}
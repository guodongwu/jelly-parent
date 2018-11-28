package com.jelly.mybatis.mapper;

import com.jelly.mybatis.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RoleMapper {
    public Role getRole(Long id);
    public  int deleteRole(Long id);
    public  int insertRole(Role role);
    public List<Role> findRoleByMap(Map<String,String> params);
    public List<Role> findRoleByAnnotation(@Param("roleName") String roleName);
    public List<Role> findByRole(Role role);
    public void count(Map<String,Object> map);

}

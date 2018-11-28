package com.jelly.shiro.study.service.impl;

import com.jelly.shiro.study.entity.Role;
import com.jelly.shiro.study.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Role createRole(Role role) {
        final String sql="insert into t_role(role,description,available)values(?,?,?)";
        GeneratedKeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement psst=connection.prepareStatement(sql,new String[]{"id"});
                psst.setString(1,role.getRole());
                psst.setString(2,role.getDescription());
                psst.setBoolean(3,role.getAvailable());
                return  psst;
            }
        },keyHolder);
        return role;
    }

    @Override
    public void deleteRole(Long roleId) {
        String sql="delete from user_role where role_id=?";
        jdbcTemplate.update(sql,roleId);
        sql="delete from t_role where id=?";
        jdbcTemplate.update(sql,roleId);

    }

    @Override
    public void correlationPermission(Long roleId, Long... permissionIds) {
        if(permissionIds==null || permissionIds.length==0){
            return;
        }
        String sql="insert into role_permission(role_id,permission_id)values(?,?)";
        for (Long permissionId:permissionIds){
            if(!exists(roleId,permissionId)){
                jdbcTemplate.update(sql,roleId,permissionId);
            }
        }
    }

    private boolean exists(Long roleId, Long permissionId) {
        String sql = "select count(1) from role_permission where role_id=? and permission_id=?";
        return jdbcTemplate.queryForObject(sql, Integer.class, roleId, permissionId) != 0;
    }


    @Override
    public void uncorrelationPermission(Long roleId, Long... permissionIds) {
        if(permissionIds == null || permissionIds.length == 0) {
            return;
        }
        String sql = "delete from role_permission where role_id=? and permission_id=?";
        for(Long permissionId : permissionIds) {
            if(exists(roleId, permissionId)) {
                jdbcTemplate.update(sql, roleId, permissionId);
            }
        }
    }
}

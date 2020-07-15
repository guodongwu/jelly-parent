package com.jelly.shiro.study.service.impl;

import com.jelly.shiro.study.entity.Permission;
import com.jelly.shiro.study.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Permission createPermission(final Permission permission) {
        final String sql="insert into t_permission(permission,description,avaiable) values(?,?,?)";
        GeneratedKeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement psst=connection.prepareStatement(sql,new String[]{"id"});
                psst.setString(1,permission.getPermission());
                psst.setString(2,permission.getDescription());
                psst.setBoolean(3,permission.getAvailable());
                return psst;
            }
        },keyHolder);
        return permission;
    }

    @Override
    public int deletePermission(Long permissionId) {
        String sql="delete from role_permission where permission_id=?";
        jdbcTemplate.update(sql,permissionId);
        sql="delete from t_permission where id=?";
        jdbcTemplate.update(sql,permissionId);
        return 1;
    }
}

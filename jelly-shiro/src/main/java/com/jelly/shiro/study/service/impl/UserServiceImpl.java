package com.jelly.shiro.study.service.impl;

import com.jelly.shiro.study.entity.User;
import com.jelly.shiro.study.service.UserService;
import com.jelly.shiro.study.utils.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public User createUser(final User user) {
        final String sql="insert into t_user(username, password, salt, locked) values(?,?,?, ?)";
        GeneratedKeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps=connection.prepareStatement(sql,new String[]{"id"});
                ps.setString(1,user.getUsername());
                ps.setString(2,user.getPassword());
                ps.setString(3,user.getSalt());
                ps.setBoolean(4,user.getLocked());

                return ps;
            }
        },keyHolder);
        user.setId(keyHolder.getKey().longValue());
        return user;
    }

    @Override
    public int changePassword(Long userId, String newPassword) {
        return 0;
    }

    @Override
    public int correlationRoles(Long userId, Long... roleIds) {
        if(roleIds==null  || roleIds.length==0){
            return 0;
        }
        String sql="insert into user_role(user_id,role_id)values(?,?)";
        for (Long roleId:roleIds){
            if(!exists(userId,roleId)){
                jdbcTemplate.update(sql,userId,roleId);
            }
        }
        return 1;
    }

    private boolean exists(Long userId, Long roleId) {
        String sql="select count(1) from user_role where user_id=? and role_id=?";
        return  jdbcTemplate.queryForObject(sql,Integer.class,userId,roleId)!=0;

    }

    @Override
    public int uncorrelationRoles(Long userId, Long... roleIds) {
        if(roleIds==null || roleIds.length==0) {
            return 0;
        }
        String sql ="delete from user_role where user_id=? and role_id=?";
        for (Long roleId:roleIds){
            if(!exists(userId,roleId)){
                jdbcTemplate.update(sql,userId,roleId);
            }
        }
        return 1;

    }

    @Override
    public User findByUserName(String userName) {
        String sql="select * from t_user where username=?";
        List<User> userList=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class),userName);
        if(userList.size()==0){
            return null;
        }
        return userList.get(0);
    }

    @Override
    public Set<String> findRoles(String userName) {
        String sql="select role from t_user u,t_role r,user_role ur where u.username=? and u.id=ur.user_id and r.id=ur.role_id";

        return new HashSet<>(jdbcTemplate.queryForList(sql,String.class,userName));
    }

    @Override
    public Set<String> findPermission(String userName) {
        String sql="select permission from t_user u, t_role r, t_permission p, user_role ur, role_permission rp where u.username=? and u.id=ur.user_id and r.id=ur.role_id and r.id=rp.role_id and p.id=rp.permission_id";
        return new HashSet<>(jdbcTemplate.queryForList(sql,String.class,userName));
    }
}

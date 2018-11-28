package com.jelly.spring.study.config.dao;

import com.jelly.spring.study.config.db.UserDb;
import com.jelly.spring.study.config.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao {

    public List<User> getUsers(){
       return UserDb.getUsers();
    }
    public  User getUser(String username,String password){
        return  UserDb.getUser(username,password);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public  List<User> getUsersByDb(){
        String sql="select username,password from admin_user";
        List<User> users = jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setUsename(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        });
        return users;
    }

}

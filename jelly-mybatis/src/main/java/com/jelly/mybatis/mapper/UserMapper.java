package com.jelly.mybatis.mapper;

import com.jelly.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    public User getUser(Long id);
    public  int insertUser(User user);

    public  void insertUserList(List<User> user);

}

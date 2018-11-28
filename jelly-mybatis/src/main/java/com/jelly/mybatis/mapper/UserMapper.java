package com.jelly.mybatis.mapper;

import com.jelly.mybatis.pojo.User;

public interface UserMapper {
    public User getUser(Long id);
    public  int insertUser(User user);

}

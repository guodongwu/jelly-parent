package com.jelly.shiro.study.service;

import com.jelly.shiro.study.entity.User;

import java.util.Set;

public interface UserService {
    public User createUser(User user);
    public int changePassword(Long userId,String newPassword);
    public int correlationRoles(Long userId,Long...roleIds);
    public int uncorrelationRoles(Long userId,Long...roleIds);
    public  User findByUserName(String userName);
    public Set<String> findRoles(String userName);
    public Set<String> findPermission(String userName);

}

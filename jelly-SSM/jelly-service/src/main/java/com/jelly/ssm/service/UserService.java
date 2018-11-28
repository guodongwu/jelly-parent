package com.jelly.ssm.service;

import com.jelly.ssm.entity.User;

/**
 * <p>
 * 管理员用户 服务类
 * </p>
 *
 * @author will
 * @since 2018-11-05
 */
public interface UserService extends BaseService<User,Integer> {
    public  User findUser(String username,String password);
    public  User findUserByUserName(String username);
}

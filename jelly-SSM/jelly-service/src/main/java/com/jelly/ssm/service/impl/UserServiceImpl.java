package com.jelly.ssm.service.impl;

import com.jelly.ssm.dao.UserDao;
import com.jelly.ssm.entity.User;
import com.jelly.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员用户 服务实现类
 * </p>
 *
 * @author will
 * @since 2018-11-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<User,Integer> implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public User findUser(String username,String password) {
        return userDao.findUserByUserNameAndPassword(username,password);
    }

    @Override
    public User findUserByUserName(String username) {
        return userDao.findUserByUserName(username);
    }
}

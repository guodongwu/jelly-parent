package com.jelly.spring.study.config.service;

import com.jelly.spring.study.config.pojo.User;
import com.jelly.spring.study.config.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public List<User> getUsers(){
        return userDao.getUsers();
    }
    public  User getUser(String username,String password){
        return
                 userDao.getUser(username,password);
    }
    public  List<User> getUsersByDb(){
        return userDao.getUsersByDb();
    }
}

package com.jelly.jellynacos.service.impl;

import com.jelly.entity.User;
import com.jelly.jellynacos.dao.UserRepository;
import com.jelly.service.UserSerivce;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DubboService(interfaceClass = UserSerivce.class)
public class UserServiceImpl implements UserSerivce {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getUsers(User user) {
       return userRepository.findAll(Example.of(user));
    }
}

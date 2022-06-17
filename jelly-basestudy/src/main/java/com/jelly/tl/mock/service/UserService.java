package com.jelly.tl.mock.service;

import com.jelly.tl.mock.User;
import com.jelly.tl.mock.UserContextHolder;

public class UserService {
    public User getUser(User user){
        UserContextHolder.holder.set(user);
        return new UserInfoService().getUserInfo();

    }
}

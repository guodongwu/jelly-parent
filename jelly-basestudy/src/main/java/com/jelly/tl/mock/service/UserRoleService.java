package com.jelly.tl.mock.service;

import com.jelly.tl.mock.User;
import com.jelly.tl.mock.UserContextHolder;

public class UserRoleService {
    public User getUserRole(){
       User user=UserContextHolder.holder.get();
       if(user==null){
           return null;
       }
       user.setInfo("有点小权限");
       return  user;
    }
}

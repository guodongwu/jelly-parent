package com.jelly.tl.mock.service;

import com.jelly.tl.mock.User;
import com.jelly.tl.mock.UserContextHolder;

public class UserInfoService {
    public User getUserInfo(){
        User user= UserContextHolder.holder.get();
        if(user==null){
            System.out.println("未获取");
            return null;
        }
        user.setAge(18);
        System.out.println("UserInfo获取User"+user.toString());
        return  new  UserRoleService().getUserRole();
    }
}

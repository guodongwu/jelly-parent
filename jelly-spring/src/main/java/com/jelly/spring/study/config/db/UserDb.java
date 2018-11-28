package com.jelly.spring.study.config.db;

import com.jelly.spring.study.config.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class UserDb {
    private  static List<User> userList=null;
    static {
        userList=new ArrayList<>();
        for (int i=0;i<10;i++){
            userList.add(new User("user"+i,"password"+i));
        }
    }
    public  static User getUser(String username,String password){
        User user=new User(username,password);
        if(userList.contains(user)){
            return user;
        }
        return null;
    }
    public  static  List<User> getUsers(){
        return userList;
    }
}

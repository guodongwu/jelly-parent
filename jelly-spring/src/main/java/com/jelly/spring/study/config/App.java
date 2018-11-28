package com.jelly.spring.study.config;

import com.jelly.spring.study.config.pojo.User;
import com.jelly.spring.study.config.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
        UserService userService=  context.getBean(UserService.class);
        List<User> users=userService.getUsers();
        System.out.println(users);
        User user=userService.getUser("user2","password1");
        if(user!=null) {
            System.out.println(user);
        }else {
            System.out.println("no user");
        }
        List<User> users1=userService.getUsersByDb();
        System.out.println(users1);
    }
}

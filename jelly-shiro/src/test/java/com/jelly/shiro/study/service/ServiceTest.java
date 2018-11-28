package com.jelly.shiro.study.service;

import com.jelly.shiro.study.entity.User;
import com.jelly.shiro.study.realm.UserRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class ServiceTest  extends  BaseTest {
    @Autowired
    private  UserService userService;
    @Autowired
    private  UserRealm userRealm;
    @Test
    public  void findByUsername(){
       User user= userService.findByUserName("zhang");
        System.out.println(user);
    }
    @Test
    public  void login(){
        SecurityManager securityManager=new DefaultSecurityManager();
        ((DefaultSecurityManager) securityManager).setRealm(userRealm);
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject=SecurityUtils.getSubject();
        String username="zhang";
        UsernamePasswordToken token=new UsernamePasswordToken(username,"123");
        subject.login(token);
        System.out.println(subject.isAuthenticated());
    }
}

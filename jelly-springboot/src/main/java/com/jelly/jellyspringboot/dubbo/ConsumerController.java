package com.jelly.jellyspringboot.dubbo;

import com.alibaba.fastjson.JSON;
import com.jelly.entity.User;
import com.jelly.service.UserSerivce;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/dubbo")
@RestController
public class ConsumerController {
    @DubboReference
    private UserSerivce userSerivce;
    @RequestMapping("/get")
    public  String get(){
        User user =new User();
        user.setId(1L);
        List<User> users=userSerivce.getUsers(user);
        return JSON.toJSONString(users);
    }
}

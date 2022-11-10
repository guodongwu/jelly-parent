package com.jelly.jellyspringboot.dubbo;

import com.alibaba.fastjson.JSON;
import com.jelly.entity.User;
import com.jelly.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/dubbo")
@RestController
public class ConsumerController {
    @DubboReference
    private UserService userService;
    @RequestMapping("/get")
    public  String get(){
        User user =new User();
        user.setId(1L);
        List<User> users=userService.getUsers(user);
        return JSON.toJSONString(users);
    }
}

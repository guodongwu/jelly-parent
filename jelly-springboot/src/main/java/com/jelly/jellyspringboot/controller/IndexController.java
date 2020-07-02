package com.jelly.jellyspringboot.controller;

import com.jelly.jellyspringboot.view.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {


    @GetMapping(value = "/index",produces = "text/html;charset=UTF-8")
    public  String index(){
        return "index 嘿嘿嘿";
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable String id){
        User user=new User();
        user.setName("user"+id);
        user.setPassword("password"+id);
        return user;
    }


}

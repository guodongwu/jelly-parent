package com.jelly.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 后台首页
 */
@Controller
public class BackHomeController {


    @GetMapping("/index")
    public String  index(){
        return "index";
    }
    @GetMapping("/index2")
    public String  index2(){
        return "index-2";
    }
    /**
     * welcome
     */
    @GetMapping("/welcome")
    public  String welcome(){
        return "welcome";
    }

}

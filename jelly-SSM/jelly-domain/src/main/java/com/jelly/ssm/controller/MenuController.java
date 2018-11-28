package com.jelly.ssm.controller;

import com.jelly.ssm.view.result.JsonResult;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @GetMapping("/menu/list")
    public JsonResult menu_index(Model model){
       JsonResult jsonResult=new JsonResult();


       return jsonResult;
    }

}

package com.jelly.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 图片管理
 */
@Controller
public class PictureController {

    @GetMapping("/picture-list")
    public  String picturelist(){
        return "picture-list";
    }
}

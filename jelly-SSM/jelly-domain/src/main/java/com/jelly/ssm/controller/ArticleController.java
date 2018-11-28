package com.jelly.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 资讯
 */
@Controller
public class ArticleController {

    @GetMapping("/article-list")
    public  String articlelist(){
        return "article-list";
    }
}

package com.jelly.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 *  用户,会员管理
 * </p>
 *
 * @author will
 * @since 2018-11-02
 */
@Controller
public class UserController {
    @GetMapping("/user-list")
    public String userlist(Model model){
        return "user-list";
    }
}


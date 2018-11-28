package com.jelly.ssm.controller;

import com.google.code.kaptcha.Constants;
import com.jelly.ssm.entity.User;
import com.jelly.ssm.service.UserService;
import com.jelly.ssm.view.model.UserLoginVo;
import com.jelly.ssm.view.result.JsonResult;
import com.jelly.ssm.view.result.JsonResultCode;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.constraint.AssertURL;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private  Validator validator;

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public  String login(){
        return "login";
    }

    @PostMapping(value = "/login",produces = "application/json;charset=utf-8")
    public @ResponseBody  JsonResult login(UserLoginVo loginVo, HttpServletRequest request){
        JsonResult jsonResult=null;
        String error = null;
        List<ConstraintViolation> messages= validator.validate(loginVo);
        //判断是否有错误
        if(messages.size()>0){
            jsonResult=new JsonResult(JsonResultCode.FAIL.getValue(),messages.get(0).getMessage());
            return  jsonResult;
        }
        //无错误验证是否正确
        String orginal= (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (!loginVo.getCode().equalsIgnoreCase(orginal)){
            jsonResult=new JsonResult(JsonResultCode.CODE_FAIL);
            return  jsonResult;
        }
        //判断用户名密码逻辑
        User user=userService.findUserByUserName(loginVo.getAccount());
        if(user==null){
            jsonResult=new JsonResult(JsonResultCode.FAIL.getValue(),"用户名或密码错误");
            return  jsonResult;
        }
        if(Boolean.TRUE.equals(user.getLocked())){
            jsonResult=new JsonResult(JsonResultCode.FAIL.getValue(),"用户被锁定，请通知管理员解锁");
        }



        Subject subject= SecurityUtils.getSubject();
        try {
            subject.logout();
            UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),loginVo.getPassword()
                    ,loginVo.getRememberMe());
            subject.login(token);

            jsonResult=new JsonResult(JsonResultCode.SUCCESS,"index");
            return  jsonResult;
        }catch (UnknownAccountException e){
            error="用户名/密码错误";
        }catch (IncorrectCredentialsException e){
            error="用户名/密码错误";
        }catch (ExcessiveAttemptsException e){
            error = "登录失败多次，账户锁定10分钟";
        } catch (AuthenticationException e) {
            // 其他错误，比如锁定，如果想单独处理请单独catch处理
            error = "其他错误：" + e.getMessage();
        }
        jsonResult=new JsonResult(JsonResultCode.FAIL.getValue(),error);
        return jsonResult;
    }


}

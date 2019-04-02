package com.ryx.common;


import com.alibaba.fastjson.JSONObject;
import com.ryx.utils.JsonResult;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class BaseController {
    /**
     * 获取application/json数据
     * @param request
     * @return
     * @throws
     */
   public final Logger logger =LoggerFactory.getLogger(BaseController.class);
   public  Map<String,Object> getParamsToMap(HttpServletRequest request) {
        Map<String,Object> param= new HashMap<String, Object>();
       BufferedReader streamReader = null;
       try {
            streamReader = new BufferedReader( new InputStreamReader(request.getInputStream(), "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null) {
                responseStrBuilder.append(inputStr);
            }

            if(responseStrBuilder.length()>0) {
                JSONObject jsonObject = JSONObject.parseObject(responseStrBuilder.toString());
                param = jsonObject.toJavaObject(Map.class);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
           try {
               streamReader.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
       return param;
    }

    @ExceptionHandler({Exception.class})
    public JsonResult otherException(){
        JsonResult jsonResult= JsonResult.FAIL();
        jsonResult.setMsg("请求的参数不正确");
        return  jsonResult;
    }

    @ExceptionHandler({ UnauthenticatedException.class, AuthenticationException.class })
    public  JsonResult authenticationInfoException(HttpServletRequest request,HttpServletResponse response){
        JsonResult jsonResult= JsonResult.FAIL();
        jsonResult.setMsg("会话超时，请重新登录");
        return  jsonResult;
    }
    @ExceptionHandler({ UnauthorizedException.class, AuthorizationException.class })
    public  JsonResult unauthorizedException(HttpServletRequest request,HttpServletResponse response){
        JsonResult jsonResult= JsonResult.FAIL();
        jsonResult.setMsg("无权限操作");
        return  jsonResult;
    }
}

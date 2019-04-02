package com.ryx.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class CaptchaUtil {
    @Autowired
    private  JedisUtil jedisUtil;

    public Map<String,Object> createToken(String captcha){
        //生成一个token
        String cToken = UUID.randomUUID().toString();
        //生成验证码对应的token  以token为key  验证码为value存在redis中
        String key =ConstantUtil.CAPTCHA_TOKEN+cToken;
        jedisUtil.set(key,captcha,300);
        Map<String, Object> map = new HashMap<>();
        map.put("cToken", cToken);
        map.put("expire", 300);
        return map;
    }
}

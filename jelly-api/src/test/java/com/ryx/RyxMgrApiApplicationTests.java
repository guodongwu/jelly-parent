package com.ryx;

import com.alibaba.fastjson.JSON;
import com.ryx.ryxrzt.service.RztDealService;
import com.ryx.ryxrzt.service.UserInfoService;
import com.ryx.utils.JedisUtil;
import com.ryx.utils.JsonResult;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RyxMgrApiApplicationTests {



    @Test
    public void Test() throws Exception {


    }


    @Autowired
    private JedisUtil jedisUtil;
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private RztDealService rztDealService;

    @Test
    public void contextLoads() throws InstantiationException, IllegalAccessException {
        Map<String,Object> map=new HashMap<>();
        JsonResult list= rztDealService.getDealList(map);
        System.out.println(list);
    }

    @Autowired
    StringEncryptor stringEncryptor;
    @Test
    public  void encryptPwd(){
        String pwd=stringEncryptor.encrypt("xxx");
        System.out.println(pwd);

    }
    @Test
    public  void toJson(){
        List<String> list=new ArrayList<String>();
        list.add("a1");

        System.out.println(JSON.toJSONString(list));
    }


}

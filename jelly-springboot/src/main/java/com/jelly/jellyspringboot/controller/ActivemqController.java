package com.jelly.jellyspringboot.controller;

import com.jelly.jellyspringboot.activemq.ActivemqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/activemq")
public class ActivemqController {
    @Autowired
    private Environment environment;

    @Autowired
    private ActivemqProducer activemqProducer;


    @GetMapping("info")
    public String info(){
        activemqProducer.sendMsg("啦啦啦");
        Map map = new HashMap();
        map.put("a"+UUID.randomUUID(), "a");
        map.put("b"+UUID.randomUUID(), "b");
        activemqProducer.sendMap(map);
        activemqProducer.sendQueues("皮皮皮");
        activemqProducer.sendTopic("皮卡皮");
        return  "info:"+environment.getProperty("url");
    }
}

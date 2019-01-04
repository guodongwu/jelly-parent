package com.jelly.jellyspringboot.controller;

import com.jelly.jellyspringboot.rabbitmq.RabbitmqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")
public class RabbitmqController {

    @Autowired
    private RabbitmqProducer rabbitmqProducer;

    @GetMapping("/info")
    public String index(){
        rabbitmqProducer.sendMsg("ok");
        rabbitmqProducer.sendTopicMsg("啦啦啦");
        return "ok";
    }

}

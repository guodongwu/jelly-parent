package com.jelly.jellyspringboot.controller;

import com.jelly.jellyspringboot.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;
    @GetMapping("/info")
    public String sendKafka(){
        kafkaProducer.sendKafka("abcd");
        return "ok";
    }
}

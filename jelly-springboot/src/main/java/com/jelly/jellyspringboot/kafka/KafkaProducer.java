package com.jelly.jellyspringboot.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendKafka(String msg){
        kafkaTemplate.send("test","key",msg);
        System.out.println("send ok");
    }

}

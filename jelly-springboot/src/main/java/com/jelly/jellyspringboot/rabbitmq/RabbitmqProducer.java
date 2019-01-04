package com.jelly.jellyspringboot.rabbitmq;

import com.jelly.jellyspringboot.config.RabbitmqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitmqProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public  void sendMsg(String msg){
        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE,RabbitmqConfig.ROUTINGKEY,msg);
    }

    public  void sendTopicMsg(String msg){
        rabbitTemplate.convertAndSend(RabbitmqConfig.TOPIC_EXCHANGE,RabbitmqConfig.TOPIC1_NAME,msg);
    }
}

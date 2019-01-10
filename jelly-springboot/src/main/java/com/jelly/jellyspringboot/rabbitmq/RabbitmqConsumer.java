package com.jelly.jellyspringboot.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitmqConsumer {
  //  @RabbitListener(queues="rabbitMQQueue")
    public void reciveMsg(String text){
        System.out.println("[接收消息]:"+text);
    }

    // @RabbitListener(queues = "topic.message1")
    public void process1(String text){
        System.out.println("msg1:"+text);
    }
    // @RabbitListener(queues = "topic.#")
    public void process2(String text){
        System.out.println("msg2:"+text);
    }
}

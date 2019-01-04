package com.jelly.jellyspringboot.config;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
public class ActivemqConfig {


    @Bean
    public Queue activeMQQueue(){
        return  new ActiveMQQueue("queue");
    }
    @Bean
    public Topic activeMQTopic(){
        return  new ActiveMQTopic("topic");
    }


}

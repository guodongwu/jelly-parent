package com.jelly.jellyspringboot.activemq;

import org.apache.activemq.broker.region.Destination;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;
import java.util.Map;

@Component
public class ActivemqProducer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;


    @Autowired
    private Queue activeMQQueue;
    @Autowired
    private Topic activeMQTopic;
    public void sendMsg(String msg)
    {
        jmsMessagingTemplate.convertAndSend("msg",msg);
        System.out.println("msg send success!");
    }
    public  void sendMap(Map<String,Object> map){
        jmsMessagingTemplate.convertAndSend("map",map);
        System.out.println("map send success!");
    }
    public  void sendQueues(String msg){
        jmsMessagingTemplate.convertAndSend(this.activeMQQueue,msg);
        System.out.println("msg send success");
    }
    public  void sendTopic(String msg){
        jmsMessagingTemplate.convertAndSend(this.activeMQTopic,msg);
    }
}

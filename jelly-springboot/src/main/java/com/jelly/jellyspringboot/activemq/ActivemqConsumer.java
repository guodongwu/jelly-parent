package com.jelly.jellyspringboot.activemq;

import com.jelly.jellyspringboot.constant.Init;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ActivemqConsumer {
    @JmsListener(destination = "msg")
    public  void readMsg(String text){
        System.out.println(text);
        Init.list.add(text);
        System.out.println("activemq:list:"+Init.list.size());
    }
    @JmsListener(destination = "map")
    public void readMap(Map<String,Object> map){
        System.out.println(map);
        Init.map.putAll(map);
        System.out.println("activemq:map:"+Init.map.size());
    }
    @JmsListener(destination = "queue")
    public  void readQueue(String text){
        System.out.println("Queue:"+text);
    }

    @JmsListener(destination = "topic")
    public  void readTopic(String text){
        System.out.println("Topic:"+text);
    }


}

package com.jelly.jellyspringboot.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    public  static  final  String EXCHANGE="exchange";
    public static  final  String ROUTINGKEY="routingkey";
    public  static  final  String QUEUE_NAME="rabbitMQQueue";

    public static final  String TOPIC_EXCHANGE="topicExchange";
    public  static  final  String TOPIC1_NAME="topic.message1";
    public  static  final  String TOPIC2_NAME="topic.#";

    @Bean
    public Binding bindingExchangeQueue(DirectExchange exchange, Queue rabbitMQQueue)
    {
        return BindingBuilder.bind(rabbitMQQueue).to(exchange).with(ROUTINGKEY);
    }
    @Bean
    public DirectExchange exchange(){
        return new DirectExchange(EXCHANGE,true,true);
    }
    @Bean
    public Queue rabbitMQQueue(){
        return new Queue(QUEUE_NAME);
    }
    @Bean(name = "topic1")
    public Queue topicMessage1(){
        return new Queue(TOPIC1_NAME);
    }
    @Bean(name = "topic2")
    public Queue topicMessage2(){
        return  new Queue(TOPIC2_NAME);
    }
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(TOPIC_EXCHANGE);
    }
    @Bean
    public Binding bindingExchangeTopic1(@Qualifier("topic1") Queue topicMessage1,TopicExchange topicExchange){
        return  BindingBuilder.bind(topicMessage1).to(topicExchange).with(TOPIC1_NAME);
    }
    @Bean
    public Binding bindingExchangeTopic2(@Qualifier("topic2") Queue topicMessage2,TopicExchange topicExchange){
        return  BindingBuilder.bind(topicMessage2).to(topicExchange).with(TOPIC2_NAME);
    }

}

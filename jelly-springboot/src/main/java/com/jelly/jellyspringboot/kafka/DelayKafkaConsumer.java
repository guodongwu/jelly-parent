package com.jelly.jellyspringboot.kafka;

import org.springframework.kafka.annotation.TopicPartition;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DelayKafkaConsumer {
    String id() default "";

    String[] topics() default {};

    String errorHandler() default "";

    String groupId() default "";

    TopicPartition[] topicPartitions() default {};

    String beanRef() default "__listener";

}

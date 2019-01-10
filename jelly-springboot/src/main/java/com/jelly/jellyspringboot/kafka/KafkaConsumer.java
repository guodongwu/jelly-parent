
package com.jelly.jellyspringboot.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    // @KafkaListener(topics = {"test"})
    public  void reciveMsg(ConsumerRecord<?,?> record){
        System.out.println(record.key());
        System.out.println(record.value().toString());
    }
}

package com.jelly.mq;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.Random;

public class KafkaTest {
    public static  final  String borkerList="192.168.212.5:9092";
    public static  final String topic="topic-demo2";
    public static  final  String groupId="group.demo2";
    public  static  Properties properties;
    static {
        properties=new Properties();
        properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");

        properties.put("bootstrap.servers",borkerList);
        properties.put("group.id",groupId);
    }
    public static void producer(){
        KafkaProducer<String, String> producer=new KafkaProducer<String, String>(properties);
        ProducerRecord<String, String> record=new ProducerRecord<>(topic,"hello java");
        try {
            Random r=new Random();
            for (int i= 0;i<10;i++){
                record=new ProducerRecord<>(topic,"hello java"+r.nextInt(10));
                producer.send(record);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            producer.close();
        }

    }

    public static  void consumer(){
        KafkaConsumer<String, String> consumer=new KafkaConsumer<String, String>(properties);
        consumer.subscribe(Collections.singletonList(topic));
        while (true){
            ConsumerRecords<String,String> records=
                    consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord record:records){
                System.out.println(record.value());
            }
        }
    }

    public static void main(String[] args) {
        producer();
        consumer();
    }
}

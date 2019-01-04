package com.jelly.jellyspringboot;

import com.jelly.jellyspringboot.activemq.ActivemqProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JellySpringbootApplicationTests {
    @Autowired
    private ActivemqProducer producer;
    @Test
    public void contextLoads() {
        producer.sendMsg("啦啦啦");
        Map map = new HashMap();
        map.put("aq", "a");
        map.put("bq", "b");
        producer.sendMap(map);


    }

}

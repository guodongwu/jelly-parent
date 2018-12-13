package com.jelly.spring.batch.study.processor;

import org.springframework.batch.item.ItemProcessor;

public class SimpleItemProcessor implements ItemProcessor<String,String> {
    public String process(String s) throws Exception {

        System.out.println("send:"+s);
        return s;
    }
}

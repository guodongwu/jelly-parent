package com.jelly.spring.batch.study.writer;

import org.springframework.batch.item.file.transform.LineAggregator;

import java.util.Random;
import java.util.UUID;

public class SimpleLineAggregator implements LineAggregator<String> {
    public String aggregate(String s) {
        StringBuilder sb=new StringBuilder("insert into sys_tb");
        sb.append("(");
        sb.append("name,key,value");
        sb.append(")");
        sb.append("values");
        sb.append("(");
        sb.append((new Random()).nextInt());
        sb.append(",key"+ UUID.randomUUID());
        sb.append(","+s);
        sb.append(")");
        return  sb.toString();

    }
}

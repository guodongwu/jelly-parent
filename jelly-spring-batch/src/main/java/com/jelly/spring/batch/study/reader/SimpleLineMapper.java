package com.jelly.spring.batch.study.reader;

import org.springframework.batch.item.file.LineMapper;

public class SimpleLineMapper implements LineMapper<String> {
    public String mapLine(String s, int i) throws Exception {
        return  s;
    }
}

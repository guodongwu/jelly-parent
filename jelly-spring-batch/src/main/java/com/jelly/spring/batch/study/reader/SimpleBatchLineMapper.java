package com.jelly.spring.batch.study.reader;

import org.springframework.batch.item.file.LineMapper;

public class SimpleBatchLineMapper implements LineMapper<String> {
    public String mapLine(String line, int lineNumber) throws Exception {
        System.out.println(line+"====>"+lineNumber);
        return line;
    }
}

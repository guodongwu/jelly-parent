package com.jelly.jellyspringboot.logging;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class LogTest {
    Logger logger=LoggerFactory.getLogger(LogTest.class);
    @Test
    public void loggingTest(){
        logger.trace("this is trace....");
        logger.debug("this is debug....");
        //springboot 默认级别 info
        logger.info("this is info....");
        logger.warn("this is warn...");
        logger.error("this is error...");

    }
}

package com.jelly.zookeeper.study.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

    public  static  String ZOOKEEPER_IP_PORT;
    public  static  Integer SESSIONTIMEOUT;
    public  static  Integer CONNCETTIMEOUT;
    static  {
        Properties properties=new Properties();
        InputStream inputStream=PropertiesUtils.class.getClassLoader().getResourceAsStream("zookeeper.properties");
        try {
            properties.load(inputStream);
            ZOOKEEPER_IP_PORT=properties.getProperty("zookeeper.url");
            SESSIONTIMEOUT= Integer.valueOf(properties.getProperty("zookeeper.sessionTimeout"));
            CONNCETTIMEOUT= Integer.valueOf(properties.getProperty("zookeeper.connectTimeout"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

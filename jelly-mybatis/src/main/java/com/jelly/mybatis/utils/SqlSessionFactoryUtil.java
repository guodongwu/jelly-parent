package com.jelly.mybatis.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.print.DocFlavor;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

@Slf4j
public class SqlSessionFactoryUtil {
    private  static SqlSessionFactory sqlSessionFactory=null;
    private static  final Class CLASS_LOCK=SqlSessionFactoryUtil.class;

    private  SqlSessionFactoryUtil(){}
    public  static  SqlSessionFactory initSqlSessionFactory(){
        String resource="mybatis-config.xml";
        InputStream inputStream=null;
        try {
            inputStream= Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            log.info(e.getMessage());
        }
        synchronized (CLASS_LOCK){
            if(sqlSessionFactory==null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }
        }
        return  sqlSessionFactory;

    }

    public  static SqlSession openSqlSession(){
        if(sqlSessionFactory==null){
            initSqlSessionFactory();
        }
        return  sqlSessionFactory.openSession();
    }
    public  static  SqlSession openSqlSession(Boolean isBatch){
        if(sqlSessionFactory==null){
            initSqlSessionFactory();
        }
        return  sqlSessionFactory.openSession(ExecutorType.BATCH,true);
    }

    /*public static  SqlSessionFactory initSqlSessionFactory2(){
        InputStream cfgStream=null;
        Reader cfgReader=null;
        InputStream proStream=null;
        Reader proReader=null;
        Properties properties=null;
        try
        {
            cfgStream=Resources.getResourceAsStream("mybatis-config.xml");
            cfgReader=new InputStreamReader(cfgStream);
            proStream=Resources.getResourceAsStream("jdbc.properties");
            proReader=new InputStreamReader(proStream);
            properties=new Properties();
            properties.load(proReader);


        }catch (Exception ex){

        }
    }*/
}

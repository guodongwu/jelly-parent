package com.jelly.spring.study.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.jelly.spring.study.config.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = "com.jelly.spring.study.config")
@PropertySource(value = {"classpath:jdbc.properties"})
public class JavaConfig {

    @Bean
    public UserDao getUserDao(){
        return new UserDao();
    }

    @Value("${druid.driver}")
    private  String driverClassName;
    @Value("${druid.url}")
    private  String url;
    @Value("${druid.username}")
    private  String username;
    @Value("${druid.password}")
    private  String password;

    @Bean(destroyMethod = "close")
    public DruidDataSource druidDataSource(){
        DruidDataSource druidDataSource=new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setMaxActive(10);
        druidDataSource.setMinIdle(1);
        druidDataSource.setTestOnBorrow(true);
        return druidDataSource;

    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(druidDataSource());
        jdbcTemplate.setIgnoreWarnings(true);
        return  jdbcTemplate;
    }

}

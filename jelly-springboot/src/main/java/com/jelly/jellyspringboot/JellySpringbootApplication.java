package com.jelly.jellyspringboot;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDubbo(scanBasePackages="com.jelly")
public class JellySpringbootApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder builder=new SpringApplicationBuilder(JellySpringbootApplication.class);
        builder.bannerMode(Banner.Mode.OFF).run(args);
        //SpringApplication.run(JellySpringbootApplication.class, args);
    }

 }

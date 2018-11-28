package com.jelly.spring.study.conditional.config;

import com.jelly.spring.study.conditional.pojo.Man;
import com.jelly.spring.study.conditional.pojo.Woman;
import com.jelly.spring.study.conditional.service.ManCondition;
import com.jelly.spring.study.conditional.service.WomanCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value ="com.jelly.spring.study.conditional")
public class ConditionalConfig {
    @Bean
    @Conditional(ManCondition.class)
    public Man man(){
        return new Man();
    }
    @Bean
    @Conditional(WomanCondition.class)
    public Woman woman(){
        return new Woman();
    }
}

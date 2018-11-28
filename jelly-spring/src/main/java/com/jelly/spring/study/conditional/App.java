package com.jelly.spring.study.conditional;

import com.jelly.spring.study.conditional.config.ConditionalConfig;
import com.jelly.spring.study.conditional.pojo.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(ConditionalConfig.class);
        Person person=ctx.getBean(Person.class);
        System.out.println(person);
        person.birth();
    }
}

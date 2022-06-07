package com.jelly.lamda;

import com.jelly.reflection.TestBean;

import java.util.function.Predicate;

public class FunInterfaceTest {
    public static void main(String[] args) {
        FunInterface ff=()->{
            TestBean testBean=new TestBean();
            testBean.setId(1);
            testBean.setName("test");
            return testBean;
        };
        System.out.println(ff.getTestBean());
        System.out.println(ff.getBeanById(2));

    }
}

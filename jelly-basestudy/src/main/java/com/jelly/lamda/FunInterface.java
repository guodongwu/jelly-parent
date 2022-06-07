package com.jelly.lamda;

import com.jelly.reflection.TestBean;

@FunctionalInterface
public interface FunInterface {
    TestBean getTestBean();
    default TestBean getBeanById(Integer id){
        TestBean testBean=new TestBean();
        testBean.setId(id);
        return testBean;
    }
}

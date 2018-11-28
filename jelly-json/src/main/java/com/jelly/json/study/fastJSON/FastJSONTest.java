package com.jelly.json.study.fastJSON;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jelly.json.study.FemaleBean;
import com.jelly.json.study.PersonBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.BindException;
import org.springframework.validation.Validator;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class FastJSONTest {
    @Autowired
    private Validator customerValidatorFactory;
    @Test
    public void testToObject(){
        PersonBean personBean=null;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time= sdf.format(new Date());
        String json=String.format("{'id':1,'name':'abc','birthday':'%s','money':12.5,'idcard':1234567890" +
                ",femaleBeans:[{'id':1,'nick':'lili'},{'id':2,'nick':'aaa'}]}",time);
        personBean=JSON.parseObject(json,PersonBean.class);
        System.out.println(personBean);
        BindException errors=new BindException(personBean,"target");
        customerValidatorFactory.validate(personBean,errors);
        System.out.println(errors.getFieldErrors());
        String json2=JSON.toJSONString(personBean);
        System.out.println(json2);
    }
}

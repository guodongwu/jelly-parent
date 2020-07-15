package com.jelly.json.study.gson;

import com.google.gson.Gson;
import com.jelly.json.study.FemaleBean;
import com.jelly.json.study.PersonBean;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GsonTest {
    @Test
    public void gsonToObject() {
        Gson gson=new Gson();
        PersonBean personBean=new PersonBean();
        personBean.setBirthday(new Date());
        personBean.setId(1);
        personBean.setMoney(12d);
        personBean.setIdCard("11111111");
        personBean.setMarried(true);
        personBean.setName("abcv");
        List<FemaleBean> femaleBeans=new ArrayList<FemaleBean>();

        FemaleBean femaleBean=new FemaleBean();
        femaleBean.setId(1);
        femaleBean.setNick("aa");
        femaleBeans.add(femaleBean);
        femaleBean=new FemaleBean();
        femaleBean.setNick("bb");
        femaleBean.setId(2);
        femaleBeans.add(femaleBean);
        personBean.setFemaleBeans(femaleBeans);

        String jsonStr=gson.toJson(personBean,PersonBean.class);
        System.out.println(jsonStr);
        PersonBean person=gson.fromJson(jsonStr,PersonBean.class);
        System.out.println(person);

    }
}
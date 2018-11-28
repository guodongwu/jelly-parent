package com.jelly.json.study;

import com.alibaba.fastjson.annotation.JSONField;
import com.jelly.json.study.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonBean {
    private int id;
    private String name;
    @JSONField(format ="yyyy-MM-dd HH:mm:ss" )
    @DateTimeFormat
    private Date birthday;
    private double money;

    public List<FemaleBean> getFemaleBeans() {
        return femaleBeans;
    }

    public void setFemaleBeans(List<FemaleBean> femaleBeans) {
        this.femaleBeans = femaleBeans;
    }

    private List<FemaleBean> femaleBeans;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    @Override
    public String toString() {
        return "PersonBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", money=" + money +
                ", femaleBeans=" + femaleBeans +
                ", idCard='" + idCard + '\'' +
                ", isMarried=" + isMarried +
                '}';
    }

    private String idCard;
    private boolean isMarried;

}

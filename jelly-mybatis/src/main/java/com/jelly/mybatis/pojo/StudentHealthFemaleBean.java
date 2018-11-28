package com.jelly.mybatis.pojo;

import java.util.Date;
import java.util.List;

public class StudentHealthFemaleBean extends Student {
    private  int id;
    private int student_id;
    private Date checkTime;
    private String xin;
    private  String gan;
    private String pi;
    private String fei;

    @Override
    public String toString() {
        return "StudentHealthFemaleBean{" +
                "id=" + id +
                ", student_id=" + student_id +
                ", checkTime=" + checkTime +
                ", xin='" + xin + '\'' +
                ", gan='" + gan + '\'' +
                ", pi='" + pi + '\'' +
                ", fei='" + fei + '\'' +
                ", shen='" + shen + '\'' +
                ", zigong='" + zigong + '\'' +
                ", beizhu='" + beizhu + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getXin() {
        return xin;
    }

    public void setXin(String xin) {
        this.xin = xin;
    }

    public String getGan() {
        return gan;
    }

    public void setGan(String gan) {
        this.gan = gan;
    }

    public String getPi() {
        return pi;
    }

    public void setPi(String pi) {
        this.pi = pi;
    }

    public String getFei() {
        return fei;
    }

    public void setFei(String fei) {
        this.fei = fei;
    }

    public String getShen() {
        return shen;
    }

    public void setShen(String shen) {
        this.shen = shen;
    }

    public String getZigong() {
        return zigong;
    }

    public void setZigong(String zigong) {
        this.zigong = zigong;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    private String shen;
    private String zigong;
    private String beizhu;

}

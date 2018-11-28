package com.jelly.mybatis.pojo;

import java.util.List;

public class MaleStudentBean extends Student {
    public List<StudentHealthMaleBean> getStudentHealthMaleBeanList() {
        return studentHealthMaleBeanList;
    }

    public void setStudentHealthMaleBeanList(List<StudentHealthMaleBean> studentHealthMaleBeanList) {
        this.studentHealthMaleBeanList = studentHealthMaleBeanList;
    }

    private List<StudentHealthMaleBean> studentHealthMaleBeanList;
}

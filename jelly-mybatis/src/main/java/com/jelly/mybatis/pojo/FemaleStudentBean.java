package com.jelly.mybatis.pojo;

import java.util.List;

public class FemaleStudentBean extends Student {
    public List<StudentHealthFemaleBean> getStudentHealthFemaleBeanList() {
        return studentHealthFemaleBeanList;
    }

    public void setStudentHealthFemaleBeanList(List<StudentHealthFemaleBean> studentHealthFemaleBeanList) {
        this.studentHealthFemaleBeanList = studentHealthFemaleBeanList;
    }

    private List<StudentHealthFemaleBean> studentHealthFemaleBeanList;

}

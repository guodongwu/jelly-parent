package com.jelly.mybatis.mapper;

import com.jelly.mybatis.pojo.FemaleStudentBean;

public interface StudentHealthFemaleMapper {
    public FemaleStudentBean findStudentHealthFemaleByStudentId(int studentId);
}

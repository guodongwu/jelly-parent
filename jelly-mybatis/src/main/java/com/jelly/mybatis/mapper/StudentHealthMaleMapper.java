package com.jelly.mybatis.mapper;

import com.jelly.mybatis.pojo.MaleStudentBean;

public interface StudentHealthMaleMapper {
    public MaleStudentBean findStudentHealthMaleByStudentId(int studentId);
}

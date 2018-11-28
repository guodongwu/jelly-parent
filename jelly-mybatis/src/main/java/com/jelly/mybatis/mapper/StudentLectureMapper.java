package com.jelly.mybatis.mapper;

import com.jelly.mybatis.pojo.StudentLectureBean;

import java.util.List;

public interface StudentLectureMapper {
    public List<StudentLectureBean> findStudentLectureByStudentId(int studentId);
}

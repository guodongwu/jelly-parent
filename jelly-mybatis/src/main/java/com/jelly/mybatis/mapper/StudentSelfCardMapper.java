package com.jelly.mybatis.mapper;

import com.jelly.mybatis.pojo.StudentSelfCard;

public interface StudentSelfCardMapper {
  public StudentSelfCard  findStudentSelfCardByStudentId(int studentId);
}

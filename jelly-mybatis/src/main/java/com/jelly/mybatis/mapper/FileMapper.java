package com.jelly.mybatis.mapper;

import com.jelly.mybatis.pojo.FileBean;

public interface FileMapper {
   int insertFile(FileBean fileBean);
   FileBean getFile(Long id);
}

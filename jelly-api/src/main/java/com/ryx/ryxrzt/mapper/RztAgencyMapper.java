package com.ryx.ryxrzt.mapper;

import com.ryx.ryxrzt.entity.RztAgency;
import com.ryx.ryxrzt.entity.RztAgencyExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RztAgencyMapper {
    long countByExample(RztAgencyExample example);

    int deleteByExample(RztAgencyExample example);

    int insert(RztAgency record);

    int insertSelective(RztAgency record);

    List<RztAgency> selectByExample(RztAgencyExample example);

    int updateByExampleSelective(@Param("record") RztAgency record, @Param("example") RztAgencyExample example);

    int updateByExample(@Param("record") RztAgency record, @Param("example") RztAgencyExample example);


    @Select("SELECT AGENCY_CODE,CREATE_DATE,UPDATE_DATE,MOBILE,AGENCY_NAME FROM RZT_AGENCY WHERE MOBILE=#{mobile}")
    RztAgency getRztAgencyByMobile(String mobile);
}
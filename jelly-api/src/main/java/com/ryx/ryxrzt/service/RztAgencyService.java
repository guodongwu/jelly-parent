package com.ryx.ryxrzt.service;


import com.ryx.ryxrzt.entity.RztAgency;
import com.ryx.ryxrzt.entity.RztAgencyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RztAgencyService {
    long count();

    int deleteByExample(RztAgencyExample example);

    int insert(RztAgency record);

    int insertSelective(RztAgency record);

    List<RztAgency> selectByExample(RztAgencyExample example);

    int updateByExampleSelective(@Param("record") RztAgency record, @Param("example") RztAgencyExample example);

    int updateByExample(@Param("record") RztAgency record, @Param("example") RztAgencyExample example);


    RztAgency getRztAgencyByMobile(String mobile);
}

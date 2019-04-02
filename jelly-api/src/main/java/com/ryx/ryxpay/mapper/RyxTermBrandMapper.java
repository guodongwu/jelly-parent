package com.ryx.ryxpay.mapper;

import com.ryx.common.BaseMapper;
import com.ryx.ryxpay.entity.PayBankInfo;
import com.ryx.ryxpay.entity.RyxTermBrand;
import com.ryx.ryxpay.entity.RyxTermBrandExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface RyxTermBrandMapper extends BaseMapper<PayBankInfo,String> {
    int countByExample(RyxTermBrandExample example);

    int deleteByExample(RyxTermBrandExample example);

    int insert(RyxTermBrand record);

    int insertSelective(RyxTermBrand record);

    List<RyxTermBrand> selectByExample(RyxTermBrandExample example);

    int updateByExampleSelective(@Param("record") RyxTermBrand record, @Param("example") RyxTermBrandExample example);

    int updateByExample(@Param("record") RyxTermBrand record, @Param("example") RyxTermBrandExample example);
}
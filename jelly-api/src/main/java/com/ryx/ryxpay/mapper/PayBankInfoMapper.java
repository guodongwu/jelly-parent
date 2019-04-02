package com.ryx.ryxpay.mapper;

import com.ryx.common.BaseMapper;
import com.ryx.ryxpay.entity.PayBankInfo;
import com.ryx.ryxpay.entity.PayBankInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface PayBankInfoMapper extends BaseMapper<PayBankInfo,String> {
    long countByExample(PayBankInfoExample example);

    int deleteByExample(PayBankInfoExample example);

    int insertSelective(PayBankInfo record);

    List<PayBankInfo> selectByExample(PayBankInfoExample example);

    int updateByExampleSelective(@Param("record") PayBankInfo record, @Param("example") PayBankInfoExample example);

    int updateByExample(@Param("record") PayBankInfo record, @Param("example") PayBankInfoExample example);
}
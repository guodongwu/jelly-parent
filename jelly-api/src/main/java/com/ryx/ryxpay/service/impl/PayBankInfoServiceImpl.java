package com.ryx.ryxpay.service.impl;

import com.ryx.ryxpay.entity.PayBankInfo;
import com.ryx.ryxpay.entity.PayBankInfoExample;
import com.ryx.ryxpay.mapper.PayBankInfoMapper;
import com.ryx.ryxpay.service.PayBankInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayBankInfoServiceImpl implements PayBankInfoService {
    @Autowired
    private PayBankInfoMapper payBankInfoMapper;
    @Override
    public long count() {
        return payBankInfoMapper.countByExample(new PayBankInfoExample());
    }

    @Override
    public int delete(PayBankInfo payBankInfo) {
        return 0;
    }

    @Override
    public int insert(PayBankInfo record) {
        return 0;
    }

    @Override
    public int insertSelective(PayBankInfo record) {
        return 0;
    }

    @Override
    public List<PayBankInfo> select(PayBankInfo payBankInfo) {
        PayBankInfoExample payBankInfoExample=new PayBankInfoExample();
        PayBankInfoExample.Criteria payBankInfoExampleCriteria=payBankInfoExample.createCriteria();
        if(StringUtils.isNotEmpty(payBankInfo.getBankname())){
            payBankInfoExampleCriteria.andBanknameEqualTo(payBankInfo.getBankname());
        }
        return payBankInfoMapper.selectByExample(payBankInfoExample);
    }

    @Override
    public int update(PayBankInfo record) {
        return 0;
    }


}

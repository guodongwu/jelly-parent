package com.ryx.ryxpay.service;

import com.ryx.ryxpay.entity.PayBankInfo;

import java.util.List;

public interface PayBankInfoService {
    long count();

    int delete(PayBankInfo payBankInfo);

    int insert(PayBankInfo record);

    int insertSelective(PayBankInfo record);

    List<PayBankInfo> select(PayBankInfo payBankInfo);

    int update(PayBankInfo record);


}

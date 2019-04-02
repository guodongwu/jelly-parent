package com.ryx.ryxpay.mapper;

import com.ryx.ryxpay.entity.PayBindBankCard2;
import com.ryx.ryxpay.entity.PayCustomer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PayCustomerMapper {
    PayCustomer getPayCustomerByAgencyCode(String agencyCode);

    List<PayBindBankCard2> getPayBindBankCardByAgencyCode(String agencyCode);

    boolean insertPayBindBankCard(PayBindBankCard2 payBindBankCard);
//    boolean insertPayCustomer(PayCustomer payCustomer);
//
//    boolean insertPayBindBankCard2(PayBindBankCard2 payBindBankCard2);
}

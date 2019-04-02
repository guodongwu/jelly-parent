package com.ryx.ryxpay.service;

import com.ryx.ryxpay.entity.PayBindBankCard2;
import com.ryx.ryxpay.entity.PayCustomer;
import com.ryx.ryxrzt.entity.RztAgencyInfo;
import com.ryx.utils.JsonResult;

import java.util.List;

public interface PayCustomerService {
    PayCustomer getPayCustomerByAgencyCode(String agencyCode);

    List<PayBindBankCard2> getPayBindBankCardByAgencyCode(String agencyCode);

    JsonResult insertPayBindBankCard(PayBindBankCard2 payBindBankCard);
    //JsonResult insertPayCustomer(PayCustomer payCustomer, RztAgencyInfo rztAgencyInfo, PayBindBankCard2 payBindBankCard2);
}

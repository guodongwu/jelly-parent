package com.ryx.ryxpay.service.impl;

import com.ryx.ryxpay.entity.PayBindBankCard2;
import com.ryx.ryxpay.entity.PayCustomer;
import com.ryx.ryxpay.mapper.PayCustomerMapper;
import com.ryx.ryxpay.service.PayCustomerService;
import com.ryx.ryxrzt.entity.RztAgencyInfo;
import com.ryx.utils.ConstantUtil;
import com.ryx.utils.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PayCustomerServiceImpl implements PayCustomerService {
    @Resource
    private PayCustomerMapper payCustomerMapper;

    @Override
    public PayCustomer getPayCustomerByAgencyCode(String agencyCode) {
        //根据AgencyCode查询代理商客户信息
        return payCustomerMapper.getPayCustomerByAgencyCode(agencyCode);
    }

    @Override
    public List<PayBindBankCard2> getPayBindBankCardByAgencyCode(String agencyCode) {
        //根据AgencyCode查询代理商结算账户信息
        return payCustomerMapper.getPayBindBankCardByAgencyCode(agencyCode);
    }

    @Override
    public JsonResult insertPayBindBankCard(PayBindBankCard2 payBindBankCard) {
        JsonResult jsonResult = new JsonResult();
        //添加结算信息
        boolean flag = payCustomerMapper.insertPayBindBankCard(payBindBankCard);
        if (flag){
            jsonResult.setCode(ConstantUtil.SUCCESS_CODE);
            jsonResult.setMsg("添加结算信息成功");
            return jsonResult;
        }else{
            jsonResult.setCode(ConstantUtil.FAIL_CODE);
            jsonResult.setMsg("添加结算信息失败");
            return jsonResult;
        }
    }
    /*@Override
    public JsonResult insertPayCustomer(PayCustomer payCustomer, RztAgencyInfo rztAgencyInfo, PayBindBankCard2 payBindBankCard2) {
        //添加代理商信息
        //boolean flag1 = payCustomerMapper.insertPayCustomer(payCustomer);
        //添加代理商结算账户
        //boolean flag2 = payCustomerMapper.insertPayBindBankCard2(payBindBankCard2);
        return null;
    }*/
}

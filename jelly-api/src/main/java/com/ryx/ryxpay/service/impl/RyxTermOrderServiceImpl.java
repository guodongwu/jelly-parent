package com.ryx.ryxpay.service.impl;

import com.ryx.ryxpay.entity.RyxTermOrder;
import com.ryx.ryxpay.mapper.RyxTermOrderMapper;
import com.ryx.ryxpay.service.RyxTermOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RyxTermOrderServiceImpl implements RyxTermOrderService {

    @Autowired
    RyxTermOrderMapper ryxTermOrderMapper;


    @Override
    public List<RyxTermOrder> selectByRyxTermOrder(RyxTermOrder ryxTermOrder) {
        return ryxTermOrderMapper.selectByRyxTermOrder(ryxTermOrder);
    }
    @Override
    public int selectCountByRyxTermOrder(RyxTermOrder ryxTermOrder) {
        return ryxTermOrderMapper.selectCountByRyxTermOrder(ryxTermOrder);
    }

    @Override
    public RyxTermOrder selectRyxTermOrder(String orderId) {
        return ryxTermOrderMapper.selectRyxTermOrder(orderId);
    }
}

package com.ryx.ryxpay.service;

import com.ryx.ryxpay.entity.RyxTermOrder;

import java.util.List;

public interface RyxTermOrderService {
   public List<RyxTermOrder> selectByRyxTermOrder(RyxTermOrder ryxTermOrderMap);
   public int  selectCountByRyxTermOrder(RyxTermOrder ryxTermOrder);
   public RyxTermOrder selectRyxTermOrder(String orderId);
}

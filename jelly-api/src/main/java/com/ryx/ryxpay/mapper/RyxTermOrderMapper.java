package com.ryx.ryxpay.mapper;

import com.ryx.common.BaseMapper;
import com.ryx.ryxpay.entity.RyxTermOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RyxTermOrderMapper extends BaseMapper<RyxTermOrder,String> {

    List<RyxTermOrder> selectByRyxTermOrder(RyxTermOrder ryxTermOrder);
    int  selectCountByRyxTermOrder(RyxTermOrder ryxTermOrder);
    public RyxTermOrder selectRyxTermOrder(String orderId);

}
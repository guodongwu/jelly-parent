package com.ryx.ryxrzt.mapper;

import com.ryx.ryxrzt.entity.RztDealExpand;

import java.util.List;
import java.util.Map;

/**
 * 交易管理
 */
public interface RztDealMapper {
    /**
     * 获取交易列表
     * @param map
     * @return
     */
    List<RztDealExpand> getDealList(Map<String,Object> map);

    /**
     * 撤销分润
     * @param map
     * @return
     */
    int revokeDeal(Map<String,Object> map);

}

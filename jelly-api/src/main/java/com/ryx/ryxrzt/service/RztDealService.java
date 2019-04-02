package com.ryx.ryxrzt.service;

import com.ryx.ryxrzt.vo.RztDealVo;
import com.ryx.utils.JsonResult;

import java.util.List;
import java.util.Map;

public interface RztDealService {
    /**
     * 获取交易列表
     * @param map
     * @return
     */
    public JsonResult getDealList(Map<String,Object> map);

    /**
     * 撤销分润
     * @param map
     * @return
     */
    public int revokeDeal(Map<String,Object> map);

    List<RztDealVo> getDealTable(Map<String,Object> map);
}

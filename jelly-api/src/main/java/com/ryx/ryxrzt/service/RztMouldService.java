package com.ryx.ryxrzt.service;

import com.ryx.ryxrzt.entity.RztAgencyMould;
import com.ryx.ryxrzt.entity.RztMould;
import com.ryx.utils.JsonResult;

import java.util.List;
import java.util.Map;

/**
 * 分润规则服务
 */
public interface RztMouldService {

    /**
     * 插入机构分润规则
     * @param map
     * @return
     */
    JsonResult addAgencyMould(Map<String,Object> map);

    /**
     * 更新机构分润
     * @param map
     * @return
     */
    JsonResult updateAgencyMould(Map<String,Object> map);

    /**
     * 根据ruleNum获取下级分润模板
     * @param ruleNum
     * @return
     */
    RztMould  getMould(String ruleNum);

    /**
     * 获取模板列表（MOULDLIST）
     * @param map
     * @return
     */
    List<RztMould> getMouldList(Map<String,Object> map);
    /**
     * 获取代理商分润模板
     * @param map
     * @return
     */
    List<RztAgencyMould> getAgencyMouldList(Map<String,Object> map);

    /**
     * 可用模板
     * @param map
     * @return
     */
    List<Map<String,Object>> getAgencyUseableMouldList(Map<String,Object> map);
    /**
     * 删除模板
     * @param params
     * @return
     */
    JsonResult delMould(Map<String, Object> params);

    /**
     * 分配模板
     * @param map
     * @return
     */
    JsonResult assignMould(Map<String, Object> map);

    /**
     * 获取代理商模板的数量
     * @param params
     * @return
     */
    int getAgencyMouldCount(Map<String, Object> params);

    /**
     * 获取代理商模板的数量
     * @param params
     * @return
     */
    int getAgencyUseableMouldCount(Map<String, Object> params);
    /**
     * 获取模板的规则值
     * @param params
     * @return
     */
    JsonResult getMouldRule(Map<String, Object> params);
}

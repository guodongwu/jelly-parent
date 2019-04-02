package com.ryx.ryxrzt.mapper;

import com.ryx.ryxrzt.entity.RztAgencyMould;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface RztAgencyMouldMapper {

    /**
     * 添加代理商分润模板
     * @param record
     * @return
     */
    int insert(RztAgencyMould record);

    /**
     * 查询代理商分润模板
     * @param map
     * @return
     */
    List<RztAgencyMould> getAgencyMouldList(Map<String,Object> map);

    /**
     * 不限于只用代理商
     * @param map
     * @return
     */
    List<Map<String,Object>> selectAnyWhere(Map<String,Object> map);


    /**
     * 判断是否存在分润模板
     * @param map
     * @return
     */
    Integer hasMouldName(Map<String,Object> map);

    /**
     * 获取有效模板
     * @param map
     * @return
     */
    Map<String,Object> getUseableAgencyMould(Map<String,Object> map);

    /**
     * 获取分润规则值
     * @param map
     * @return
     */
    List<Map<String, Object>> getTemplateRule( Map<String,Object> map);

    /**
     * 获取分润规则值细节
     * @param branchId
     * @param sequenceId
     * @return
     */
    Map<String, Object> getAgencyRule(@Param("branchId") String branchId, @Param("sequenceId") String sequenceId);

    /**
     * 获取批次
     * @return
     */
    List<Map<String, String>> getBatch();


    /**
     * 获取模板编号
     * @return
     * @throws Exception
     */
    @Select("select rzt_seq_ruleid.nextval from dual")
    String getRuleId();

    /**
     * 插入日志
     * @param map
     * @return
     */
    @Insert("INSERT INTO RZT_MOULD_LOG (AGENCY_ID,RULE_ID,UP_TYPE,UP_DATE,UP_JSON) VALUES" +
            " (#{agencyId},#{ruleId},#{UP_TYPE},TO_CHAR(sysdate,'YYYYMMDDHH24MISS'),#{jsonStr})")
    int addAgencyRuleLog(Map<String,Object> map);

    /**
     * 更新代理商顶级模板
     * @param rztAgencyMould
     * @return
     */
    int upTopMould(RztAgencyMould rztAgencyMould);

    /**
     * 删除代理商模板顶级和子级
     * @param map
     */
    void delAgencyMould(Map<String, Object> map);

    /**
     * 获取规则生效的最大时间
     * @param mouldMap
     * @return
     */
    @Select("SELECT * FROM RZT_AGENCY_MOULD WHERE AGENCY_ID = #{agencyId} and Status='1' and VALIDITY_DATE = #{validityDate}")
    Map<String, Object> getAgencyRuleMaxDate(Map<String, Object> mouldMap);

    /**
     * 获取代理商数量
     * @param params
     * @return
     */
    int getAgencyMouldCount(Map<String, Object> params);

    /**
     * 获取有效的数量
     * @param params
     * @return
     */
    int getAgencyUseableMouldCount(Map<String, Object> params);
    /**
     * 获取品牌id
     * @param params
     * @return
     */
    String getBranchId(Map<String,Object> params);
}
package com.ryx.ryxrzt.mapper;

import com.ryx.ryxrzt.entity.RztMould;
import com.ryx.ryxrzt.entity.RztMouldExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface RztMouldMapper {

    /**
     * 查询数量
     * @param example
     * @return
     */
    long countByExample(RztMouldExample example);

    /**
     * 删除
     * @param example
     * @return
     */
    int deleteByExample(RztMouldExample example);

    /**
     * 添加
     * @param record
     * @return
     */
    int insert(RztMould record);

    /**
     * 添加
     * @param record
     * @return
     */
    int insertSelective(RztMould record);

    /**
     * 查询
     * @param example
     * @return
     */
    List<RztMould> selectByExample(RztMouldExample example);

    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") RztMould record, @Param("example") RztMouldExample example);

    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") RztMould record, @Param("example") RztMouldExample example);

    /**
     * 批量插入
     * @param list
     */
    void insertBatch(List<RztMould> list);

    /**
     * 批量更新
     * @param list
     */
    void upBatchMould(List<RztMould> list);

    /**
     * 删除
     * @param map
     * @return
     */
    int deleteMould(Map<String,Object> map);

    /**
     * 添加代理商分润规则
     * @param map
     */
    void addAgencyMould(Map<String, Object> map);
}
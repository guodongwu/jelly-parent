package com.jelly.ssm.dao;

import com.jelly.ssm.entity.Log;

import java.util.List;


/**
 * <p>
 * 操作日志 Mapper 接口
 * </p>
 *
 * @author will
 * @since 2018-11-05
 */
public interface LogDao extends BaseMapper<Log,Integer> {

    public void insertBatch(List<Log> list);
}

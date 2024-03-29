package com.jelly.ssm.service;

import com.jelly.ssm.entity.Log;

import java.util.List;

/**
 * <p>
 * 操作日志 服务类
 * </p>
 *
 * @author will
 * @since 2018-11-05
 */
public interface LogService extends BaseService<Log,Integer> {

    public  void insertBatch(List<Log> list);
}

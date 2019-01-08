package com.jelly.ssm.service.impl;

import com.jelly.ssm.dao.LogDao;
import com.jelly.ssm.entity.Log;
import com.jelly.ssm.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 操作日志 服务实现类
 * </p>
 *
 * @author will
 * @since 2018-11-05
 */
@Service
public class LogServiceImpl extends ServiceImpl<Log,Integer> implements LogService {

    @Autowired
    private LogDao logDao;
    @Override
    public void insertBatch(List<Log> list) {
        logDao.insertBatch(list);
    }
}

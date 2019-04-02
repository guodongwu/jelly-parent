package com.ryx.ryxrzt.service.impl;
import com.ryx.ryxrzt.entity.RztAgency;
import com.ryx.ryxrzt.entity.RztAgencyExample;
import com.ryx.ryxrzt.mapper.RztAgencyMapper;
import com.ryx.ryxrzt.service.RztAgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RztAgencyServiceImpl implements RztAgencyService {
    @Autowired
    private RztAgencyMapper rztAgencyMapper;


    @Override
    public long count() {
        RztAgencyExample example = new RztAgencyExample();
        long count = rztAgencyMapper.countByExample(example);
        return count;
    }

    @Override
    public int deleteByExample(RztAgencyExample example) {
        return rztAgencyMapper.deleteByExample(example);
    }

    @Override
    public int insert(RztAgency record) {
        return rztAgencyMapper.insert(record);
    }

    @Override
    public int insertSelective(RztAgency record) {
        return rztAgencyMapper.insertSelective(record);
    }

    @Override
    public List<RztAgency> selectByExample(RztAgencyExample example) {
        return rztAgencyMapper.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(RztAgency record, RztAgencyExample example) {
        return rztAgencyMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(RztAgency record, RztAgencyExample example) {
        return rztAgencyMapper.updateByExample(record,example);
    }

    @Override
    public RztAgency getRztAgencyByMobile(String mobile) {
        return rztAgencyMapper.getRztAgencyByMobile(mobile);
    }
}

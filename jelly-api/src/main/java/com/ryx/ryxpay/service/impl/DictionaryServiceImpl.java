package com.ryx.ryxpay.service.impl;

import com.ryx.ryxpay.entity.RyxTermBrand;
import com.ryx.ryxpay.entity.RyxTermBrandExample;
import com.ryx.ryxpay.mapper.RyxTermBrandMapper;
import com.ryx.ryxpay.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    private RyxTermBrandMapper ryxTermBrandMapper;

    @Override
    public List<RyxTermBrand> selectRyxTermBrandList(RyxTermBrand ryxTermBrand) {

        RyxTermBrandExample ryxTermBrandExample=new RyxTermBrandExample();
       RyxTermBrandExample.Criteria criteria= ryxTermBrandExample.createCriteria();
       String id= ryxTermBrand.getId();
       if(StringUtils.isNotEmpty(id)){
           criteria.andIdEqualTo(id);
       }
        return ryxTermBrandMapper.selectByExample(ryxTermBrandExample);
    }
}

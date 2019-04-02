package com.ryx.ryxrzt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ryx.ryxrzt.entity.RztDealExpand;
import com.ryx.ryxrzt.mapper.RztDealMapper;
import com.ryx.ryxrzt.service.RztDealService;
import com.ryx.ryxrzt.vo.RztDealVo;
import com.ryx.utils.ConstantUtil;
import com.ryx.utils.JsonResult;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RztDealServiceImpl  implements RztDealService {
    @Autowired
    private RztDealMapper rztDealMapper;

    /**
     * 查找交易列表
     * @param map
     * @return
     */
    @Override
    public JsonResult getDealList(Map<String, Object> map) {
        JsonResult jsonResult;
        if(null==map){
            map=new HashMap<>();
            map.put("page",1);
            map.put("limit", ConstantUtil.PAGE_SIZE);
        }
        if(StringUtils.isBlank(MapUtils.getString(map,"page"))){
            map.put("page",1);
        }
        if(StringUtils.isBlank(MapUtils.getString(map,"limit"))){
            map.put("limit", ConstantUtil.PAGE_SIZE);
        }
        PageHelper.startPage(MapUtils.getInteger(map,"page"),MapUtils.getInteger(map,"limit"));
        List<RztDealExpand> list = rztDealMapper.getDealList(map);
        PageInfo<RztDealExpand> pageInfo= new PageInfo<>(list);

        jsonResult=JsonResult.SUCCESS();
        Map<String,Object> result=new HashMap<>();
        result.put("page",pageInfo.getPageNum());
        result.put("limit",pageInfo.getPageSize());
        result.put("total",pageInfo.getTotal());
        result.put("items",pageInfo.getList());
        jsonResult.setResult(result);
        return jsonResult;
    }

    @Override
    public int revokeDeal(Map<String, Object> map) {
        return 0;
    }

    /**
     * 导出table
     * @param map
     * @return
     */
    @Override
    public List<RztDealVo> getDealTable(Map<String, Object> map) {
        JsonResult jsonResult;
        List<RztDealExpand> list = rztDealMapper.getDealList(map);
        List<RztDealVo> rztDealVoList=new ArrayList<>();
        RztDealVo dealVo;
        for (RztDealExpand rztDealExpand: list) {
            dealVo=new RztDealVo();
            BeanUtils.copyProperties(rztDealExpand,dealVo );
            rztDealVoList.add(dealVo);
        }
        return rztDealVoList;
    }

}

package com.ryx.ryxrzt.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ryx.ryxrzt.entity.*;
import com.ryx.ryxrzt.mapper.RztAgencyMouldMapper;
import com.ryx.ryxrzt.mapper.RztMouldMapper;
import com.ryx.ryxrzt.service.RztMouldService;
import com.ryx.utils.ConstantUtil;
import com.ryx.utils.ContentFormatUtil;
import com.ryx.utils.JsonResult;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;

@Service
public class RztMouldServiceImpl implements RztMouldService {
    private  static Logger logger= LoggerFactory.getLogger(RztMouldServiceImpl.class);
    private  static  Pattern p1 = Pattern.compile("^[5,6,2]+$");
    private static  Pattern p2 = Pattern.compile("^[3]+$");
    private static Pattern p3 = Pattern.compile("^[4]+$");
    private static Pattern p4 = Pattern.compile("^[1]+$");
    private static Pattern p1yuan = Pattern.compile("^[5,6,2,4]+$");
    private static Pattern p2per = Pattern.compile("^[1,3]+$");

    @Autowired
    private RztAgencyMouldMapper rztAgencyMouldMapper;
    @Autowired
    private RztMouldMapper rztMouldMapper;

    @Override
    @Transactional(value = "ryxrztTransactionManager",rollbackFor = Exception.class)
    public JsonResult addAgencyMould(Map<String,Object> map) {
        //处理固定值
        JsonResult result=new JsonResult();
        //判断是否存在该模板
        Integer flag = rztAgencyMouldMapper.hasMouldName(map);
        if(flag>0) {
            result.setCode("5001");
            result.setMsg("模板名称已存在！");
            return result;
        }
        //验证是否存在分润规则
        Map<String, Object> validityDateMap = rztAgencyMouldMapper.getUseableAgencyMould(map);
        if (null==validityDateMap || validityDateMap.isEmpty()){
            result.setCode("4001");
            result.setMsg("暂无分润规则，请联系上级分配分润规则");
            return result;
        }
        //验证时间是否正确
        String validityDate = MapUtils.getString(map, "validityDate");
        DateTime validDate;
        try {
            DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd");
            validDate=DateTime.parse(validityDate,format);
            String baseValidDateStr=MapUtils.getString(validityDateMap, "VALIDITY_DATE");
            baseValidDateStr=ContentFormatUtil.convertTime(baseValidDateStr);
            DateTime baseValidDate=DateTime.parse(baseValidDateStr,format);
            if(validDate.isBefore(baseValidDate)) {
                result.setCode("5003");
                result.setMsg("模板时间不能小于参考模板！");
                return result;
            }
        } catch (Exception e) {
            result.setCode("5002");
            result.setMsg("模板时间配置异常！");
            return result;
        }
        //验证json是否符合要求
        String jsonStr=MapUtils.getString(map, "jsonStr");
        List<Map<String, Object>> jsonObj;
        try {
            if(StringUtils.isBlank(jsonStr)) {
                result.setCode("5003");
                result.setMsg("模板数据异常,创建失败！");
                return result;
            }
            jsonObj = JSONArray.parseObject(jsonStr, List.class);
        }catch (Exception e){
            result.setCode("1000");
            result.setMsg("jsonStr字符串格式有误");
            logger.error(jsonStr);
            return  result;
        }
        //获取分润规则值
        Map<String, Object> paramMap = new HashMap<>();
        String baseRuleId= MapUtils.getString(map, "ruleId");
        if(StringUtils.isBlank(baseRuleId)){
            baseRuleId=MapUtils.getString(validityDateMap,"ruleId");
        }
        paramMap.put("ruleId", baseRuleId);
		paramMap.put("agencyId",  MapUtils.getString(map, "agencyId"));
		String  branchId=MapUtils.getString(map,"branchId");
		if(StringUtils.isBlank(branchId)){
            //如果没有 则查询出品牌
           branchId=rztAgencyMouldMapper.getBranchId(map);
        }
        paramMap.put("branchId", branchId);
        List<Map<String, Object>> upRuleList = rztAgencyMouldMapper.getTemplateRule(paramMap);
        List<RztMould> rztMouldList=new ArrayList<>();

        //顶层获取ruleId
        String ruleId = rztAgencyMouldMapper.getRuleId();
        for (Map<String,Object> jsonObjItem:jsonObj){
                List<Map<String, Object>> child = (List<Map<String, Object>>) jsonObjItem.get("BATCHVALUE");
                if(null== child || child.isEmpty()) {
                    result.setCode("5004");
                    result.setMsg("模板数据异常！");
                    return result;
                }
            for(Map<String, Object> obj : child) {
                String sequenceId =MapUtils.getString(obj,"SEQUENCE_ID","");
                for (int j = 0; j < upRuleList.size(); j++) {
                    String upSequenceId =MapUtils.getString(upRuleList.get(j),"SEQUENCE_ID","");
                    if (StringUtils.isNotBlank(sequenceId)&&sequenceId.equals(upSequenceId)) {
                        String ruleValue =MapUtils.getString(upRuleList.get(j),"RULEVALUE","0");
                        macthRuleValue(sequenceId, obj, ruleValue);
                        //插入数据
                        RztMould rztMould = new RztMould();
                        rztMould.setAgencyId(MapUtils.getString(obj,"AGENCY_ID"));
                        rztMould.setBatchId(MapUtils.getString(obj,"BATCH_ID"));
                        rztMould.setDealtypeId(MapUtils.getString(obj,"DEAL_TYPE"));
                        rztMould.setSplittingMode(MapUtils.getString(obj,"SPLITTING_MODE"));
                        rztMould.setSplittingRegionmode(MapUtils.getString(obj,"SPLITTING_REGIONMODE"));
                        rztMould.setRulebegin(BigDecimal.valueOf(MapUtils.getDouble(obj,"RULEBEGIN")));
                        rztMould.setRuleend(BigDecimal.valueOf(MapUtils.getDouble(obj,"RULEEND")));
                        rztMould.setRuleNum(MapUtils.getString(obj,"RULE_NUM"));
                        rztMould.setRulevalue(BigDecimal.valueOf(MapUtils.getDouble(obj,"RULEVALUE")));
                        rztMould.setMouldName(MapUtils.getString(map, "mouldName"));
                        rztMould.setModifyType(MapUtils.getString(obj, "MODIFY_TYPE"));
                        rztMould.setDelay(MapUtils.getString(obj, "DELAY"));
                        rztMould.setSequenceId(MapUtils.getString(obj, "SEQUENCE_ID"));
                        rztMould.setValidityDate(MapUtils.getString(map,"validityDate").replaceAll("-","")+"000000");

                        rztMould.setRuleId(ruleId);
                        rztMouldList.add(rztMould);
                    }
                }
            }
        }


        RztAgencyMould rztAgencyMould=new RztAgencyMould();
        rztAgencyMould.setAgencyId(MapUtils.getString(map,"agencyId"));
        rztAgencyMould.setRuleId(ruleId);
        rztAgencyMould.setRulerem("1");
        rztAgencyMould.setMouldName(MapUtils.getString(map,"mouldName"));
        rztAgencyMould.setStatus("2");
        rztAgencyMould.setValidityDate(validDate.toString("yyyyMMdd000000"));
        rztAgencyMould.setCreateDate(DateTime.now().toString("yyyyMMddHHmmss"));
        rztAgencyMould.setCreator(MapUtils.getString(map,"agencyId"));
        rztAgencyMould.setParentRuleId(MapUtils.getString(map,"ruleId"));
        rztAgencyMouldMapper.insert(rztAgencyMould);
        //批量插入
        rztMouldMapper.insertBatch(rztMouldList);
        //添加日志信息
        map.put("UP_TYPE", "1");
        map.put("ruleId",ruleId);
        if(jsonStr.length()>4000) {
            map.put("jsonStr", jsonStr.substring(0, 4000));
        }else {
            map.put("jsonStr", jsonStr);
        }
        rztAgencyMouldMapper.addAgencyRuleLog(map);
        result.setCode("0000");
        result.setMsg("处理成功！");
        return result;
    }


    @Override
    @Transactional(value = "ryxrztTransactionManager",rollbackFor = Exception.class)
    public JsonResult updateAgencyMould(Map<String, Object> map) {
        //处理固定值
        JsonResult result=new JsonResult();
        String jsonStr=MapUtils.getString(map, "jsonStr");
        List<Map<String, Object>> jsonObj;
        try {
            jsonObj = JSONArray.parseObject(jsonStr, List.class);
            if(null==jsonObj || jsonObj.isEmpty()){
                result.setCode("1000");
                result.setMsg("jsonStr没有数据");
                return result;
            }
        }catch (Exception e){
            result.setCode("1000");
            result.setMsg("jsonStr格式有误或没有数据");
            return  result;
        }
        if(StringUtils.isNotBlank(MapUtils.getString(map, "parentRuleId"))) {
            map.put("ruleId",  MapUtils.getString(map, "parentRuleId"));
        } else {
            map.put("ruleId",  MapUtils.getString(map, "ruleId"));
        }
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("agencyId",  MapUtils.getString(map, "agencyId"));
        paramMap.put("branchId", map.get("branchId"));
        List<Map<String, Object>> upRuleList = rztAgencyMouldMapper.getTemplateRule(paramMap);
        List<RztMould> rztMouldList=new ArrayList<>();

        for (Map<String,Object> jsonObjItem:jsonObj){
            List<Map<String, Object>> child = (List<Map<String, Object>>) jsonObjItem.get("BATCHVALUE");
            if(null== child || child.isEmpty()) {
                result.setCode("5004");
                result.setMsg("模板数据异常！");
                return result;
            }
            for(Map<String, Object> obj : child) {
                String sequenceId=MapUtils.getString(obj,"SEQUENCE_ID","");
                for (int j = 0; j < upRuleList.size(); j++) {
                    if (StringUtils.isNotBlank(sequenceId) && sequenceId.equals(upRuleList.get(j).get("SEQUENCE_ID"))) {
                        String ruleValue=MapUtils.getString(upRuleList.get(j),"RULEVALUE","0");
                        macthRuleValue(sequenceId,obj,ruleValue);

                        RztMould rztMould=new RztMould();
                        rztMould.setAgencyId(MapUtils.getString(obj,"AGENCY_ID"));
                        rztMould.setBatchId(MapUtils.getString(obj,"BATCH_ID"));
                        rztMould.setDealtypeId(MapUtils.getString(obj,"DEALTYPE_ID"));
                        rztMould.setSplittingMode(MapUtils.getString(obj,"SPLITTING_MODE"));
                        rztMould.setSplittingRegionmode(MapUtils.getString(obj,"SPLITTING_REGIONMODE"));
                        rztMould.setRulebegin(BigDecimal.valueOf(MapUtils.getDouble(obj,"RULEBEGIN")));
                        rztMould.setRuleend(BigDecimal.valueOf(MapUtils.getDouble(obj,"RULEEND")));
                        rztMould.setRuleNum(MapUtils.getString(obj,"RULE_NUM"));
                        rztMould.setRulevalue(BigDecimal.valueOf(MapUtils.getDouble(obj,"RULEVALUE")));
                        rztMould.setMouldName(MapUtils.getString(map,"mouldName"));
                        rztMould.setModifyType(MapUtils.getString(obj,"MODIFY_TYPE"));
                        rztMould.setDelay(MapUtils.getString(obj,"DELAY"));
                        rztMould.setSequenceId(MapUtils.getString(obj,"SEQUENCE_ID"));
                        rztMould.setRuleId(MapUtils.getString(obj,"RULE_ID"));
                        rztMould.setValidityDate(MapUtils.getString(map,"validityDate").replaceAll("-","")+"000000");
                        rztMouldList.add(rztMould);

                    }
                }

            }


        }
        //顶层
        String ruleId = MapUtils.getString(map,"ruleId");
        RztAgencyMould rztAgencyMould=new RztAgencyMould();
        rztAgencyMould.setAgencyId(MapUtils.getString(map,"agencyId"));
        rztAgencyMould.setRuleId(ruleId);
        rztAgencyMould.setRulerem("1");
        rztAgencyMould.setMouldName(MapUtils.getString(map,"mouldName"));
        rztAgencyMould.setStatus("2");
        rztAgencyMould.setValidityDate(MapUtils.getString(map,"validityDate").replaceAll("-","")+"000000");
        rztAgencyMould.setCreateDate(DateTime.now().toString("yyyyMMddHHmmss"));
        rztAgencyMould.setCreator(MapUtils.getString(map,"agencyId"));
        rztAgencyMould.setParentRuleId(MapUtils.getString(map,"ruleId"));
        //更新顶级模板
        rztAgencyMouldMapper.upTopMould(rztAgencyMould);
        //更新下级模板
        rztMouldMapper.upBatchMould(rztMouldList);
        map.put("UP_TYPE", "2");
        if(jsonStr.length()>4000) {
            map.put("jsonStr", jsonStr.substring(0, 4000));
        }else{
            map.put("jsonStr", jsonStr);
        }
        rztAgencyMouldMapper.addAgencyRuleLog(map);
        result.setCode("0000");
        result.setMsg("处理成功！");
        return result;
    }


    public JsonResult macthRuleValue(String splittingMode,Map<String, Object> mp,String ruleValue){
        JsonResult result;
        if(p1.matcher(splittingMode).find()) {
            mp.put("RULEVALUE", new BigDecimal(mp.get("RULEVALUE").toString()).divide(new BigDecimal(100)));
            String newRuleValue=MapUtils.getString(mp,"RULEVALUE","0");
            if( 0<new BigDecimal(newRuleValue).compareTo(new BigDecimal(ruleValue).divide(new BigDecimal(100)))
                    || 0>new BigDecimal(newRuleValue).compareTo(new BigDecimal(mp.get("RULESTART").toString()).divide(new BigDecimal(100)))
            ){
                result=new JsonResult();
                result.setCode("4003");
                result.setMsg("规则值超限！");
                return result;
            }
        }
        else if (p2.matcher(splittingMode).find()) {
            String newRuleValue=mp.get("RULEVALUE").toString();
            if( 0>new BigDecimal(newRuleValue).compareTo(new BigDecimal(ruleValue))
                    || 0<new BigDecimal(newRuleValue).compareTo(new BigDecimal(mp.get("RULEENDD").toString()))
            ){
                result=new JsonResult();
                result.setCode("4003");
                result.setMsg("规则值超限！");
                return result;
            }
        }
        else if (p3.matcher(splittingMode).find()) {
            mp.put("RULEVALUE", new BigDecimal(mp.get("RULEVALUE").toString()).divide(new BigDecimal(100)));
            String newRuleValue=MapUtils.getString(mp,"RULEVALUE","0");
            if( 0>new BigDecimal(newRuleValue).compareTo(new BigDecimal(ruleValue).divide(new BigDecimal(100)))
                    || 0<new BigDecimal(newRuleValue).compareTo(new BigDecimal(mp.get("RULEENDD").toString()).divide(new BigDecimal(100)))
            ){
                result=new JsonResult();
                result.setCode("4003");
                result.setMsg("规则值超限！");
                return result;
            }
        }
        else if (p4.matcher(splittingMode).find()) {
            String newRuleValue=MapUtils.getString(mp,"RULEVALUE","0");
            String ruleStart=MapUtils.getString(mp,"RULESTART","0");
            if( 0<new BigDecimal(newRuleValue).compareTo(new BigDecimal(ruleValue))
                    || 0>new BigDecimal(newRuleValue).compareTo(new BigDecimal(ruleStart))
            ){
                result=new JsonResult();
                result.setCode("4003");
                result.setMsg("规则值超限！");
                return result;
            }
        }
        result =new JsonResult();
        result.setCode("9999");
        result.setMsg("操作失败！");
        return result;
    }

    /**
     * 获取单个的分润模板
     * @param ruleNum
     * @return
     */
    @Override
    public RztMould getMould(String ruleNum) {
        RztMouldExample example=new RztMouldExample();
        RztMouldExample.Criteria criteria=example.createCriteria();
        criteria.andRuleNumEqualTo(ruleNum);
        List<RztMould> rztMoulds=rztMouldMapper.selectByExample(example);
        if(rztMoulds!=null && rztMoulds.isEmpty()) {
            return rztMoulds.get(0);
        }
        return null;
    }


    /**
     * 获取分润模板详细
     * @param map
     * @return
     */
    @Override
    public List<RztMould> getMouldList(Map<String,Object> map) {
        RztMouldExample example=new RztMouldExample();
        RztMouldExample.Criteria criteria=example.createCriteria();
        criteria.andAgencyIdEqualTo(MapUtils.getString(map,"agencyId"));
        criteria.andRuleIdEqualTo(MapUtils.getString(map,"ruleId"));
        List<RztMould> rztMoulds=rztMouldMapper.selectByExample(example);
        return rztMoulds;
    }

    /**
     * 获取机构下所有生效和待生效模板
     * @param map
     * @return
     */
    @Override
    public List<Map<String,Object>> getAgencyUseableMouldList(Map<String,Object> map) {
        if(StringUtils.isBlank(MapUtils.getString(map,"limit"))) {
            map.put("limit", ConstantUtil.PAGE_SIZE);
        }
        if(StringUtils.isBlank(MapUtils.getString(map,"page"))){
            map.put("page", "1");
        }
        String startDate=MapUtils.getString(map,"startDate");
        if(StringUtils.isNotEmpty(startDate)) {
            map.put("startDate", startDate.replace("-", ""));
        }
        String endDate=MapUtils.getString(map,"endDate");
        if(StringUtils.isNotEmpty(endDate)) {
            map.put("endDate", endDate.replace("-", ""));
        }
        String ruleRem=MapUtils.getString(map,"ruleRem");
        if(StringUtils.isNotBlank(ruleRem) && "0".equals(ruleRem)){
            //如果查找的是生效或待生效的模板 因为分页没有 但是数据量不大可以暂时把分页搞大一些
            map.put("limit",200);
        }

        List<Map<String,Object>> rztMoulds=rztAgencyMouldMapper.selectAnyWhere(map);
        return rztMoulds;
    }


    /**
     * 获取机构下模板
     * @param map
     * @return
     */
    @Override
    public List<RztAgencyMould> getAgencyMouldList(Map<String,Object> map) {
        if(StringUtils.isBlank(MapUtils.getString(map,"limit"))) {
            map.put("limit", ConstantUtil.PAGE_SIZE);
        }
        if(StringUtils.isBlank(MapUtils.getString(map,"page"))){
            map.put("page", "1");
        }
        String startDate=MapUtils.getString(map,"startDate");
        if(StringUtils.isNotEmpty(startDate)) {
            map.put("startDate", startDate.replace("-", ""));
        }
        String endDate=MapUtils.getString(map,"endDate");
        if(StringUtils.isNotEmpty(endDate)) {
            map.put("endDate", endDate.replace("-", ""));
        }
        /*if(StringUtils.isBlank(MapUtils.getString(map,"rulerem"))) {
            map.put("rulerem", "1");
        }else{
            map.put("rulerem", "0");
        }*/
        List<RztAgencyMould> rztMoulds=rztAgencyMouldMapper.getAgencyMouldList(map);
        return rztMoulds;
    }


    @Transactional(value = "ryxrztTransactionManager",rollbackFor = Exception.class)
    @Override
    public JsonResult delMould(Map<String, Object> map) {
        JsonResult result = new JsonResult();
        String agencyId= MapUtils.getString(map,"agencyId");
        String ruleId=MapUtils.getString(map, "ruleId");
        String branchId=rztAgencyMouldMapper.getBranchId(map);
        map.put("branchId",branchId);
        List<Map<String, Object>> agencies= rztAgencyMouldMapper.getTemplateRule(map);
        if(agencies!=null && !agencies.isEmpty()) {
            String agencyRule = JSONArray.toJSONString(agencies);

            rztAgencyMouldMapper.delAgencyMould(map);
            rztMouldMapper.deleteMould(map);
            map.put("UP_TYPE", "3");
            if (agencyRule.length() > 4000) {
                map.put("jsonStr", agencyRule.substring(0, 4000));
            } else {
                map.put("jsonStr", agencyRule);
            }
            rztAgencyMouldMapper.addAgencyRuleLog(map);
            result.setMsg("处理成功！");
        }else{
            result.setMsg("分润模板不存在,无需删除！");
        }
        result.setCode("0000");
        return result;

    }

    /**
     * 分配模板
     * @param map
     * @return
     */
    @Override
    @Transactional(value = "ryxrztTransactionManager",rollbackFor = Exception.class)
    public JsonResult assignMould(Map<String, Object> map) {
        JsonResult result = new JsonResult();

        String agencyListStr = MapUtils.getString(map, "childAgencyId");
        String validityDate = MapUtils.getString(map, "validityDate");

        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd");
        DateTime validDate;
        try {
            validDate = DateTime.parse(validityDate, format);
        }catch (RuntimeException e){
            result.setCode("1000");
            result.setMsg("时间格式有误");
            return result;
        }
        List<String> agencyList;
        try {
           agencyList = JSON.parseObject(agencyListStr, List.class);
           if(null==agencyList || agencyList.isEmpty()){
               result.setCode("1000");
               result.setMsg("没有下级代理商列表");
               return  result;
           }
        }catch (RuntimeException e){
            logger.error("assignMould:json转换错误"+e.getMessage());
            result.setCode("1000");
            result.setMsg("下级代理商字符串格式有误");
            return  result;
        }
        Map<String, Object> useableAgencyMouldMap =  rztAgencyMouldMapper.getUseableAgencyMould(map);
        if(null==useableAgencyMouldMap || useableAgencyMouldMap.isEmpty()) {
            result.setCode("1000");
            result.setMsg("未获取到分配模板信息！");
            return result;
        }
        for (String agencyid : agencyList) {
            String ruleId = rztAgencyMouldMapper.getRuleId();
            RztAgencyMould rztAgencyMould=new RztAgencyMould();
            rztAgencyMould.setAgencyId(agencyid);
            rztAgencyMould.setRuleId(ruleId);
            rztAgencyMould.setRulerem("0");
            Map<String, Object> mouldMap = new HashMap<>();

            DateTime today=DateTime.parse(DateTime.now().toString("yyyy-MM-dd"),format);
            if(validDate.isAfter(today)) {
                rztAgencyMould.setMouldName(validDate.toString("yyyyMMdd")+" 待生效规则");
                rztAgencyMould.setStatus("1");
                rztAgencyMould.setValidityDate(validDate.toString("yyyyMMdd000000"));
                mouldMap.put("agencyId", agencyid);
                mouldMap.put("validityDate", validDate.toString("yyyyMMdd000000"));

                Map<String, Object> maxMap = rztAgencyMouldMapper.getAgencyRuleMaxDate(mouldMap);
                if(null!=maxMap && !maxMap.isEmpty()) {
                    mouldMap.put("ruleId", maxMap.get("RULE_ID"));
                    this.delMould(mouldMap);
                }
            }
            else {
                mouldMap.put("agencyId", agencyid);
                Map<String, Object> mouMap = rztAgencyMouldMapper.getUseableAgencyMould(mouldMap);
                if(null==mouMap || mouMap.isEmpty()) {
                    rztAgencyMould.setMouldName("当前生效规则");
                    rztAgencyMould.setStatus("0");
                    rztAgencyMould.setValidityDate(today.toString("yyyyMMdd000000"));
                }
                else {
                    DateTime nextDate=today.plusDays(1);
                    mouldMap.put("validityDate", nextDate.toString("yyyyMMdd000000"));
                    Map<String, Object> maxMap = rztAgencyMouldMapper.getAgencyRuleMaxDate(mouldMap);
                    if(maxMap!=null && !maxMap.isEmpty()) {
                        mouldMap.put("ruleId", maxMap.get("RULE_ID"));
                        this.delMould(mouldMap);
                    }
                    rztAgencyMould.setMouldName(nextDate.toString("yyyy-MM-dd")+" 待生效规则");
                    rztAgencyMould.setStatus("1");
                    rztAgencyMould.setValidityDate(nextDate.toString("yyyyMMdd000000"));
                }

            }
            rztAgencyMould.setCreateDate(DateTime.now().toString("yyyyMMddHHmmss"));
            rztAgencyMould.setCreator(MapUtils.getString(map,"agencyId"));
            rztAgencyMould.setParentRuleId(MapUtils.getString(map,"ruleId"));
            rztAgencyMouldMapper.insert(rztAgencyMould);


            useableAgencyMouldMap.put("ruleId", useableAgencyMouldMap.get("RULE_ID"));
            useableAgencyMouldMap.put("rulerem", useableAgencyMouldMap.get("RULEREM"));
            useableAgencyMouldMap.put("childAgencyId", agencyid);
            useableAgencyMouldMap.put("agencyId", MapUtils.getString(map, "agencyId"));
            useableAgencyMouldMap.put("id",ruleId);
            useableAgencyMouldMap.put("mouldName",rztAgencyMould.getMouldName());
            rztMouldMapper.addAgencyMould(useableAgencyMouldMap);

            map.put("UP_TYPE", "4");
            if(agencyListStr.length()>4000) {
                map.put("jsonStr", agencyListStr.substring(0, 4000));
            }else{
                map.put("jsonStr",agencyListStr);
            }
            rztAgencyMouldMapper.addAgencyRuleLog(map);
        }
        result.setCode("0000");
        result.setMsg("处理成功！");
        return result;
    }

    @Override
    public int getAgencyMouldCount(Map<String, Object> params) {
        return rztAgencyMouldMapper.getAgencyMouldCount(params);
    }

    @Override
    public int getAgencyUseableMouldCount(Map<String, Object> params) {
        return rztAgencyMouldMapper.getAgencyUseableMouldCount(params);
    }

    /**
     * 获取分润规则值
     * @param params
     * @return
     */
    @Override
    public JsonResult getMouldRule(Map<String, Object> params) {
        JsonResult result;
        Map<String, Object> paramMap = new HashMap<>();
        //查找上级代理商
        if(StringUtils.isNotBlank(MapUtils.getString(params, "parentRuleId"))) {
            paramMap.put("ruleId",  MapUtils.getString(params, "parentRuleId"));
        } else {
            paramMap.put("ruleId",  MapUtils.getString(params, "ruleId"));
        }
        paramMap.put("agencyId",  MapUtils.getString(params, "agencyId"));
        //如果没有品牌 则通过代理商获取品牌
        String branchId=MapUtils.getString(params,"branchId");
        if(StringUtils.isBlank(branchId)){
           branchId=rztAgencyMouldMapper.getBranchId(paramMap);
        }
        paramMap.put("branchId",branchId);
        params.put("branchId",branchId);
        List<Map<String, Object>> upRuleList = rztAgencyMouldMapper.getTemplateRule(paramMap);
        if(null == upRuleList || upRuleList.isEmpty()) {

//			防止代理上迁移 代理商参照模板无效，默认根据当前代理商生效模板匹配
            Map<String, Object> twoMap = new HashMap<>();
            twoMap.put("branchId",branchId);
            twoMap.put("status", "0");
            twoMap.put("agencyId",  MapUtils.getString(params, "agencyId"));
            upRuleList = rztAgencyMouldMapper.getTemplateRule(twoMap);
            if(null == upRuleList || upRuleList.isEmpty()) {
                result=new JsonResult();
                result.setCode("4001");
                result.setMsg("尚未设置分润规则，请设置分润规则");
                return result;
            }
        }
        //查找本级代理商
        paramMap.put("ruleId",  MapUtils.getString(params, "ruleId"));
        List<Map<String, Object>> agencyRuleList;
        if(StringUtils.isBlank(MapUtils.getString(params, "parentRuleId"))) {
            agencyRuleList=new ArrayList<>();
            agencyRuleList.addAll(upRuleList);
        }else {
            agencyRuleList = rztAgencyMouldMapper.getTemplateRule(paramMap);
        }
        if(null == agencyRuleList || agencyRuleList.isEmpty()) {
            result=new JsonResult();
            result.setCode("4001");
            if(StringUtils.isNotBlank(MapUtils.getString(params, "LessAgencyId"))) {
                result.setMsg("尚未设置分润规则，请设置分润规则");
            } else {
                result.setMsg("暂无分润规则，请联系上级分配分润规则");
            }
            return result;
        }
        //本级代理商和上级代理商
        for (int i = 0; i < agencyRuleList.size(); ++i) {
            //上级代理商
            for (int j = 0; j < upRuleList.size(); j++) {
                String agencyRule=MapUtils.getString(agencyRuleList.get(i),"SEQUENCE_ID","");
                String upAgencyRule=MapUtils.getString(upRuleList.get(j),"SEQUENCE_ID","");
                if (agencyRule.equals(upAgencyRule)) {
                    Map<String, Object> ruleMap = rztAgencyMouldMapper.getAgencyRule(
                            branchId,upAgencyRule);

                    BigDecimal b1 = ((BigDecimal)upRuleList.get(j).get("RULEVALUE"));
                    BigDecimal b2 =new BigDecimal(10);
                    BigDecimal b3 = ((BigDecimal)agencyRuleList.get(i).get("RULEVALUE"));

                    if(p1yuan.matcher(agencyRuleList.get(i).get("SPLITTING_MODE").toString()).find()) {
                        agencyRuleList.get(i).put("UNIT","元");
                    } else if(p2per.matcher(agencyRuleList.get(i).get("SPLITTING_MODE").toString()).find()) {
                        agencyRuleList.get(i).put("UNIT","%");
                    }

                    String unit = agencyRuleList.get(i).get("UNIT").toString();
                    switch (agencyRule){
                        case "1":
                            if(ruleMap!=null && !ruleMap.isEmpty()) {
                                b2 = (BigDecimal) ruleMap.get("RULESTART");
                            }
                            if("0".equals(upRuleList.get(j).get("RULEBEGIN"))) {
                                agencyRuleList.get(i).put("PAYSETTING","0元激活");
                            }  else {
                                agencyRuleList.get(i).put("PAYSETTING","金额"+upRuleList.get(j).get("RULEBEGIN")+"元");
                            }
                            if(0<b1.compareTo(b3)) {
                                agencyRuleList.get(i).put("UPSIDEDOWN_TYPE","1");
                                agencyRuleList.get(i).put("UPSIDEDOWN_DESC","该规则存在无法获得收益的情况,请联系上级设置！");
                            }
                            agencyRuleList.get(i).put("PARENTRULEVALUE","设置"+b2+unit+"~"+b1+unit+"之间");
                            agencyRuleList.get(i).put("RULEENDD",b1);
                            agencyRuleList.get(i).put("RULESTART",b2);
                            break;
                        case "3":
                            if(ruleMap!=null &&!ruleMap.isEmpty()) {
                                b2 = ((BigDecimal) ruleMap.get("RULEEND"));
                            }
                            if(0>b1.compareTo(b3)) {
                                agencyRuleList.get(i).put("UPSIDEDOWN_TYPE","1");
                                agencyRuleList.get(i).put("UPSIDEDOWN_DESC","该规则存在无法获得收益的情况,请联系上级设置！");
                            }
                            agencyRuleList.get(i).put("PAYSETTING","金额"+upRuleList.get(j).get("RULEBEGIN")+"-"+upRuleList.get(j).get("RULEEND")+"之间");
                            agencyRuleList.get(i).put("PARENTRULEVALUE","设置"+b1+unit+"~"+b2+unit+"之间");
                            agencyRuleList.get(i).put("RULEENDD",b2);
                            agencyRuleList.get(i).put("RULESTART",b1);
                            break;
                        case "4":
                            if(null==ruleMap || ruleMap.isEmpty()) {
                                b2 = new BigDecimal(0);
                            } else {
                                b2 = ((BigDecimal) ruleMap.get("RULEEND")).multiply(new BigDecimal(100));
                            }
                            if(0>b1.compareTo(b3)) {
                                agencyRuleList.get(i).put("UPSIDEDOWN_TYPE","1");
                                agencyRuleList.get(i).put("UPSIDEDOWN_DESC","该规则存在无法获得收益的情况,请联系上级设置！");
                            }
                            agencyRuleList.get(i).put("PAYSETTING","金额"+upRuleList.get(j).get("RULEBEGIN")+"-"+upRuleList.get(j).get("RULEEND")+"之间");
                            agencyRuleList.get(i).put("PARENTRULEVALUE","设置"+b1+unit+"~"+b2+unit+"之间");
                            agencyRuleList.get(i).put("RULEENDD",b2);
                            agencyRuleList.get(i).put("RULESTART",b1);
                            break;
                        case "5":
                        case "6":
                        case "2":
                            if(null==ruleMap || ruleMap.isEmpty()) {
                                b2 = new BigDecimal(0);
                            } else {
                                b2 = ((BigDecimal) ruleMap.get("RULESTART")).multiply(new BigDecimal(100));
                            }
                            if(0<b1.compareTo(b3)) {
                                agencyRuleList.get(i).put("UPSIDEDOWN_TYPE","1");
                                agencyRuleList.get(i).put("UPSIDEDOWN_DESC","该规则存在无法获得收益的情况,请联系上级设置！");
                            }
                            agencyRuleList.get(i).put("PAYSETTING","金额"+upRuleList.get(j).get("RULEBEGIN")+"-"+upRuleList.get(j).get("RULEEND")+"之间");
                            agencyRuleList.get(i).put("PARENTRULEVALUE","设置"+b2+unit+"~"+b1+unit+"之间");
                            agencyRuleList.get(i).put("RULEENDD",b1);
                            agencyRuleList.get(i).put("RULESTART",b2);
                            break;
                        default:
                            break;

                    }
                    break;

                }
            }
        }

        List<Map<String, String>> batchList = rztAgencyMouldMapper.getBatch();
        List<Map<String, Object>> resultList = new ArrayList<>();
        result =new  JsonResult();
        if(null != batchList && !batchList.isEmpty()) {
            for(Map<String, String> batmap : batchList) {
                Map<String, Object> resultMap = new HashMap<>();
                List<Map<String, Object>> ruleList = new ArrayList<>();
                for(Map<String, Object> ruleMap : agencyRuleList){
                    if(batmap.get("BATCH_ID").equals(ruleMap.get("BATCH_ID"))){
                        ruleList.add(ruleMap);
                    }
                }
                if( ruleList.isEmpty()) {
                    continue;
                }
                resultMap.put("BATCHNAME", batmap.get("NAME"));
                resultMap.put("BATCHVALUE", ruleList);
                resultList.add(resultMap);
            }
            result.setCode("0000");
            result.setMsg("查询成功");
            result.setResult(resultList);
        } else {
            result.setCode("0000");
            result.setMsg("查询成功");
            result.setResult(agencyRuleList);
        }
        return result;
    }

}

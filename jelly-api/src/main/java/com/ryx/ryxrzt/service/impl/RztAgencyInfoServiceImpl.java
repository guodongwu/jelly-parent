package com.ryx.ryxrzt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ryx.ryxrzt.entity.RztAgencyFreezeLs;
import com.ryx.ryxrzt.entity.RztAgencyInfo;
import com.ryx.ryxrzt.entity.RztBranch;
import com.ryx.ryxrzt.entity.SysDictionaryBasic;
import com.ryx.ryxrzt.mapper.RztAgencyInfoMapper;
import com.ryx.ryxrzt.service.RztAgencyInfoService;
import com.ryx.ryxrzt.vo.AgencyInfoVo;
import com.ryx.utils.ConstantUtil;
import com.ryx.utils.JsonResult;
import com.ryx.utils.SysDictionaryBasicEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class RztAgencyInfoServiceImpl implements RztAgencyInfoService{
    @Resource
    private RztAgencyInfoMapper rztAgencyInfoMapper;

    @Override
    public JsonResult getRztAgencyInfoList(AgencyInfoVo agencyInfoVo,Integer page,Integer limit) {
        JsonResult jsonResult = new JsonResult();
        PageHelper.startPage(page,limit);
        //查询代理商信息
        List<AgencyInfoVo> list = rztAgencyInfoMapper.getRztAgencyInfoList(agencyInfoVo);
        PageInfo pageInfo = new PageInfo(list);
        long total = pageInfo.getTotal();
        HashMap map = new HashMap();
        map.put("list",list);
        map.put("total",total);
        if (list.size() > 0){
            jsonResult.setResult(map);
            jsonResult.setCode(ConstantUtil.SUCCESS_CODE);
            jsonResult.setMsg(ConstantUtil.QUERY_SUCCESS_MSG);
            return jsonResult;
        }else{
            jsonResult.setResult(list);
            jsonResult.setCode(ConstantUtil.FAIL_CODE);
            jsonResult.setMsg("没有查询到代理商信息！");
            return jsonResult;
        }
    }

    @Override
    public JsonResult setRztAgencyDirect(AgencyInfoVo agencyInfoVo) {
        JsonResult jsonResult = new JsonResult();
        //修改代理商直签标识 + 等级
        agencyInfoVo.setDirect(BigDecimal.valueOf(1));
        agencyInfoVo.setLevelType("10C");
        boolean flag = rztAgencyInfoMapper.setRztAgencyDirect(agencyInfoVo);
        if (flag){
            jsonResult.setCode(ConstantUtil.SUCCESS_CODE);
            jsonResult.setMsg("设置直签成功");
            return jsonResult;
        }else{
            jsonResult.setCode(ConstantUtil.FAIL_CODE);
            jsonResult.setMsg("设置直签失败");
            return jsonResult;
        }
    }

    @Override
    public JsonResult getAgencyInfoByAgencyId(String agencyId) {
        JsonResult jsonResult = new JsonResult();
        //查询下级代理商
        List<RztAgencyInfo>  list = rztAgencyInfoMapper.getAgencyInfoByAgencyId(agencyId);
        if (list.size() > 0){
            jsonResult.setResult(list);
            jsonResult.setCode(ConstantUtil.SUCCESS_CODE);
            jsonResult.setMsg(ConstantUtil.QUERY_SUCCESS_MSG);
            return jsonResult;
        }else{
            jsonResult.setResult(list);
            jsonResult.setCode(ConstantUtil.FAIL_CODE);
            jsonResult.setMsg("没有查询到下级代理商信息！");
            return jsonResult;
        }
    }

    @Override
    public JsonResult setAgencyFreeze(RztAgencyInfo rztAgencyInfo, HttpServletRequest request) {
        JsonResult jsonResult = new JsonResult();
        rztAgencyInfo.setFreeze(BigDecimal.valueOf(1));
        //修改rzt_agency_info冻结状态以及冻结关系
        boolean flag = rztAgencyInfoMapper.setAgencyFreeze(rztAgencyInfo);
        //判断冻结关系
        if (rztAgencyInfo.getFreezeRelation().equals(BigDecimal.valueOf(0))){
            //冻结本级
            if (flag){
                //修改冻结流水信息
                RztAgencyFreezeLs rztAgencyFreezeLs = new RztAgencyFreezeLs();
                rztAgencyFreezeLs.setFreeze("1");
                rztAgencyFreezeLs.setFreezeRelation("0");
                String agencyId = (String) request.getSession().getAttribute("id");
                rztAgencyFreezeLs.setFreezePerson(agencyId);
                rztAgencyFreezeLs.setFreezedPerson(rztAgencyInfo.getAgencyId());
                Date s = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                String date = simpleDateFormat.format(s);
                rztAgencyFreezeLs.setIndate(date);
                //添加冻结流水表
                boolean  flag1 = rztAgencyInfoMapper.insertAgencyFreezeLs(rztAgencyFreezeLs);
                if (flag1){
                    jsonResult.setCode(ConstantUtil.SUCCESS_CODE);
                    jsonResult.setMsg("冻结本级代理商成功");
                    return jsonResult;
                }else{
                    jsonResult.setCode(ConstantUtil.FAIL_CODE);
                    jsonResult.setMsg("冻结本级代理商失败");
                    return jsonResult;
                }
            }else{
                jsonResult.setCode("4001");
                jsonResult.setMsg("修改冻结状态与冻结关系失败");
                return jsonResult;
            }
        }else if(rztAgencyInfo.getFreezeRelation().equals(BigDecimal.valueOf(1))){  //级联冻结代理商
            if (flag){
                //修改冻结流水信息
                RztAgencyFreezeLs rztAgencyFreezeLs = new RztAgencyFreezeLs();
                rztAgencyFreezeLs.setFreeze("1");
                rztAgencyFreezeLs.setFreezeRelation("1");
                String agencyId = (String) request.getSession().getAttribute("id");
                rztAgencyFreezeLs.setFreezePerson(agencyId);
                rztAgencyFreezeLs.setFreezedPerson(rztAgencyInfo.getAgencyId());
                Date s = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                String date = simpleDateFormat.format(s);
                rztAgencyFreezeLs.setIndate(date);
                //添加冻结流水表
                boolean  flag1 = rztAgencyInfoMapper.insertAgencyFreezeLs(rztAgencyFreezeLs);
                if (flag1){
                    jsonResult.setCode(ConstantUtil.SUCCESS_CODE);
                    jsonResult.setMsg("级联冻结代理商成功");
                    return jsonResult;
                }else{
                    jsonResult.setCode(ConstantUtil.FAIL_CODE);
                    jsonResult.setMsg("级联冻结代理商失败");
                    return jsonResult;
                }
            }else{
                jsonResult.setCode("4001");
                jsonResult.setMsg("修改冻结状态与冻结关系失败");
                return jsonResult;
            }
        }else{
            jsonResult.setCode(ConstantUtil.FAIL_CODE);
            jsonResult.setMsg("冻结关系为空");
            return jsonResult;
        }
    }

    @Override
    public JsonResult setAgencyUnFreeze(RztAgencyInfo rztAgencyInfo, HttpServletRequest request) {
        JsonResult jsonResult = new JsonResult();
        rztAgencyInfo.setFreeze(BigDecimal.valueOf(0));
        //修改rzt_agency_info冻结状态以及冻结关系
        boolean flag = rztAgencyInfoMapper.setAgencyFreeze(rztAgencyInfo);
        //判断冻结关系
        if (rztAgencyInfo.getFreezeRelation().equals(BigDecimal.valueOf(0))){
            //解冻本级
            if (flag){
                //修改冻结流水信息
                RztAgencyFreezeLs rztAgencyFreezeLs = new RztAgencyFreezeLs();
                rztAgencyFreezeLs.setFreeze("0");
                rztAgencyFreezeLs.setFreezeRelation("0");
                String agencyId = (String) request.getSession().getAttribute("id");
                rztAgencyFreezeLs.setFreezePerson(agencyId);
                rztAgencyFreezeLs.setFreezedPerson(rztAgencyInfo.getAgencyId());
                Date s = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                String date = simpleDateFormat.format(s);
                rztAgencyFreezeLs.setIndate(date);
                //添加冻结流水表
                boolean  flag1 = rztAgencyInfoMapper.insertAgencyFreezeLs(rztAgencyFreezeLs);
                if (flag1){
                    jsonResult.setCode(ConstantUtil.SUCCESS_CODE);
                    jsonResult.setMsg("解冻本级代理商成功");
                    return jsonResult;
                }else{
                    jsonResult.setCode(ConstantUtil.FAIL_CODE);
                    jsonResult.setMsg("解冻本级代理商失败");
                    return jsonResult;
                }
            }else{
                jsonResult.setCode("4001");
                jsonResult.setMsg("修改冻结状态与冻结关系失败");
                return jsonResult;
            }
        }else if(rztAgencyInfo.getFreezeRelation().equals(BigDecimal.valueOf(1))){  //级联解冻代理商
            if (flag){
                //修改冻结流水信息
                RztAgencyFreezeLs rztAgencyFreezeLs = new RztAgencyFreezeLs();
                rztAgencyFreezeLs.setFreeze("0");
                rztAgencyFreezeLs.setFreezeRelation("1");
                String agencyId = (String) request.getSession().getAttribute("id");
                rztAgencyFreezeLs.setFreezePerson(agencyId);
                rztAgencyFreezeLs.setFreezedPerson(rztAgencyInfo.getAgencyId());
                Date s = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                String date = simpleDateFormat.format(s);
                rztAgencyFreezeLs.setIndate(date);
                //添加冻结流水表
                boolean  flag1 = rztAgencyInfoMapper.insertAgencyFreezeLs(rztAgencyFreezeLs);
                if (flag1){
                    jsonResult.setCode(ConstantUtil.SUCCESS_CODE);
                    jsonResult.setMsg("级联解冻代理商成功");
                    return jsonResult;
                }else{
                    jsonResult.setCode(ConstantUtil.FAIL_CODE);
                    jsonResult.setMsg("级联解冻代理商失败");
                    return jsonResult;
                }
            }else{
                jsonResult.setCode("4001");
                jsonResult.setMsg("修改冻结状态与冻结关系失败");
                return jsonResult;
            }
        }else{
            jsonResult.setCode(ConstantUtil.FAIL_CODE);
            jsonResult.setMsg("冻结关系为空");
            return jsonResult;
        }
    }
    @Override
    public JsonResult getSelectList() {
        JsonResult jsonResult = new JsonResult();
        HashMap map = new HashMap();
        //查询品牌表信息
        List<RztBranch>  branchList = rztAgencyInfoMapper.getRztBranch();
        //查询所有机构
        List<AgencyInfoVo> appUserList = rztAgencyInfoMapper.getAppUserList();
        //查询字典表数据（下拉框）
        List<SysDictionaryBasic> levelTypeList = rztAgencyInfoMapper.getSelectList(SysDictionaryBasicEnum.LEVEL_TYPE.name());//代理商层级
        List<SysDictionaryBasic> directList = rztAgencyInfoMapper.getSelectList(SysDictionaryBasicEnum.DIRECT.name());//是否直签
        List<SysDictionaryBasic> statusList = rztAgencyInfoMapper.getSelectList(SysDictionaryBasicEnum.STATUS.name());//代理商状态
        map.put("branchList",branchList);
        map.put("appUserList",appUserList);
        map.put("levelTypeList",levelTypeList);
        map.put("directList",directList);
        map.put("statusList",statusList);
        if (map.size() != 0){
            jsonResult.setCode(ConstantUtil.SUCCESS_CODE);
            jsonResult.setMsg("查询下拉框成功");
            jsonResult.setResult(map);
            return jsonResult;
        }else{
            jsonResult.setCode(ConstantUtil.FAIL_CODE);
            jsonResult.setMsg("查询下拉框失败");
            jsonResult.setResult(map);
            return jsonResult;
        }
    }

    @Override
    public JsonResult getAgencyInfoAllSonByAgencyId(String agencyId) {
        //查询所有下级代理商信息
        JsonResult jsonResult = new JsonResult();
        List<RztAgencyInfo> list = rztAgencyInfoMapper.getAgencyInfoAllSonByAgencyId(agencyId);
        if (list.size() > 0){
            jsonResult.setResult(list);
            jsonResult.setCode(ConstantUtil.SUCCESS_CODE);
            jsonResult.setMsg("查询所有下级代理商信息成功！");
            return jsonResult;
        }else{
            jsonResult.setResult(list);
            jsonResult.setCode(ConstantUtil.FAIL_CODE);
            jsonResult.setMsg("没有查询到所有下级代理商信息！");
            return jsonResult;
        }
    }

    @Override
    public AgencyInfoVo getAgencyByAgencyId(AgencyInfoVo agencyInfoVo) {
        //查询代理商相关信息根据agencyId
        AgencyInfoVo agency = rztAgencyInfoMapper.getAgencyByAgencyId(agencyInfoVo);
        //获取字典表数据代理商层级
        List<SysDictionaryBasic> levelTypeList = rztAgencyInfoMapper.getSelectList(SysDictionaryBasicEnum.LEVEL_TYPE.name());
        //遍历将代理商名称后追加层级
        for (SysDictionaryBasic l:levelTypeList) {
            if (l.getValue().equals(agency.getLevelType())){
                agency.setAgencyName(agency.getAgencyName() + "("+l.getText() +")");
            }
        }
        return agency;
    }

    @Override
    public String getAgencyInfoAllParentByAgencyId(AgencyInfoVo agencyInfoVo) {
        //查询代理商所有上级关系根据agencyId
        List<AgencyInfoVo> list = rztAgencyInfoMapper.getAgencyInfoAllParentByAgencyId(agencyInfoVo);
        //倒序遍历上级关系
        Collections.reverse(list);
        //获取字典表数据代理商层级
        List<SysDictionaryBasic> levelTypeList = rztAgencyInfoMapper.getSelectList(SysDictionaryBasicEnum.LEVEL_TYPE.name());
        StringBuilder string = new StringBuilder();
        for (AgencyInfoVo agency:list) {
            for (SysDictionaryBasic l:levelTypeList) {
                if (l.getValue().equals(agency.getLevelType())){
                    agency.setAgencyName(agency.getAgencyName() + "(" + l.getText() + ")" + "->");
                    string.append(agency.getAgencyName());
                }
            }
        }
        //切除最后一个 ->
        string.setLength(string.length()-2);
        String cjgx = string.toString();
        return cjgx;
    }

}

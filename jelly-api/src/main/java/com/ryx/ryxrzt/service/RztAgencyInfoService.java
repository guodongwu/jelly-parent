package com.ryx.ryxrzt.service;

import com.ryx.ryxrzt.entity.RztAgencyInfo;
import com.ryx.ryxrzt.vo.AgencyInfoVo;
import com.ryx.utils.JsonResult;

import javax.servlet.http.HttpServletRequest;


public interface RztAgencyInfoService {
    JsonResult getRztAgencyInfoList(AgencyInfoVo agencyInfoVo,Integer page,Integer limit);

    JsonResult setRztAgencyDirect(AgencyInfoVo agencyInfoVo);

    JsonResult getAgencyInfoByAgencyId(String agencyId);

    JsonResult setAgencyFreeze(RztAgencyInfo rztAgencyInfo,HttpServletRequest request);

    JsonResult setAgencyUnFreeze(RztAgencyInfo rztAgencyInfo, HttpServletRequest request);

    JsonResult getSelectList();

    JsonResult getAgencyInfoAllSonByAgencyId(String agencyId);

    String getAgencyInfoAllParentByAgencyId(AgencyInfoVo agencyInfoVo);

    AgencyInfoVo getAgencyByAgencyId(AgencyInfoVo agencyInfoVo);
}

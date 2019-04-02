package com.ryx.ryxrzt.mapper;

import com.ryx.ryxrzt.entity.RztAgencyFreezeLs;
import com.ryx.ryxrzt.entity.RztAgencyInfo;
import com.ryx.ryxrzt.entity.RztBranch;
import com.ryx.ryxrzt.entity.SysDictionaryBasic;
import com.ryx.ryxrzt.vo.AgencyInfoVo;
import com.ryx.utils.SysDictionaryBasicEnum;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RztAgencyInfoMapper {
    List<AgencyInfoVo> getRztAgencyInfoList(AgencyInfoVo agencyInfoVo);

    boolean setRztAgencyDirect(AgencyInfoVo agencyInfoVo);

    List<RztAgencyInfo> getAgencyInfoByAgencyId(String agencyId);

    boolean insertAgencyFreezeLs(RztAgencyFreezeLs rztAgencyFreezeLs);

    boolean setAgencyFreeze(RztAgencyInfo rztAgencyInfo);

    List<RztAgencyInfo> getAgencyInfoAllSonByAgencyId(String agencyId);

    List<RztBranch> getRztBranch();

    List<SysDictionaryBasic> getSelectList(String name);

    AgencyInfoVo getAgencyByAgencyId(AgencyInfoVo agencyInfoVo);

    List<AgencyInfoVo> getAgencyInfoAllParentByAgencyId(AgencyInfoVo agencyInfoVo);

    List<AgencyInfoVo> getAppUserList();
}

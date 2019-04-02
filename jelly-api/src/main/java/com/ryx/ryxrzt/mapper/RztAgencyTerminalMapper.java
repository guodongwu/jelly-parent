package com.ryx.ryxrzt.mapper;

import java.util.List;
import java.util.Map;

import com.ryx.ryxrzt.vo.AgencyInfoVo;
import com.ryx.ryxrzt.vo.RztAgencyTerminalInfoVo;
import com.ryx.ryxrzt.vo.RztBranchVo;
import com.ryx.ryxrzt.vo.RztTerminalBatchAllotVo;

public interface RztAgencyTerminalMapper {
	public List<RztAgencyTerminalInfoVo> getRztAgencyTerminalInfoList(Map<String, Object> map);
	public List<RztBranchVo> getRztBranchInfoList(Map<String, Object> map);
	public RztAgencyTerminalInfoVo getRztAgencyTerminalInfoByTerminalNo(Map<String, Object> map);
	public List<AgencyInfoVo> getRztOneLevelAgencyAndDirectAgencyByBranch(Map<String, Object> map);
	public String getRztTerminalNoPrefixByBranch(Map<String, Object> map);
	public List<AgencyInfoVo> getRztAgencyInfoListByLevelType(Map<String, Object> map);
	public List<RztTerminalBatchAllotVo> getRztTerminalBatchAllotListByCondition(Map<String, Object> map);
}

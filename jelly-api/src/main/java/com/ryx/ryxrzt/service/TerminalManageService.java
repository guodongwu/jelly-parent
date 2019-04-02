package com.ryx.ryxrzt.service;

import java.util.Map;

import com.ryx.utils.JsonResult;

public interface TerminalManageService {
	public JsonResult getRztAgencyTerminalInfoList(Map<String, Object> map);
	public JsonResult getRztBranchAndTerminalStatusInfoList(Map<String, Object> map);
	public JsonResult getRztAgencyTerminalInfoByTerminalNo(Map<String, Object> map);
	public JsonResult getRztOneLevelAgencyAndDirectAgencyByBranch(Map<String, Object> map);
	public JsonResult getRztTerminalNoPrefixByBranch(Map<String, Object> map);
	public JsonResult getRztAgencyInfoListByLevelType(Map<String, Object> map);
	public JsonResult getRztTerminalBatchAllotListByCondition(Map<String, Object> map);
}

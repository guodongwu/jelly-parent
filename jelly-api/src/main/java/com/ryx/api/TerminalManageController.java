package com.ryx.api;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ryx.ryxrzt.service.TerminalManageService;
import com.ryx.ryxrzt.vo.RequestBodyVo;
import com.ryx.utils.ConstantUtil;
import com.ryx.utils.JsonResult;
import com.ryx.utils.RequestUtil;
@CrossOrigin
@Controller
@RequestMapping("/terminal")
public class TerminalManageController {
	private static final Logger log = LoggerFactory.getLogger(TerminalManageController.class);
	@Autowired
	private TerminalManageService terminalManageService;
	
	/**
	 * 获取终端列表
	 * @param equestBodyVo
	 * @param request
	 * @return
	 */
	@RequestMapping(value="getRztAgencyTerminalInfoList")
	@ResponseBody
	public JsonResult getRztAgencyTerminalInfoList(@RequestBody RequestBodyVo requestBodyVo, HttpServletRequest request) {
		Map<String, String> params = RequestUtil.getParamsToMap(request);
		log.info("TerminalManageController.getRztAgencyTerminalInfoList："+JSON.toJSONString(params));
		log.info("TerminalManageController.getRztAgencyTerminalInfoList："+JSON.toJSONString(requestBodyVo));
		JsonResult result = new JsonResult();
		try {
//			String agencyId = params.get("agencyId");
			String agencyId = requestBodyVo.getAgencyId();
			int page = requestBodyVo.getPage();
			int limit = requestBodyVo.getLimit();
//			if (StringUtils.isBlank(agencyId)) {
//				result.setCode("1001");
//				result.setMsg("渠道编号不可为空");
//				return result;
//			}
			if (page<1) {
				page = 1;
			}
			if (limit>1000) {
				limit = 1000;
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("agencyId", agencyId);
			map.put("page", page);
			map.put("limit", limit);
			result = terminalManageService.getRztAgencyTerminalInfoList(map);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("TerminalManageController.getRztAgencyTerminalInfoList",e);
			result.setCode(ConstantUtil.FAIL_CODE);
			result.setMsg(ConstantUtil.QUERY_FAIL_MSG);
			return result;
		}
	}
	
	/**
	 * 获取终端列表查询条件枚举值
	 * @param request
	 * @return
	 */
	@RequestMapping(value="getRztBranchAndTerminalStatusInfoList")
	@ResponseBody
	public JsonResult getRztBranchAndTerminalStatusInfoList(HttpServletRequest request) {
		JsonResult result = new JsonResult();
		try {
			result = terminalManageService.getRztBranchAndTerminalStatusInfoList(null);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("TerminalManageController.getRztBranchAndTerminalStatusInfoList",e);
			result.setCode(ConstantUtil.FAIL_CODE);
			result.setMsg(ConstantUtil.QUERY_FAIL_MSG);
			return result;
		}
	}
	
	/**
	 * 获取终端详情
	 * @param equestBodyVo
	 * @param request
	 * @return
	 */
	@RequestMapping(value="getRztAgencyTerminalInfoByTerminalNo")
	@ResponseBody
	public JsonResult getRztAgencyTerminalInfoByTerminalNo(HttpServletRequest request) {
		Map<String, String> params = RequestUtil.getParamsToMap(request);
		log.info("TerminalManageController.getRztAgencyTerminalInfoList："+JSON.toJSONString(params));
//		log.info("TerminalManageController.getRztAgencyTerminalInfoList："+JSON.toJSONString(equestBodyVo));
		JsonResult result = new JsonResult();
		try {
			String terminalNo = params.get("terminalNo");
			if (StringUtils.isBlank(terminalNo)) {
				result.setCode("1001");
				result.setMsg("终端号不可为空");
				return result;
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("terminalNo", terminalNo);
			result = terminalManageService.getRztAgencyTerminalInfoByTerminalNo(map);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("TerminalManageController.getRztAgencyTerminalInfoList",e);
			result.setCode(ConstantUtil.FAIL_CODE);
			result.setMsg(ConstantUtil.QUERY_FAIL_MSG);
			return result;
		}
	}
	
	/**
	 * 获取一个品牌的一代和所有直签，必须要有分润模板的渠道
	 * @param request
	 * @return
	 */
	@RequestMapping(value="getRztOneLevelAgencyAndDirectAgencyByBranch")
	@ResponseBody
	public JsonResult getRztOneLevelAgencyAndDirectAgencyByBranch(HttpServletRequest request) {
		Map<String, String> params = RequestUtil.getParamsToMap(request);
		JsonResult result = new JsonResult();
		try {
			String agencyId = params.get("agencyId");
			if (StringUtils.isBlank(agencyId)) {
				result.setCode("1001");
				result.setMsg("渠道编号不可为空");
				return result;
			}
			String branchId = params.get("branchId");
			if (StringUtils.isBlank(branchId)) {
				result.setCode("1002");
				result.setMsg("品牌号不可为空");
				return result;
			}
			String agencyName = params.get("agencyName");
			String page = params.get("page");
			String limit = params.get("limit");
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("agencyId", agencyId);
			paramMap.put("branchId", branchId);
			paramMap.put("page", page);
			paramMap.put("limit", limit);
			if (!StringUtils.isBlank(agencyName)) {
				paramMap.put("agencyName", agencyName);
			}
			result = terminalManageService.getRztOneLevelAgencyAndDirectAgencyByBranch(paramMap);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("TerminalManageController.getRztOneLevelAgencyAndDirectAgencyByBranch",e);
			result.setCode(ConstantUtil.FAIL_CODE);
			result.setMsg(ConstantUtil.QUERY_FAIL_MSG);
			return result;
		}
	}
	
	/**
	 * 根据品牌获取终端号前置配置
	 * @param request
	 * @return
	 */
	@RequestMapping(value="getRztTerminalNoPrefixByBranch")
	@ResponseBody
	public JsonResult getRztTerminalNoPrefixByBranch(HttpServletRequest request) {
		Map<String, String> params = RequestUtil.getParamsToMap(request);
		JsonResult result = new JsonResult();
		try {
			String branchId = params.get("branchId");
			if (StringUtils.isBlank(branchId)) {
				result.setCode("1001");
				result.setMsg("品牌号不可为空");
				return result;
			}
			String rztParamId = "terminalNoPrefix_" + branchId;
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("rztParamId", rztParamId);
			result = terminalManageService.getRztTerminalNoPrefixByBranch(paramMap);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("TerminalManageController.getRztTerminalNoPrefixByBranch",e);
			result.setCode(ConstantUtil.FAIL_CODE);
			result.setMsg(ConstantUtil.QUERY_FAIL_MSG);
			return result;
		}
	}
	
	/**
	 * 获取所有机构信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="getRztAgencyInfoListByLevelType")
	@ResponseBody
	public JsonResult getRztAgencyInfoListByLevelType(HttpServletRequest request) {
		JsonResult result = new JsonResult();
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("levelType", "10A");
			result = terminalManageService.getRztAgencyInfoListByLevelType(paramMap);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("TerminalManageController.getRztAgencyInfoListByLevelType",e);
			result.setCode(ConstantUtil.FAIL_CODE);
			result.setMsg(ConstantUtil.QUERY_FAIL_MSG);
			return result;
		}
	}
}

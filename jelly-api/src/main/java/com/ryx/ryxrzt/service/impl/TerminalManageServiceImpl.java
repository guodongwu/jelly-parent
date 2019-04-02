package com.ryx.ryxrzt.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ryx.ryxpay.mapper.RyxTerminalMapper;
import com.ryx.ryxpay.vo.RyxpayTerminalRateInfoVo;
import com.ryx.ryxrzt.mapper.RztAgencyTerminalMapper;
import com.ryx.ryxrzt.service.TerminalManageService;
import com.ryx.ryxrzt.vo.AgencyInfoVo;
import com.ryx.ryxrzt.vo.RztAgencyTerminalInfoVo;
import com.ryx.ryxrzt.vo.RztBranchVo;
import com.ryx.ryxrzt.vo.RztTerminalBatchAllotVo;
import com.ryx.utils.ConstantUtil;
import com.ryx.utils.ContentFormatUtil;
import com.ryx.utils.JsonResult;
import com.ryx.utils.NumberFormatUtil;
@Service
public class TerminalManageServiceImpl implements TerminalManageService{
	@Autowired
	private RztAgencyTerminalMapper rztAgencyTerminalMapper;
	@Autowired
	private RyxTerminalMapper ryxTerminalMapper;
	
	@Override
	public JsonResult getRztAgencyTerminalInfoList(Map<String, Object> map) {
		JsonResult result = new JsonResult();
		result.setCode(ConstantUtil.SUCCESS_CODE);
		result.setMsg(ConstantUtil.QUERY_SUCCESS_MSG);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int pageNum = Integer.parseInt(map.get("page").toString());
		int pageSize = Integer.parseInt(map.get("limit").toString());
		PageHelper.startPage(pageNum, pageSize);
		List<RztAgencyTerminalInfoVo> list = rztAgencyTerminalMapper.getRztAgencyTerminalInfoList(map);
		if (list!=null&&list.size()>0) {
			for (RztAgencyTerminalInfoVo vo : list) {
				vo.setBranchName(vo.getBranchName()==null?"":vo.getBranchName());
				vo.setTerminalBatchName(vo.getTerminalBatchName()==null?"":vo.getTerminalBatchName());
				vo.setAgencyName(vo.getAgencyName()==null?"":vo.getAgencyName());
				vo.setTerminalNo(vo.getTerminalNo()==null?"":vo.getTerminalNo());
				vo.setTerminalStatus(vo.getTerminalStatus()==null?"":vo.getTerminalStatus());
				vo.setMerchantPhone(vo.getMerchantPhone()==null?"":vo.getMerchantPhone());
				vo.setTransferDate(ContentFormatUtil.handleDateFormat(vo.getTransferDate()));
				vo.setActiveDate(ContentFormatUtil.handleDateFormat(vo.getActiveDate()));
				vo.setMerchantName(vo.getMerchantName()==null?"":vo.getMerchantName());
				vo.setIsCashback(vo.getIsCashback()==null?"":vo.getIsCashback());
				vo.setCashbackTime(ContentFormatUtil.handleDateFormat(vo.getCashbackTime()));
				vo.setCashbackFailReason(vo.getCashbackFailReason()==null?"":vo.getCashbackFailReason());
			}
		} else {
			list = new ArrayList<RztAgencyTerminalInfoVo>();
		}
		PageInfo<RztAgencyTerminalInfoVo> pageInfo = new PageInfo<RztAgencyTerminalInfoVo>(list);
		resultMap.put("items", list);
		resultMap.put("terminalInfoListSize", list.size());
		resultMap.put("total", pageInfo.getTotal());
		result.setResult(resultMap);
		return result;
	}

	@Override
	public JsonResult getRztBranchAndTerminalStatusInfoList(Map<String, Object> map) {
		JsonResult result = new JsonResult();
		result.setCode(ConstantUtil.SUCCESS_CODE);
		result.setMsg(ConstantUtil.QUERY_SUCCESS_MSG);
		List<RztBranchVo> list = rztAgencyTerminalMapper.getRztBranchInfoList(map);
		if (list!=null&&list.size()>0) {
			for (RztBranchVo vo : list) {
				vo.setBranchId(vo.getBranchId()==null?"":vo.getBranchId());
				vo.setBranchName(vo.getBranchName()==null?"":vo.getBranchName());
			}
		} else {
			list = new ArrayList<RztBranchVo>();
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("branchList", list);
		List<Map<String, String>> terminalStatusList = new ArrayList<Map<String,String>>();
		Map<String, String> terminalStatusMap1 = new HashMap<String, String>();
		terminalStatusMap1.put("terminalStatus", "0");
		terminalStatusMap1.put("terminalStatusName", "未激活");
		Map<String, String> terminalStatusMap2 = new HashMap<String, String>();
		terminalStatusMap2.put("terminalStatus", "1");
		terminalStatusMap2.put("terminalStatusName", "已绑定");
		Map<String, String> terminalStatusMap3 = new HashMap<String, String>();
		terminalStatusMap3.put("terminalStatus", "2");
		terminalStatusMap3.put("terminalStatusName", "已激活");
		terminalStatusList.add(terminalStatusMap1);
		terminalStatusList.add(terminalStatusMap2);
		terminalStatusList.add(terminalStatusMap3);
		resultMap.put("terminalStatusList", terminalStatusList);
		List<Map<String, String>> terminalFreezeStatusList = new ArrayList<Map<String,String>>();
		Map<String, String> terminalFreezeStatusMap1 = new HashMap<String, String>();
		terminalFreezeStatusMap1.put("terminalFreezeStatus", "0");
		terminalFreezeStatusMap1.put("terminalFreezeStatusName", "未冻结");
		Map<String, String> terminalFreezeStatusMap2 = new HashMap<String, String>();
		terminalFreezeStatusMap2.put("terminalFreezeStatus", "1");
		terminalFreezeStatusMap2.put("terminalFreezeStatusName", "已冻结");
		terminalFreezeStatusList.add(terminalFreezeStatusMap1);
		terminalFreezeStatusList.add(terminalFreezeStatusMap2);
		resultMap.put("terminalFreezeStatusList", terminalFreezeStatusList);
		result.setResult(resultMap);
		return result;
	}

	@Override
	public JsonResult getRztAgencyTerminalInfoByTerminalNo(
			Map<String, Object> map) {
		JsonResult result = new JsonResult();
		result.setCode(ConstantUtil.SUCCESS_CODE);
		result.setMsg(ConstantUtil.QUERY_SUCCESS_MSG);
		Map<String, Object> resultMap = new HashMap<String, Object>();
//		查询终端信息
		RztAgencyTerminalInfoVo vo = rztAgencyTerminalMapper.
				getRztAgencyTerminalInfoByTerminalNo(map);
		vo.setBranchName(vo.getBranchName()==null?"":vo.getBranchName());
		vo.setTerminalBatchName(vo.getTerminalBatchName()==null?"":vo.getTerminalBatchName());
		vo.setAgencyName(vo.getAgencyName()==null?"":vo.getAgencyName());
		vo.setTerminalNo(vo.getTerminalNo()==null?"":vo.getTerminalNo());
		vo.setTerminalStatus(vo.getTerminalStatus()==null?"":vo.getTerminalStatus());
		vo.setMerchantPhone(vo.getMerchantPhone()==null?"":vo.getMerchantPhone());
		vo.setTransferDate(ContentFormatUtil.handleDateFormat(vo.getTransferDate()));
		vo.setActiveDate(ContentFormatUtil.handleDateFormat(vo.getActiveDate()));
		vo.setMerchantName(vo.getMerchantName()==null?"":vo.getMerchantName());
		vo.setIsCashback(vo.getIsCashback()==null?"":vo.getIsCashback());
		vo.setCashbackTime(ContentFormatUtil.handleDateFormat(vo.getCashbackTime()));
		vo.setCashbackFailReason(vo.getCashbackFailReason()==null?"":vo.getCashbackFailReason());
		vo.setTerminalPolicyName(vo.getTerminalPolicyName()==null?"":vo.getTerminalPolicyName());
		vo.setReturnAmount(vo.getReturnAmount()==null?"":
			NumberFormatUtil.keepTwoDecimalPlacesRoundUp(vo.getReturnAmount()));
		resultMap.put("rztAgencyTerminalInfoList", vo);
		result.setResult(resultMap);
		if (StringUtils.isBlank(vo.getBranchId())) {
			resultMap.put("terminalRateInfoList", new ArrayList<RyxpayTerminalRateInfoVo>());
			return result;
		}
//		查询费率信息
//		查询云闪付
		String appUser = vo.getAppUser();
		String branchId = vo.getBranchId();
		String terminalNo = (String) map.get("terminalNo");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("appUser", appUser);
		paramMap.put("terminalType", "04");
		List<RyxpayTerminalRateInfoVo> ryxpayTerminalRateInfoVoList04 = ryxTerminalMapper.
				getTerminalRateByType04(paramMap);
		List<RyxpayTerminalRateInfoVo> ryxpayTerminalRateInfoVoList01 = null;
		if ("00800130".equals(branchId)) {
			paramMap.put("branchId", branchId);
			paramMap.put("terminalNo", terminalNo);
			String customerLevel = ryxTerminalMapper.getCustomerLevel(paramMap);
			if (StringUtils.isBlank(customerLevel)) {
				customerLevel = "ryx_level_0";
			}
			paramMap.put("appUser", customerLevel);
			paramMap.put("terminalType", "01");
			ryxpayTerminalRateInfoVoList01 = ryxTerminalMapper.getTerminalRateByType01(paramMap);
		} else {
			paramMap.put("appUser", terminalNo);
			paramMap.put("terminalType", "01");
			ryxpayTerminalRateInfoVoList01 = ryxTerminalMapper.getTerminalRateByType01(paramMap);
			if (ryxpayTerminalRateInfoVoList01==null||ryxpayTerminalRateInfoVoList01.size()==0) {
				paramMap.put("appUser", appUser);
				ryxpayTerminalRateInfoVoList01 = ryxTerminalMapper.getTerminalRateByType01(paramMap);
			}
		}
		if (ryxpayTerminalRateInfoVoList01 == null) {
			ryxpayTerminalRateInfoVoList01 = new ArrayList<RyxpayTerminalRateInfoVo>();
		}
		if (ryxpayTerminalRateInfoVoList04!=null&&ryxpayTerminalRateInfoVoList04.size()>0) {
			ryxpayTerminalRateInfoVoList01.addAll(ryxpayTerminalRateInfoVoList04);
		}
		for (RyxpayTerminalRateInfoVo rateInfoVo : ryxpayTerminalRateInfoVoList01) {
			if (rateInfoVo.getTradeTypeName()==null) {
				rateInfoVo.setTradeTypeName("");
			}
			if (rateInfoVo.getFeeRate()==null) {
				rateInfoVo.setFeeRate("0.00");
			} else {
				rateInfoVo.setFeeRate(NumberFormatUtil.keepTwoDecimalPlacesRoundUp(rateInfoVo.getFeeRate()));
			}
			if (rateInfoVo.getFeeFixed()==null) {
				rateInfoVo.setFeeFixed("0");
			}
		}
		resultMap.put("terminalRateInfoList", ryxpayTerminalRateInfoVoList01);
		return result;
	}

	@Override
	public JsonResult getRztOneLevelAgencyAndDirectAgencyByBranch(
			Map<String, Object> map) {
		JsonResult result = new JsonResult();
		result.setCode(ConstantUtil.SUCCESS_CODE);
		result.setMsg(ConstantUtil.QUERY_SUCCESS_MSG);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int pageNum = Integer.parseInt(map.get("page").toString());
		int pageSize = Integer.parseInt(map.get("limit").toString());
		PageHelper.startPage(pageNum, pageSize);
		List<AgencyInfoVo> agencyInfoList = rztAgencyTerminalMapper.
				getRztOneLevelAgencyAndDirectAgencyByBranch(map);
		PageInfo<AgencyInfoVo> pageInfo = new PageInfo<AgencyInfoVo>(agencyInfoList);
		resultMap.put("agencyInfoList", agencyInfoList.size());
		resultMap.put("total", pageInfo.getTotal());
		for (AgencyInfoVo agencyInfoVo : agencyInfoList) {
			if (agencyInfoVo.getAgencyId()==null) {
				agencyInfoVo.setAgencyId("");
			}
			if (StringUtils.isBlank(agencyInfoVo.getAgencyName())) {
				agencyInfoVo.setAgencyName("未实名");
			}
			if (agencyInfoVo.getMobile()==null) {
				agencyInfoVo.setMobile("");
			}
		}
		resultMap.put("items", agencyInfoList);
//		resultMap.put("agencyInfoList", agencyInfoList);
		result.setResult(resultMap);
		return result;
	}

	@Override
	public JsonResult getRztTerminalNoPrefixByBranch(Map<String, Object> map) {
		JsonResult result = new JsonResult();
		result.setCode(ConstantUtil.SUCCESS_CODE);
		result.setMsg(ConstantUtil.QUERY_SUCCESS_MSG);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String terminalNoPrefix = rztAgencyTerminalMapper.getRztTerminalNoPrefixByBranch(map);
		if (terminalNoPrefix==null) {
			terminalNoPrefix="";
		}
		resultMap.put("terminalNoPrefix", terminalNoPrefix);
		result.setResult(resultMap);
		return result;
	}

	@Override
	public JsonResult getRztAgencyInfoListByLevelType(Map<String, Object> map) {
		JsonResult result = new JsonResult();
		result.setCode(ConstantUtil.SUCCESS_CODE);
		result.setMsg(ConstantUtil.QUERY_SUCCESS_MSG);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<AgencyInfoVo> agencyInfoList = rztAgencyTerminalMapper.getRztAgencyInfoListByLevelType(map);
		for (AgencyInfoVo agencyInfoVo : agencyInfoList) {
			if (agencyInfoVo.getAgencyId()==null) {
				agencyInfoVo.setAgencyId("");
			}
			if (StringUtils.isBlank(agencyInfoVo.getAgencyName())) {
				agencyInfoVo.setAgencyName("未实名");
			}
			if (agencyInfoVo.getMobile()==null) {
				agencyInfoVo.setMobile("");
			}
		}
		resultMap.put("agencyInfoList", agencyInfoList);
		result.setResult(resultMap);
		return result;
	}

	@Override
	public JsonResult getRztTerminalBatchAllotListByCondition(
			Map<String, Object> map) {
		JsonResult result = new JsonResult();
		result.setCode(ConstantUtil.SUCCESS_CODE);
		result.setMsg(ConstantUtil.QUERY_SUCCESS_MSG);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<RztTerminalBatchAllotVo> rztTerminalBatchAllotList = rztAgencyTerminalMapper.
				getRztTerminalBatchAllotListByCondition(map);
		for (RztTerminalBatchAllotVo vo : rztTerminalBatchAllotList) {
			if (vo.getBranchName()==null) {
				vo.setBranchName("");
			}
			if (StringUtils.isBlank(vo.getBranchAgencyName())) {
				vo.setBranchAgencyName("未认证");
			}
			if (StringUtils.isBlank(vo.getAgencyName())) {
				vo.setAgencyName("未认证");
			}
			if (StringUtils.isBlank(vo.getAllotNum())) {
				vo.setAllotNum("0");
			}
			if (vo.getAllotTime()!=null) {
				vo.setAllotTime(ContentFormatUtil.handleDateFormat(vo.getAllotTime()));
			} else {
				vo.setAllotTime("");
			}
		}
		result.setResult(resultMap);
		return result;
	}
}

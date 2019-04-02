package com.ryx.ryxpay.mapper;
import java.util.List;
import java.util.Map;

import com.ryx.ryxpay.vo.RyxpayTerminalRateInfoVo;
public interface RyxTerminalMapper {
	public List<RyxpayTerminalRateInfoVo> getTerminalRateByType04(Map<String, Object> map);
	public List<RyxpayTerminalRateInfoVo> getTerminalRateByType01(Map<String, Object> map);
	public String getCustomerLevel(Map<String, Object> map);
}

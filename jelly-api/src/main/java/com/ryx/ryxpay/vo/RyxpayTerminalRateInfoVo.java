package com.ryx.ryxpay.vo;

public class RyxpayTerminalRateInfoVo {
	private String tradeTypeName;
	private String feeRate;
	private String feeFixed;
	
	public RyxpayTerminalRateInfoVo() {
		
	}
	
	public String getTradeTypeName() {
		return tradeTypeName;
	}
	
	public void setTradeTypeName(String tradeTypeName) {
		this.tradeTypeName = tradeTypeName;
	}

	public String getFeeRate() {
		return feeRate;
	}

	public void setFeeRate(String feeRate) {
		this.feeRate = feeRate;
	}

	public String getFeeFixed() {
		return feeFixed;
	}

	public void setFeeFixed(String feeFixed) {
		this.feeFixed = feeFixed;
	}

	@Override
	public String toString() {
		return "RyxpayTerminalRateInfoVo [tradeTypeName=" + tradeTypeName
				+ ", feeRate=" + feeRate + ", feeFixed=" + feeFixed + "]";
	}
}

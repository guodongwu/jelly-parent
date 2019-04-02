package com.ryx.ryxrzt.vo;

public class RztBranchVo {
	private String branchId;
	private String branchName;
	
	public RztBranchVo() {

	}
	
	public String getBranchId() {
		return branchId;
	}
	
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	
	public String getBranchName() {
		return branchName;
	}
	
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	@Override
	public String toString() {
		return "RztBranchVo [branchId=" + branchId + ", branchName="
				+ branchName + "]";
	}
}

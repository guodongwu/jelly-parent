package com.ryx.ryxrzt.entity;

import java.io.Serializable;

public class RztBranch implements Serializable {
    private String branchid;

    private String appuser;

    private String name;

    private String icon;

    private String termRateFlag;

    private String termPledgeFlag;

    private String agencyInviteUrl;

    private String merchantInviteUrl;

    public String getBranchid() {
        return branchid;
    }

    public void setBranchid(String branchid) {
        this.branchid = branchid == null ? null : branchid.trim();
    }

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser == null ? null : appuser.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getTermRateFlag() {
        return termRateFlag;
    }

    public void setTermRateFlag(String termRateFlag) {
        this.termRateFlag = termRateFlag == null ? null : termRateFlag.trim();
    }

    public String getTermPledgeFlag() {
        return termPledgeFlag;
    }

    public void setTermPledgeFlag(String termPledgeFlag) {
        this.termPledgeFlag = termPledgeFlag == null ? null : termPledgeFlag.trim();
    }

    public String getAgencyInviteUrl() {
        return agencyInviteUrl;
    }

    public void setAgencyInviteUrl(String agencyInviteUrl) {
        this.agencyInviteUrl = agencyInviteUrl == null ? null : agencyInviteUrl.trim();
    }

    public String getMerchantInviteUrl() {
        return merchantInviteUrl;
    }

    public void setMerchantInviteUrl(String merchantInviteUrl) {
        this.merchantInviteUrl = merchantInviteUrl == null ? null : merchantInviteUrl.trim();
    }
}
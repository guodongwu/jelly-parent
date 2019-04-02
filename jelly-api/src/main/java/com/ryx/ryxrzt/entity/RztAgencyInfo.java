package com.ryx.ryxrzt.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class RztAgencyInfo implements Serializable {
    private String agencyId;

    private String createDate;

    private String updateDate;

    private String mobile;

    private String agencyName;

    private String parentAgencyId;

    private String parental;

    private String codeVal;

    private String codeUrl;

    private String codePic;

    private String agencyCode;

    private String parentAgencyCode;

    private String appuser;

    private BigDecimal agencyLevel;

    private String branchid;

    private BigDecimal freeze;

    private BigDecimal freezeRelation;

    private String freezePerson;

    private String merchantInviteUrl;

    private BigDecimal direct;

    private BigDecimal termCount;

    private String levelType;

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getParentAgencyId() {
        return parentAgencyId;
    }

    public void setParentAgencyId(String parentAgencyId) {
        this.parentAgencyId = parentAgencyId;
    }

    public String getParental() {
        return parental;
    }

    public void setParental(String parental) {
        this.parental = parental;
    }

    public String getCodeVal() {
        return codeVal;
    }

    public void setCodeVal(String codeVal) {
        this.codeVal = codeVal;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

    public String getCodePic() {
        return codePic;
    }

    public void setCodePic(String codePic) {
        this.codePic = codePic;
    }

    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
    }

    public String getParentAgencyCode() {
        return parentAgencyCode;
    }

    public void setParentAgencyCode(String parentAgencyCode) {
        this.parentAgencyCode = parentAgencyCode;
    }

    public String getAppuser() {
        return appuser;
    }

    public void setAppuser(String appuser) {
        this.appuser = appuser;
    }

    public BigDecimal getAgencyLevel() {
        return agencyLevel;
    }

    public void setAgencyLevel(BigDecimal agencyLevel) {
        this.agencyLevel = agencyLevel;
    }

    public String getBranchid() {
        return branchid;
    }

    public void setBranchid(String branchid) {
        this.branchid = branchid;
    }

    public BigDecimal getFreeze() {
        return freeze;
    }

    public void setFreeze(BigDecimal freeze) {
        this.freeze = freeze;
    }

    public BigDecimal getFreezeRelation() {
        return freezeRelation;
    }

    public void setFreezeRelation(BigDecimal freezeRelation) {
        this.freezeRelation = freezeRelation;
    }

    public String getFreezePerson() {
        return freezePerson;
    }

    public void setFreezePerson(String freezePerson) {
        this.freezePerson = freezePerson;
    }

    public String getMerchantInviteUrl() {
        return merchantInviteUrl;
    }

    public void setMerchantInviteUrl(String merchantInviteUrl) {
        this.merchantInviteUrl = merchantInviteUrl;
    }

    public BigDecimal getDirect() {
        return direct;
    }

    public void setDirect(BigDecimal direct) {
        this.direct = direct;
    }

    public BigDecimal getTermCount() {
        return termCount;
    }

    public void setTermCount(BigDecimal termCount) {
        this.termCount = termCount;
    }

    public String getLevelType() {
        return levelType;
    }

    public void setLevelType(String levelType) {
        this.levelType = levelType;
    }
}
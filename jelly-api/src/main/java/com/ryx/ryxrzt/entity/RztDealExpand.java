package com.ryx.ryxrzt.entity;

import java.io.Serializable;

public class RztDealExpand implements Serializable {

    private String branchId;
    private String termId;
    private String dealTypeId;
    private String dealTypeName;
    private String customerMobile;
    private String customerName;
    private String dealDate;
    private String amount;
    private String onlyCode;
    private String customerId;
    private String fee;
    private String agencyName;
    private String branchName;


    private String frAmt;

    public String getFrAmt() {
        return this.frAmt;
    }

    public void setFrAmt(final String frAmt) {
        this.frAmt = frAmt;
    }

    public String getBranchName() {
        return this.branchName;
    }

    public void setBranchName(final String branchName) {
        this.branchName = branchName;
    }

    public String getBranchId() {
        return this.branchId;
    }

    public void setBranchId(final String branchId) {
        this.branchId = branchId;
    }

    public String getTermId() {
        return this.termId;
    }

    public void setTermId(final String termId) {
        this.termId = termId;
    }

    public String getDealTypeId() {
        return this.dealTypeId;
    }

    public void setDealTypeId(final String dealTypeId) {
        this.dealTypeId = dealTypeId;
    }

    public String getDealTypeName() {
        return this.dealTypeName;
    }

    public void setDealTypeName(final String dealTypeName) {
        this.dealTypeName = dealTypeName;
    }

    public String getCustomerMobile() {
        return this.customerMobile;
    }

    public void setCustomerMobile(final String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(final String customerName) {
        this.customerName = customerName;
    }

    public String getDealDate() {
        return this.dealDate;
    }

    public void setDealDate(final String dealDate) {
        this.dealDate = dealDate;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(final String amount) {
        this.amount = amount;
    }

    public String getOnlyCode() {
        return this.onlyCode;
    }

    public void setOnlyCode(final String onlyCode) {
        this.onlyCode = onlyCode;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(final String customerId) {
        this.customerId = customerId;
    }

    public String getFee() {
        return this.fee;
    }

    public void setFee(final String fee) {
        this.fee = fee;
    }

    public String getAgencyName() {
        return this.agencyName;
    }

    public void setAgencyName(final String agencyName) {
        this.agencyName = agencyName;
    }


}

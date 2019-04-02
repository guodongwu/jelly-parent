package com.ryx.ryxrzt.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class RztDealVo extends BaseRowModel {

    @ExcelProperty(value = "终端编号",index = 0)
    private String termId;
    @ExcelProperty(value = "交易流水号",index = 1)
    private String onlyCode;
    @ExcelProperty(value = "交易日期",index = 2)
    private String dealDate;
    @ExcelProperty(value = "交易类型",index = 3)
    private String dealTypeName;
    @ExcelProperty(value = "交易金额",index = 4)
    private String amount;
    @ExcelProperty(value = "手续费",index = 5)
    private String fee;
    @ExcelProperty(value = "分润金额",index = 6)
    private String frAmt;
    @ExcelProperty(value = "品牌" ,index = 7)
    private String branchName;
    @ExcelProperty(value = "商户A号" ,index = 8)
    private String customerId;
    @ExcelProperty(value = "商户名称" ,index =9)
    private String customerName;
    @ExcelProperty(value = "商户手机号" ,index =10)
    private String customerMobile;
    @ExcelProperty(value = "代理商" ,index = 11)
    private String agencyName;

    public String getTermId() {
        return this.termId;
    }

    public void setTermId(final String termId) {
        this.termId = termId;
    }

    public String getOnlyCode() {
        return this.onlyCode;
    }

    public void setOnlyCode(final String onlyCode) {
        this.onlyCode = onlyCode;
    }

    public String getDealDate() {
        return this.dealDate;
    }

    public void setDealDate(final String dealDate) {
        this.dealDate = dealDate;
    }

    public String getDealTypeName() {
        return this.dealTypeName;
    }

    public void setDealTypeName(final String dealTypeName) {
        this.dealTypeName = dealTypeName;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(final String amount) {
        this.amount = amount;
    }

    public String getFee() {
        return this.fee;
    }

    public void setFee(final String fee) {
        this.fee = fee;
    }

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

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(final String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(final String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMobile() {
        return this.customerMobile;
    }

    public void setCustomerMobile(final String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getAgencyName() {
        return this.agencyName;
    }

    public void setAgencyName(final String agencyName) {
        this.agencyName = agencyName;
    }
}

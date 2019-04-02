package com.ryx.ryxpay.entity;

import java.io.Serializable;

public class RyxTermOrder  implements Serializable {
    /**
     * 品牌名称
     */
    private String branchName;
    /**
     * 商户名
     */
    private String userName;
    /**
     * 商户手机号
     */
    private String userPhoneNumber;
    /**
     * 终端编号
     */
    private String termid;
    /**
     * 金额
     */
    private String amount;
    /**
     * 订单状态
     */
    private String orderStatus;
    /**
     * 支付类型
     */
    private String tradeMode;
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 订货日期
     */
    private String ordercDate;
    /**
     * 发货日期
     */
    private String wayDate;

    /**
     * 收货人
     */
    private String consignee;
    /**
     * 省份
     */
    private String province;
    /**
     * 城市
     */
    private String city;
    /**
     * 收货人手机号
     */
    private String consigneePhone;
    /**
     * 收货地址
     */
    private String address;
    /**
     * 物流公司
     */
    private String expressCompany;
    /**
     * 物流编号
     */
    private String waybill;


    private int page=1;
    private int startRownum;
    private int endRownum;


    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getTermid() {
        return termid;
    }

    public void setTermid(String termid) {
        this.termid = termid;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getTradeMode() {
        return tradeMode;
    }

    public void setTradeMode(String tradeMode) {
        this.tradeMode = tradeMode;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrdercDate() {
        return ordercDate;
    }

    public void setOrdercDate(String ordercDate) {
        this.ordercDate = ordercDate;
    }

    public String getWayDate() {
        return wayDate;
    }

    public void setWayDate(String wayDate) {
        this.wayDate = wayDate;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getStartRownum() {
        return startRownum;
    }

    public void setStartRownum(int startRownum) {
        this.startRownum = startRownum;
    }

    public int getEndRownum() {
        return endRownum;
    }

    public void setEndRownum(int endRownum) {
        this.endRownum = endRownum;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getConsigneePhone() {
        return consigneePhone;
    }

    public void setConsigneePhone(String consigneePhone) {
        this.consigneePhone = consigneePhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getExpressCompany() {
        return expressCompany;
    }

    public void setExpressCompany(String expressCompany) {
        this.expressCompany = expressCompany;
    }

    public String getWaybill() {
        return waybill;
    }

    public void setWaybill(String waybill) {
        this.waybill = waybill;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
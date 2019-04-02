package com.ryx.ryxpay.entity;

import java.math.BigDecimal;

public class PayBindBankCard2Key {
    private String customerid;

    private BigDecimal cardidx;

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid == null ? null : customerid.trim();
    }

    public BigDecimal getCardidx() {
        return cardidx;
    }

    public void setCardidx(BigDecimal cardidx) {
        this.cardidx = cardidx;
    }
}
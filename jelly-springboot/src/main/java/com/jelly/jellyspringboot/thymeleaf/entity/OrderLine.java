package com.jelly.jellyspringboot.thymeleaf.entity;

import java.math.BigDecimal;

public class OrderLine {
    private  Product product;
    private Integer amount;
    private BigDecimal purchasePrice;
    public  OrderLine(){}

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}

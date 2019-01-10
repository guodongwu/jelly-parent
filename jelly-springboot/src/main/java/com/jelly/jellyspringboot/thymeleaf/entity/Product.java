package com.jelly.jellyspringboot.thymeleaf.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Product {
    private  Integer id;
    private String  name;
    private BigDecimal price;
    private  Boolean inStock;
    private List<Comment> comments=new ArrayList<>();
    public  Product(){}
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Product(Integer id, String name, Boolean inStock, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }



}

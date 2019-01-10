package com.jelly.jellyspringboot.thymeleaf.entity;

import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;

public class Order {
    private Integer id;
    private Calendar date;
    private Customer customer;

    public Order(Integer id, Calendar date, Customer customer, Set<OrderLine> orderLines) {
        this.id = id;
        this.date = date;
        this.customer = customer;
        this.orderLines = orderLines;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(Set<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    private Set<OrderLine> orderLines=new LinkedHashSet<OrderLine>();

    public Order() {
    }
}

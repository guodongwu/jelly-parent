package com.jelly.esper.entity;

public class Address {
    private  String home;
    private  String company;
    private  String zip;

    public  Address(){}
    public  Address(String home)
    {
        this.home=home;
    }
    @Override
    public String toString() {
        return "Address{" +
                "home='" + home + '\'' +
                ", company='" + company + '\'' +
                ", zip='" + zip + '\'' +
                ", other='" + other + '\'' +
                '}';
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    private String other;
}

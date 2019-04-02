package com.ryx.ryxpay.entity;

import java.io.Serializable;

/**
 * PAYBANKINFO
 * @author 
 */
public class PayBankInfo implements Serializable {
    private String banktype;

    private String provinceid;

    private String provincename;

    private String cityid;

    private String cityname;

    private String bankid;

    private String bankname;

    private String banknameshort;

    private String bankbranchid;

    private String bankbranchname;

    private String bankaddress;

    private String liqbankid;

    private String liqbankcityid;

    private String flag;

    private String bankcityid;

    private String bankpostcode;

    private String telnum;

    private String setupdate;

    private String upbankid;

    private String headbankid;

    private static final long serialVersionUID = 1L;

    public String getBanktype() {
        return banktype;
    }

    public void setBanktype(String banktype) {
        this.banktype = banktype;
    }

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid;
    }

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getBankid() {
        return bankid;
    }

    public void setBankid(String bankid) {
        this.bankid = bankid;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getBanknameshort() {
        return banknameshort;
    }

    public void setBanknameshort(String banknameshort) {
        this.banknameshort = banknameshort;
    }

    public String getBankbranchid() {
        return bankbranchid;
    }

    public void setBankbranchid(String bankbranchid) {
        this.bankbranchid = bankbranchid;
    }

    public String getBankbranchname() {
        return bankbranchname;
    }

    public void setBankbranchname(String bankbranchname) {
        this.bankbranchname = bankbranchname;
    }

    public String getBankaddress() {
        return bankaddress;
    }

    public void setBankaddress(String bankaddress) {
        this.bankaddress = bankaddress;
    }

    public String getLiqbankid() {
        return liqbankid;
    }

    public void setLiqbankid(String liqbankid) {
        this.liqbankid = liqbankid;
    }

    public String getLiqbankcityid() {
        return liqbankcityid;
    }

    public void setLiqbankcityid(String liqbankcityid) {
        this.liqbankcityid = liqbankcityid;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getBankcityid() {
        return bankcityid;
    }

    public void setBankcityid(String bankcityid) {
        this.bankcityid = bankcityid;
    }

    public String getBankpostcode() {
        return bankpostcode;
    }

    public void setBankpostcode(String bankpostcode) {
        this.bankpostcode = bankpostcode;
    }

    public String getTelnum() {
        return telnum;
    }

    public void setTelnum(String telnum) {
        this.telnum = telnum;
    }

    public String getSetupdate() {
        return setupdate;
    }

    public void setSetupdate(String setupdate) {
        this.setupdate = setupdate;
    }

    public String getUpbankid() {
        return upbankid;
    }

    public void setUpbankid(String upbankid) {
        this.upbankid = upbankid;
    }

    public String getHeadbankid() {
        return headbankid;
    }

    public void setHeadbankid(String headbankid) {
        this.headbankid = headbankid;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PayBankInfo other = (PayBankInfo) that;
        return (this.getBanktype() == null ? other.getBanktype() == null : this.getBanktype().equals(other.getBanktype()))
            && (this.getProvinceid() == null ? other.getProvinceid() == null : this.getProvinceid().equals(other.getProvinceid()))
            && (this.getProvincename() == null ? other.getProvincename() == null : this.getProvincename().equals(other.getProvincename()))
            && (this.getCityid() == null ? other.getCityid() == null : this.getCityid().equals(other.getCityid()))
            && (this.getCityname() == null ? other.getCityname() == null : this.getCityname().equals(other.getCityname()))
            && (this.getBankid() == null ? other.getBankid() == null : this.getBankid().equals(other.getBankid()))
            && (this.getBankname() == null ? other.getBankname() == null : this.getBankname().equals(other.getBankname()))
            && (this.getBanknameshort() == null ? other.getBanknameshort() == null : this.getBanknameshort().equals(other.getBanknameshort()))
            && (this.getBankbranchid() == null ? other.getBankbranchid() == null : this.getBankbranchid().equals(other.getBankbranchid()))
            && (this.getBankbranchname() == null ? other.getBankbranchname() == null : this.getBankbranchname().equals(other.getBankbranchname()))
            && (this.getBankaddress() == null ? other.getBankaddress() == null : this.getBankaddress().equals(other.getBankaddress()))
            && (this.getLiqbankid() == null ? other.getLiqbankid() == null : this.getLiqbankid().equals(other.getLiqbankid()))
            && (this.getLiqbankcityid() == null ? other.getLiqbankcityid() == null : this.getLiqbankcityid().equals(other.getLiqbankcityid()))
            && (this.getFlag() == null ? other.getFlag() == null : this.getFlag().equals(other.getFlag()))
            && (this.getBankcityid() == null ? other.getBankcityid() == null : this.getBankcityid().equals(other.getBankcityid()))
            && (this.getBankpostcode() == null ? other.getBankpostcode() == null : this.getBankpostcode().equals(other.getBankpostcode()))
            && (this.getTelnum() == null ? other.getTelnum() == null : this.getTelnum().equals(other.getTelnum()))
            && (this.getSetupdate() == null ? other.getSetupdate() == null : this.getSetupdate().equals(other.getSetupdate()))
            && (this.getUpbankid() == null ? other.getUpbankid() == null : this.getUpbankid().equals(other.getUpbankid()))
            && (this.getHeadbankid() == null ? other.getHeadbankid() == null : this.getHeadbankid().equals(other.getHeadbankid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBanktype() == null) ? 0 : getBanktype().hashCode());
        result = prime * result + ((getProvinceid() == null) ? 0 : getProvinceid().hashCode());
        result = prime * result + ((getProvincename() == null) ? 0 : getProvincename().hashCode());
        result = prime * result + ((getCityid() == null) ? 0 : getCityid().hashCode());
        result = prime * result + ((getCityname() == null) ? 0 : getCityname().hashCode());
        result = prime * result + ((getBankid() == null) ? 0 : getBankid().hashCode());
        result = prime * result + ((getBankname() == null) ? 0 : getBankname().hashCode());
        result = prime * result + ((getBanknameshort() == null) ? 0 : getBanknameshort().hashCode());
        result = prime * result + ((getBankbranchid() == null) ? 0 : getBankbranchid().hashCode());
        result = prime * result + ((getBankbranchname() == null) ? 0 : getBankbranchname().hashCode());
        result = prime * result + ((getBankaddress() == null) ? 0 : getBankaddress().hashCode());
        result = prime * result + ((getLiqbankid() == null) ? 0 : getLiqbankid().hashCode());
        result = prime * result + ((getLiqbankcityid() == null) ? 0 : getLiqbankcityid().hashCode());
        result = prime * result + ((getFlag() == null) ? 0 : getFlag().hashCode());
        result = prime * result + ((getBankcityid() == null) ? 0 : getBankcityid().hashCode());
        result = prime * result + ((getBankpostcode() == null) ? 0 : getBankpostcode().hashCode());
        result = prime * result + ((getTelnum() == null) ? 0 : getTelnum().hashCode());
        result = prime * result + ((getSetupdate() == null) ? 0 : getSetupdate().hashCode());
        result = prime * result + ((getUpbankid() == null) ? 0 : getUpbankid().hashCode());
        result = prime * result + ((getHeadbankid() == null) ? 0 : getHeadbankid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", banktype=").append(banktype);
        sb.append(", provinceid=").append(provinceid);
        sb.append(", provincename=").append(provincename);
        sb.append(", cityid=").append(cityid);
        sb.append(", cityname=").append(cityname);
        sb.append(", bankid=").append(bankid);
        sb.append(", bankname=").append(bankname);
        sb.append(", banknameshort=").append(banknameshort);
        sb.append(", bankbranchid=").append(bankbranchid);
        sb.append(", bankbranchname=").append(bankbranchname);
        sb.append(", bankaddress=").append(bankaddress);
        sb.append(", liqbankid=").append(liqbankid);
        sb.append(", liqbankcityid=").append(liqbankcityid);
        sb.append(", flag=").append(flag);
        sb.append(", bankcityid=").append(bankcityid);
        sb.append(", bankpostcode=").append(bankpostcode);
        sb.append(", telnum=").append(telnum);
        sb.append(", setupdate=").append(setupdate);
        sb.append(", upbankid=").append(upbankid);
        sb.append(", headbankid=").append(headbankid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
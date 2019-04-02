package com.ryx.ryxpay.entity;

public class RyxTermBrand {
    private String id;

    private String name;

    private String merchantSelect;

    private String termRate;

    private String termPrice;

    private String icon;

    private String brandNote;

    private String policyNote;

    private String appUser;

    private String inviteUrl;

    private String channelMerchId;

    private String channelAgentId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMerchantSelect() {
        return merchantSelect;
    }

    public void setMerchantSelect(String merchantSelect) {
        this.merchantSelect = merchantSelect == null ? null : merchantSelect.trim();
    }

    public String getTermRate() {
        return termRate;
    }

    public void setTermRate(String termRate) {
        this.termRate = termRate == null ? null : termRate.trim();
    }

    public String getTermPrice() {
        return termPrice;
    }

    public void setTermPrice(String termPrice) {
        this.termPrice = termPrice == null ? null : termPrice.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getBrandNote() {
        return brandNote;
    }

    public void setBrandNote(String brandNote) {
        this.brandNote = brandNote == null ? null : brandNote.trim();
    }

    public String getPolicyNote() {
        return policyNote;
    }

    public void setPolicyNote(String policyNote) {
        this.policyNote = policyNote == null ? null : policyNote.trim();
    }

    public String getAppUser() {
        return appUser;
    }

    public void setAppUser(String appUser) {
        this.appUser = appUser == null ? null : appUser.trim();
    }

    public String getInviteUrl() {
        return inviteUrl;
    }

    public void setInviteUrl(String inviteUrl) {
        this.inviteUrl = inviteUrl == null ? null : inviteUrl.trim();
    }

    public String getChannelMerchId() {
        return channelMerchId;
    }

    public void setChannelMerchId(String channelMerchId) {
        this.channelMerchId = channelMerchId == null ? null : channelMerchId.trim();
    }

    public String getChannelAgentId() {
        return channelAgentId;
    }

    public void setChannelAgentId(String channelAgentId) {
        this.channelAgentId = channelAgentId == null ? null : channelAgentId.trim();
    }
}
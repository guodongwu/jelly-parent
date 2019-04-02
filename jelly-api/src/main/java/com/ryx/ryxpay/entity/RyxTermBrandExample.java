package com.ryx.ryxpay.entity;

import java.util.ArrayList;
import java.util.List;

public class RyxTermBrandExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RyxTermBrandExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andMerchantSelectIsNull() {
            addCriterion("MERCHANT_SELECT is null");
            return (Criteria) this;
        }

        public Criteria andMerchantSelectIsNotNull() {
            addCriterion("MERCHANT_SELECT is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantSelectEqualTo(String value) {
            addCriterion("MERCHANT_SELECT =", value, "merchantSelect");
            return (Criteria) this;
        }

        public Criteria andMerchantSelectNotEqualTo(String value) {
            addCriterion("MERCHANT_SELECT <>", value, "merchantSelect");
            return (Criteria) this;
        }

        public Criteria andMerchantSelectGreaterThan(String value) {
            addCriterion("MERCHANT_SELECT >", value, "merchantSelect");
            return (Criteria) this;
        }

        public Criteria andMerchantSelectGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT_SELECT >=", value, "merchantSelect");
            return (Criteria) this;
        }

        public Criteria andMerchantSelectLessThan(String value) {
            addCriterion("MERCHANT_SELECT <", value, "merchantSelect");
            return (Criteria) this;
        }

        public Criteria andMerchantSelectLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT_SELECT <=", value, "merchantSelect");
            return (Criteria) this;
        }

        public Criteria andMerchantSelectLike(String value) {
            addCriterion("MERCHANT_SELECT like", value, "merchantSelect");
            return (Criteria) this;
        }

        public Criteria andMerchantSelectNotLike(String value) {
            addCriterion("MERCHANT_SELECT not like", value, "merchantSelect");
            return (Criteria) this;
        }

        public Criteria andMerchantSelectIn(List<String> values) {
            addCriterion("MERCHANT_SELECT in", values, "merchantSelect");
            return (Criteria) this;
        }

        public Criteria andMerchantSelectNotIn(List<String> values) {
            addCriterion("MERCHANT_SELECT not in", values, "merchantSelect");
            return (Criteria) this;
        }

        public Criteria andMerchantSelectBetween(String value1, String value2) {
            addCriterion("MERCHANT_SELECT between", value1, value2, "merchantSelect");
            return (Criteria) this;
        }

        public Criteria andMerchantSelectNotBetween(String value1, String value2) {
            addCriterion("MERCHANT_SELECT not between", value1, value2, "merchantSelect");
            return (Criteria) this;
        }

        public Criteria andTermRateIsNull() {
            addCriterion("TERM_RATE is null");
            return (Criteria) this;
        }

        public Criteria andTermRateIsNotNull() {
            addCriterion("TERM_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andTermRateEqualTo(String value) {
            addCriterion("TERM_RATE =", value, "termRate");
            return (Criteria) this;
        }

        public Criteria andTermRateNotEqualTo(String value) {
            addCriterion("TERM_RATE <>", value, "termRate");
            return (Criteria) this;
        }

        public Criteria andTermRateGreaterThan(String value) {
            addCriterion("TERM_RATE >", value, "termRate");
            return (Criteria) this;
        }

        public Criteria andTermRateGreaterThanOrEqualTo(String value) {
            addCriterion("TERM_RATE >=", value, "termRate");
            return (Criteria) this;
        }

        public Criteria andTermRateLessThan(String value) {
            addCriterion("TERM_RATE <", value, "termRate");
            return (Criteria) this;
        }

        public Criteria andTermRateLessThanOrEqualTo(String value) {
            addCriterion("TERM_RATE <=", value, "termRate");
            return (Criteria) this;
        }

        public Criteria andTermRateLike(String value) {
            addCriterion("TERM_RATE like", value, "termRate");
            return (Criteria) this;
        }

        public Criteria andTermRateNotLike(String value) {
            addCriterion("TERM_RATE not like", value, "termRate");
            return (Criteria) this;
        }

        public Criteria andTermRateIn(List<String> values) {
            addCriterion("TERM_RATE in", values, "termRate");
            return (Criteria) this;
        }

        public Criteria andTermRateNotIn(List<String> values) {
            addCriterion("TERM_RATE not in", values, "termRate");
            return (Criteria) this;
        }

        public Criteria andTermRateBetween(String value1, String value2) {
            addCriterion("TERM_RATE between", value1, value2, "termRate");
            return (Criteria) this;
        }

        public Criteria andTermRateNotBetween(String value1, String value2) {
            addCriterion("TERM_RATE not between", value1, value2, "termRate");
            return (Criteria) this;
        }

        public Criteria andTermPriceIsNull() {
            addCriterion("TERM_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andTermPriceIsNotNull() {
            addCriterion("TERM_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andTermPriceEqualTo(String value) {
            addCriterion("TERM_PRICE =", value, "termPrice");
            return (Criteria) this;
        }

        public Criteria andTermPriceNotEqualTo(String value) {
            addCriterion("TERM_PRICE <>", value, "termPrice");
            return (Criteria) this;
        }

        public Criteria andTermPriceGreaterThan(String value) {
            addCriterion("TERM_PRICE >", value, "termPrice");
            return (Criteria) this;
        }

        public Criteria andTermPriceGreaterThanOrEqualTo(String value) {
            addCriterion("TERM_PRICE >=", value, "termPrice");
            return (Criteria) this;
        }

        public Criteria andTermPriceLessThan(String value) {
            addCriterion("TERM_PRICE <", value, "termPrice");
            return (Criteria) this;
        }

        public Criteria andTermPriceLessThanOrEqualTo(String value) {
            addCriterion("TERM_PRICE <=", value, "termPrice");
            return (Criteria) this;
        }

        public Criteria andTermPriceLike(String value) {
            addCriterion("TERM_PRICE like", value, "termPrice");
            return (Criteria) this;
        }

        public Criteria andTermPriceNotLike(String value) {
            addCriterion("TERM_PRICE not like", value, "termPrice");
            return (Criteria) this;
        }

        public Criteria andTermPriceIn(List<String> values) {
            addCriterion("TERM_PRICE in", values, "termPrice");
            return (Criteria) this;
        }

        public Criteria andTermPriceNotIn(List<String> values) {
            addCriterion("TERM_PRICE not in", values, "termPrice");
            return (Criteria) this;
        }

        public Criteria andTermPriceBetween(String value1, String value2) {
            addCriterion("TERM_PRICE between", value1, value2, "termPrice");
            return (Criteria) this;
        }

        public Criteria andTermPriceNotBetween(String value1, String value2) {
            addCriterion("TERM_PRICE not between", value1, value2, "termPrice");
            return (Criteria) this;
        }

        public Criteria andIconIsNull() {
            addCriterion("ICON is null");
            return (Criteria) this;
        }

        public Criteria andIconIsNotNull() {
            addCriterion("ICON is not null");
            return (Criteria) this;
        }

        public Criteria andIconEqualTo(String value) {
            addCriterion("ICON =", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotEqualTo(String value) {
            addCriterion("ICON <>", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThan(String value) {
            addCriterion("ICON >", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            addCriterion("ICON >=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThan(String value) {
            addCriterion("ICON <", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            addCriterion("ICON <=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLike(String value) {
            addCriterion("ICON like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotLike(String value) {
            addCriterion("ICON not like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconIn(List<String> values) {
            addCriterion("ICON in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotIn(List<String> values) {
            addCriterion("ICON not in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconBetween(String value1, String value2) {
            addCriterion("ICON between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotBetween(String value1, String value2) {
            addCriterion("ICON not between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andBrandNoteIsNull() {
            addCriterion("BRAND_NOTE is null");
            return (Criteria) this;
        }

        public Criteria andBrandNoteIsNotNull() {
            addCriterion("BRAND_NOTE is not null");
            return (Criteria) this;
        }

        public Criteria andBrandNoteEqualTo(String value) {
            addCriterion("BRAND_NOTE =", value, "brandNote");
            return (Criteria) this;
        }

        public Criteria andBrandNoteNotEqualTo(String value) {
            addCriterion("BRAND_NOTE <>", value, "brandNote");
            return (Criteria) this;
        }

        public Criteria andBrandNoteGreaterThan(String value) {
            addCriterion("BRAND_NOTE >", value, "brandNote");
            return (Criteria) this;
        }

        public Criteria andBrandNoteGreaterThanOrEqualTo(String value) {
            addCriterion("BRAND_NOTE >=", value, "brandNote");
            return (Criteria) this;
        }

        public Criteria andBrandNoteLessThan(String value) {
            addCriterion("BRAND_NOTE <", value, "brandNote");
            return (Criteria) this;
        }

        public Criteria andBrandNoteLessThanOrEqualTo(String value) {
            addCriterion("BRAND_NOTE <=", value, "brandNote");
            return (Criteria) this;
        }

        public Criteria andBrandNoteLike(String value) {
            addCriterion("BRAND_NOTE like", value, "brandNote");
            return (Criteria) this;
        }

        public Criteria andBrandNoteNotLike(String value) {
            addCriterion("BRAND_NOTE not like", value, "brandNote");
            return (Criteria) this;
        }

        public Criteria andBrandNoteIn(List<String> values) {
            addCriterion("BRAND_NOTE in", values, "brandNote");
            return (Criteria) this;
        }

        public Criteria andBrandNoteNotIn(List<String> values) {
            addCriterion("BRAND_NOTE not in", values, "brandNote");
            return (Criteria) this;
        }

        public Criteria andBrandNoteBetween(String value1, String value2) {
            addCriterion("BRAND_NOTE between", value1, value2, "brandNote");
            return (Criteria) this;
        }

        public Criteria andBrandNoteNotBetween(String value1, String value2) {
            addCriterion("BRAND_NOTE not between", value1, value2, "brandNote");
            return (Criteria) this;
        }

        public Criteria andPolicyNoteIsNull() {
            addCriterion("POLICY_NOTE is null");
            return (Criteria) this;
        }

        public Criteria andPolicyNoteIsNotNull() {
            addCriterion("POLICY_NOTE is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyNoteEqualTo(String value) {
            addCriterion("POLICY_NOTE =", value, "policyNote");
            return (Criteria) this;
        }

        public Criteria andPolicyNoteNotEqualTo(String value) {
            addCriterion("POLICY_NOTE <>", value, "policyNote");
            return (Criteria) this;
        }

        public Criteria andPolicyNoteGreaterThan(String value) {
            addCriterion("POLICY_NOTE >", value, "policyNote");
            return (Criteria) this;
        }

        public Criteria andPolicyNoteGreaterThanOrEqualTo(String value) {
            addCriterion("POLICY_NOTE >=", value, "policyNote");
            return (Criteria) this;
        }

        public Criteria andPolicyNoteLessThan(String value) {
            addCriterion("POLICY_NOTE <", value, "policyNote");
            return (Criteria) this;
        }

        public Criteria andPolicyNoteLessThanOrEqualTo(String value) {
            addCriterion("POLICY_NOTE <=", value, "policyNote");
            return (Criteria) this;
        }

        public Criteria andPolicyNoteLike(String value) {
            addCriterion("POLICY_NOTE like", value, "policyNote");
            return (Criteria) this;
        }

        public Criteria andPolicyNoteNotLike(String value) {
            addCriterion("POLICY_NOTE not like", value, "policyNote");
            return (Criteria) this;
        }

        public Criteria andPolicyNoteIn(List<String> values) {
            addCriterion("POLICY_NOTE in", values, "policyNote");
            return (Criteria) this;
        }

        public Criteria andPolicyNoteNotIn(List<String> values) {
            addCriterion("POLICY_NOTE not in", values, "policyNote");
            return (Criteria) this;
        }

        public Criteria andPolicyNoteBetween(String value1, String value2) {
            addCriterion("POLICY_NOTE between", value1, value2, "policyNote");
            return (Criteria) this;
        }

        public Criteria andPolicyNoteNotBetween(String value1, String value2) {
            addCriterion("POLICY_NOTE not between", value1, value2, "policyNote");
            return (Criteria) this;
        }

        public Criteria andAppUserIsNull() {
            addCriterion("APP_USER is null");
            return (Criteria) this;
        }

        public Criteria andAppUserIsNotNull() {
            addCriterion("APP_USER is not null");
            return (Criteria) this;
        }

        public Criteria andAppUserEqualTo(String value) {
            addCriterion("APP_USER =", value, "appUser");
            return (Criteria) this;
        }

        public Criteria andAppUserNotEqualTo(String value) {
            addCriterion("APP_USER <>", value, "appUser");
            return (Criteria) this;
        }

        public Criteria andAppUserGreaterThan(String value) {
            addCriterion("APP_USER >", value, "appUser");
            return (Criteria) this;
        }

        public Criteria andAppUserGreaterThanOrEqualTo(String value) {
            addCriterion("APP_USER >=", value, "appUser");
            return (Criteria) this;
        }

        public Criteria andAppUserLessThan(String value) {
            addCriterion("APP_USER <", value, "appUser");
            return (Criteria) this;
        }

        public Criteria andAppUserLessThanOrEqualTo(String value) {
            addCriterion("APP_USER <=", value, "appUser");
            return (Criteria) this;
        }

        public Criteria andAppUserLike(String value) {
            addCriterion("APP_USER like", value, "appUser");
            return (Criteria) this;
        }

        public Criteria andAppUserNotLike(String value) {
            addCriterion("APP_USER not like", value, "appUser");
            return (Criteria) this;
        }

        public Criteria andAppUserIn(List<String> values) {
            addCriterion("APP_USER in", values, "appUser");
            return (Criteria) this;
        }

        public Criteria andAppUserNotIn(List<String> values) {
            addCriterion("APP_USER not in", values, "appUser");
            return (Criteria) this;
        }

        public Criteria andAppUserBetween(String value1, String value2) {
            addCriterion("APP_USER between", value1, value2, "appUser");
            return (Criteria) this;
        }

        public Criteria andAppUserNotBetween(String value1, String value2) {
            addCriterion("APP_USER not between", value1, value2, "appUser");
            return (Criteria) this;
        }

        public Criteria andInviteUrlIsNull() {
            addCriterion("INVITE_URL is null");
            return (Criteria) this;
        }

        public Criteria andInviteUrlIsNotNull() {
            addCriterion("INVITE_URL is not null");
            return (Criteria) this;
        }

        public Criteria andInviteUrlEqualTo(String value) {
            addCriterion("INVITE_URL =", value, "inviteUrl");
            return (Criteria) this;
        }

        public Criteria andInviteUrlNotEqualTo(String value) {
            addCriterion("INVITE_URL <>", value, "inviteUrl");
            return (Criteria) this;
        }

        public Criteria andInviteUrlGreaterThan(String value) {
            addCriterion("INVITE_URL >", value, "inviteUrl");
            return (Criteria) this;
        }

        public Criteria andInviteUrlGreaterThanOrEqualTo(String value) {
            addCriterion("INVITE_URL >=", value, "inviteUrl");
            return (Criteria) this;
        }

        public Criteria andInviteUrlLessThan(String value) {
            addCriterion("INVITE_URL <", value, "inviteUrl");
            return (Criteria) this;
        }

        public Criteria andInviteUrlLessThanOrEqualTo(String value) {
            addCriterion("INVITE_URL <=", value, "inviteUrl");
            return (Criteria) this;
        }

        public Criteria andInviteUrlLike(String value) {
            addCriterion("INVITE_URL like", value, "inviteUrl");
            return (Criteria) this;
        }

        public Criteria andInviteUrlNotLike(String value) {
            addCriterion("INVITE_URL not like", value, "inviteUrl");
            return (Criteria) this;
        }

        public Criteria andInviteUrlIn(List<String> values) {
            addCriterion("INVITE_URL in", values, "inviteUrl");
            return (Criteria) this;
        }

        public Criteria andInviteUrlNotIn(List<String> values) {
            addCriterion("INVITE_URL not in", values, "inviteUrl");
            return (Criteria) this;
        }

        public Criteria andInviteUrlBetween(String value1, String value2) {
            addCriterion("INVITE_URL between", value1, value2, "inviteUrl");
            return (Criteria) this;
        }

        public Criteria andInviteUrlNotBetween(String value1, String value2) {
            addCriterion("INVITE_URL not between", value1, value2, "inviteUrl");
            return (Criteria) this;
        }

        public Criteria andChannelMerchIdIsNull() {
            addCriterion("CHANNEL_MERCH_ID is null");
            return (Criteria) this;
        }

        public Criteria andChannelMerchIdIsNotNull() {
            addCriterion("CHANNEL_MERCH_ID is not null");
            return (Criteria) this;
        }

        public Criteria andChannelMerchIdEqualTo(String value) {
            addCriterion("CHANNEL_MERCH_ID =", value, "channelMerchId");
            return (Criteria) this;
        }

        public Criteria andChannelMerchIdNotEqualTo(String value) {
            addCriterion("CHANNEL_MERCH_ID <>", value, "channelMerchId");
            return (Criteria) this;
        }

        public Criteria andChannelMerchIdGreaterThan(String value) {
            addCriterion("CHANNEL_MERCH_ID >", value, "channelMerchId");
            return (Criteria) this;
        }

        public Criteria andChannelMerchIdGreaterThanOrEqualTo(String value) {
            addCriterion("CHANNEL_MERCH_ID >=", value, "channelMerchId");
            return (Criteria) this;
        }

        public Criteria andChannelMerchIdLessThan(String value) {
            addCriterion("CHANNEL_MERCH_ID <", value, "channelMerchId");
            return (Criteria) this;
        }

        public Criteria andChannelMerchIdLessThanOrEqualTo(String value) {
            addCriterion("CHANNEL_MERCH_ID <=", value, "channelMerchId");
            return (Criteria) this;
        }

        public Criteria andChannelMerchIdLike(String value) {
            addCriterion("CHANNEL_MERCH_ID like", value, "channelMerchId");
            return (Criteria) this;
        }

        public Criteria andChannelMerchIdNotLike(String value) {
            addCriterion("CHANNEL_MERCH_ID not like", value, "channelMerchId");
            return (Criteria) this;
        }

        public Criteria andChannelMerchIdIn(List<String> values) {
            addCriterion("CHANNEL_MERCH_ID in", values, "channelMerchId");
            return (Criteria) this;
        }

        public Criteria andChannelMerchIdNotIn(List<String> values) {
            addCriterion("CHANNEL_MERCH_ID not in", values, "channelMerchId");
            return (Criteria) this;
        }

        public Criteria andChannelMerchIdBetween(String value1, String value2) {
            addCriterion("CHANNEL_MERCH_ID between", value1, value2, "channelMerchId");
            return (Criteria) this;
        }

        public Criteria andChannelMerchIdNotBetween(String value1, String value2) {
            addCriterion("CHANNEL_MERCH_ID not between", value1, value2, "channelMerchId");
            return (Criteria) this;
        }

        public Criteria andChannelAgentIdIsNull() {
            addCriterion("CHANNEL_AGENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andChannelAgentIdIsNotNull() {
            addCriterion("CHANNEL_AGENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andChannelAgentIdEqualTo(String value) {
            addCriterion("CHANNEL_AGENT_ID =", value, "channelAgentId");
            return (Criteria) this;
        }

        public Criteria andChannelAgentIdNotEqualTo(String value) {
            addCriterion("CHANNEL_AGENT_ID <>", value, "channelAgentId");
            return (Criteria) this;
        }

        public Criteria andChannelAgentIdGreaterThan(String value) {
            addCriterion("CHANNEL_AGENT_ID >", value, "channelAgentId");
            return (Criteria) this;
        }

        public Criteria andChannelAgentIdGreaterThanOrEqualTo(String value) {
            addCriterion("CHANNEL_AGENT_ID >=", value, "channelAgentId");
            return (Criteria) this;
        }

        public Criteria andChannelAgentIdLessThan(String value) {
            addCriterion("CHANNEL_AGENT_ID <", value, "channelAgentId");
            return (Criteria) this;
        }

        public Criteria andChannelAgentIdLessThanOrEqualTo(String value) {
            addCriterion("CHANNEL_AGENT_ID <=", value, "channelAgentId");
            return (Criteria) this;
        }

        public Criteria andChannelAgentIdLike(String value) {
            addCriterion("CHANNEL_AGENT_ID like", value, "channelAgentId");
            return (Criteria) this;
        }

        public Criteria andChannelAgentIdNotLike(String value) {
            addCriterion("CHANNEL_AGENT_ID not like", value, "channelAgentId");
            return (Criteria) this;
        }

        public Criteria andChannelAgentIdIn(List<String> values) {
            addCriterion("CHANNEL_AGENT_ID in", values, "channelAgentId");
            return (Criteria) this;
        }

        public Criteria andChannelAgentIdNotIn(List<String> values) {
            addCriterion("CHANNEL_AGENT_ID not in", values, "channelAgentId");
            return (Criteria) this;
        }

        public Criteria andChannelAgentIdBetween(String value1, String value2) {
            addCriterion("CHANNEL_AGENT_ID between", value1, value2, "channelAgentId");
            return (Criteria) this;
        }

        public Criteria andChannelAgentIdNotBetween(String value1, String value2) {
            addCriterion("CHANNEL_AGENT_ID not between", value1, value2, "channelAgentId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
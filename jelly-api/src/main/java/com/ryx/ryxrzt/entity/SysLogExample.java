package com.ryx.ryxrzt.entity;


import java.util.ArrayList;
import java.util.List;

public class SysLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysLogExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andLoginNameIsNull() {
            addCriterion("LOGIN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andLoginNameIsNotNull() {
            addCriterion("LOGIN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andLoginNameEqualTo(String value) {
            addCriterion("LOGIN_NAME =", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotEqualTo(String value) {
            addCriterion("LOGIN_NAME <>", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameGreaterThan(String value) {
            addCriterion("LOGIN_NAME >", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_NAME >=", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLessThan(String value) {
            addCriterion("LOGIN_NAME <", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_NAME <=", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLike(String value) {
            addCriterion("LOGIN_NAME like", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotLike(String value) {
            addCriterion("LOGIN_NAME not like", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameIn(List<String> values) {
            addCriterion("LOGIN_NAME in", values, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotIn(List<String> values) {
            addCriterion("LOGIN_NAME not in", values, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameBetween(String value1, String value2) {
            addCriterion("LOGIN_NAME between", value1, value2, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotBetween(String value1, String value2) {
            addCriterion("LOGIN_NAME not between", value1, value2, "loginName");
            return (Criteria) this;
        }

        public Criteria andReqUrlIsNull() {
            addCriterion("REQ_URL is null");
            return (Criteria) this;
        }

        public Criteria andReqUrlIsNotNull() {
            addCriterion("REQ_URL is not null");
            return (Criteria) this;
        }

        public Criteria andReqUrlEqualTo(String value) {
            addCriterion("REQ_URL =", value, "reqUrl");
            return (Criteria) this;
        }

        public Criteria andReqUrlNotEqualTo(String value) {
            addCriterion("REQ_URL <>", value, "reqUrl");
            return (Criteria) this;
        }

        public Criteria andReqUrlGreaterThan(String value) {
            addCriterion("REQ_URL >", value, "reqUrl");
            return (Criteria) this;
        }

        public Criteria andReqUrlGreaterThanOrEqualTo(String value) {
            addCriterion("REQ_URL >=", value, "reqUrl");
            return (Criteria) this;
        }

        public Criteria andReqUrlLessThan(String value) {
            addCriterion("REQ_URL <", value, "reqUrl");
            return (Criteria) this;
        }

        public Criteria andReqUrlLessThanOrEqualTo(String value) {
            addCriterion("REQ_URL <=", value, "reqUrl");
            return (Criteria) this;
        }

        public Criteria andReqUrlLike(String value) {
            addCriterion("REQ_URL like", value, "reqUrl");
            return (Criteria) this;
        }

        public Criteria andReqUrlNotLike(String value) {
            addCriterion("REQ_URL not like", value, "reqUrl");
            return (Criteria) this;
        }

        public Criteria andReqUrlIn(List<String> values) {
            addCriterion("REQ_URL in", values, "reqUrl");
            return (Criteria) this;
        }

        public Criteria andReqUrlNotIn(List<String> values) {
            addCriterion("REQ_URL not in", values, "reqUrl");
            return (Criteria) this;
        }

        public Criteria andReqUrlBetween(String value1, String value2) {
            addCriterion("REQ_URL between", value1, value2, "reqUrl");
            return (Criteria) this;
        }

        public Criteria andReqUrlNotBetween(String value1, String value2) {
            addCriterion("REQ_URL not between", value1, value2, "reqUrl");
            return (Criteria) this;
        }

        public Criteria andReqMethdIsNull() {
            addCriterion("REQ_METHD is null");
            return (Criteria) this;
        }

        public Criteria andReqMethdIsNotNull() {
            addCriterion("REQ_METHD is not null");
            return (Criteria) this;
        }

        public Criteria andReqMethdEqualTo(String value) {
            addCriterion("REQ_METHD =", value, "reqMethd");
            return (Criteria) this;
        }

        public Criteria andReqMethdNotEqualTo(String value) {
            addCriterion("REQ_METHD <>", value, "reqMethd");
            return (Criteria) this;
        }

        public Criteria andReqMethdGreaterThan(String value) {
            addCriterion("REQ_METHD >", value, "reqMethd");
            return (Criteria) this;
        }

        public Criteria andReqMethdGreaterThanOrEqualTo(String value) {
            addCriterion("REQ_METHD >=", value, "reqMethd");
            return (Criteria) this;
        }

        public Criteria andReqMethdLessThan(String value) {
            addCriterion("REQ_METHD <", value, "reqMethd");
            return (Criteria) this;
        }

        public Criteria andReqMethdLessThanOrEqualTo(String value) {
            addCriterion("REQ_METHD <=", value, "reqMethd");
            return (Criteria) this;
        }

        public Criteria andReqMethdLike(String value) {
            addCriterion("REQ_METHD like", value, "reqMethd");
            return (Criteria) this;
        }

        public Criteria andReqMethdNotLike(String value) {
            addCriterion("REQ_METHD not like", value, "reqMethd");
            return (Criteria) this;
        }

        public Criteria andReqMethdIn(List<String> values) {
            addCriterion("REQ_METHD in", values, "reqMethd");
            return (Criteria) this;
        }

        public Criteria andReqMethdNotIn(List<String> values) {
            addCriterion("REQ_METHD not in", values, "reqMethd");
            return (Criteria) this;
        }

        public Criteria andReqMethdBetween(String value1, String value2) {
            addCriterion("REQ_METHD between", value1, value2, "reqMethd");
            return (Criteria) this;
        }

        public Criteria andReqMethdNotBetween(String value1, String value2) {
            addCriterion("REQ_METHD not between", value1, value2, "reqMethd");
            return (Criteria) this;
        }

        public Criteria andReqNameIsNull() {
            addCriterion("REQ_NAME is null");
            return (Criteria) this;
        }

        public Criteria andReqNameIsNotNull() {
            addCriterion("REQ_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andReqNameEqualTo(String value) {
            addCriterion("REQ_NAME =", value, "reqName");
            return (Criteria) this;
        }

        public Criteria andReqNameNotEqualTo(String value) {
            addCriterion("REQ_NAME <>", value, "reqName");
            return (Criteria) this;
        }

        public Criteria andReqNameGreaterThan(String value) {
            addCriterion("REQ_NAME >", value, "reqName");
            return (Criteria) this;
        }

        public Criteria andReqNameGreaterThanOrEqualTo(String value) {
            addCriterion("REQ_NAME >=", value, "reqName");
            return (Criteria) this;
        }

        public Criteria andReqNameLessThan(String value) {
            addCriterion("REQ_NAME <", value, "reqName");
            return (Criteria) this;
        }

        public Criteria andReqNameLessThanOrEqualTo(String value) {
            addCriterion("REQ_NAME <=", value, "reqName");
            return (Criteria) this;
        }

        public Criteria andReqNameLike(String value) {
            addCriterion("REQ_NAME like", value, "reqName");
            return (Criteria) this;
        }

        public Criteria andReqNameNotLike(String value) {
            addCriterion("REQ_NAME not like", value, "reqName");
            return (Criteria) this;
        }

        public Criteria andReqNameIn(List<String> values) {
            addCriterion("REQ_NAME in", values, "reqName");
            return (Criteria) this;
        }

        public Criteria andReqNameNotIn(List<String> values) {
            addCriterion("REQ_NAME not in", values, "reqName");
            return (Criteria) this;
        }

        public Criteria andReqNameBetween(String value1, String value2) {
            addCriterion("REQ_NAME between", value1, value2, "reqName");
            return (Criteria) this;
        }

        public Criteria andReqNameNotBetween(String value1, String value2) {
            addCriterion("REQ_NAME not between", value1, value2, "reqName");
            return (Criteria) this;
        }

        public Criteria andReqTimestampIsNull() {
            addCriterion("REQ_TIMESTAMP is null");
            return (Criteria) this;
        }

        public Criteria andReqTimestampIsNotNull() {
            addCriterion("REQ_TIMESTAMP is not null");
            return (Criteria) this;
        }

        public Criteria andReqTimestampEqualTo(String value) {
            addCriterion("REQ_TIMESTAMP =", value, "reqTimestamp");
            return (Criteria) this;
        }

        public Criteria andReqTimestampNotEqualTo(String value) {
            addCriterion("REQ_TIMESTAMP <>", value, "reqTimestamp");
            return (Criteria) this;
        }

        public Criteria andReqTimestampGreaterThan(String value) {
            addCriterion("REQ_TIMESTAMP >", value, "reqTimestamp");
            return (Criteria) this;
        }

        public Criteria andReqTimestampGreaterThanOrEqualTo(String value) {
            addCriterion("REQ_TIMESTAMP >=", value, "reqTimestamp");
            return (Criteria) this;
        }

        public Criteria andReqTimestampLessThan(String value) {
            addCriterion("REQ_TIMESTAMP <", value, "reqTimestamp");
            return (Criteria) this;
        }

        public Criteria andReqTimestampLessThanOrEqualTo(String value) {
            addCriterion("REQ_TIMESTAMP <=", value, "reqTimestamp");
            return (Criteria) this;
        }

        public Criteria andReqTimestampLike(String value) {
            addCriterion("REQ_TIMESTAMP like", value, "reqTimestamp");
            return (Criteria) this;
        }

        public Criteria andReqTimestampNotLike(String value) {
            addCriterion("REQ_TIMESTAMP not like", value, "reqTimestamp");
            return (Criteria) this;
        }

        public Criteria andReqTimestampIn(List<String> values) {
            addCriterion("REQ_TIMESTAMP in", values, "reqTimestamp");
            return (Criteria) this;
        }

        public Criteria andReqTimestampNotIn(List<String> values) {
            addCriterion("REQ_TIMESTAMP not in", values, "reqTimestamp");
            return (Criteria) this;
        }

        public Criteria andReqTimestampBetween(String value1, String value2) {
            addCriterion("REQ_TIMESTAMP between", value1, value2, "reqTimestamp");
            return (Criteria) this;
        }

        public Criteria andReqTimestampNotBetween(String value1, String value2) {
            addCriterion("REQ_TIMESTAMP not between", value1, value2, "reqTimestamp");
            return (Criteria) this;
        }

        public Criteria andReqParamsIsNull() {
            addCriterion("REQ_PARAMS is null");
            return (Criteria) this;
        }

        public Criteria andReqParamsIsNotNull() {
            addCriterion("REQ_PARAMS is not null");
            return (Criteria) this;
        }

        public Criteria andReqParamsEqualTo(String value) {
            addCriterion("REQ_PARAMS =", value, "reqParams");
            return (Criteria) this;
        }

        public Criteria andReqParamsNotEqualTo(String value) {
            addCriterion("REQ_PARAMS <>", value, "reqParams");
            return (Criteria) this;
        }

        public Criteria andReqParamsGreaterThan(String value) {
            addCriterion("REQ_PARAMS >", value, "reqParams");
            return (Criteria) this;
        }

        public Criteria andReqParamsGreaterThanOrEqualTo(String value) {
            addCriterion("REQ_PARAMS >=", value, "reqParams");
            return (Criteria) this;
        }

        public Criteria andReqParamsLessThan(String value) {
            addCriterion("REQ_PARAMS <", value, "reqParams");
            return (Criteria) this;
        }

        public Criteria andReqParamsLessThanOrEqualTo(String value) {
            addCriterion("REQ_PARAMS <=", value, "reqParams");
            return (Criteria) this;
        }

        public Criteria andReqParamsLike(String value) {
            addCriterion("REQ_PARAMS like", value, "reqParams");
            return (Criteria) this;
        }

        public Criteria andReqParamsNotLike(String value) {
            addCriterion("REQ_PARAMS not like", value, "reqParams");
            return (Criteria) this;
        }

        public Criteria andReqParamsIn(List<String> values) {
            addCriterion("REQ_PARAMS in", values, "reqParams");
            return (Criteria) this;
        }

        public Criteria andReqParamsNotIn(List<String> values) {
            addCriterion("REQ_PARAMS not in", values, "reqParams");
            return (Criteria) this;
        }

        public Criteria andReqParamsBetween(String value1, String value2) {
            addCriterion("REQ_PARAMS between", value1, value2, "reqParams");
            return (Criteria) this;
        }

        public Criteria andReqParamsNotBetween(String value1, String value2) {
            addCriterion("REQ_PARAMS not between", value1, value2, "reqParams");
            return (Criteria) this;
        }

        public Criteria andRepCodeIsNull() {
            addCriterion("REP_CODE is null");
            return (Criteria) this;
        }

        public Criteria andRepCodeIsNotNull() {
            addCriterion("REP_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andRepCodeEqualTo(String value) {
            addCriterion("REP_CODE =", value, "repCode");
            return (Criteria) this;
        }

        public Criteria andRepCodeNotEqualTo(String value) {
            addCriterion("REP_CODE <>", value, "repCode");
            return (Criteria) this;
        }

        public Criteria andRepCodeGreaterThan(String value) {
            addCriterion("REP_CODE >", value, "repCode");
            return (Criteria) this;
        }

        public Criteria andRepCodeGreaterThanOrEqualTo(String value) {
            addCriterion("REP_CODE >=", value, "repCode");
            return (Criteria) this;
        }

        public Criteria andRepCodeLessThan(String value) {
            addCriterion("REP_CODE <", value, "repCode");
            return (Criteria) this;
        }

        public Criteria andRepCodeLessThanOrEqualTo(String value) {
            addCriterion("REP_CODE <=", value, "repCode");
            return (Criteria) this;
        }

        public Criteria andRepCodeLike(String value) {
            addCriterion("REP_CODE like", value, "repCode");
            return (Criteria) this;
        }

        public Criteria andRepCodeNotLike(String value) {
            addCriterion("REP_CODE not like", value, "repCode");
            return (Criteria) this;
        }

        public Criteria andRepCodeIn(List<String> values) {
            addCriterion("REP_CODE in", values, "repCode");
            return (Criteria) this;
        }

        public Criteria andRepCodeNotIn(List<String> values) {
            addCriterion("REP_CODE not in", values, "repCode");
            return (Criteria) this;
        }

        public Criteria andRepCodeBetween(String value1, String value2) {
            addCriterion("REP_CODE between", value1, value2, "repCode");
            return (Criteria) this;
        }

        public Criteria andRepCodeNotBetween(String value1, String value2) {
            addCriterion("REP_CODE not between", value1, value2, "repCode");
            return (Criteria) this;
        }

        public Criteria andRepMsgIsNull() {
            addCriterion("REP_MSG is null");
            return (Criteria) this;
        }

        public Criteria andRepMsgIsNotNull() {
            addCriterion("REP_MSG is not null");
            return (Criteria) this;
        }

        public Criteria andRepMsgEqualTo(String value) {
            addCriterion("REP_MSG =", value, "repMsg");
            return (Criteria) this;
        }

        public Criteria andRepMsgNotEqualTo(String value) {
            addCriterion("REP_MSG <>", value, "repMsg");
            return (Criteria) this;
        }

        public Criteria andRepMsgGreaterThan(String value) {
            addCriterion("REP_MSG >", value, "repMsg");
            return (Criteria) this;
        }

        public Criteria andRepMsgGreaterThanOrEqualTo(String value) {
            addCriterion("REP_MSG >=", value, "repMsg");
            return (Criteria) this;
        }

        public Criteria andRepMsgLessThan(String value) {
            addCriterion("REP_MSG <", value, "repMsg");
            return (Criteria) this;
        }

        public Criteria andRepMsgLessThanOrEqualTo(String value) {
            addCriterion("REP_MSG <=", value, "repMsg");
            return (Criteria) this;
        }

        public Criteria andRepMsgLike(String value) {
            addCriterion("REP_MSG like", value, "repMsg");
            return (Criteria) this;
        }

        public Criteria andRepMsgNotLike(String value) {
            addCriterion("REP_MSG not like", value, "repMsg");
            return (Criteria) this;
        }

        public Criteria andRepMsgIn(List<String> values) {
            addCriterion("REP_MSG in", values, "repMsg");
            return (Criteria) this;
        }

        public Criteria andRepMsgNotIn(List<String> values) {
            addCriterion("REP_MSG not in", values, "repMsg");
            return (Criteria) this;
        }

        public Criteria andRepMsgBetween(String value1, String value2) {
            addCriterion("REP_MSG between", value1, value2, "repMsg");
            return (Criteria) this;
        }

        public Criteria andRepMsgNotBetween(String value1, String value2) {
            addCriterion("REP_MSG not between", value1, value2, "repMsg");
            return (Criteria) this;
        }

        public Criteria andRepParamsIsNull() {
            addCriterion("REP_PARAMS is null");
            return (Criteria) this;
        }

        public Criteria andRepParamsIsNotNull() {
            addCriterion("REP_PARAMS is not null");
            return (Criteria) this;
        }

        public Criteria andRepParamsEqualTo(String value) {
            addCriterion("REP_PARAMS =", value, "repParams");
            return (Criteria) this;
        }

        public Criteria andRepParamsNotEqualTo(String value) {
            addCriterion("REP_PARAMS <>", value, "repParams");
            return (Criteria) this;
        }

        public Criteria andRepParamsGreaterThan(String value) {
            addCriterion("REP_PARAMS >", value, "repParams");
            return (Criteria) this;
        }

        public Criteria andRepParamsGreaterThanOrEqualTo(String value) {
            addCriterion("REP_PARAMS >=", value, "repParams");
            return (Criteria) this;
        }

        public Criteria andRepParamsLessThan(String value) {
            addCriterion("REP_PARAMS <", value, "repParams");
            return (Criteria) this;
        }

        public Criteria andRepParamsLessThanOrEqualTo(String value) {
            addCriterion("REP_PARAMS <=", value, "repParams");
            return (Criteria) this;
        }

        public Criteria andRepParamsLike(String value) {
            addCriterion("REP_PARAMS like", value, "repParams");
            return (Criteria) this;
        }

        public Criteria andRepParamsNotLike(String value) {
            addCriterion("REP_PARAMS not like", value, "repParams");
            return (Criteria) this;
        }

        public Criteria andRepParamsIn(List<String> values) {
            addCriterion("REP_PARAMS in", values, "repParams");
            return (Criteria) this;
        }

        public Criteria andRepParamsNotIn(List<String> values) {
            addCriterion("REP_PARAMS not in", values, "repParams");
            return (Criteria) this;
        }

        public Criteria andRepParamsBetween(String value1, String value2) {
            addCriterion("REP_PARAMS between", value1, value2, "repParams");
            return (Criteria) this;
        }

        public Criteria andRepParamsNotBetween(String value1, String value2) {
            addCriterion("REP_PARAMS not between", value1, value2, "repParams");
            return (Criteria) this;
        }

        public Criteria andRepTimestampIsNull() {
            addCriterion("REP_TIMESTAMP is null");
            return (Criteria) this;
        }

        public Criteria andRepTimestampIsNotNull() {
            addCriterion("REP_TIMESTAMP is not null");
            return (Criteria) this;
        }

        public Criteria andRepTimestampEqualTo(String value) {
            addCriterion("REP_TIMESTAMP =", value, "repTimestamp");
            return (Criteria) this;
        }

        public Criteria andRepTimestampNotEqualTo(String value) {
            addCriterion("REP_TIMESTAMP <>", value, "repTimestamp");
            return (Criteria) this;
        }

        public Criteria andRepTimestampGreaterThan(String value) {
            addCriterion("REP_TIMESTAMP >", value, "repTimestamp");
            return (Criteria) this;
        }

        public Criteria andRepTimestampGreaterThanOrEqualTo(String value) {
            addCriterion("REP_TIMESTAMP >=", value, "repTimestamp");
            return (Criteria) this;
        }

        public Criteria andRepTimestampLessThan(String value) {
            addCriterion("REP_TIMESTAMP <", value, "repTimestamp");
            return (Criteria) this;
        }

        public Criteria andRepTimestampLessThanOrEqualTo(String value) {
            addCriterion("REP_TIMESTAMP <=", value, "repTimestamp");
            return (Criteria) this;
        }

        public Criteria andRepTimestampLike(String value) {
            addCriterion("REP_TIMESTAMP like", value, "repTimestamp");
            return (Criteria) this;
        }

        public Criteria andRepTimestampNotLike(String value) {
            addCriterion("REP_TIMESTAMP not like", value, "repTimestamp");
            return (Criteria) this;
        }

        public Criteria andRepTimestampIn(List<String> values) {
            addCriterion("REP_TIMESTAMP in", values, "repTimestamp");
            return (Criteria) this;
        }

        public Criteria andRepTimestampNotIn(List<String> values) {
            addCriterion("REP_TIMESTAMP not in", values, "repTimestamp");
            return (Criteria) this;
        }

        public Criteria andRepTimestampBetween(String value1, String value2) {
            addCriterion("REP_TIMESTAMP between", value1, value2, "repTimestamp");
            return (Criteria) this;
        }

        public Criteria andRepTimestampNotBetween(String value1, String value2) {
            addCriterion("REP_TIMESTAMP not between", value1, value2, "repTimestamp");
            return (Criteria) this;
        }

        public Criteria andTimeLenIsNull() {
            addCriterion("TIME_LEN is null");
            return (Criteria) this;
        }

        public Criteria andTimeLenIsNotNull() {
            addCriterion("TIME_LEN is not null");
            return (Criteria) this;
        }

        public Criteria andTimeLenEqualTo(Integer value) {
            addCriterion("TIME_LEN =", value, "timeLen");
            return (Criteria) this;
        }

        public Criteria andTimeLenNotEqualTo(Integer value) {
            addCriterion("TIME_LEN <>", value, "timeLen");
            return (Criteria) this;
        }

        public Criteria andTimeLenGreaterThan(Integer value) {
            addCriterion("TIME_LEN >", value, "timeLen");
            return (Criteria) this;
        }

        public Criteria andTimeLenGreaterThanOrEqualTo(Integer value) {
            addCriterion("TIME_LEN >=", value, "timeLen");
            return (Criteria) this;
        }

        public Criteria andTimeLenLessThan(Integer value) {
            addCriterion("TIME_LEN <", value, "timeLen");
            return (Criteria) this;
        }

        public Criteria andTimeLenLessThanOrEqualTo(Integer value) {
            addCriterion("TIME_LEN <=", value, "timeLen");
            return (Criteria) this;
        }

        public Criteria andTimeLenIn(List<Integer> values) {
            addCriterion("TIME_LEN in", values, "timeLen");
            return (Criteria) this;
        }

        public Criteria andTimeLenNotIn(List<Integer> values) {
            addCriterion("TIME_LEN not in", values, "timeLen");
            return (Criteria) this;
        }

        public Criteria andTimeLenBetween(Integer value1, Integer value2) {
            addCriterion("TIME_LEN between", value1, value2, "timeLen");
            return (Criteria) this;
        }

        public Criteria andTimeLenNotBetween(Integer value1, Integer value2) {
            addCriterion("TIME_LEN not between", value1, value2, "timeLen");
            return (Criteria) this;
        }

        public Criteria andInTimestampIsNull() {
            addCriterion("IN_TIMESTAMP is null");
            return (Criteria) this;
        }

        public Criteria andInTimestampIsNotNull() {
            addCriterion("IN_TIMESTAMP is not null");
            return (Criteria) this;
        }

        public Criteria andInTimestampEqualTo(String value) {
            addCriterion("IN_TIMESTAMP =", value, "inTimestamp");
            return (Criteria) this;
        }

        public Criteria andInTimestampNotEqualTo(String value) {
            addCriterion("IN_TIMESTAMP <>", value, "inTimestamp");
            return (Criteria) this;
        }

        public Criteria andInTimestampGreaterThan(String value) {
            addCriterion("IN_TIMESTAMP >", value, "inTimestamp");
            return (Criteria) this;
        }

        public Criteria andInTimestampGreaterThanOrEqualTo(String value) {
            addCriterion("IN_TIMESTAMP >=", value, "inTimestamp");
            return (Criteria) this;
        }

        public Criteria andInTimestampLessThan(String value) {
            addCriterion("IN_TIMESTAMP <", value, "inTimestamp");
            return (Criteria) this;
        }

        public Criteria andInTimestampLessThanOrEqualTo(String value) {
            addCriterion("IN_TIMESTAMP <=", value, "inTimestamp");
            return (Criteria) this;
        }

        public Criteria andInTimestampLike(String value) {
            addCriterion("IN_TIMESTAMP like", value, "inTimestamp");
            return (Criteria) this;
        }

        public Criteria andInTimestampNotLike(String value) {
            addCriterion("IN_TIMESTAMP not like", value, "inTimestamp");
            return (Criteria) this;
        }

        public Criteria andInTimestampIn(List<String> values) {
            addCriterion("IN_TIMESTAMP in", values, "inTimestamp");
            return (Criteria) this;
        }

        public Criteria andInTimestampNotIn(List<String> values) {
            addCriterion("IN_TIMESTAMP not in", values, "inTimestamp");
            return (Criteria) this;
        }

        public Criteria andInTimestampBetween(String value1, String value2) {
            addCriterion("IN_TIMESTAMP between", value1, value2, "inTimestamp");
            return (Criteria) this;
        }

        public Criteria andInTimestampNotBetween(String value1, String value2) {
            addCriterion("IN_TIMESTAMP not between", value1, value2, "inTimestamp");
            return (Criteria) this;
        }

        public Criteria andBrowserIsNull() {
            addCriterion("BROWSER is null");
            return (Criteria) this;
        }

        public Criteria andBrowserIsNotNull() {
            addCriterion("BROWSER is not null");
            return (Criteria) this;
        }

        public Criteria andBrowserEqualTo(String value) {
            addCriterion("BROWSER =", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserNotEqualTo(String value) {
            addCriterion("BROWSER <>", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserGreaterThan(String value) {
            addCriterion("BROWSER >", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserGreaterThanOrEqualTo(String value) {
            addCriterion("BROWSER >=", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserLessThan(String value) {
            addCriterion("BROWSER <", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserLessThanOrEqualTo(String value) {
            addCriterion("BROWSER <=", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserLike(String value) {
            addCriterion("BROWSER like", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserNotLike(String value) {
            addCriterion("BROWSER not like", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserIn(List<String> values) {
            addCriterion("BROWSER in", values, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserNotIn(List<String> values) {
            addCriterion("BROWSER not in", values, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserBetween(String value1, String value2) {
            addCriterion("BROWSER between", value1, value2, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserNotBetween(String value1, String value2) {
            addCriterion("BROWSER not between", value1, value2, "browser");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("IP is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("IP is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("IP =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("IP <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("IP >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("IP >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("IP <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("IP <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("IP like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("IP not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("IP in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("IP not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("IP between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("IP not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andUserIdLikeInsensitive(String value) {
            addCriterion("upper(USER_ID) like", value.toUpperCase(), "userId");
            return (Criteria) this;
        }

        public Criteria andLoginNameLikeInsensitive(String value) {
            addCriterion("upper(LOGIN_NAME) like", value.toUpperCase(), "loginName");
            return (Criteria) this;
        }

        public Criteria andReqUrlLikeInsensitive(String value) {
            addCriterion("upper(REQ_URL) like", value.toUpperCase(), "reqUrl");
            return (Criteria) this;
        }

        public Criteria andReqMethdLikeInsensitive(String value) {
            addCriterion("upper(REQ_METHD) like", value.toUpperCase(), "reqMethd");
            return (Criteria) this;
        }

        public Criteria andReqNameLikeInsensitive(String value) {
            addCriterion("upper(REQ_NAME) like", value.toUpperCase(), "reqName");
            return (Criteria) this;
        }

        public Criteria andReqTimestampLikeInsensitive(String value) {
            addCriterion("upper(REQ_TIMESTAMP) like", value.toUpperCase(), "reqTimestamp");
            return (Criteria) this;
        }

        public Criteria andReqParamsLikeInsensitive(String value) {
            addCriterion("upper(REQ_PARAMS) like", value.toUpperCase(), "reqParams");
            return (Criteria) this;
        }

        public Criteria andRepCodeLikeInsensitive(String value) {
            addCriterion("upper(REP_CODE) like", value.toUpperCase(), "repCode");
            return (Criteria) this;
        }

        public Criteria andRepMsgLikeInsensitive(String value) {
            addCriterion("upper(REP_MSG) like", value.toUpperCase(), "repMsg");
            return (Criteria) this;
        }

        public Criteria andRepParamsLikeInsensitive(String value) {
            addCriterion("upper(REP_PARAMS) like", value.toUpperCase(), "repParams");
            return (Criteria) this;
        }

        public Criteria andRepTimestampLikeInsensitive(String value) {
            addCriterion("upper(REP_TIMESTAMP) like", value.toUpperCase(), "repTimestamp");
            return (Criteria) this;
        }

        public Criteria andInTimestampLikeInsensitive(String value) {
            addCriterion("upper(IN_TIMESTAMP) like", value.toUpperCase(), "inTimestamp");
            return (Criteria) this;
        }

        public Criteria andBrowserLikeInsensitive(String value) {
            addCriterion("upper(BROWSER) like", value.toUpperCase(), "browser");
            return (Criteria) this;
        }

        public Criteria andIpLikeInsensitive(String value) {
            addCriterion("upper(IP) like", value.toUpperCase(), "ip");
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
package com.h3c.platform.assetplan.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProcessRecordInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProcessRecordInfoExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAssetplanidIsNull() {
            addCriterion("AssetPlanID is null");
            return (Criteria) this;
        }

        public Criteria andAssetplanidIsNotNull() {
            addCriterion("AssetPlanID is not null");
            return (Criteria) this;
        }

        public Criteria andAssetplanidEqualTo(Integer value) {
            addCriterion("AssetPlanID =", value, "assetplanid");
            return (Criteria) this;
        }

        public Criteria andAssetplanidNotEqualTo(Integer value) {
            addCriterion("AssetPlanID <>", value, "assetplanid");
            return (Criteria) this;
        }

        public Criteria andAssetplanidGreaterThan(Integer value) {
            addCriterion("AssetPlanID >", value, "assetplanid");
            return (Criteria) this;
        }

        public Criteria andAssetplanidGreaterThanOrEqualTo(Integer value) {
            addCriterion("AssetPlanID >=", value, "assetplanid");
            return (Criteria) this;
        }

        public Criteria andAssetplanidLessThan(Integer value) {
            addCriterion("AssetPlanID <", value, "assetplanid");
            return (Criteria) this;
        }

        public Criteria andAssetplanidLessThanOrEqualTo(Integer value) {
            addCriterion("AssetPlanID <=", value, "assetplanid");
            return (Criteria) this;
        }

        public Criteria andAssetplanidIn(List<Integer> values) {
            addCriterion("AssetPlanID in", values, "assetplanid");
            return (Criteria) this;
        }

        public Criteria andAssetplanidNotIn(List<Integer> values) {
            addCriterion("AssetPlanID not in", values, "assetplanid");
            return (Criteria) this;
        }

        public Criteria andAssetplanidBetween(Integer value1, Integer value2) {
            addCriterion("AssetPlanID between", value1, value2, "assetplanid");
            return (Criteria) this;
        }

        public Criteria andAssetplanidNotBetween(Integer value1, Integer value2) {
            addCriterion("AssetPlanID not between", value1, value2, "assetplanid");
            return (Criteria) this;
        }

        public Criteria andApstageIsNull() {
            addCriterion("ApStage is null");
            return (Criteria) this;
        }

        public Criteria andApstageIsNotNull() {
            addCriterion("ApStage is not null");
            return (Criteria) this;
        }

        public Criteria andApstageEqualTo(String value) {
            addCriterion("ApStage =", value, "apstage");
            return (Criteria) this;
        }

        public Criteria andApstageNotEqualTo(String value) {
            addCriterion("ApStage <>", value, "apstage");
            return (Criteria) this;
        }

        public Criteria andApstageGreaterThan(String value) {
            addCriterion("ApStage >", value, "apstage");
            return (Criteria) this;
        }

        public Criteria andApstageGreaterThanOrEqualTo(String value) {
            addCriterion("ApStage >=", value, "apstage");
            return (Criteria) this;
        }

        public Criteria andApstageLessThan(String value) {
            addCriterion("ApStage <", value, "apstage");
            return (Criteria) this;
        }

        public Criteria andApstageLessThanOrEqualTo(String value) {
            addCriterion("ApStage <=", value, "apstage");
            return (Criteria) this;
        }

        public Criteria andApstageLike(String value) {
            addCriterion("ApStage like", value, "apstage");
            return (Criteria) this;
        }

        public Criteria andApstageNotLike(String value) {
            addCriterion("ApStage not like", value, "apstage");
            return (Criteria) this;
        }

        public Criteria andApstageIn(List<String> values) {
            addCriterion("ApStage in", values, "apstage");
            return (Criteria) this;
        }

        public Criteria andApstageNotIn(List<String> values) {
            addCriterion("ApStage not in", values, "apstage");
            return (Criteria) this;
        }

        public Criteria andApstageBetween(String value1, String value2) {
            addCriterion("ApStage between", value1, value2, "apstage");
            return (Criteria) this;
        }

        public Criteria andApstageNotBetween(String value1, String value2) {
            addCriterion("ApStage not between", value1, value2, "apstage");
            return (Criteria) this;
        }

        public Criteria andCurrentpersonIsNull() {
            addCriterion("CurrentPerson is null");
            return (Criteria) this;
        }

        public Criteria andCurrentpersonIsNotNull() {
            addCriterion("CurrentPerson is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentpersonEqualTo(String value) {
            addCriterion("CurrentPerson =", value, "currentperson");
            return (Criteria) this;
        }

        public Criteria andCurrentpersonNotEqualTo(String value) {
            addCriterion("CurrentPerson <>", value, "currentperson");
            return (Criteria) this;
        }

        public Criteria andCurrentpersonGreaterThan(String value) {
            addCriterion("CurrentPerson >", value, "currentperson");
            return (Criteria) this;
        }

        public Criteria andCurrentpersonGreaterThanOrEqualTo(String value) {
            addCriterion("CurrentPerson >=", value, "currentperson");
            return (Criteria) this;
        }

        public Criteria andCurrentpersonLessThan(String value) {
            addCriterion("CurrentPerson <", value, "currentperson");
            return (Criteria) this;
        }

        public Criteria andCurrentpersonLessThanOrEqualTo(String value) {
            addCriterion("CurrentPerson <=", value, "currentperson");
            return (Criteria) this;
        }

        public Criteria andCurrentpersonLike(String value) {
            addCriterion("CurrentPerson like", value, "currentperson");
            return (Criteria) this;
        }

        public Criteria andCurrentpersonNotLike(String value) {
            addCriterion("CurrentPerson not like", value, "currentperson");
            return (Criteria) this;
        }

        public Criteria andCurrentpersonIn(List<String> values) {
            addCriterion("CurrentPerson in", values, "currentperson");
            return (Criteria) this;
        }

        public Criteria andCurrentpersonNotIn(List<String> values) {
            addCriterion("CurrentPerson not in", values, "currentperson");
            return (Criteria) this;
        }

        public Criteria andCurrentpersonBetween(String value1, String value2) {
            addCriterion("CurrentPerson between", value1, value2, "currentperson");
            return (Criteria) this;
        }

        public Criteria andCurrentpersonNotBetween(String value1, String value2) {
            addCriterion("CurrentPerson not between", value1, value2, "currentperson");
            return (Criteria) this;
        }

        public Criteria andNewpersonIsNull() {
            addCriterion("NewPerson is null");
            return (Criteria) this;
        }

        public Criteria andNewpersonIsNotNull() {
            addCriterion("NewPerson is not null");
            return (Criteria) this;
        }

        public Criteria andNewpersonEqualTo(String value) {
            addCriterion("NewPerson =", value, "newperson");
            return (Criteria) this;
        }

        public Criteria andNewpersonNotEqualTo(String value) {
            addCriterion("NewPerson <>", value, "newperson");
            return (Criteria) this;
        }

        public Criteria andNewpersonGreaterThan(String value) {
            addCriterion("NewPerson >", value, "newperson");
            return (Criteria) this;
        }

        public Criteria andNewpersonGreaterThanOrEqualTo(String value) {
            addCriterion("NewPerson >=", value, "newperson");
            return (Criteria) this;
        }

        public Criteria andNewpersonLessThan(String value) {
            addCriterion("NewPerson <", value, "newperson");
            return (Criteria) this;
        }

        public Criteria andNewpersonLessThanOrEqualTo(String value) {
            addCriterion("NewPerson <=", value, "newperson");
            return (Criteria) this;
        }

        public Criteria andNewpersonLike(String value) {
            addCriterion("NewPerson like", value, "newperson");
            return (Criteria) this;
        }

        public Criteria andNewpersonNotLike(String value) {
            addCriterion("NewPerson not like", value, "newperson");
            return (Criteria) this;
        }

        public Criteria andNewpersonIn(List<String> values) {
            addCriterion("NewPerson in", values, "newperson");
            return (Criteria) this;
        }

        public Criteria andNewpersonNotIn(List<String> values) {
            addCriterion("NewPerson not in", values, "newperson");
            return (Criteria) this;
        }

        public Criteria andNewpersonBetween(String value1, String value2) {
            addCriterion("NewPerson between", value1, value2, "newperson");
            return (Criteria) this;
        }

        public Criteria andNewpersonNotBetween(String value1, String value2) {
            addCriterion("NewPerson not between", value1, value2, "newperson");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("Creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("Creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("Creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("Creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("Creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("Creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("Creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("Creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("Creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("Creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("Creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("Creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("Creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("Creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CreateTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CreateTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CreateTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CreateTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CreateTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CreateTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CreateTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CreateTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CreateTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CreateTime not between", value1, value2, "createtime");
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
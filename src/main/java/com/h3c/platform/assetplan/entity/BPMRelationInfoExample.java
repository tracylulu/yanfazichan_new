package com.h3c.platform.assetplan.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BPMRelationInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BPMRelationInfoExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andAsstplanidIsNull() {
            addCriterion("AsstPlanID is null");
            return (Criteria) this;
        }

        public Criteria andAsstplanidIsNotNull() {
            addCriterion("AsstPlanID is not null");
            return (Criteria) this;
        }

        public Criteria andAsstplanidEqualTo(Integer value) {
            addCriterion("AsstPlanID =", value, "asstplanid");
            return (Criteria) this;
        }

        public Criteria andAsstplanidNotEqualTo(Integer value) {
            addCriterion("AsstPlanID <>", value, "asstplanid");
            return (Criteria) this;
        }

        public Criteria andAsstplanidGreaterThan(Integer value) {
            addCriterion("AsstPlanID >", value, "asstplanid");
            return (Criteria) this;
        }

        public Criteria andAsstplanidGreaterThanOrEqualTo(Integer value) {
            addCriterion("AsstPlanID >=", value, "asstplanid");
            return (Criteria) this;
        }

        public Criteria andAsstplanidLessThan(Integer value) {
            addCriterion("AsstPlanID <", value, "asstplanid");
            return (Criteria) this;
        }

        public Criteria andAsstplanidLessThanOrEqualTo(Integer value) {
            addCriterion("AsstPlanID <=", value, "asstplanid");
            return (Criteria) this;
        }

        public Criteria andAsstplanidIn(List<Integer> values) {
            addCriterion("AsstPlanID in", values, "asstplanid");
            return (Criteria) this;
        }

        public Criteria andAsstplanidNotIn(List<Integer> values) {
            addCriterion("AsstPlanID not in", values, "asstplanid");
            return (Criteria) this;
        }

        public Criteria andAsstplanidBetween(Integer value1, Integer value2) {
            addCriterion("AsstPlanID between", value1, value2, "asstplanid");
            return (Criteria) this;
        }

        public Criteria andAsstplanidNotBetween(Integer value1, Integer value2) {
            addCriterion("AsstPlanID not between", value1, value2, "asstplanid");
            return (Criteria) this;
        }

        public Criteria andBpmcodeIsNull() {
            addCriterion("BPMCode is null");
            return (Criteria) this;
        }

        public Criteria andBpmcodeIsNotNull() {
            addCriterion("BPMCode is not null");
            return (Criteria) this;
        }

        public Criteria andBpmcodeEqualTo(String value) {
            addCriterion("BPMCode =", value, "bpmcode");
            return (Criteria) this;
        }

        public Criteria andBpmcodeNotEqualTo(String value) {
            addCriterion("BPMCode <>", value, "bpmcode");
            return (Criteria) this;
        }

        public Criteria andBpmcodeGreaterThan(String value) {
            addCriterion("BPMCode >", value, "bpmcode");
            return (Criteria) this;
        }

        public Criteria andBpmcodeGreaterThanOrEqualTo(String value) {
            addCriterion("BPMCode >=", value, "bpmcode");
            return (Criteria) this;
        }

        public Criteria andBpmcodeLessThan(String value) {
            addCriterion("BPMCode <", value, "bpmcode");
            return (Criteria) this;
        }

        public Criteria andBpmcodeLessThanOrEqualTo(String value) {
            addCriterion("BPMCode <=", value, "bpmcode");
            return (Criteria) this;
        }

        public Criteria andBpmcodeLike(String value) {
            addCriterion("BPMCode like", value, "bpmcode");
            return (Criteria) this;
        }

        public Criteria andBpmcodeNotLike(String value) {
            addCriterion("BPMCode not like", value, "bpmcode");
            return (Criteria) this;
        }

        public Criteria andBpmcodeIn(List<String> values) {
            addCriterion("BPMCode in", values, "bpmcode");
            return (Criteria) this;
        }

        public Criteria andBpmcodeNotIn(List<String> values) {
            addCriterion("BPMCode not in", values, "bpmcode");
            return (Criteria) this;
        }

        public Criteria andBpmcodeBetween(String value1, String value2) {
            addCriterion("BPMCode between", value1, value2, "bpmcode");
            return (Criteria) this;
        }

        public Criteria andBpmcodeNotBetween(String value1, String value2) {
            addCriterion("BPMCode not between", value1, value2, "bpmcode");
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
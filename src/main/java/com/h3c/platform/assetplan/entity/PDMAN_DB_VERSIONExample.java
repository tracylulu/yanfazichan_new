package com.h3c.platform.assetplan.entity;

import java.util.ArrayList;
import java.util.List;

public class PDMAN_DB_VERSIONExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PDMAN_DB_VERSIONExample() {
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

        public Criteria andDbVersionIsNull() {
            addCriterion("DB_VERSION is null");
            return (Criteria) this;
        }

        public Criteria andDbVersionIsNotNull() {
            addCriterion("DB_VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andDbVersionEqualTo(String value) {
            addCriterion("DB_VERSION =", value, "dbVersion");
            return (Criteria) this;
        }

        public Criteria andDbVersionNotEqualTo(String value) {
            addCriterion("DB_VERSION <>", value, "dbVersion");
            return (Criteria) this;
        }

        public Criteria andDbVersionGreaterThan(String value) {
            addCriterion("DB_VERSION >", value, "dbVersion");
            return (Criteria) this;
        }

        public Criteria andDbVersionGreaterThanOrEqualTo(String value) {
            addCriterion("DB_VERSION >=", value, "dbVersion");
            return (Criteria) this;
        }

        public Criteria andDbVersionLessThan(String value) {
            addCriterion("DB_VERSION <", value, "dbVersion");
            return (Criteria) this;
        }

        public Criteria andDbVersionLessThanOrEqualTo(String value) {
            addCriterion("DB_VERSION <=", value, "dbVersion");
            return (Criteria) this;
        }

        public Criteria andDbVersionLike(String value) {
            addCriterion("DB_VERSION like", value, "dbVersion");
            return (Criteria) this;
        }

        public Criteria andDbVersionNotLike(String value) {
            addCriterion("DB_VERSION not like", value, "dbVersion");
            return (Criteria) this;
        }

        public Criteria andDbVersionIn(List<String> values) {
            addCriterion("DB_VERSION in", values, "dbVersion");
            return (Criteria) this;
        }

        public Criteria andDbVersionNotIn(List<String> values) {
            addCriterion("DB_VERSION not in", values, "dbVersion");
            return (Criteria) this;
        }

        public Criteria andDbVersionBetween(String value1, String value2) {
            addCriterion("DB_VERSION between", value1, value2, "dbVersion");
            return (Criteria) this;
        }

        public Criteria andDbVersionNotBetween(String value1, String value2) {
            addCriterion("DB_VERSION not between", value1, value2, "dbVersion");
            return (Criteria) this;
        }

        public Criteria andVersionDescIsNull() {
            addCriterion("VERSION_DESC is null");
            return (Criteria) this;
        }

        public Criteria andVersionDescIsNotNull() {
            addCriterion("VERSION_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andVersionDescEqualTo(String value) {
            addCriterion("VERSION_DESC =", value, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescNotEqualTo(String value) {
            addCriterion("VERSION_DESC <>", value, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescGreaterThan(String value) {
            addCriterion("VERSION_DESC >", value, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescGreaterThanOrEqualTo(String value) {
            addCriterion("VERSION_DESC >=", value, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescLessThan(String value) {
            addCriterion("VERSION_DESC <", value, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescLessThanOrEqualTo(String value) {
            addCriterion("VERSION_DESC <=", value, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescLike(String value) {
            addCriterion("VERSION_DESC like", value, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescNotLike(String value) {
            addCriterion("VERSION_DESC not like", value, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescIn(List<String> values) {
            addCriterion("VERSION_DESC in", values, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescNotIn(List<String> values) {
            addCriterion("VERSION_DESC not in", values, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescBetween(String value1, String value2) {
            addCriterion("VERSION_DESC between", value1, value2, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andVersionDescNotBetween(String value1, String value2) {
            addCriterion("VERSION_DESC not between", value1, value2, "versionDesc");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("CREATED_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("CREATED_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(String value) {
            addCriterion("CREATED_TIME =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(String value) {
            addCriterion("CREATED_TIME <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(String value) {
            addCriterion("CREATED_TIME >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(String value) {
            addCriterion("CREATED_TIME >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(String value) {
            addCriterion("CREATED_TIME <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(String value) {
            addCriterion("CREATED_TIME <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLike(String value) {
            addCriterion("CREATED_TIME like", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotLike(String value) {
            addCriterion("CREATED_TIME not like", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<String> values) {
            addCriterion("CREATED_TIME in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<String> values) {
            addCriterion("CREATED_TIME not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(String value1, String value2) {
            addCriterion("CREATED_TIME between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(String value1, String value2) {
            addCriterion("CREATED_TIME not between", value1, value2, "createdTime");
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
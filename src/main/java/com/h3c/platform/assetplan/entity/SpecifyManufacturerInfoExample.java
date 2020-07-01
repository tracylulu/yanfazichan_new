package com.h3c.platform.assetplan.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpecifyManufacturerInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpecifyManufacturerInfoExample() {
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

        public Criteria andSpecifymanufactureridIsNull() {
            addCriterion("SpecifyManufacturerID is null");
            return (Criteria) this;
        }

        public Criteria andSpecifymanufactureridIsNotNull() {
            addCriterion("SpecifyManufacturerID is not null");
            return (Criteria) this;
        }

        public Criteria andSpecifymanufactureridEqualTo(Integer value) {
            addCriterion("SpecifyManufacturerID =", value, "specifymanufacturerid");
            return (Criteria) this;
        }

        public Criteria andSpecifymanufactureridNotEqualTo(Integer value) {
            addCriterion("SpecifyManufacturerID <>", value, "specifymanufacturerid");
            return (Criteria) this;
        }

        public Criteria andSpecifymanufactureridGreaterThan(Integer value) {
            addCriterion("SpecifyManufacturerID >", value, "specifymanufacturerid");
            return (Criteria) this;
        }

        public Criteria andSpecifymanufactureridGreaterThanOrEqualTo(Integer value) {
            addCriterion("SpecifyManufacturerID >=", value, "specifymanufacturerid");
            return (Criteria) this;
        }

        public Criteria andSpecifymanufactureridLessThan(Integer value) {
            addCriterion("SpecifyManufacturerID <", value, "specifymanufacturerid");
            return (Criteria) this;
        }

        public Criteria andSpecifymanufactureridLessThanOrEqualTo(Integer value) {
            addCriterion("SpecifyManufacturerID <=", value, "specifymanufacturerid");
            return (Criteria) this;
        }

        public Criteria andSpecifymanufactureridIn(List<Integer> values) {
            addCriterion("SpecifyManufacturerID in", values, "specifymanufacturerid");
            return (Criteria) this;
        }

        public Criteria andSpecifymanufactureridNotIn(List<Integer> values) {
            addCriterion("SpecifyManufacturerID not in", values, "specifymanufacturerid");
            return (Criteria) this;
        }

        public Criteria andSpecifymanufactureridBetween(Integer value1, Integer value2) {
            addCriterion("SpecifyManufacturerID between", value1, value2, "specifymanufacturerid");
            return (Criteria) this;
        }

        public Criteria andSpecifymanufactureridNotBetween(Integer value1, Integer value2) {
            addCriterion("SpecifyManufacturerID not between", value1, value2, "specifymanufacturerid");
            return (Criteria) this;
        }

        public Criteria andPurposeIsNull() {
            addCriterion("Purpose is null");
            return (Criteria) this;
        }

        public Criteria andPurposeIsNotNull() {
            addCriterion("Purpose is not null");
            return (Criteria) this;
        }

        public Criteria andPurposeEqualTo(String value) {
            addCriterion("Purpose =", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotEqualTo(String value) {
            addCriterion("Purpose <>", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeGreaterThan(String value) {
            addCriterion("Purpose >", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeGreaterThanOrEqualTo(String value) {
            addCriterion("Purpose >=", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeLessThan(String value) {
            addCriterion("Purpose <", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeLessThanOrEqualTo(String value) {
            addCriterion("Purpose <=", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeLike(String value) {
            addCriterion("Purpose like", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotLike(String value) {
            addCriterion("Purpose not like", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeIn(List<String> values) {
            addCriterion("Purpose in", values, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotIn(List<String> values) {
            addCriterion("Purpose not in", values, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeBetween(String value1, String value2) {
            addCriterion("Purpose between", value1, value2, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotBetween(String value1, String value2) {
            addCriterion("Purpose not between", value1, value2, "purpose");
            return (Criteria) this;
        }

        public Criteria andNecessityanalysisIsNull() {
            addCriterion("NecessityAnalysis is null");
            return (Criteria) this;
        }

        public Criteria andNecessityanalysisIsNotNull() {
            addCriterion("NecessityAnalysis is not null");
            return (Criteria) this;
        }

        public Criteria andNecessityanalysisEqualTo(String value) {
            addCriterion("NecessityAnalysis =", value, "necessityanalysis");
            return (Criteria) this;
        }

        public Criteria andNecessityanalysisNotEqualTo(String value) {
            addCriterion("NecessityAnalysis <>", value, "necessityanalysis");
            return (Criteria) this;
        }

        public Criteria andNecessityanalysisGreaterThan(String value) {
            addCriterion("NecessityAnalysis >", value, "necessityanalysis");
            return (Criteria) this;
        }

        public Criteria andNecessityanalysisGreaterThanOrEqualTo(String value) {
            addCriterion("NecessityAnalysis >=", value, "necessityanalysis");
            return (Criteria) this;
        }

        public Criteria andNecessityanalysisLessThan(String value) {
            addCriterion("NecessityAnalysis <", value, "necessityanalysis");
            return (Criteria) this;
        }

        public Criteria andNecessityanalysisLessThanOrEqualTo(String value) {
            addCriterion("NecessityAnalysis <=", value, "necessityanalysis");
            return (Criteria) this;
        }

        public Criteria andNecessityanalysisLike(String value) {
            addCriterion("NecessityAnalysis like", value, "necessityanalysis");
            return (Criteria) this;
        }

        public Criteria andNecessityanalysisNotLike(String value) {
            addCriterion("NecessityAnalysis not like", value, "necessityanalysis");
            return (Criteria) this;
        }

        public Criteria andNecessityanalysisIn(List<String> values) {
            addCriterion("NecessityAnalysis in", values, "necessityanalysis");
            return (Criteria) this;
        }

        public Criteria andNecessityanalysisNotIn(List<String> values) {
            addCriterion("NecessityAnalysis not in", values, "necessityanalysis");
            return (Criteria) this;
        }

        public Criteria andNecessityanalysisBetween(String value1, String value2) {
            addCriterion("NecessityAnalysis between", value1, value2, "necessityanalysis");
            return (Criteria) this;
        }

        public Criteria andNecessityanalysisNotBetween(String value1, String value2) {
            addCriterion("NecessityAnalysis not between", value1, value2, "necessityanalysis");
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
            addCriterion("Createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("Createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("Createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("Createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("Createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("Createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("Createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("Createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("Createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("Createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("Createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andModifierIsNull() {
            addCriterion("Modifier is null");
            return (Criteria) this;
        }

        public Criteria andModifierIsNotNull() {
            addCriterion("Modifier is not null");
            return (Criteria) this;
        }

        public Criteria andModifierEqualTo(String value) {
            addCriterion("Modifier =", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotEqualTo(String value) {
            addCriterion("Modifier <>", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThan(String value) {
            addCriterion("Modifier >", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThanOrEqualTo(String value) {
            addCriterion("Modifier >=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThan(String value) {
            addCriterion("Modifier <", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThanOrEqualTo(String value) {
            addCriterion("Modifier <=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLike(String value) {
            addCriterion("Modifier like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotLike(String value) {
            addCriterion("Modifier not like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierIn(List<String> values) {
            addCriterion("Modifier in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotIn(List<String> values) {
            addCriterion("Modifier not in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierBetween(String value1, String value2) {
            addCriterion("Modifier between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotBetween(String value1, String value2) {
            addCriterion("Modifier not between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifitimeIsNull() {
            addCriterion("ModifiTime is null");
            return (Criteria) this;
        }

        public Criteria andModifitimeIsNotNull() {
            addCriterion("ModifiTime is not null");
            return (Criteria) this;
        }

        public Criteria andModifitimeEqualTo(Date value) {
            addCriterion("ModifiTime =", value, "modifitime");
            return (Criteria) this;
        }

        public Criteria andModifitimeNotEqualTo(Date value) {
            addCriterion("ModifiTime <>", value, "modifitime");
            return (Criteria) this;
        }

        public Criteria andModifitimeGreaterThan(Date value) {
            addCriterion("ModifiTime >", value, "modifitime");
            return (Criteria) this;
        }

        public Criteria andModifitimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ModifiTime >=", value, "modifitime");
            return (Criteria) this;
        }

        public Criteria andModifitimeLessThan(Date value) {
            addCriterion("ModifiTime <", value, "modifitime");
            return (Criteria) this;
        }

        public Criteria andModifitimeLessThanOrEqualTo(Date value) {
            addCriterion("ModifiTime <=", value, "modifitime");
            return (Criteria) this;
        }

        public Criteria andModifitimeIn(List<Date> values) {
            addCriterion("ModifiTime in", values, "modifitime");
            return (Criteria) this;
        }

        public Criteria andModifitimeNotIn(List<Date> values) {
            addCriterion("ModifiTime not in", values, "modifitime");
            return (Criteria) this;
        }

        public Criteria andModifitimeBetween(Date value1, Date value2) {
            addCriterion("ModifiTime between", value1, value2, "modifitime");
            return (Criteria) this;
        }

        public Criteria andModifitimeNotBetween(Date value1, Date value2) {
            addCriterion("ModifiTime not between", value1, value2, "modifitime");
            return (Criteria) this;
        }

        public Criteria andDeleteflagIsNull() {
            addCriterion("DeleteFlag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteflagIsNotNull() {
            addCriterion("DeleteFlag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteflagEqualTo(String value) {
            addCriterion("DeleteFlag =", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagNotEqualTo(String value) {
            addCriterion("DeleteFlag <>", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagGreaterThan(String value) {
            addCriterion("DeleteFlag >", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagGreaterThanOrEqualTo(String value) {
            addCriterion("DeleteFlag >=", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagLessThan(String value) {
            addCriterion("DeleteFlag <", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagLessThanOrEqualTo(String value) {
            addCriterion("DeleteFlag <=", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagLike(String value) {
            addCriterion("DeleteFlag like", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagNotLike(String value) {
            addCriterion("DeleteFlag not like", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagIn(List<String> values) {
            addCriterion("DeleteFlag in", values, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagNotIn(List<String> values) {
            addCriterion("DeleteFlag not in", values, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagBetween(String value1, String value2) {
            addCriterion("DeleteFlag between", value1, value2, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagNotBetween(String value1, String value2) {
            addCriterion("DeleteFlag not between", value1, value2, "deleteflag");
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
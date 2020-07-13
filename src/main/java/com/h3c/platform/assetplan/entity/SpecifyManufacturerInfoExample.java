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

        public Criteria andSpecifymanufactureridIsNull() {
            addCriterion("SpecifyManufacturerID is null");
            return (Criteria) this;
        }

        public Criteria andSpecifymanufactureridIsNotNull() {
            addCriterion("SpecifyManufacturerID is not null");
            return (Criteria) this;
        }

        public Criteria andSpecifymanufactureridEqualTo(String value) {
            addCriterion("SpecifyManufacturerID =", value, "specifymanufacturerid");
            return (Criteria) this;
        }

        public Criteria andSpecifymanufactureridNotEqualTo(String value) {
            addCriterion("SpecifyManufacturerID <>", value, "specifymanufacturerid");
            return (Criteria) this;
        }

        public Criteria andSpecifymanufactureridGreaterThan(String value) {
            addCriterion("SpecifyManufacturerID >", value, "specifymanufacturerid");
            return (Criteria) this;
        }

        public Criteria andSpecifymanufactureridGreaterThanOrEqualTo(String value) {
            addCriterion("SpecifyManufacturerID >=", value, "specifymanufacturerid");
            return (Criteria) this;
        }

        public Criteria andSpecifymanufactureridLessThan(String value) {
            addCriterion("SpecifyManufacturerID <", value, "specifymanufacturerid");
            return (Criteria) this;
        }

        public Criteria andSpecifymanufactureridLessThanOrEqualTo(String value) {
            addCriterion("SpecifyManufacturerID <=", value, "specifymanufacturerid");
            return (Criteria) this;
        }

        public Criteria andSpecifymanufactureridLike(String value) {
            addCriterion("SpecifyManufacturerID like", value, "specifymanufacturerid");
            return (Criteria) this;
        }

        public Criteria andSpecifymanufactureridNotLike(String value) {
            addCriterion("SpecifyManufacturerID not like", value, "specifymanufacturerid");
            return (Criteria) this;
        }

        public Criteria andSpecifymanufactureridIn(List<String> values) {
            addCriterion("SpecifyManufacturerID in", values, "specifymanufacturerid");
            return (Criteria) this;
        }

        public Criteria andSpecifymanufactureridNotIn(List<String> values) {
            addCriterion("SpecifyManufacturerID not in", values, "specifymanufacturerid");
            return (Criteria) this;
        }

        public Criteria andSpecifymanufactureridBetween(String value1, String value2) {
            addCriterion("SpecifyManufacturerID between", value1, value2, "specifymanufacturerid");
            return (Criteria) this;
        }

        public Criteria andSpecifymanufactureridNotBetween(String value1, String value2) {
            addCriterion("SpecifyManufacturerID not between", value1, value2, "specifymanufacturerid");
            return (Criteria) this;
        }

        public Criteria andTitlecodeIsNull() {
            addCriterion("TitleCode is null");
            return (Criteria) this;
        }

        public Criteria andTitlecodeIsNotNull() {
            addCriterion("TitleCode is not null");
            return (Criteria) this;
        }

        public Criteria andTitlecodeEqualTo(String value) {
            addCriterion("TitleCode =", value, "titlecode");
            return (Criteria) this;
        }

        public Criteria andTitlecodeNotEqualTo(String value) {
            addCriterion("TitleCode <>", value, "titlecode");
            return (Criteria) this;
        }

        public Criteria andTitlecodeGreaterThan(String value) {
            addCriterion("TitleCode >", value, "titlecode");
            return (Criteria) this;
        }

        public Criteria andTitlecodeGreaterThanOrEqualTo(String value) {
            addCriterion("TitleCode >=", value, "titlecode");
            return (Criteria) this;
        }

        public Criteria andTitlecodeLessThan(String value) {
            addCriterion("TitleCode <", value, "titlecode");
            return (Criteria) this;
        }

        public Criteria andTitlecodeLessThanOrEqualTo(String value) {
            addCriterion("TitleCode <=", value, "titlecode");
            return (Criteria) this;
        }

        public Criteria andTitlecodeLike(String value) {
            addCriterion("TitleCode like", value, "titlecode");
            return (Criteria) this;
        }

        public Criteria andTitlecodeNotLike(String value) {
            addCriterion("TitleCode not like", value, "titlecode");
            return (Criteria) this;
        }

        public Criteria andTitlecodeIn(List<String> values) {
            addCriterion("TitleCode in", values, "titlecode");
            return (Criteria) this;
        }

        public Criteria andTitlecodeNotIn(List<String> values) {
            addCriterion("TitleCode not in", values, "titlecode");
            return (Criteria) this;
        }

        public Criteria andTitlecodeBetween(String value1, String value2) {
            addCriterion("TitleCode between", value1, value2, "titlecode");
            return (Criteria) this;
        }

        public Criteria andTitlecodeNotBetween(String value1, String value2) {
            addCriterion("TitleCode not between", value1, value2, "titlecode");
            return (Criteria) this;
        }

        public Criteria andInfoIsNull() {
            addCriterion("Info is null");
            return (Criteria) this;
        }

        public Criteria andInfoIsNotNull() {
            addCriterion("Info is not null");
            return (Criteria) this;
        }

        public Criteria andInfoEqualTo(String value) {
            addCriterion("Info =", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotEqualTo(String value) {
            addCriterion("Info <>", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoGreaterThan(String value) {
            addCriterion("Info >", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoGreaterThanOrEqualTo(String value) {
            addCriterion("Info >=", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLessThan(String value) {
            addCriterion("Info <", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLessThanOrEqualTo(String value) {
            addCriterion("Info <=", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLike(String value) {
            addCriterion("Info like", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotLike(String value) {
            addCriterion("Info not like", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoIn(List<String> values) {
            addCriterion("Info in", values, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotIn(List<String> values) {
            addCriterion("Info not in", values, "info");
            return (Criteria) this;
        }

        public Criteria andInfoBetween(String value1, String value2) {
            addCriterion("Info between", value1, value2, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotBetween(String value1, String value2) {
            addCriterion("Info not between", value1, value2, "info");
            return (Criteria) this;
        }

        public Criteria andPicturepathIsNull() {
            addCriterion("PicturePath is null");
            return (Criteria) this;
        }

        public Criteria andPicturepathIsNotNull() {
            addCriterion("PicturePath is not null");
            return (Criteria) this;
        }

        public Criteria andPicturepathEqualTo(String value) {
            addCriterion("PicturePath =", value, "picturepath");
            return (Criteria) this;
        }

        public Criteria andPicturepathNotEqualTo(String value) {
            addCriterion("PicturePath <>", value, "picturepath");
            return (Criteria) this;
        }

        public Criteria andPicturepathGreaterThan(String value) {
            addCriterion("PicturePath >", value, "picturepath");
            return (Criteria) this;
        }

        public Criteria andPicturepathGreaterThanOrEqualTo(String value) {
            addCriterion("PicturePath >=", value, "picturepath");
            return (Criteria) this;
        }

        public Criteria andPicturepathLessThan(String value) {
            addCriterion("PicturePath <", value, "picturepath");
            return (Criteria) this;
        }

        public Criteria andPicturepathLessThanOrEqualTo(String value) {
            addCriterion("PicturePath <=", value, "picturepath");
            return (Criteria) this;
        }

        public Criteria andPicturepathLike(String value) {
            addCriterion("PicturePath like", value, "picturepath");
            return (Criteria) this;
        }

        public Criteria andPicturepathNotLike(String value) {
            addCriterion("PicturePath not like", value, "picturepath");
            return (Criteria) this;
        }

        public Criteria andPicturepathIn(List<String> values) {
            addCriterion("PicturePath in", values, "picturepath");
            return (Criteria) this;
        }

        public Criteria andPicturepathNotIn(List<String> values) {
            addCriterion("PicturePath not in", values, "picturepath");
            return (Criteria) this;
        }

        public Criteria andPicturepathBetween(String value1, String value2) {
            addCriterion("PicturePath between", value1, value2, "picturepath");
            return (Criteria) this;
        }

        public Criteria andPicturepathNotBetween(String value1, String value2) {
            addCriterion("PicturePath not between", value1, value2, "picturepath");
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
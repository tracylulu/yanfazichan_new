package com.h3c.platform.assetplan.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AssetPlanInfoMenuViewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssetPlanInfoMenuViewExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andPlancodeIsNull() {
            addCriterion("PlanCode is null");
            return (Criteria) this;
        }

        public Criteria andPlancodeIsNotNull() {
            addCriterion("PlanCode is not null");
            return (Criteria) this;
        }

        public Criteria andPlancodeEqualTo(String value) {
            addCriterion("PlanCode =", value, "plancode");
            return (Criteria) this;
        }

        public Criteria andPlancodeNotEqualTo(String value) {
            addCriterion("PlanCode <>", value, "plancode");
            return (Criteria) this;
        }

        public Criteria andPlancodeGreaterThan(String value) {
            addCriterion("PlanCode >", value, "plancode");
            return (Criteria) this;
        }

        public Criteria andPlancodeGreaterThanOrEqualTo(String value) {
            addCriterion("PlanCode >=", value, "plancode");
            return (Criteria) this;
        }

        public Criteria andPlancodeLessThan(String value) {
            addCriterion("PlanCode <", value, "plancode");
            return (Criteria) this;
        }

        public Criteria andPlancodeLessThanOrEqualTo(String value) {
            addCriterion("PlanCode <=", value, "plancode");
            return (Criteria) this;
        }

        public Criteria andPlancodeLike(String value) {
            addCriterion("PlanCode like", value, "plancode");
            return (Criteria) this;
        }

        public Criteria andPlancodeNotLike(String value) {
            addCriterion("PlanCode not like", value, "plancode");
            return (Criteria) this;
        }

        public Criteria andPlancodeIn(List<String> values) {
            addCriterion("PlanCode in", values, "plancode");
            return (Criteria) this;
        }

        public Criteria andPlancodeNotIn(List<String> values) {
            addCriterion("PlanCode not in", values, "plancode");
            return (Criteria) this;
        }

        public Criteria andPlancodeBetween(String value1, String value2) {
            addCriterion("PlanCode between", value1, value2, "plancode");
            return (Criteria) this;
        }

        public Criteria andPlancodeNotBetween(String value1, String value2) {
            addCriterion("PlanCode not between", value1, value2, "plancode");
            return (Criteria) this;
        }

        public Criteria andAssetnameIsNull() {
            addCriterion("AssetName is null");
            return (Criteria) this;
        }

        public Criteria andAssetnameIsNotNull() {
            addCriterion("AssetName is not null");
            return (Criteria) this;
        }

        public Criteria andAssetnameEqualTo(String value) {
            addCriterion("AssetName =", value, "assetname");
            return (Criteria) this;
        }

        public Criteria andAssetnameNotEqualTo(String value) {
            addCriterion("AssetName <>", value, "assetname");
            return (Criteria) this;
        }

        public Criteria andAssetnameGreaterThan(String value) {
            addCriterion("AssetName >", value, "assetname");
            return (Criteria) this;
        }

        public Criteria andAssetnameGreaterThanOrEqualTo(String value) {
            addCriterion("AssetName >=", value, "assetname");
            return (Criteria) this;
        }

        public Criteria andAssetnameLessThan(String value) {
            addCriterion("AssetName <", value, "assetname");
            return (Criteria) this;
        }

        public Criteria andAssetnameLessThanOrEqualTo(String value) {
            addCriterion("AssetName <=", value, "assetname");
            return (Criteria) this;
        }

        public Criteria andAssetnameLike(String value) {
            addCriterion("AssetName like", value, "assetname");
            return (Criteria) this;
        }

        public Criteria andAssetnameNotLike(String value) {
            addCriterion("AssetName not like", value, "assetname");
            return (Criteria) this;
        }

        public Criteria andAssetnameIn(List<String> values) {
            addCriterion("AssetName in", values, "assetname");
            return (Criteria) this;
        }

        public Criteria andAssetnameNotIn(List<String> values) {
            addCriterion("AssetName not in", values, "assetname");
            return (Criteria) this;
        }

        public Criteria andAssetnameBetween(String value1, String value2) {
            addCriterion("AssetName between", value1, value2, "assetname");
            return (Criteria) this;
        }

        public Criteria andAssetnameNotBetween(String value1, String value2) {
            addCriterion("AssetName not between", value1, value2, "assetname");
            return (Criteria) this;
        }

        public Criteria andAssetmanufacturerIsNull() {
            addCriterion("AssetManufacturer is null");
            return (Criteria) this;
        }

        public Criteria andAssetmanufacturerIsNotNull() {
            addCriterion("AssetManufacturer is not null");
            return (Criteria) this;
        }

        public Criteria andAssetmanufacturerEqualTo(String value) {
            addCriterion("AssetManufacturer =", value, "assetmanufacturer");
            return (Criteria) this;
        }

        public Criteria andAssetmanufacturerNotEqualTo(String value) {
            addCriterion("AssetManufacturer <>", value, "assetmanufacturer");
            return (Criteria) this;
        }

        public Criteria andAssetmanufacturerGreaterThan(String value) {
            addCriterion("AssetManufacturer >", value, "assetmanufacturer");
            return (Criteria) this;
        }

        public Criteria andAssetmanufacturerGreaterThanOrEqualTo(String value) {
            addCriterion("AssetManufacturer >=", value, "assetmanufacturer");
            return (Criteria) this;
        }

        public Criteria andAssetmanufacturerLessThan(String value) {
            addCriterion("AssetManufacturer <", value, "assetmanufacturer");
            return (Criteria) this;
        }

        public Criteria andAssetmanufacturerLessThanOrEqualTo(String value) {
            addCriterion("AssetManufacturer <=", value, "assetmanufacturer");
            return (Criteria) this;
        }

        public Criteria andAssetmanufacturerLike(String value) {
            addCriterion("AssetManufacturer like", value, "assetmanufacturer");
            return (Criteria) this;
        }

        public Criteria andAssetmanufacturerNotLike(String value) {
            addCriterion("AssetManufacturer not like", value, "assetmanufacturer");
            return (Criteria) this;
        }

        public Criteria andAssetmanufacturerIn(List<String> values) {
            addCriterion("AssetManufacturer in", values, "assetmanufacturer");
            return (Criteria) this;
        }

        public Criteria andAssetmanufacturerNotIn(List<String> values) {
            addCriterion("AssetManufacturer not in", values, "assetmanufacturer");
            return (Criteria) this;
        }

        public Criteria andAssetmanufacturerBetween(String value1, String value2) {
            addCriterion("AssetManufacturer between", value1, value2, "assetmanufacturer");
            return (Criteria) this;
        }

        public Criteria andAssetmanufacturerNotBetween(String value1, String value2) {
            addCriterion("AssetManufacturer not between", value1, value2, "assetmanufacturer");
            return (Criteria) this;
        }

        public Criteria andAssetmodelIsNull() {
            addCriterion("AssetModel is null");
            return (Criteria) this;
        }

        public Criteria andAssetmodelIsNotNull() {
            addCriterion("AssetModel is not null");
            return (Criteria) this;
        }

        public Criteria andAssetmodelEqualTo(String value) {
            addCriterion("AssetModel =", value, "assetmodel");
            return (Criteria) this;
        }

        public Criteria andAssetmodelNotEqualTo(String value) {
            addCriterion("AssetModel <>", value, "assetmodel");
            return (Criteria) this;
        }

        public Criteria andAssetmodelGreaterThan(String value) {
            addCriterion("AssetModel >", value, "assetmodel");
            return (Criteria) this;
        }

        public Criteria andAssetmodelGreaterThanOrEqualTo(String value) {
            addCriterion("AssetModel >=", value, "assetmodel");
            return (Criteria) this;
        }

        public Criteria andAssetmodelLessThan(String value) {
            addCriterion("AssetModel <", value, "assetmodel");
            return (Criteria) this;
        }

        public Criteria andAssetmodelLessThanOrEqualTo(String value) {
            addCriterion("AssetModel <=", value, "assetmodel");
            return (Criteria) this;
        }

        public Criteria andAssetmodelLike(String value) {
            addCriterion("AssetModel like", value, "assetmodel");
            return (Criteria) this;
        }

        public Criteria andAssetmodelNotLike(String value) {
            addCriterion("AssetModel not like", value, "assetmodel");
            return (Criteria) this;
        }

        public Criteria andAssetmodelIn(List<String> values) {
            addCriterion("AssetModel in", values, "assetmodel");
            return (Criteria) this;
        }

        public Criteria andAssetmodelNotIn(List<String> values) {
            addCriterion("AssetModel not in", values, "assetmodel");
            return (Criteria) this;
        }

        public Criteria andAssetmodelBetween(String value1, String value2) {
            addCriterion("AssetModel between", value1, value2, "assetmodel");
            return (Criteria) this;
        }

        public Criteria andAssetmodelNotBetween(String value1, String value2) {
            addCriterion("AssetModel not between", value1, value2, "assetmodel");
            return (Criteria) this;
        }

        public Criteria andAssetcategoryIsNull() {
            addCriterion("AssetCategory is null");
            return (Criteria) this;
        }

        public Criteria andAssetcategoryIsNotNull() {
            addCriterion("AssetCategory is not null");
            return (Criteria) this;
        }

        public Criteria andAssetcategoryEqualTo(String value) {
            addCriterion("AssetCategory =", value, "assetcategory");
            return (Criteria) this;
        }

        public Criteria andAssetcategoryNotEqualTo(String value) {
            addCriterion("AssetCategory <>", value, "assetcategory");
            return (Criteria) this;
        }

        public Criteria andAssetcategoryGreaterThan(String value) {
            addCriterion("AssetCategory >", value, "assetcategory");
            return (Criteria) this;
        }

        public Criteria andAssetcategoryGreaterThanOrEqualTo(String value) {
            addCriterion("AssetCategory >=", value, "assetcategory");
            return (Criteria) this;
        }

        public Criteria andAssetcategoryLessThan(String value) {
            addCriterion("AssetCategory <", value, "assetcategory");
            return (Criteria) this;
        }

        public Criteria andAssetcategoryLessThanOrEqualTo(String value) {
            addCriterion("AssetCategory <=", value, "assetcategory");
            return (Criteria) this;
        }

        public Criteria andAssetcategoryLike(String value) {
            addCriterion("AssetCategory like", value, "assetcategory");
            return (Criteria) this;
        }

        public Criteria andAssetcategoryNotLike(String value) {
            addCriterion("AssetCategory not like", value, "assetcategory");
            return (Criteria) this;
        }

        public Criteria andAssetcategoryIn(List<String> values) {
            addCriterion("AssetCategory in", values, "assetcategory");
            return (Criteria) this;
        }

        public Criteria andAssetcategoryNotIn(List<String> values) {
            addCriterion("AssetCategory not in", values, "assetcategory");
            return (Criteria) this;
        }

        public Criteria andAssetcategoryBetween(String value1, String value2) {
            addCriterion("AssetCategory between", value1, value2, "assetcategory");
            return (Criteria) this;
        }

        public Criteria andAssetcategoryNotBetween(String value1, String value2) {
            addCriterion("AssetCategory not between", value1, value2, "assetcategory");
            return (Criteria) this;
        }

        public Criteria andPpriceIsNull() {
            addCriterion("PPrice is null");
            return (Criteria) this;
        }

        public Criteria andPpriceIsNotNull() {
            addCriterion("PPrice is not null");
            return (Criteria) this;
        }

        public Criteria andPpriceEqualTo(BigDecimal value) {
            addCriterion("PPrice =", value, "pprice");
            return (Criteria) this;
        }

        public Criteria andPpriceNotEqualTo(BigDecimal value) {
            addCriterion("PPrice <>", value, "pprice");
            return (Criteria) this;
        }

        public Criteria andPpriceGreaterThan(BigDecimal value) {
            addCriterion("PPrice >", value, "pprice");
            return (Criteria) this;
        }

        public Criteria andPpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PPrice >=", value, "pprice");
            return (Criteria) this;
        }

        public Criteria andPpriceLessThan(BigDecimal value) {
            addCriterion("PPrice <", value, "pprice");
            return (Criteria) this;
        }

        public Criteria andPpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PPrice <=", value, "pprice");
            return (Criteria) this;
        }

        public Criteria andPpriceIn(List<BigDecimal> values) {
            addCriterion("PPrice in", values, "pprice");
            return (Criteria) this;
        }

        public Criteria andPpriceNotIn(List<BigDecimal> values) {
            addCriterion("PPrice not in", values, "pprice");
            return (Criteria) this;
        }

        public Criteria andPpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PPrice between", value1, value2, "pprice");
            return (Criteria) this;
        }

        public Criteria andPpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PPrice not between", value1, value2, "pprice");
            return (Criteria) this;
        }

        public Criteria andPlanmonthIsNull() {
            addCriterion("PlanMonth is null");
            return (Criteria) this;
        }

        public Criteria andPlanmonthIsNotNull() {
            addCriterion("PlanMonth is not null");
            return (Criteria) this;
        }

        public Criteria andPlanmonthEqualTo(Date value) {
            addCriterionForJDBCDate("PlanMonth =", value, "planmonth");
            return (Criteria) this;
        }

        public Criteria andPlanmonthNotEqualTo(Date value) {
            addCriterionForJDBCDate("PlanMonth <>", value, "planmonth");
            return (Criteria) this;
        }

        public Criteria andPlanmonthGreaterThan(Date value) {
            addCriterionForJDBCDate("PlanMonth >", value, "planmonth");
            return (Criteria) this;
        }

        public Criteria andPlanmonthGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PlanMonth >=", value, "planmonth");
            return (Criteria) this;
        }

        public Criteria andPlanmonthLessThan(Date value) {
            addCriterionForJDBCDate("PlanMonth <", value, "planmonth");
            return (Criteria) this;
        }

        public Criteria andPlanmonthLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PlanMonth <=", value, "planmonth");
            return (Criteria) this;
        }

        public Criteria andPlanmonthIn(List<Date> values) {
            addCriterionForJDBCDate("PlanMonth in", values, "planmonth");
            return (Criteria) this;
        }

        public Criteria andPlanmonthNotIn(List<Date> values) {
            addCriterionForJDBCDate("PlanMonth not in", values, "planmonth");
            return (Criteria) this;
        }

        public Criteria andPlanmonthBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PlanMonth between", value1, value2, "planmonth");
            return (Criteria) this;
        }

        public Criteria andPlanmonthNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PlanMonth not between", value1, value2, "planmonth");
            return (Criteria) this;
        }

        public Criteria andRequireduserIsNull() {
            addCriterion("RequiredUser is null");
            return (Criteria) this;
        }

        public Criteria andRequireduserIsNotNull() {
            addCriterion("RequiredUser is not null");
            return (Criteria) this;
        }

        public Criteria andRequireduserEqualTo(String value) {
            addCriterion("RequiredUser =", value, "requireduser");
            return (Criteria) this;
        }

        public Criteria andRequireduserNotEqualTo(String value) {
            addCriterion("RequiredUser <>", value, "requireduser");
            return (Criteria) this;
        }

        public Criteria andRequireduserGreaterThan(String value) {
            addCriterion("RequiredUser >", value, "requireduser");
            return (Criteria) this;
        }

        public Criteria andRequireduserGreaterThanOrEqualTo(String value) {
            addCriterion("RequiredUser >=", value, "requireduser");
            return (Criteria) this;
        }

        public Criteria andRequireduserLessThan(String value) {
            addCriterion("RequiredUser <", value, "requireduser");
            return (Criteria) this;
        }

        public Criteria andRequireduserLessThanOrEqualTo(String value) {
            addCriterion("RequiredUser <=", value, "requireduser");
            return (Criteria) this;
        }

        public Criteria andRequireduserLike(String value) {
            addCriterion("RequiredUser like", value, "requireduser");
            return (Criteria) this;
        }

        public Criteria andRequireduserNotLike(String value) {
            addCriterion("RequiredUser not like", value, "requireduser");
            return (Criteria) this;
        }

        public Criteria andRequireduserIn(List<String> values) {
            addCriterion("RequiredUser in", values, "requireduser");
            return (Criteria) this;
        }

        public Criteria andRequireduserNotIn(List<String> values) {
            addCriterion("RequiredUser not in", values, "requireduser");
            return (Criteria) this;
        }

        public Criteria andRequireduserBetween(String value1, String value2) {
            addCriterion("RequiredUser between", value1, value2, "requireduser");
            return (Criteria) this;
        }

        public Criteria andRequireduserNotBetween(String value1, String value2) {
            addCriterion("RequiredUser not between", value1, value2, "requireduser");
            return (Criteria) this;
        }

        public Criteria andApplyuserIsNull() {
            addCriterion("ApplyUser is null");
            return (Criteria) this;
        }

        public Criteria andApplyuserIsNotNull() {
            addCriterion("ApplyUser is not null");
            return (Criteria) this;
        }

        public Criteria andApplyuserEqualTo(String value) {
            addCriterion("ApplyUser =", value, "applyuser");
            return (Criteria) this;
        }

        public Criteria andApplyuserNotEqualTo(String value) {
            addCriterion("ApplyUser <>", value, "applyuser");
            return (Criteria) this;
        }

        public Criteria andApplyuserGreaterThan(String value) {
            addCriterion("ApplyUser >", value, "applyuser");
            return (Criteria) this;
        }

        public Criteria andApplyuserGreaterThanOrEqualTo(String value) {
            addCriterion("ApplyUser >=", value, "applyuser");
            return (Criteria) this;
        }

        public Criteria andApplyuserLessThan(String value) {
            addCriterion("ApplyUser <", value, "applyuser");
            return (Criteria) this;
        }

        public Criteria andApplyuserLessThanOrEqualTo(String value) {
            addCriterion("ApplyUser <=", value, "applyuser");
            return (Criteria) this;
        }

        public Criteria andApplyuserLike(String value) {
            addCriterion("ApplyUser like", value, "applyuser");
            return (Criteria) this;
        }

        public Criteria andApplyuserNotLike(String value) {
            addCriterion("ApplyUser not like", value, "applyuser");
            return (Criteria) this;
        }

        public Criteria andApplyuserIn(List<String> values) {
            addCriterion("ApplyUser in", values, "applyuser");
            return (Criteria) this;
        }

        public Criteria andApplyuserNotIn(List<String> values) {
            addCriterion("ApplyUser not in", values, "applyuser");
            return (Criteria) this;
        }

        public Criteria andApplyuserBetween(String value1, String value2) {
            addCriterion("ApplyUser between", value1, value2, "applyuser");
            return (Criteria) this;
        }

        public Criteria andApplyuserNotBetween(String value1, String value2) {
            addCriterion("ApplyUser not between", value1, value2, "applyuser");
            return (Criteria) this;
        }

        public Criteria andApplytimeIsNull() {
            addCriterion("ApplyTime is null");
            return (Criteria) this;
        }

        public Criteria andApplytimeIsNotNull() {
            addCriterion("ApplyTime is not null");
            return (Criteria) this;
        }

        public Criteria andApplytimeEqualTo(Date value) {
            addCriterion("ApplyTime =", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotEqualTo(Date value) {
            addCriterion("ApplyTime <>", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeGreaterThan(Date value) {
            addCriterion("ApplyTime >", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ApplyTime >=", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeLessThan(Date value) {
            addCriterion("ApplyTime <", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeLessThanOrEqualTo(Date value) {
            addCriterion("ApplyTime <=", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeIn(List<Date> values) {
            addCriterion("ApplyTime in", values, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotIn(List<Date> values) {
            addCriterion("ApplyTime not in", values, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeBetween(Date value1, Date value2) {
            addCriterion("ApplyTime between", value1, value2, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotBetween(Date value1, Date value2) {
            addCriterion("ApplyTime not between", value1, value2, "applytime");
            return (Criteria) this;
        }

        public Criteria andReviewpersonIsNull() {
            addCriterion("ReviewPerson is null");
            return (Criteria) this;
        }

        public Criteria andReviewpersonIsNotNull() {
            addCriterion("ReviewPerson is not null");
            return (Criteria) this;
        }

        public Criteria andReviewpersonEqualTo(String value) {
            addCriterion("ReviewPerson =", value, "reviewperson");
            return (Criteria) this;
        }

        public Criteria andReviewpersonNotEqualTo(String value) {
            addCriterion("ReviewPerson <>", value, "reviewperson");
            return (Criteria) this;
        }

        public Criteria andReviewpersonGreaterThan(String value) {
            addCriterion("ReviewPerson >", value, "reviewperson");
            return (Criteria) this;
        }

        public Criteria andReviewpersonGreaterThanOrEqualTo(String value) {
            addCriterion("ReviewPerson >=", value, "reviewperson");
            return (Criteria) this;
        }

        public Criteria andReviewpersonLessThan(String value) {
            addCriterion("ReviewPerson <", value, "reviewperson");
            return (Criteria) this;
        }

        public Criteria andReviewpersonLessThanOrEqualTo(String value) {
            addCriterion("ReviewPerson <=", value, "reviewperson");
            return (Criteria) this;
        }

        public Criteria andReviewpersonLike(String value) {
            addCriterion("ReviewPerson like", value, "reviewperson");
            return (Criteria) this;
        }

        public Criteria andReviewpersonNotLike(String value) {
            addCriterion("ReviewPerson not like", value, "reviewperson");
            return (Criteria) this;
        }

        public Criteria andReviewpersonIn(List<String> values) {
            addCriterion("ReviewPerson in", values, "reviewperson");
            return (Criteria) this;
        }

        public Criteria andReviewpersonNotIn(List<String> values) {
            addCriterion("ReviewPerson not in", values, "reviewperson");
            return (Criteria) this;
        }

        public Criteria andReviewpersonBetween(String value1, String value2) {
            addCriterion("ReviewPerson between", value1, value2, "reviewperson");
            return (Criteria) this;
        }

        public Criteria andReviewpersonNotBetween(String value1, String value2) {
            addCriterion("ReviewPerson not between", value1, value2, "reviewperson");
            return (Criteria) this;
        }

        public Criteria andReviewerIsNull() {
            addCriterion("Reviewer is null");
            return (Criteria) this;
        }

        public Criteria andReviewerIsNotNull() {
            addCriterion("Reviewer is not null");
            return (Criteria) this;
        }

        public Criteria andReviewerEqualTo(String value) {
            addCriterion("Reviewer =", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerNotEqualTo(String value) {
            addCriterion("Reviewer <>", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerGreaterThan(String value) {
            addCriterion("Reviewer >", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerGreaterThanOrEqualTo(String value) {
            addCriterion("Reviewer >=", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerLessThan(String value) {
            addCriterion("Reviewer <", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerLessThanOrEqualTo(String value) {
            addCriterion("Reviewer <=", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerLike(String value) {
            addCriterion("Reviewer like", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerNotLike(String value) {
            addCriterion("Reviewer not like", value, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerIn(List<String> values) {
            addCriterion("Reviewer in", values, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerNotIn(List<String> values) {
            addCriterion("Reviewer not in", values, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerBetween(String value1, String value2) {
            addCriterion("Reviewer between", value1, value2, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewerNotBetween(String value1, String value2) {
            addCriterion("Reviewer not between", value1, value2, "reviewer");
            return (Criteria) this;
        }

        public Criteria andReviewresultIsNull() {
            addCriterion("ReviewResult is null");
            return (Criteria) this;
        }

        public Criteria andReviewresultIsNotNull() {
            addCriterion("ReviewResult is not null");
            return (Criteria) this;
        }

        public Criteria andReviewresultEqualTo(Integer value) {
            addCriterion("ReviewResult =", value, "reviewresult");
            return (Criteria) this;
        }

        public Criteria andReviewresultNotEqualTo(Integer value) {
            addCriterion("ReviewResult <>", value, "reviewresult");
            return (Criteria) this;
        }

        public Criteria andReviewresultGreaterThan(Integer value) {
            addCriterion("ReviewResult >", value, "reviewresult");
            return (Criteria) this;
        }

        public Criteria andReviewresultGreaterThanOrEqualTo(Integer value) {
            addCriterion("ReviewResult >=", value, "reviewresult");
            return (Criteria) this;
        }

        public Criteria andReviewresultLessThan(Integer value) {
            addCriterion("ReviewResult <", value, "reviewresult");
            return (Criteria) this;
        }

        public Criteria andReviewresultLessThanOrEqualTo(Integer value) {
            addCriterion("ReviewResult <=", value, "reviewresult");
            return (Criteria) this;
        }

        public Criteria andReviewresultIn(List<Integer> values) {
            addCriterion("ReviewResult in", values, "reviewresult");
            return (Criteria) this;
        }

        public Criteria andReviewresultNotIn(List<Integer> values) {
            addCriterion("ReviewResult not in", values, "reviewresult");
            return (Criteria) this;
        }

        public Criteria andReviewresultBetween(Integer value1, Integer value2) {
            addCriterion("ReviewResult between", value1, value2, "reviewresult");
            return (Criteria) this;
        }

        public Criteria andReviewresultNotBetween(Integer value1, Integer value2) {
            addCriterion("ReviewResult not between", value1, value2, "reviewresult");
            return (Criteria) this;
        }

        public Criteria andDept3managerIsNull() {
            addCriterion("Dept3Manager is null");
            return (Criteria) this;
        }

        public Criteria andDept3managerIsNotNull() {
            addCriterion("Dept3Manager is not null");
            return (Criteria) this;
        }

        public Criteria andDept3managerEqualTo(String value) {
            addCriterion("Dept3Manager =", value, "dept3manager");
            return (Criteria) this;
        }

        public Criteria andDept3managerNotEqualTo(String value) {
            addCriterion("Dept3Manager <>", value, "dept3manager");
            return (Criteria) this;
        }

        public Criteria andDept3managerGreaterThan(String value) {
            addCriterion("Dept3Manager >", value, "dept3manager");
            return (Criteria) this;
        }

        public Criteria andDept3managerGreaterThanOrEqualTo(String value) {
            addCriterion("Dept3Manager >=", value, "dept3manager");
            return (Criteria) this;
        }

        public Criteria andDept3managerLessThan(String value) {
            addCriterion("Dept3Manager <", value, "dept3manager");
            return (Criteria) this;
        }

        public Criteria andDept3managerLessThanOrEqualTo(String value) {
            addCriterion("Dept3Manager <=", value, "dept3manager");
            return (Criteria) this;
        }

        public Criteria andDept3managerLike(String value) {
            addCriterion("Dept3Manager like", value, "dept3manager");
            return (Criteria) this;
        }

        public Criteria andDept3managerNotLike(String value) {
            addCriterion("Dept3Manager not like", value, "dept3manager");
            return (Criteria) this;
        }

        public Criteria andDept3managerIn(List<String> values) {
            addCriterion("Dept3Manager in", values, "dept3manager");
            return (Criteria) this;
        }

        public Criteria andDept3managerNotIn(List<String> values) {
            addCriterion("Dept3Manager not in", values, "dept3manager");
            return (Criteria) this;
        }

        public Criteria andDept3managerBetween(String value1, String value2) {
            addCriterion("Dept3Manager between", value1, value2, "dept3manager");
            return (Criteria) this;
        }

        public Criteria andDept3managerNotBetween(String value1, String value2) {
            addCriterion("Dept3Manager not between", value1, value2, "dept3manager");
            return (Criteria) this;
        }

        public Criteria andDept2managerIsNull() {
            addCriterion("Dept2Manager is null");
            return (Criteria) this;
        }

        public Criteria andDept2managerIsNotNull() {
            addCriterion("Dept2Manager is not null");
            return (Criteria) this;
        }

        public Criteria andDept2managerEqualTo(String value) {
            addCriterion("Dept2Manager =", value, "dept2manager");
            return (Criteria) this;
        }

        public Criteria andDept2managerNotEqualTo(String value) {
            addCriterion("Dept2Manager <>", value, "dept2manager");
            return (Criteria) this;
        }

        public Criteria andDept2managerGreaterThan(String value) {
            addCriterion("Dept2Manager >", value, "dept2manager");
            return (Criteria) this;
        }

        public Criteria andDept2managerGreaterThanOrEqualTo(String value) {
            addCriterion("Dept2Manager >=", value, "dept2manager");
            return (Criteria) this;
        }

        public Criteria andDept2managerLessThan(String value) {
            addCriterion("Dept2Manager <", value, "dept2manager");
            return (Criteria) this;
        }

        public Criteria andDept2managerLessThanOrEqualTo(String value) {
            addCriterion("Dept2Manager <=", value, "dept2manager");
            return (Criteria) this;
        }

        public Criteria andDept2managerLike(String value) {
            addCriterion("Dept2Manager like", value, "dept2manager");
            return (Criteria) this;
        }

        public Criteria andDept2managerNotLike(String value) {
            addCriterion("Dept2Manager not like", value, "dept2manager");
            return (Criteria) this;
        }

        public Criteria andDept2managerIn(List<String> values) {
            addCriterion("Dept2Manager in", values, "dept2manager");
            return (Criteria) this;
        }

        public Criteria andDept2managerNotIn(List<String> values) {
            addCriterion("Dept2Manager not in", values, "dept2manager");
            return (Criteria) this;
        }

        public Criteria andDept2managerBetween(String value1, String value2) {
            addCriterion("Dept2Manager between", value1, value2, "dept2manager");
            return (Criteria) this;
        }

        public Criteria andDept2managerNotBetween(String value1, String value2) {
            addCriterion("Dept2Manager not between", value1, value2, "dept2manager");
            return (Criteria) this;
        }

        public Criteria andPlannerIsNull() {
            addCriterion("Planner is null");
            return (Criteria) this;
        }

        public Criteria andPlannerIsNotNull() {
            addCriterion("Planner is not null");
            return (Criteria) this;
        }

        public Criteria andPlannerEqualTo(String value) {
            addCriterion("Planner =", value, "planner");
            return (Criteria) this;
        }

        public Criteria andPlannerNotEqualTo(String value) {
            addCriterion("Planner <>", value, "planner");
            return (Criteria) this;
        }

        public Criteria andPlannerGreaterThan(String value) {
            addCriterion("Planner >", value, "planner");
            return (Criteria) this;
        }

        public Criteria andPlannerGreaterThanOrEqualTo(String value) {
            addCriterion("Planner >=", value, "planner");
            return (Criteria) this;
        }

        public Criteria andPlannerLessThan(String value) {
            addCriterion("Planner <", value, "planner");
            return (Criteria) this;
        }

        public Criteria andPlannerLessThanOrEqualTo(String value) {
            addCriterion("Planner <=", value, "planner");
            return (Criteria) this;
        }

        public Criteria andPlannerLike(String value) {
            addCriterion("Planner like", value, "planner");
            return (Criteria) this;
        }

        public Criteria andPlannerNotLike(String value) {
            addCriterion("Planner not like", value, "planner");
            return (Criteria) this;
        }

        public Criteria andPlannerIn(List<String> values) {
            addCriterion("Planner in", values, "planner");
            return (Criteria) this;
        }

        public Criteria andPlannerNotIn(List<String> values) {
            addCriterion("Planner not in", values, "planner");
            return (Criteria) this;
        }

        public Criteria andPlannerBetween(String value1, String value2) {
            addCriterion("Planner between", value1, value2, "planner");
            return (Criteria) this;
        }

        public Criteria andPlannerNotBetween(String value1, String value2) {
            addCriterion("Planner not between", value1, value2, "planner");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewerIsNull() {
            addCriterion("OQDeptReviewer is null");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewerIsNotNull() {
            addCriterion("OQDeptReviewer is not null");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewerEqualTo(String value) {
            addCriterion("OQDeptReviewer =", value, "oqdeptreviewer");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewerNotEqualTo(String value) {
            addCriterion("OQDeptReviewer <>", value, "oqdeptreviewer");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewerGreaterThan(String value) {
            addCriterion("OQDeptReviewer >", value, "oqdeptreviewer");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewerGreaterThanOrEqualTo(String value) {
            addCriterion("OQDeptReviewer >=", value, "oqdeptreviewer");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewerLessThan(String value) {
            addCriterion("OQDeptReviewer <", value, "oqdeptreviewer");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewerLessThanOrEqualTo(String value) {
            addCriterion("OQDeptReviewer <=", value, "oqdeptreviewer");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewerLike(String value) {
            addCriterion("OQDeptReviewer like", value, "oqdeptreviewer");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewerNotLike(String value) {
            addCriterion("OQDeptReviewer not like", value, "oqdeptreviewer");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewerIn(List<String> values) {
            addCriterion("OQDeptReviewer in", values, "oqdeptreviewer");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewerNotIn(List<String> values) {
            addCriterion("OQDeptReviewer not in", values, "oqdeptreviewer");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewerBetween(String value1, String value2) {
            addCriterion("OQDeptReviewer between", value1, value2, "oqdeptreviewer");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewerNotBetween(String value1, String value2) {
            addCriterion("OQDeptReviewer not between", value1, value2, "oqdeptreviewer");
            return (Criteria) this;
        }

        public Criteria andDept1reviewerIsNull() {
            addCriterion("Dept1Reviewer is null");
            return (Criteria) this;
        }

        public Criteria andDept1reviewerIsNotNull() {
            addCriterion("Dept1Reviewer is not null");
            return (Criteria) this;
        }

        public Criteria andDept1reviewerEqualTo(String value) {
            addCriterion("Dept1Reviewer =", value, "dept1reviewer");
            return (Criteria) this;
        }

        public Criteria andDept1reviewerNotEqualTo(String value) {
            addCriterion("Dept1Reviewer <>", value, "dept1reviewer");
            return (Criteria) this;
        }

        public Criteria andDept1reviewerGreaterThan(String value) {
            addCriterion("Dept1Reviewer >", value, "dept1reviewer");
            return (Criteria) this;
        }

        public Criteria andDept1reviewerGreaterThanOrEqualTo(String value) {
            addCriterion("Dept1Reviewer >=", value, "dept1reviewer");
            return (Criteria) this;
        }

        public Criteria andDept1reviewerLessThan(String value) {
            addCriterion("Dept1Reviewer <", value, "dept1reviewer");
            return (Criteria) this;
        }

        public Criteria andDept1reviewerLessThanOrEqualTo(String value) {
            addCriterion("Dept1Reviewer <=", value, "dept1reviewer");
            return (Criteria) this;
        }

        public Criteria andDept1reviewerLike(String value) {
            addCriterion("Dept1Reviewer like", value, "dept1reviewer");
            return (Criteria) this;
        }

        public Criteria andDept1reviewerNotLike(String value) {
            addCriterion("Dept1Reviewer not like", value, "dept1reviewer");
            return (Criteria) this;
        }

        public Criteria andDept1reviewerIn(List<String> values) {
            addCriterion("Dept1Reviewer in", values, "dept1reviewer");
            return (Criteria) this;
        }

        public Criteria andDept1reviewerNotIn(List<String> values) {
            addCriterion("Dept1Reviewer not in", values, "dept1reviewer");
            return (Criteria) this;
        }

        public Criteria andDept1reviewerBetween(String value1, String value2) {
            addCriterion("Dept1Reviewer between", value1, value2, "dept1reviewer");
            return (Criteria) this;
        }

        public Criteria andDept1reviewerNotBetween(String value1, String value2) {
            addCriterion("Dept1Reviewer not between", value1, value2, "dept1reviewer");
            return (Criteria) this;
        }

        public Criteria andApstatusIsNull() {
            addCriterion("APStatus is null");
            return (Criteria) this;
        }

        public Criteria andApstatusIsNotNull() {
            addCriterion("APStatus is not null");
            return (Criteria) this;
        }

        public Criteria andApstatusEqualTo(String value) {
            addCriterion("APStatus =", value, "apstatus");
            return (Criteria) this;
        }

        public Criteria andApstatusNotEqualTo(String value) {
            addCriterion("APStatus <>", value, "apstatus");
            return (Criteria) this;
        }

        public Criteria andApstatusGreaterThan(String value) {
            addCriterion("APStatus >", value, "apstatus");
            return (Criteria) this;
        }

        public Criteria andApstatusGreaterThanOrEqualTo(String value) {
            addCriterion("APStatus >=", value, "apstatus");
            return (Criteria) this;
        }

        public Criteria andApstatusLessThan(String value) {
            addCriterion("APStatus <", value, "apstatus");
            return (Criteria) this;
        }

        public Criteria andApstatusLessThanOrEqualTo(String value) {
            addCriterion("APStatus <=", value, "apstatus");
            return (Criteria) this;
        }

        public Criteria andApstatusLike(String value) {
            addCriterion("APStatus like", value, "apstatus");
            return (Criteria) this;
        }

        public Criteria andApstatusNotLike(String value) {
            addCriterion("APStatus not like", value, "apstatus");
            return (Criteria) this;
        }

        public Criteria andApstatusIn(List<String> values) {
            addCriterion("APStatus in", values, "apstatus");
            return (Criteria) this;
        }

        public Criteria andApstatusNotIn(List<String> values) {
            addCriterion("APStatus not in", values, "apstatus");
            return (Criteria) this;
        }

        public Criteria andApstatusBetween(String value1, String value2) {
            addCriterion("APStatus between", value1, value2, "apstatus");
            return (Criteria) this;
        }

        public Criteria andApstatusNotBetween(String value1, String value2) {
            addCriterion("APStatus not between", value1, value2, "apstatus");
            return (Criteria) this;
        }

        public Criteria andApstageIsNull() {
            addCriterion("APStage is null");
            return (Criteria) this;
        }

        public Criteria andApstageIsNotNull() {
            addCriterion("APStage is not null");
            return (Criteria) this;
        }

        public Criteria andApstageEqualTo(String value) {
            addCriterion("APStage =", value, "apstage");
            return (Criteria) this;
        }

        public Criteria andApstageNotEqualTo(String value) {
            addCriterion("APStage <>", value, "apstage");
            return (Criteria) this;
        }

        public Criteria andApstageGreaterThan(String value) {
            addCriterion("APStage >", value, "apstage");
            return (Criteria) this;
        }

        public Criteria andApstageGreaterThanOrEqualTo(String value) {
            addCriterion("APStage >=", value, "apstage");
            return (Criteria) this;
        }

        public Criteria andApstageLessThan(String value) {
            addCriterion("APStage <", value, "apstage");
            return (Criteria) this;
        }

        public Criteria andApstageLessThanOrEqualTo(String value) {
            addCriterion("APStage <=", value, "apstage");
            return (Criteria) this;
        }

        public Criteria andApstageLike(String value) {
            addCriterion("APStage like", value, "apstage");
            return (Criteria) this;
        }

        public Criteria andApstageNotLike(String value) {
            addCriterion("APStage not like", value, "apstage");
            return (Criteria) this;
        }

        public Criteria andApstageIn(List<String> values) {
            addCriterion("APStage in", values, "apstage");
            return (Criteria) this;
        }

        public Criteria andApstageNotIn(List<String> values) {
            addCriterion("APStage not in", values, "apstage");
            return (Criteria) this;
        }

        public Criteria andApstageBetween(String value1, String value2) {
            addCriterion("APStage between", value1, value2, "apstage");
            return (Criteria) this;
        }

        public Criteria andApstageNotBetween(String value1, String value2) {
            addCriterion("APStage not between", value1, value2, "apstage");
            return (Criteria) this;
        }

        public Criteria andApstatusdetailIsNull() {
            addCriterion("APStatusDetail is null");
            return (Criteria) this;
        }

        public Criteria andApstatusdetailIsNotNull() {
            addCriterion("APStatusDetail is not null");
            return (Criteria) this;
        }

        public Criteria andApstatusdetailEqualTo(String value) {
            addCriterion("APStatusDetail =", value, "apstatusdetail");
            return (Criteria) this;
        }

        public Criteria andApstatusdetailNotEqualTo(String value) {
            addCriterion("APStatusDetail <>", value, "apstatusdetail");
            return (Criteria) this;
        }

        public Criteria andApstatusdetailGreaterThan(String value) {
            addCriterion("APStatusDetail >", value, "apstatusdetail");
            return (Criteria) this;
        }

        public Criteria andApstatusdetailGreaterThanOrEqualTo(String value) {
            addCriterion("APStatusDetail >=", value, "apstatusdetail");
            return (Criteria) this;
        }

        public Criteria andApstatusdetailLessThan(String value) {
            addCriterion("APStatusDetail <", value, "apstatusdetail");
            return (Criteria) this;
        }

        public Criteria andApstatusdetailLessThanOrEqualTo(String value) {
            addCriterion("APStatusDetail <=", value, "apstatusdetail");
            return (Criteria) this;
        }

        public Criteria andApstatusdetailLike(String value) {
            addCriterion("APStatusDetail like", value, "apstatusdetail");
            return (Criteria) this;
        }

        public Criteria andApstatusdetailNotLike(String value) {
            addCriterion("APStatusDetail not like", value, "apstatusdetail");
            return (Criteria) this;
        }

        public Criteria andApstatusdetailIn(List<String> values) {
            addCriterion("APStatusDetail in", values, "apstatusdetail");
            return (Criteria) this;
        }

        public Criteria andApstatusdetailNotIn(List<String> values) {
            addCriterion("APStatusDetail not in", values, "apstatusdetail");
            return (Criteria) this;
        }

        public Criteria andApstatusdetailBetween(String value1, String value2) {
            addCriterion("APStatusDetail between", value1, value2, "apstatusdetail");
            return (Criteria) this;
        }

        public Criteria andApstatusdetailNotBetween(String value1, String value2) {
            addCriterion("APStatusDetail not between", value1, value2, "apstatusdetail");
            return (Criteria) this;
        }

        public Criteria andApplymonthIsNull() {
            addCriterion("ApplyMonth is null");
            return (Criteria) this;
        }

        public Criteria andApplymonthIsNotNull() {
            addCriterion("ApplyMonth is not null");
            return (Criteria) this;
        }

        public Criteria andApplymonthEqualTo(String value) {
            addCriterion("ApplyMonth =", value, "applymonth");
            return (Criteria) this;
        }

        public Criteria andApplymonthNotEqualTo(String value) {
            addCriterion("ApplyMonth <>", value, "applymonth");
            return (Criteria) this;
        }

        public Criteria andApplymonthGreaterThan(String value) {
            addCriterion("ApplyMonth >", value, "applymonth");
            return (Criteria) this;
        }

        public Criteria andApplymonthGreaterThanOrEqualTo(String value) {
            addCriterion("ApplyMonth >=", value, "applymonth");
            return (Criteria) this;
        }

        public Criteria andApplymonthLessThan(String value) {
            addCriterion("ApplyMonth <", value, "applymonth");
            return (Criteria) this;
        }

        public Criteria andApplymonthLessThanOrEqualTo(String value) {
            addCriterion("ApplyMonth <=", value, "applymonth");
            return (Criteria) this;
        }

        public Criteria andApplymonthLike(String value) {
            addCriterion("ApplyMonth like", value, "applymonth");
            return (Criteria) this;
        }

        public Criteria andApplymonthNotLike(String value) {
            addCriterion("ApplyMonth not like", value, "applymonth");
            return (Criteria) this;
        }

        public Criteria andApplymonthIn(List<String> values) {
            addCriterion("ApplyMonth in", values, "applymonth");
            return (Criteria) this;
        }

        public Criteria andApplymonthNotIn(List<String> values) {
            addCriterion("ApplyMonth not in", values, "applymonth");
            return (Criteria) this;
        }

        public Criteria andApplymonthBetween(String value1, String value2) {
            addCriterion("ApplyMonth between", value1, value2, "applymonth");
            return (Criteria) this;
        }

        public Criteria andApplymonthNotBetween(String value1, String value2) {
            addCriterion("ApplyMonth not between", value1, value2, "applymonth");
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
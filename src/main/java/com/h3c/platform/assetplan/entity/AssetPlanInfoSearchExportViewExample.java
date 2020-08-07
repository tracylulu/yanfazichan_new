package com.h3c.platform.assetplan.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AssetPlanInfoSearchExportViewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssetPlanInfoSearchExportViewExample() {
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
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
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

        public Criteria andGoodstimeIsNull() {
            addCriterion("Goodstime is null");
            return (Criteria) this;
        }

        public Criteria andGoodstimeIsNotNull() {
            addCriterion("Goodstime is not null");
            return (Criteria) this;
        }

        public Criteria andGoodstimeEqualTo(String value) {
            addCriterion("Goodstime =", value, "goodstime");
            return (Criteria) this;
        }

        public Criteria andGoodstimeNotEqualTo(String value) {
            addCriterion("Goodstime <>", value, "goodstime");
            return (Criteria) this;
        }

        public Criteria andGoodstimeGreaterThan(String value) {
            addCriterion("Goodstime >", value, "goodstime");
            return (Criteria) this;
        }

        public Criteria andGoodstimeGreaterThanOrEqualTo(String value) {
            addCriterion("Goodstime >=", value, "goodstime");
            return (Criteria) this;
        }

        public Criteria andGoodstimeLessThan(String value) {
            addCriterion("Goodstime <", value, "goodstime");
            return (Criteria) this;
        }

        public Criteria andGoodstimeLessThanOrEqualTo(String value) {
            addCriterion("Goodstime <=", value, "goodstime");
            return (Criteria) this;
        }

        public Criteria andGoodstimeLike(String value) {
            addCriterion("Goodstime like", value, "goodstime");
            return (Criteria) this;
        }

        public Criteria andGoodstimeNotLike(String value) {
            addCriterion("Goodstime not like", value, "goodstime");
            return (Criteria) this;
        }

        public Criteria andGoodstimeIn(List<String> values) {
            addCriterion("Goodstime in", values, "goodstime");
            return (Criteria) this;
        }

        public Criteria andGoodstimeNotIn(List<String> values) {
            addCriterion("Goodstime not in", values, "goodstime");
            return (Criteria) this;
        }

        public Criteria andGoodstimeBetween(String value1, String value2) {
            addCriterion("Goodstime between", value1, value2, "goodstime");
            return (Criteria) this;
        }

        public Criteria andGoodstimeNotBetween(String value1, String value2) {
            addCriterion("Goodstime not between", value1, value2, "goodstime");
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

        public Criteria andRequiredsIsNull() {
            addCriterion("Requireds is null");
            return (Criteria) this;
        }

        public Criteria andRequiredsIsNotNull() {
            addCriterion("Requireds is not null");
            return (Criteria) this;
        }

        public Criteria andRequiredsEqualTo(Integer value) {
            addCriterion("Requireds =", value, "requireds");
            return (Criteria) this;
        }

        public Criteria andRequiredsNotEqualTo(Integer value) {
            addCriterion("Requireds <>", value, "requireds");
            return (Criteria) this;
        }

        public Criteria andRequiredsGreaterThan(Integer value) {
            addCriterion("Requireds >", value, "requireds");
            return (Criteria) this;
        }

        public Criteria andRequiredsGreaterThanOrEqualTo(Integer value) {
            addCriterion("Requireds >=", value, "requireds");
            return (Criteria) this;
        }

        public Criteria andRequiredsLessThan(Integer value) {
            addCriterion("Requireds <", value, "requireds");
            return (Criteria) this;
        }

        public Criteria andRequiredsLessThanOrEqualTo(Integer value) {
            addCriterion("Requireds <=", value, "requireds");
            return (Criteria) this;
        }

        public Criteria andRequiredsIn(List<Integer> values) {
            addCriterion("Requireds in", values, "requireds");
            return (Criteria) this;
        }

        public Criteria andRequiredsNotIn(List<Integer> values) {
            addCriterion("Requireds not in", values, "requireds");
            return (Criteria) this;
        }

        public Criteria andRequiredsBetween(Integer value1, Integer value2) {
            addCriterion("Requireds between", value1, value2, "requireds");
            return (Criteria) this;
        }

        public Criteria andRequiredsNotBetween(Integer value1, Integer value2) {
            addCriterion("Requireds not between", value1, value2, "requireds");
            return (Criteria) this;
        }

        public Criteria andRequiredsauditIsNull() {
            addCriterion("RequiredsAudit is null");
            return (Criteria) this;
        }

        public Criteria andRequiredsauditIsNotNull() {
            addCriterion("RequiredsAudit is not null");
            return (Criteria) this;
        }

        public Criteria andRequiredsauditEqualTo(Integer value) {
            addCriterion("RequiredsAudit =", value, "requiredsaudit");
            return (Criteria) this;
        }

        public Criteria andRequiredsauditNotEqualTo(Integer value) {
            addCriterion("RequiredsAudit <>", value, "requiredsaudit");
            return (Criteria) this;
        }

        public Criteria andRequiredsauditGreaterThan(Integer value) {
            addCriterion("RequiredsAudit >", value, "requiredsaudit");
            return (Criteria) this;
        }

        public Criteria andRequiredsauditGreaterThanOrEqualTo(Integer value) {
            addCriterion("RequiredsAudit >=", value, "requiredsaudit");
            return (Criteria) this;
        }

        public Criteria andRequiredsauditLessThan(Integer value) {
            addCriterion("RequiredsAudit <", value, "requiredsaudit");
            return (Criteria) this;
        }

        public Criteria andRequiredsauditLessThanOrEqualTo(Integer value) {
            addCriterion("RequiredsAudit <=", value, "requiredsaudit");
            return (Criteria) this;
        }

        public Criteria andRequiredsauditIn(List<Integer> values) {
            addCriterion("RequiredsAudit in", values, "requiredsaudit");
            return (Criteria) this;
        }

        public Criteria andRequiredsauditNotIn(List<Integer> values) {
            addCriterion("RequiredsAudit not in", values, "requiredsaudit");
            return (Criteria) this;
        }

        public Criteria andRequiredsauditBetween(Integer value1, Integer value2) {
            addCriterion("RequiredsAudit between", value1, value2, "requiredsaudit");
            return (Criteria) this;
        }

        public Criteria andRequiredsauditNotBetween(Integer value1, Integer value2) {
            addCriterion("RequiredsAudit not between", value1, value2, "requiredsaudit");
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

        public Criteria andTotalmoneyIsNull() {
            addCriterion("TotalMoney is null");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIsNotNull() {
            addCriterion("TotalMoney is not null");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyEqualTo(BigDecimal value) {
            addCriterion("TotalMoney =", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotEqualTo(BigDecimal value) {
            addCriterion("TotalMoney <>", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyGreaterThan(BigDecimal value) {
            addCriterion("TotalMoney >", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TotalMoney >=", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyLessThan(BigDecimal value) {
            addCriterion("TotalMoney <", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TotalMoney <=", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIn(List<BigDecimal> values) {
            addCriterion("TotalMoney in", values, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotIn(List<BigDecimal> values) {
            addCriterion("TotalMoney not in", values, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TotalMoney between", value1, value2, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TotalMoney not between", value1, value2, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andActualmoneyIsNull() {
            addCriterion("ActualMoney is null");
            return (Criteria) this;
        }

        public Criteria andActualmoneyIsNotNull() {
            addCriterion("ActualMoney is not null");
            return (Criteria) this;
        }

        public Criteria andActualmoneyEqualTo(BigDecimal value) {
            addCriterion("ActualMoney =", value, "actualmoney");
            return (Criteria) this;
        }

        public Criteria andActualmoneyNotEqualTo(BigDecimal value) {
            addCriterion("ActualMoney <>", value, "actualmoney");
            return (Criteria) this;
        }

        public Criteria andActualmoneyGreaterThan(BigDecimal value) {
            addCriterion("ActualMoney >", value, "actualmoney");
            return (Criteria) this;
        }

        public Criteria andActualmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ActualMoney >=", value, "actualmoney");
            return (Criteria) this;
        }

        public Criteria andActualmoneyLessThan(BigDecimal value) {
            addCriterion("ActualMoney <", value, "actualmoney");
            return (Criteria) this;
        }

        public Criteria andActualmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ActualMoney <=", value, "actualmoney");
            return (Criteria) this;
        }

        public Criteria andActualmoneyIn(List<BigDecimal> values) {
            addCriterion("ActualMoney in", values, "actualmoney");
            return (Criteria) this;
        }

        public Criteria andActualmoneyNotIn(List<BigDecimal> values) {
            addCriterion("ActualMoney not in", values, "actualmoney");
            return (Criteria) this;
        }

        public Criteria andActualmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ActualMoney between", value1, value2, "actualmoney");
            return (Criteria) this;
        }

        public Criteria andActualmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ActualMoney not between", value1, value2, "actualmoney");
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

        public Criteria andRequiredusernameIsNull() {
            addCriterion("RequiredUserName is null");
            return (Criteria) this;
        }

        public Criteria andRequiredusernameIsNotNull() {
            addCriterion("RequiredUserName is not null");
            return (Criteria) this;
        }

        public Criteria andRequiredusernameEqualTo(String value) {
            addCriterion("RequiredUserName =", value, "requiredusername");
            return (Criteria) this;
        }

        public Criteria andRequiredusernameNotEqualTo(String value) {
            addCriterion("RequiredUserName <>", value, "requiredusername");
            return (Criteria) this;
        }

        public Criteria andRequiredusernameGreaterThan(String value) {
            addCriterion("RequiredUserName >", value, "requiredusername");
            return (Criteria) this;
        }

        public Criteria andRequiredusernameGreaterThanOrEqualTo(String value) {
            addCriterion("RequiredUserName >=", value, "requiredusername");
            return (Criteria) this;
        }

        public Criteria andRequiredusernameLessThan(String value) {
            addCriterion("RequiredUserName <", value, "requiredusername");
            return (Criteria) this;
        }

        public Criteria andRequiredusernameLessThanOrEqualTo(String value) {
            addCriterion("RequiredUserName <=", value, "requiredusername");
            return (Criteria) this;
        }

        public Criteria andRequiredusernameLike(String value) {
            addCriterion("RequiredUserName like", value, "requiredusername");
            return (Criteria) this;
        }

        public Criteria andRequiredusernameNotLike(String value) {
            addCriterion("RequiredUserName not like", value, "requiredusername");
            return (Criteria) this;
        }

        public Criteria andRequiredusernameIn(List<String> values) {
            addCriterion("RequiredUserName in", values, "requiredusername");
            return (Criteria) this;
        }

        public Criteria andRequiredusernameNotIn(List<String> values) {
            addCriterion("RequiredUserName not in", values, "requiredusername");
            return (Criteria) this;
        }

        public Criteria andRequiredusernameBetween(String value1, String value2) {
            addCriterion("RequiredUserName between", value1, value2, "requiredusername");
            return (Criteria) this;
        }

        public Criteria andRequiredusernameNotBetween(String value1, String value2) {
            addCriterion("RequiredUserName not between", value1, value2, "requiredusername");
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

        public Criteria andDeptcodeIsNull() {
            addCriterion("DeptCode is null");
            return (Criteria) this;
        }

        public Criteria andDeptcodeIsNotNull() {
            addCriterion("DeptCode is not null");
            return (Criteria) this;
        }

        public Criteria andDeptcodeEqualTo(String value) {
            addCriterion("DeptCode =", value, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeNotEqualTo(String value) {
            addCriterion("DeptCode <>", value, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeGreaterThan(String value) {
            addCriterion("DeptCode >", value, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeGreaterThanOrEqualTo(String value) {
            addCriterion("DeptCode >=", value, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeLessThan(String value) {
            addCriterion("DeptCode <", value, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeLessThanOrEqualTo(String value) {
            addCriterion("DeptCode <=", value, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeLike(String value) {
            addCriterion("DeptCode like", value, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeNotLike(String value) {
            addCriterion("DeptCode not like", value, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeIn(List<String> values) {
            addCriterion("DeptCode in", values, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeNotIn(List<String> values) {
            addCriterion("DeptCode not in", values, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeBetween(String value1, String value2) {
            addCriterion("DeptCode between", value1, value2, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeNotBetween(String value1, String value2) {
            addCriterion("DeptCode not between", value1, value2, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDept3nameIsNull() {
            addCriterion("Dept3Name is null");
            return (Criteria) this;
        }

        public Criteria andDept3nameIsNotNull() {
            addCriterion("Dept3Name is not null");
            return (Criteria) this;
        }

        public Criteria andDept3nameEqualTo(String value) {
            addCriterion("Dept3Name =", value, "dept3name");
            return (Criteria) this;
        }

        public Criteria andDept3nameNotEqualTo(String value) {
            addCriterion("Dept3Name <>", value, "dept3name");
            return (Criteria) this;
        }

        public Criteria andDept3nameGreaterThan(String value) {
            addCriterion("Dept3Name >", value, "dept3name");
            return (Criteria) this;
        }

        public Criteria andDept3nameGreaterThanOrEqualTo(String value) {
            addCriterion("Dept3Name >=", value, "dept3name");
            return (Criteria) this;
        }

        public Criteria andDept3nameLessThan(String value) {
            addCriterion("Dept3Name <", value, "dept3name");
            return (Criteria) this;
        }

        public Criteria andDept3nameLessThanOrEqualTo(String value) {
            addCriterion("Dept3Name <=", value, "dept3name");
            return (Criteria) this;
        }

        public Criteria andDept3nameLike(String value) {
            addCriterion("Dept3Name like", value, "dept3name");
            return (Criteria) this;
        }

        public Criteria andDept3nameNotLike(String value) {
            addCriterion("Dept3Name not like", value, "dept3name");
            return (Criteria) this;
        }

        public Criteria andDept3nameIn(List<String> values) {
            addCriterion("Dept3Name in", values, "dept3name");
            return (Criteria) this;
        }

        public Criteria andDept3nameNotIn(List<String> values) {
            addCriterion("Dept3Name not in", values, "dept3name");
            return (Criteria) this;
        }

        public Criteria andDept3nameBetween(String value1, String value2) {
            addCriterion("Dept3Name between", value1, value2, "dept3name");
            return (Criteria) this;
        }

        public Criteria andDept3nameNotBetween(String value1, String value2) {
            addCriterion("Dept3Name not between", value1, value2, "dept3name");
            return (Criteria) this;
        }

        public Criteria andDept2codeIsNull() {
            addCriterion("Dept2Code is null");
            return (Criteria) this;
        }

        public Criteria andDept2codeIsNotNull() {
            addCriterion("Dept2Code is not null");
            return (Criteria) this;
        }

        public Criteria andDept2codeEqualTo(String value) {
            addCriterion("Dept2Code =", value, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeNotEqualTo(String value) {
            addCriterion("Dept2Code <>", value, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeGreaterThan(String value) {
            addCriterion("Dept2Code >", value, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeGreaterThanOrEqualTo(String value) {
            addCriterion("Dept2Code >=", value, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeLessThan(String value) {
            addCriterion("Dept2Code <", value, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeLessThanOrEqualTo(String value) {
            addCriterion("Dept2Code <=", value, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeLike(String value) {
            addCriterion("Dept2Code like", value, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeNotLike(String value) {
            addCriterion("Dept2Code not like", value, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeIn(List<String> values) {
            addCriterion("Dept2Code in", values, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeNotIn(List<String> values) {
            addCriterion("Dept2Code not in", values, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeBetween(String value1, String value2) {
            addCriterion("Dept2Code between", value1, value2, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeNotBetween(String value1, String value2) {
            addCriterion("Dept2Code not between", value1, value2, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2nameIsNull() {
            addCriterion("Dept2Name is null");
            return (Criteria) this;
        }

        public Criteria andDept2nameIsNotNull() {
            addCriterion("Dept2Name is not null");
            return (Criteria) this;
        }

        public Criteria andDept2nameEqualTo(String value) {
            addCriterion("Dept2Name =", value, "dept2name");
            return (Criteria) this;
        }

        public Criteria andDept2nameNotEqualTo(String value) {
            addCriterion("Dept2Name <>", value, "dept2name");
            return (Criteria) this;
        }

        public Criteria andDept2nameGreaterThan(String value) {
            addCriterion("Dept2Name >", value, "dept2name");
            return (Criteria) this;
        }

        public Criteria andDept2nameGreaterThanOrEqualTo(String value) {
            addCriterion("Dept2Name >=", value, "dept2name");
            return (Criteria) this;
        }

        public Criteria andDept2nameLessThan(String value) {
            addCriterion("Dept2Name <", value, "dept2name");
            return (Criteria) this;
        }

        public Criteria andDept2nameLessThanOrEqualTo(String value) {
            addCriterion("Dept2Name <=", value, "dept2name");
            return (Criteria) this;
        }

        public Criteria andDept2nameLike(String value) {
            addCriterion("Dept2Name like", value, "dept2name");
            return (Criteria) this;
        }

        public Criteria andDept2nameNotLike(String value) {
            addCriterion("Dept2Name not like", value, "dept2name");
            return (Criteria) this;
        }

        public Criteria andDept2nameIn(List<String> values) {
            addCriterion("Dept2Name in", values, "dept2name");
            return (Criteria) this;
        }

        public Criteria andDept2nameNotIn(List<String> values) {
            addCriterion("Dept2Name not in", values, "dept2name");
            return (Criteria) this;
        }

        public Criteria andDept2nameBetween(String value1, String value2) {
            addCriterion("Dept2Name between", value1, value2, "dept2name");
            return (Criteria) this;
        }

        public Criteria andDept2nameNotBetween(String value1, String value2) {
            addCriterion("Dept2Name not between", value1, value2, "dept2name");
            return (Criteria) this;
        }

        public Criteria andDept1codeIsNull() {
            addCriterion("Dept1Code is null");
            return (Criteria) this;
        }

        public Criteria andDept1codeIsNotNull() {
            addCriterion("Dept1Code is not null");
            return (Criteria) this;
        }

        public Criteria andDept1codeEqualTo(String value) {
            addCriterion("Dept1Code =", value, "dept1code");
            return (Criteria) this;
        }

        public Criteria andDept1codeNotEqualTo(String value) {
            addCriterion("Dept1Code <>", value, "dept1code");
            return (Criteria) this;
        }

        public Criteria andDept1codeGreaterThan(String value) {
            addCriterion("Dept1Code >", value, "dept1code");
            return (Criteria) this;
        }

        public Criteria andDept1codeGreaterThanOrEqualTo(String value) {
            addCriterion("Dept1Code >=", value, "dept1code");
            return (Criteria) this;
        }

        public Criteria andDept1codeLessThan(String value) {
            addCriterion("Dept1Code <", value, "dept1code");
            return (Criteria) this;
        }

        public Criteria andDept1codeLessThanOrEqualTo(String value) {
            addCriterion("Dept1Code <=", value, "dept1code");
            return (Criteria) this;
        }

        public Criteria andDept1codeLike(String value) {
            addCriterion("Dept1Code like", value, "dept1code");
            return (Criteria) this;
        }

        public Criteria andDept1codeNotLike(String value) {
            addCriterion("Dept1Code not like", value, "dept1code");
            return (Criteria) this;
        }

        public Criteria andDept1codeIn(List<String> values) {
            addCriterion("Dept1Code in", values, "dept1code");
            return (Criteria) this;
        }

        public Criteria andDept1codeNotIn(List<String> values) {
            addCriterion("Dept1Code not in", values, "dept1code");
            return (Criteria) this;
        }

        public Criteria andDept1codeBetween(String value1, String value2) {
            addCriterion("Dept1Code between", value1, value2, "dept1code");
            return (Criteria) this;
        }

        public Criteria andDept1codeNotBetween(String value1, String value2) {
            addCriterion("Dept1Code not between", value1, value2, "dept1code");
            return (Criteria) this;
        }

        public Criteria andDept1nameIsNull() {
            addCriterion("Dept1Name is null");
            return (Criteria) this;
        }

        public Criteria andDept1nameIsNotNull() {
            addCriterion("Dept1Name is not null");
            return (Criteria) this;
        }

        public Criteria andDept1nameEqualTo(String value) {
            addCriterion("Dept1Name =", value, "dept1name");
            return (Criteria) this;
        }

        public Criteria andDept1nameNotEqualTo(String value) {
            addCriterion("Dept1Name <>", value, "dept1name");
            return (Criteria) this;
        }

        public Criteria andDept1nameGreaterThan(String value) {
            addCriterion("Dept1Name >", value, "dept1name");
            return (Criteria) this;
        }

        public Criteria andDept1nameGreaterThanOrEqualTo(String value) {
            addCriterion("Dept1Name >=", value, "dept1name");
            return (Criteria) this;
        }

        public Criteria andDept1nameLessThan(String value) {
            addCriterion("Dept1Name <", value, "dept1name");
            return (Criteria) this;
        }

        public Criteria andDept1nameLessThanOrEqualTo(String value) {
            addCriterion("Dept1Name <=", value, "dept1name");
            return (Criteria) this;
        }

        public Criteria andDept1nameLike(String value) {
            addCriterion("Dept1Name like", value, "dept1name");
            return (Criteria) this;
        }

        public Criteria andDept1nameNotLike(String value) {
            addCriterion("Dept1Name not like", value, "dept1name");
            return (Criteria) this;
        }

        public Criteria andDept1nameIn(List<String> values) {
            addCriterion("Dept1Name in", values, "dept1name");
            return (Criteria) this;
        }

        public Criteria andDept1nameNotIn(List<String> values) {
            addCriterion("Dept1Name not in", values, "dept1name");
            return (Criteria) this;
        }

        public Criteria andDept1nameBetween(String value1, String value2) {
            addCriterion("Dept1Name between", value1, value2, "dept1name");
            return (Criteria) this;
        }

        public Criteria andDept1nameNotBetween(String value1, String value2) {
            addCriterion("Dept1Name not between", value1, value2, "dept1name");
            return (Criteria) this;
        }

        public Criteria andItemcodeIsNull() {
            addCriterion("ItemCode is null");
            return (Criteria) this;
        }

        public Criteria andItemcodeIsNotNull() {
            addCriterion("ItemCode is not null");
            return (Criteria) this;
        }

        public Criteria andItemcodeEqualTo(String value) {
            addCriterion("ItemCode =", value, "itemcode");
            return (Criteria) this;
        }

        public Criteria andItemcodeNotEqualTo(String value) {
            addCriterion("ItemCode <>", value, "itemcode");
            return (Criteria) this;
        }

        public Criteria andItemcodeGreaterThan(String value) {
            addCriterion("ItemCode >", value, "itemcode");
            return (Criteria) this;
        }

        public Criteria andItemcodeGreaterThanOrEqualTo(String value) {
            addCriterion("ItemCode >=", value, "itemcode");
            return (Criteria) this;
        }

        public Criteria andItemcodeLessThan(String value) {
            addCriterion("ItemCode <", value, "itemcode");
            return (Criteria) this;
        }

        public Criteria andItemcodeLessThanOrEqualTo(String value) {
            addCriterion("ItemCode <=", value, "itemcode");
            return (Criteria) this;
        }

        public Criteria andItemcodeLike(String value) {
            addCriterion("ItemCode like", value, "itemcode");
            return (Criteria) this;
        }

        public Criteria andItemcodeNotLike(String value) {
            addCriterion("ItemCode not like", value, "itemcode");
            return (Criteria) this;
        }

        public Criteria andItemcodeIn(List<String> values) {
            addCriterion("ItemCode in", values, "itemcode");
            return (Criteria) this;
        }

        public Criteria andItemcodeNotIn(List<String> values) {
            addCriterion("ItemCode not in", values, "itemcode");
            return (Criteria) this;
        }

        public Criteria andItemcodeBetween(String value1, String value2) {
            addCriterion("ItemCode between", value1, value2, "itemcode");
            return (Criteria) this;
        }

        public Criteria andItemcodeNotBetween(String value1, String value2) {
            addCriterion("ItemCode not between", value1, value2, "itemcode");
            return (Criteria) this;
        }

        public Criteria andReceiverplaceIsNull() {
            addCriterion("ReceiverPlace is null");
            return (Criteria) this;
        }

        public Criteria andReceiverplaceIsNotNull() {
            addCriterion("ReceiverPlace is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverplaceEqualTo(String value) {
            addCriterion("ReceiverPlace =", value, "receiverplace");
            return (Criteria) this;
        }

        public Criteria andReceiverplaceNotEqualTo(String value) {
            addCriterion("ReceiverPlace <>", value, "receiverplace");
            return (Criteria) this;
        }

        public Criteria andReceiverplaceGreaterThan(String value) {
            addCriterion("ReceiverPlace >", value, "receiverplace");
            return (Criteria) this;
        }

        public Criteria andReceiverplaceGreaterThanOrEqualTo(String value) {
            addCriterion("ReceiverPlace >=", value, "receiverplace");
            return (Criteria) this;
        }

        public Criteria andReceiverplaceLessThan(String value) {
            addCriterion("ReceiverPlace <", value, "receiverplace");
            return (Criteria) this;
        }

        public Criteria andReceiverplaceLessThanOrEqualTo(String value) {
            addCriterion("ReceiverPlace <=", value, "receiverplace");
            return (Criteria) this;
        }

        public Criteria andReceiverplaceLike(String value) {
            addCriterion("ReceiverPlace like", value, "receiverplace");
            return (Criteria) this;
        }

        public Criteria andReceiverplaceNotLike(String value) {
            addCriterion("ReceiverPlace not like", value, "receiverplace");
            return (Criteria) this;
        }

        public Criteria andReceiverplaceIn(List<String> values) {
            addCriterion("ReceiverPlace in", values, "receiverplace");
            return (Criteria) this;
        }

        public Criteria andReceiverplaceNotIn(List<String> values) {
            addCriterion("ReceiverPlace not in", values, "receiverplace");
            return (Criteria) this;
        }

        public Criteria andReceiverplaceBetween(String value1, String value2) {
            addCriterion("ReceiverPlace between", value1, value2, "receiverplace");
            return (Criteria) this;
        }

        public Criteria andReceiverplaceNotBetween(String value1, String value2) {
            addCriterion("ReceiverPlace not between", value1, value2, "receiverplace");
            return (Criteria) this;
        }

        public Criteria andAbnormalplanenumIsNull() {
            addCriterion("AbnormalPlanEnum is null");
            return (Criteria) this;
        }

        public Criteria andAbnormalplanenumIsNotNull() {
            addCriterion("AbnormalPlanEnum is not null");
            return (Criteria) this;
        }

        public Criteria andAbnormalplanenumEqualTo(Integer value) {
            addCriterion("AbnormalPlanEnum =", value, "abnormalplanenum");
            return (Criteria) this;
        }

        public Criteria andAbnormalplanenumNotEqualTo(Integer value) {
            addCriterion("AbnormalPlanEnum <>", value, "abnormalplanenum");
            return (Criteria) this;
        }

        public Criteria andAbnormalplanenumGreaterThan(Integer value) {
            addCriterion("AbnormalPlanEnum >", value, "abnormalplanenum");
            return (Criteria) this;
        }

        public Criteria andAbnormalplanenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("AbnormalPlanEnum >=", value, "abnormalplanenum");
            return (Criteria) this;
        }

        public Criteria andAbnormalplanenumLessThan(Integer value) {
            addCriterion("AbnormalPlanEnum <", value, "abnormalplanenum");
            return (Criteria) this;
        }

        public Criteria andAbnormalplanenumLessThanOrEqualTo(Integer value) {
            addCriterion("AbnormalPlanEnum <=", value, "abnormalplanenum");
            return (Criteria) this;
        }

        public Criteria andAbnormalplanenumIn(List<Integer> values) {
            addCriterion("AbnormalPlanEnum in", values, "abnormalplanenum");
            return (Criteria) this;
        }

        public Criteria andAbnormalplanenumNotIn(List<Integer> values) {
            addCriterion("AbnormalPlanEnum not in", values, "abnormalplanenum");
            return (Criteria) this;
        }

        public Criteria andAbnormalplanenumBetween(Integer value1, Integer value2) {
            addCriterion("AbnormalPlanEnum between", value1, value2, "abnormalplanenum");
            return (Criteria) this;
        }

        public Criteria andAbnormalplanenumNotBetween(Integer value1, Integer value2) {
            addCriterion("AbnormalPlanEnum not between", value1, value2, "abnormalplanenum");
            return (Criteria) this;
        }

        public Criteria andOuttimeplanenumIsNull() {
            addCriterion("OutTimePlanEnum is null");
            return (Criteria) this;
        }

        public Criteria andOuttimeplanenumIsNotNull() {
            addCriterion("OutTimePlanEnum is not null");
            return (Criteria) this;
        }

        public Criteria andOuttimeplanenumEqualTo(Integer value) {
            addCriterion("OutTimePlanEnum =", value, "outtimeplanenum");
            return (Criteria) this;
        }

        public Criteria andOuttimeplanenumNotEqualTo(Integer value) {
            addCriterion("OutTimePlanEnum <>", value, "outtimeplanenum");
            return (Criteria) this;
        }

        public Criteria andOuttimeplanenumGreaterThan(Integer value) {
            addCriterion("OutTimePlanEnum >", value, "outtimeplanenum");
            return (Criteria) this;
        }

        public Criteria andOuttimeplanenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("OutTimePlanEnum >=", value, "outtimeplanenum");
            return (Criteria) this;
        }

        public Criteria andOuttimeplanenumLessThan(Integer value) {
            addCriterion("OutTimePlanEnum <", value, "outtimeplanenum");
            return (Criteria) this;
        }

        public Criteria andOuttimeplanenumLessThanOrEqualTo(Integer value) {
            addCriterion("OutTimePlanEnum <=", value, "outtimeplanenum");
            return (Criteria) this;
        }

        public Criteria andOuttimeplanenumIn(List<Integer> values) {
            addCriterion("OutTimePlanEnum in", values, "outtimeplanenum");
            return (Criteria) this;
        }

        public Criteria andOuttimeplanenumNotIn(List<Integer> values) {
            addCriterion("OutTimePlanEnum not in", values, "outtimeplanenum");
            return (Criteria) this;
        }

        public Criteria andOuttimeplanenumBetween(Integer value1, Integer value2) {
            addCriterion("OutTimePlanEnum between", value1, value2, "outtimeplanenum");
            return (Criteria) this;
        }

        public Criteria andOuttimeplanenumNotBetween(Integer value1, Integer value2) {
            addCriterion("OutTimePlanEnum not between", value1, value2, "outtimeplanenum");
            return (Criteria) this;
        }

        public Criteria andAssetnoteIsNull() {
            addCriterion("AssetNote is null");
            return (Criteria) this;
        }

        public Criteria andAssetnoteIsNotNull() {
            addCriterion("AssetNote is not null");
            return (Criteria) this;
        }

        public Criteria andAssetnoteEqualTo(String value) {
            addCriterion("AssetNote =", value, "assetnote");
            return (Criteria) this;
        }

        public Criteria andAssetnoteNotEqualTo(String value) {
            addCriterion("AssetNote <>", value, "assetnote");
            return (Criteria) this;
        }

        public Criteria andAssetnoteGreaterThan(String value) {
            addCriterion("AssetNote >", value, "assetnote");
            return (Criteria) this;
        }

        public Criteria andAssetnoteGreaterThanOrEqualTo(String value) {
            addCriterion("AssetNote >=", value, "assetnote");
            return (Criteria) this;
        }

        public Criteria andAssetnoteLessThan(String value) {
            addCriterion("AssetNote <", value, "assetnote");
            return (Criteria) this;
        }

        public Criteria andAssetnoteLessThanOrEqualTo(String value) {
            addCriterion("AssetNote <=", value, "assetnote");
            return (Criteria) this;
        }

        public Criteria andAssetnoteLike(String value) {
            addCriterion("AssetNote like", value, "assetnote");
            return (Criteria) this;
        }

        public Criteria andAssetnoteNotLike(String value) {
            addCriterion("AssetNote not like", value, "assetnote");
            return (Criteria) this;
        }

        public Criteria andAssetnoteIn(List<String> values) {
            addCriterion("AssetNote in", values, "assetnote");
            return (Criteria) this;
        }

        public Criteria andAssetnoteNotIn(List<String> values) {
            addCriterion("AssetNote not in", values, "assetnote");
            return (Criteria) this;
        }

        public Criteria andAssetnoteBetween(String value1, String value2) {
            addCriterion("AssetNote between", value1, value2, "assetnote");
            return (Criteria) this;
        }

        public Criteria andAssetnoteNotBetween(String value1, String value2) {
            addCriterion("AssetNote not between", value1, value2, "assetnote");
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

        public Criteria andIscompletesetIsNull() {
            addCriterion("IsCompleteSet is null");
            return (Criteria) this;
        }

        public Criteria andIscompletesetIsNotNull() {
            addCriterion("IsCompleteSet is not null");
            return (Criteria) this;
        }

        public Criteria andIscompletesetEqualTo(String value) {
            addCriterion("IsCompleteSet =", value, "iscompleteset");
            return (Criteria) this;
        }

        public Criteria andIscompletesetNotEqualTo(String value) {
            addCriterion("IsCompleteSet <>", value, "iscompleteset");
            return (Criteria) this;
        }

        public Criteria andIscompletesetGreaterThan(String value) {
            addCriterion("IsCompleteSet >", value, "iscompleteset");
            return (Criteria) this;
        }

        public Criteria andIscompletesetGreaterThanOrEqualTo(String value) {
            addCriterion("IsCompleteSet >=", value, "iscompleteset");
            return (Criteria) this;
        }

        public Criteria andIscompletesetLessThan(String value) {
            addCriterion("IsCompleteSet <", value, "iscompleteset");
            return (Criteria) this;
        }

        public Criteria andIscompletesetLessThanOrEqualTo(String value) {
            addCriterion("IsCompleteSet <=", value, "iscompleteset");
            return (Criteria) this;
        }

        public Criteria andIscompletesetLike(String value) {
            addCriterion("IsCompleteSet like", value, "iscompleteset");
            return (Criteria) this;
        }

        public Criteria andIscompletesetNotLike(String value) {
            addCriterion("IsCompleteSet not like", value, "iscompleteset");
            return (Criteria) this;
        }

        public Criteria andIscompletesetIn(List<String> values) {
            addCriterion("IsCompleteSet in", values, "iscompleteset");
            return (Criteria) this;
        }

        public Criteria andIscompletesetNotIn(List<String> values) {
            addCriterion("IsCompleteSet not in", values, "iscompleteset");
            return (Criteria) this;
        }

        public Criteria andIscompletesetBetween(String value1, String value2) {
            addCriterion("IsCompleteSet between", value1, value2, "iscompleteset");
            return (Criteria) this;
        }

        public Criteria andIscompletesetNotBetween(String value1, String value2) {
            addCriterion("IsCompleteSet not between", value1, value2, "iscompleteset");
            return (Criteria) this;
        }

        public Criteria andCompletesetcodeIsNull() {
            addCriterion("CompleteSetCode is null");
            return (Criteria) this;
        }

        public Criteria andCompletesetcodeIsNotNull() {
            addCriterion("CompleteSetCode is not null");
            return (Criteria) this;
        }

        public Criteria andCompletesetcodeEqualTo(Integer value) {
            addCriterion("CompleteSetCode =", value, "completesetcode");
            return (Criteria) this;
        }

        public Criteria andCompletesetcodeNotEqualTo(Integer value) {
            addCriterion("CompleteSetCode <>", value, "completesetcode");
            return (Criteria) this;
        }

        public Criteria andCompletesetcodeGreaterThan(Integer value) {
            addCriterion("CompleteSetCode >", value, "completesetcode");
            return (Criteria) this;
        }

        public Criteria andCompletesetcodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("CompleteSetCode >=", value, "completesetcode");
            return (Criteria) this;
        }

        public Criteria andCompletesetcodeLessThan(Integer value) {
            addCriterion("CompleteSetCode <", value, "completesetcode");
            return (Criteria) this;
        }

        public Criteria andCompletesetcodeLessThanOrEqualTo(Integer value) {
            addCriterion("CompleteSetCode <=", value, "completesetcode");
            return (Criteria) this;
        }

        public Criteria andCompletesetcodeIn(List<Integer> values) {
            addCriterion("CompleteSetCode in", values, "completesetcode");
            return (Criteria) this;
        }

        public Criteria andCompletesetcodeNotIn(List<Integer> values) {
            addCriterion("CompleteSetCode not in", values, "completesetcode");
            return (Criteria) this;
        }

        public Criteria andCompletesetcodeBetween(Integer value1, Integer value2) {
            addCriterion("CompleteSetCode between", value1, value2, "completesetcode");
            return (Criteria) this;
        }

        public Criteria andCompletesetcodeNotBetween(Integer value1, Integer value2) {
            addCriterion("CompleteSetCode not between", value1, value2, "completesetcode");
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

        public Criteria andApprovalpersonIsNull() {
            addCriterion("ApprovalPerson is null");
            return (Criteria) this;
        }

        public Criteria andApprovalpersonIsNotNull() {
            addCriterion("ApprovalPerson is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalpersonEqualTo(String value) {
            addCriterion("ApprovalPerson =", value, "approvalperson");
            return (Criteria) this;
        }

        public Criteria andApprovalpersonNotEqualTo(String value) {
            addCriterion("ApprovalPerson <>", value, "approvalperson");
            return (Criteria) this;
        }

        public Criteria andApprovalpersonGreaterThan(String value) {
            addCriterion("ApprovalPerson >", value, "approvalperson");
            return (Criteria) this;
        }

        public Criteria andApprovalpersonGreaterThanOrEqualTo(String value) {
            addCriterion("ApprovalPerson >=", value, "approvalperson");
            return (Criteria) this;
        }

        public Criteria andApprovalpersonLessThan(String value) {
            addCriterion("ApprovalPerson <", value, "approvalperson");
            return (Criteria) this;
        }

        public Criteria andApprovalpersonLessThanOrEqualTo(String value) {
            addCriterion("ApprovalPerson <=", value, "approvalperson");
            return (Criteria) this;
        }

        public Criteria andApprovalpersonLike(String value) {
            addCriterion("ApprovalPerson like", value, "approvalperson");
            return (Criteria) this;
        }

        public Criteria andApprovalpersonNotLike(String value) {
            addCriterion("ApprovalPerson not like", value, "approvalperson");
            return (Criteria) this;
        }

        public Criteria andApprovalpersonIn(List<String> values) {
            addCriterion("ApprovalPerson in", values, "approvalperson");
            return (Criteria) this;
        }

        public Criteria andApprovalpersonNotIn(List<String> values) {
            addCriterion("ApprovalPerson not in", values, "approvalperson");
            return (Criteria) this;
        }

        public Criteria andApprovalpersonBetween(String value1, String value2) {
            addCriterion("ApprovalPerson between", value1, value2, "approvalperson");
            return (Criteria) this;
        }

        public Criteria andApprovalpersonNotBetween(String value1, String value2) {
            addCriterion("ApprovalPerson not between", value1, value2, "approvalperson");
            return (Criteria) this;
        }

        public Criteria andApprovalnoteIsNull() {
            addCriterion("ApprovalNote is null");
            return (Criteria) this;
        }

        public Criteria andApprovalnoteIsNotNull() {
            addCriterion("ApprovalNote is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalnoteEqualTo(String value) {
            addCriterion("ApprovalNote =", value, "approvalnote");
            return (Criteria) this;
        }

        public Criteria andApprovalnoteNotEqualTo(String value) {
            addCriterion("ApprovalNote <>", value, "approvalnote");
            return (Criteria) this;
        }

        public Criteria andApprovalnoteGreaterThan(String value) {
            addCriterion("ApprovalNote >", value, "approvalnote");
            return (Criteria) this;
        }

        public Criteria andApprovalnoteGreaterThanOrEqualTo(String value) {
            addCriterion("ApprovalNote >=", value, "approvalnote");
            return (Criteria) this;
        }

        public Criteria andApprovalnoteLessThan(String value) {
            addCriterion("ApprovalNote <", value, "approvalnote");
            return (Criteria) this;
        }

        public Criteria andApprovalnoteLessThanOrEqualTo(String value) {
            addCriterion("ApprovalNote <=", value, "approvalnote");
            return (Criteria) this;
        }

        public Criteria andApprovalnoteLike(String value) {
            addCriterion("ApprovalNote like", value, "approvalnote");
            return (Criteria) this;
        }

        public Criteria andApprovalnoteNotLike(String value) {
            addCriterion("ApprovalNote not like", value, "approvalnote");
            return (Criteria) this;
        }

        public Criteria andApprovalnoteIn(List<String> values) {
            addCriterion("ApprovalNote in", values, "approvalnote");
            return (Criteria) this;
        }

        public Criteria andApprovalnoteNotIn(List<String> values) {
            addCriterion("ApprovalNote not in", values, "approvalnote");
            return (Criteria) this;
        }

        public Criteria andApprovalnoteBetween(String value1, String value2) {
            addCriterion("ApprovalNote between", value1, value2, "approvalnote");
            return (Criteria) this;
        }

        public Criteria andApprovalnoteNotBetween(String value1, String value2) {
            addCriterion("ApprovalNote not between", value1, value2, "approvalnote");
            return (Criteria) this;
        }

        public Criteria andApprovalresultIsNull() {
            addCriterion("ApprovalResult is null");
            return (Criteria) this;
        }

        public Criteria andApprovalresultIsNotNull() {
            addCriterion("ApprovalResult is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalresultEqualTo(String value) {
            addCriterion("ApprovalResult =", value, "approvalresult");
            return (Criteria) this;
        }

        public Criteria andApprovalresultNotEqualTo(String value) {
            addCriterion("ApprovalResult <>", value, "approvalresult");
            return (Criteria) this;
        }

        public Criteria andApprovalresultGreaterThan(String value) {
            addCriterion("ApprovalResult >", value, "approvalresult");
            return (Criteria) this;
        }

        public Criteria andApprovalresultGreaterThanOrEqualTo(String value) {
            addCriterion("ApprovalResult >=", value, "approvalresult");
            return (Criteria) this;
        }

        public Criteria andApprovalresultLessThan(String value) {
            addCriterion("ApprovalResult <", value, "approvalresult");
            return (Criteria) this;
        }

        public Criteria andApprovalresultLessThanOrEqualTo(String value) {
            addCriterion("ApprovalResult <=", value, "approvalresult");
            return (Criteria) this;
        }

        public Criteria andApprovalresultLike(String value) {
            addCriterion("ApprovalResult like", value, "approvalresult");
            return (Criteria) this;
        }

        public Criteria andApprovalresultNotLike(String value) {
            addCriterion("ApprovalResult not like", value, "approvalresult");
            return (Criteria) this;
        }

        public Criteria andApprovalresultIn(List<String> values) {
            addCriterion("ApprovalResult in", values, "approvalresult");
            return (Criteria) this;
        }

        public Criteria andApprovalresultNotIn(List<String> values) {
            addCriterion("ApprovalResult not in", values, "approvalresult");
            return (Criteria) this;
        }

        public Criteria andApprovalresultBetween(String value1, String value2) {
            addCriterion("ApprovalResult between", value1, value2, "approvalresult");
            return (Criteria) this;
        }

        public Criteria andApprovalresultNotBetween(String value1, String value2) {
            addCriterion("ApprovalResult not between", value1, value2, "approvalresult");
            return (Criteria) this;
        }

        public Criteria andIsreqpurchasereportIsNull() {
            addCriterion("IsReqPurchaseReport is null");
            return (Criteria) this;
        }

        public Criteria andIsreqpurchasereportIsNotNull() {
            addCriterion("IsReqPurchaseReport is not null");
            return (Criteria) this;
        }

        public Criteria andIsreqpurchasereportEqualTo(String value) {
            addCriterion("IsReqPurchaseReport =", value, "isreqpurchasereport");
            return (Criteria) this;
        }

        public Criteria andIsreqpurchasereportNotEqualTo(String value) {
            addCriterion("IsReqPurchaseReport <>", value, "isreqpurchasereport");
            return (Criteria) this;
        }

        public Criteria andIsreqpurchasereportGreaterThan(String value) {
            addCriterion("IsReqPurchaseReport >", value, "isreqpurchasereport");
            return (Criteria) this;
        }

        public Criteria andIsreqpurchasereportGreaterThanOrEqualTo(String value) {
            addCriterion("IsReqPurchaseReport >=", value, "isreqpurchasereport");
            return (Criteria) this;
        }

        public Criteria andIsreqpurchasereportLessThan(String value) {
            addCriterion("IsReqPurchaseReport <", value, "isreqpurchasereport");
            return (Criteria) this;
        }

        public Criteria andIsreqpurchasereportLessThanOrEqualTo(String value) {
            addCriterion("IsReqPurchaseReport <=", value, "isreqpurchasereport");
            return (Criteria) this;
        }

        public Criteria andIsreqpurchasereportLike(String value) {
            addCriterion("IsReqPurchaseReport like", value, "isreqpurchasereport");
            return (Criteria) this;
        }

        public Criteria andIsreqpurchasereportNotLike(String value) {
            addCriterion("IsReqPurchaseReport not like", value, "isreqpurchasereport");
            return (Criteria) this;
        }

        public Criteria andIsreqpurchasereportIn(List<String> values) {
            addCriterion("IsReqPurchaseReport in", values, "isreqpurchasereport");
            return (Criteria) this;
        }

        public Criteria andIsreqpurchasereportNotIn(List<String> values) {
            addCriterion("IsReqPurchaseReport not in", values, "isreqpurchasereport");
            return (Criteria) this;
        }

        public Criteria andIsreqpurchasereportBetween(String value1, String value2) {
            addCriterion("IsReqPurchaseReport between", value1, value2, "isreqpurchasereport");
            return (Criteria) this;
        }

        public Criteria andIsreqpurchasereportNotBetween(String value1, String value2) {
            addCriterion("IsReqPurchaseReport not between", value1, value2, "isreqpurchasereport");
            return (Criteria) this;
        }

        public Criteria andIsspecifymanufacturerIsNull() {
            addCriterion("ISSpecifyManufacturer is null");
            return (Criteria) this;
        }

        public Criteria andIsspecifymanufacturerIsNotNull() {
            addCriterion("ISSpecifyManufacturer is not null");
            return (Criteria) this;
        }

        public Criteria andIsspecifymanufacturerEqualTo(String value) {
            addCriterion("ISSpecifyManufacturer =", value, "isspecifymanufacturer");
            return (Criteria) this;
        }

        public Criteria andIsspecifymanufacturerNotEqualTo(String value) {
            addCriterion("ISSpecifyManufacturer <>", value, "isspecifymanufacturer");
            return (Criteria) this;
        }

        public Criteria andIsspecifymanufacturerGreaterThan(String value) {
            addCriterion("ISSpecifyManufacturer >", value, "isspecifymanufacturer");
            return (Criteria) this;
        }

        public Criteria andIsspecifymanufacturerGreaterThanOrEqualTo(String value) {
            addCriterion("ISSpecifyManufacturer >=", value, "isspecifymanufacturer");
            return (Criteria) this;
        }

        public Criteria andIsspecifymanufacturerLessThan(String value) {
            addCriterion("ISSpecifyManufacturer <", value, "isspecifymanufacturer");
            return (Criteria) this;
        }

        public Criteria andIsspecifymanufacturerLessThanOrEqualTo(String value) {
            addCriterion("ISSpecifyManufacturer <=", value, "isspecifymanufacturer");
            return (Criteria) this;
        }

        public Criteria andIsspecifymanufacturerLike(String value) {
            addCriterion("ISSpecifyManufacturer like", value, "isspecifymanufacturer");
            return (Criteria) this;
        }

        public Criteria andIsspecifymanufacturerNotLike(String value) {
            addCriterion("ISSpecifyManufacturer not like", value, "isspecifymanufacturer");
            return (Criteria) this;
        }

        public Criteria andIsspecifymanufacturerIn(List<String> values) {
            addCriterion("ISSpecifyManufacturer in", values, "isspecifymanufacturer");
            return (Criteria) this;
        }

        public Criteria andIsspecifymanufacturerNotIn(List<String> values) {
            addCriterion("ISSpecifyManufacturer not in", values, "isspecifymanufacturer");
            return (Criteria) this;
        }

        public Criteria andIsspecifymanufacturerBetween(String value1, String value2) {
            addCriterion("ISSpecifyManufacturer between", value1, value2, "isspecifymanufacturer");
            return (Criteria) this;
        }

        public Criteria andIsspecifymanufacturerNotBetween(String value1, String value2) {
            addCriterion("ISSpecifyManufacturer not between", value1, value2, "isspecifymanufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturertypeenumIsNull() {
            addCriterion("ManufacturerTypeEnum is null");
            return (Criteria) this;
        }

        public Criteria andManufacturertypeenumIsNotNull() {
            addCriterion("ManufacturerTypeEnum is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturertypeenumEqualTo(Integer value) {
            addCriterion("ManufacturerTypeEnum =", value, "manufacturertypeenum");
            return (Criteria) this;
        }

        public Criteria andManufacturertypeenumNotEqualTo(Integer value) {
            addCriterion("ManufacturerTypeEnum <>", value, "manufacturertypeenum");
            return (Criteria) this;
        }

        public Criteria andManufacturertypeenumGreaterThan(Integer value) {
            addCriterion("ManufacturerTypeEnum >", value, "manufacturertypeenum");
            return (Criteria) this;
        }

        public Criteria andManufacturertypeenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("ManufacturerTypeEnum >=", value, "manufacturertypeenum");
            return (Criteria) this;
        }

        public Criteria andManufacturertypeenumLessThan(Integer value) {
            addCriterion("ManufacturerTypeEnum <", value, "manufacturertypeenum");
            return (Criteria) this;
        }

        public Criteria andManufacturertypeenumLessThanOrEqualTo(Integer value) {
            addCriterion("ManufacturerTypeEnum <=", value, "manufacturertypeenum");
            return (Criteria) this;
        }

        public Criteria andManufacturertypeenumIn(List<Integer> values) {
            addCriterion("ManufacturerTypeEnum in", values, "manufacturertypeenum");
            return (Criteria) this;
        }

        public Criteria andManufacturertypeenumNotIn(List<Integer> values) {
            addCriterion("ManufacturerTypeEnum not in", values, "manufacturertypeenum");
            return (Criteria) this;
        }

        public Criteria andManufacturertypeenumBetween(Integer value1, Integer value2) {
            addCriterion("ManufacturerTypeEnum between", value1, value2, "manufacturertypeenum");
            return (Criteria) this;
        }

        public Criteria andManufacturertypeenumNotBetween(Integer value1, Integer value2) {
            addCriterion("ManufacturerTypeEnum not between", value1, value2, "manufacturertypeenum");
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

        public Criteria andRateIsNull() {
            addCriterion("rate is null");
            return (Criteria) this;
        }

        public Criteria andRateIsNotNull() {
            addCriterion("rate is not null");
            return (Criteria) this;
        }

        public Criteria andRateEqualTo(String value) {
            addCriterion("rate =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(String value) {
            addCriterion("rate <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(String value) {
            addCriterion("rate >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(String value) {
            addCriterion("rate >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(String value) {
            addCriterion("rate <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(String value) {
            addCriterion("rate <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLike(String value) {
            addCriterion("rate like", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotLike(String value) {
            addCriterion("rate not like", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<String> values) {
            addCriterion("rate in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<String> values) {
            addCriterion("rate not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(String value1, String value2) {
            addCriterion("rate between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(String value1, String value2) {
            addCriterion("rate not between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andDistributionIsNull() {
            addCriterion("distribution is null");
            return (Criteria) this;
        }

        public Criteria andDistributionIsNotNull() {
            addCriterion("distribution is not null");
            return (Criteria) this;
        }

        public Criteria andDistributionEqualTo(String value) {
            addCriterion("distribution =", value, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionNotEqualTo(String value) {
            addCriterion("distribution <>", value, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionGreaterThan(String value) {
            addCriterion("distribution >", value, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionGreaterThanOrEqualTo(String value) {
            addCriterion("distribution >=", value, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionLessThan(String value) {
            addCriterion("distribution <", value, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionLessThanOrEqualTo(String value) {
            addCriterion("distribution <=", value, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionLike(String value) {
            addCriterion("distribution like", value, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionNotLike(String value) {
            addCriterion("distribution not like", value, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionIn(List<String> values) {
            addCriterion("distribution in", values, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionNotIn(List<String> values) {
            addCriterion("distribution not in", values, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionBetween(String value1, String value2) {
            addCriterion("distribution between", value1, value2, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionNotBetween(String value1, String value2) {
            addCriterion("distribution not between", value1, value2, "distribution");
            return (Criteria) this;
        }

        public Criteria andDetailIsNull() {
            addCriterion("detail is null");
            return (Criteria) this;
        }

        public Criteria andDetailIsNotNull() {
            addCriterion("detail is not null");
            return (Criteria) this;
        }

        public Criteria andDetailEqualTo(String value) {
            addCriterion("detail =", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotEqualTo(String value) {
            addCriterion("detail <>", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThan(String value) {
            addCriterion("detail >", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThanOrEqualTo(String value) {
            addCriterion("detail >=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThan(String value) {
            addCriterion("detail <", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThanOrEqualTo(String value) {
            addCriterion("detail <=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLike(String value) {
            addCriterion("detail like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotLike(String value) {
            addCriterion("detail not like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailIn(List<String> values) {
            addCriterion("detail in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotIn(List<String> values) {
            addCriterion("detail not in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailBetween(String value1, String value2) {
            addCriterion("detail between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotBetween(String value1, String value2) {
            addCriterion("detail not between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andRdRateIsNull() {
            addCriterion("rd_rate is null");
            return (Criteria) this;
        }

        public Criteria andRdRateIsNotNull() {
            addCriterion("rd_rate is not null");
            return (Criteria) this;
        }

        public Criteria andRdRateEqualTo(String value) {
            addCriterion("rd_rate =", value, "rdRate");
            return (Criteria) this;
        }

        public Criteria andRdRateNotEqualTo(String value) {
            addCriterion("rd_rate <>", value, "rdRate");
            return (Criteria) this;
        }

        public Criteria andRdRateGreaterThan(String value) {
            addCriterion("rd_rate >", value, "rdRate");
            return (Criteria) this;
        }

        public Criteria andRdRateGreaterThanOrEqualTo(String value) {
            addCriterion("rd_rate >=", value, "rdRate");
            return (Criteria) this;
        }

        public Criteria andRdRateLessThan(String value) {
            addCriterion("rd_rate <", value, "rdRate");
            return (Criteria) this;
        }

        public Criteria andRdRateLessThanOrEqualTo(String value) {
            addCriterion("rd_rate <=", value, "rdRate");
            return (Criteria) this;
        }

        public Criteria andRdRateLike(String value) {
            addCriterion("rd_rate like", value, "rdRate");
            return (Criteria) this;
        }

        public Criteria andRdRateNotLike(String value) {
            addCriterion("rd_rate not like", value, "rdRate");
            return (Criteria) this;
        }

        public Criteria andRdRateIn(List<String> values) {
            addCriterion("rd_rate in", values, "rdRate");
            return (Criteria) this;
        }

        public Criteria andRdRateNotIn(List<String> values) {
            addCriterion("rd_rate not in", values, "rdRate");
            return (Criteria) this;
        }

        public Criteria andRdRateBetween(String value1, String value2) {
            addCriterion("rd_rate between", value1, value2, "rdRate");
            return (Criteria) this;
        }

        public Criteria andRdRateNotBetween(String value1, String value2) {
            addCriterion("rd_rate not between", value1, value2, "rdRate");
            return (Criteria) this;
        }

        public Criteria andRdNumberIsNull() {
            addCriterion("rd_number is null");
            return (Criteria) this;
        }

        public Criteria andRdNumberIsNotNull() {
            addCriterion("rd_number is not null");
            return (Criteria) this;
        }

        public Criteria andRdNumberEqualTo(Integer value) {
            addCriterion("rd_number =", value, "rdNumber");
            return (Criteria) this;
        }

        public Criteria andRdNumberNotEqualTo(Integer value) {
            addCriterion("rd_number <>", value, "rdNumber");
            return (Criteria) this;
        }

        public Criteria andRdNumberGreaterThan(Integer value) {
            addCriterion("rd_number >", value, "rdNumber");
            return (Criteria) this;
        }

        public Criteria andRdNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("rd_number >=", value, "rdNumber");
            return (Criteria) this;
        }

        public Criteria andRdNumberLessThan(Integer value) {
            addCriterion("rd_number <", value, "rdNumber");
            return (Criteria) this;
        }

        public Criteria andRdNumberLessThanOrEqualTo(Integer value) {
            addCriterion("rd_number <=", value, "rdNumber");
            return (Criteria) this;
        }

        public Criteria andRdNumberIn(List<Integer> values) {
            addCriterion("rd_number in", values, "rdNumber");
            return (Criteria) this;
        }

        public Criteria andRdNumberNotIn(List<Integer> values) {
            addCriterion("rd_number not in", values, "rdNumber");
            return (Criteria) this;
        }

        public Criteria andRdNumberBetween(Integer value1, Integer value2) {
            addCriterion("rd_number between", value1, value2, "rdNumber");
            return (Criteria) this;
        }

        public Criteria andRdNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("rd_number not between", value1, value2, "rdNumber");
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
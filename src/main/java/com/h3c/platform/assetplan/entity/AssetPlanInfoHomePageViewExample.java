package com.h3c.platform.assetplan.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AssetPlanInfoHomePageViewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssetPlanInfoHomePageViewExample() {
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

        public Criteria andReviewtimeIsNull() {
            addCriterion("ReviewTime is null");
            return (Criteria) this;
        }

        public Criteria andReviewtimeIsNotNull() {
            addCriterion("ReviewTime is not null");
            return (Criteria) this;
        }

        public Criteria andReviewtimeEqualTo(Date value) {
            addCriterion("ReviewTime =", value, "reviewtime");
            return (Criteria) this;
        }

        public Criteria andReviewtimeNotEqualTo(Date value) {
            addCriterion("ReviewTime <>", value, "reviewtime");
            return (Criteria) this;
        }

        public Criteria andReviewtimeGreaterThan(Date value) {
            addCriterion("ReviewTime >", value, "reviewtime");
            return (Criteria) this;
        }

        public Criteria andReviewtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ReviewTime >=", value, "reviewtime");
            return (Criteria) this;
        }

        public Criteria andReviewtimeLessThan(Date value) {
            addCriterion("ReviewTime <", value, "reviewtime");
            return (Criteria) this;
        }

        public Criteria andReviewtimeLessThanOrEqualTo(Date value) {
            addCriterion("ReviewTime <=", value, "reviewtime");
            return (Criteria) this;
        }

        public Criteria andReviewtimeIn(List<Date> values) {
            addCriterion("ReviewTime in", values, "reviewtime");
            return (Criteria) this;
        }

        public Criteria andReviewtimeNotIn(List<Date> values) {
            addCriterion("ReviewTime not in", values, "reviewtime");
            return (Criteria) this;
        }

        public Criteria andReviewtimeBetween(Date value1, Date value2) {
            addCriterion("ReviewTime between", value1, value2, "reviewtime");
            return (Criteria) this;
        }

        public Criteria andReviewtimeNotBetween(Date value1, Date value2) {
            addCriterion("ReviewTime not between", value1, value2, "reviewtime");
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

        public Criteria andReviewnoteIsNull() {
            addCriterion("ReviewNote is null");
            return (Criteria) this;
        }

        public Criteria andReviewnoteIsNotNull() {
            addCriterion("ReviewNote is not null");
            return (Criteria) this;
        }

        public Criteria andReviewnoteEqualTo(String value) {
            addCriterion("ReviewNote =", value, "reviewnote");
            return (Criteria) this;
        }

        public Criteria andReviewnoteNotEqualTo(String value) {
            addCriterion("ReviewNote <>", value, "reviewnote");
            return (Criteria) this;
        }

        public Criteria andReviewnoteGreaterThan(String value) {
            addCriterion("ReviewNote >", value, "reviewnote");
            return (Criteria) this;
        }

        public Criteria andReviewnoteGreaterThanOrEqualTo(String value) {
            addCriterion("ReviewNote >=", value, "reviewnote");
            return (Criteria) this;
        }

        public Criteria andReviewnoteLessThan(String value) {
            addCriterion("ReviewNote <", value, "reviewnote");
            return (Criteria) this;
        }

        public Criteria andReviewnoteLessThanOrEqualTo(String value) {
            addCriterion("ReviewNote <=", value, "reviewnote");
            return (Criteria) this;
        }

        public Criteria andReviewnoteLike(String value) {
            addCriterion("ReviewNote like", value, "reviewnote");
            return (Criteria) this;
        }

        public Criteria andReviewnoteNotLike(String value) {
            addCriterion("ReviewNote not like", value, "reviewnote");
            return (Criteria) this;
        }

        public Criteria andReviewnoteIn(List<String> values) {
            addCriterion("ReviewNote in", values, "reviewnote");
            return (Criteria) this;
        }

        public Criteria andReviewnoteNotIn(List<String> values) {
            addCriterion("ReviewNote not in", values, "reviewnote");
            return (Criteria) this;
        }

        public Criteria andReviewnoteBetween(String value1, String value2) {
            addCriterion("ReviewNote between", value1, value2, "reviewnote");
            return (Criteria) this;
        }

        public Criteria andReviewnoteNotBetween(String value1, String value2) {
            addCriterion("ReviewNote not between", value1, value2, "reviewnote");
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

        public Criteria andDept3checktimeIsNull() {
            addCriterion("Dept3CheckTime is null");
            return (Criteria) this;
        }

        public Criteria andDept3checktimeIsNotNull() {
            addCriterion("Dept3CheckTime is not null");
            return (Criteria) this;
        }

        public Criteria andDept3checktimeEqualTo(Date value) {
            addCriterion("Dept3CheckTime =", value, "dept3checktime");
            return (Criteria) this;
        }

        public Criteria andDept3checktimeNotEqualTo(Date value) {
            addCriterion("Dept3CheckTime <>", value, "dept3checktime");
            return (Criteria) this;
        }

        public Criteria andDept3checktimeGreaterThan(Date value) {
            addCriterion("Dept3CheckTime >", value, "dept3checktime");
            return (Criteria) this;
        }

        public Criteria andDept3checktimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Dept3CheckTime >=", value, "dept3checktime");
            return (Criteria) this;
        }

        public Criteria andDept3checktimeLessThan(Date value) {
            addCriterion("Dept3CheckTime <", value, "dept3checktime");
            return (Criteria) this;
        }

        public Criteria andDept3checktimeLessThanOrEqualTo(Date value) {
            addCriterion("Dept3CheckTime <=", value, "dept3checktime");
            return (Criteria) this;
        }

        public Criteria andDept3checktimeIn(List<Date> values) {
            addCriterion("Dept3CheckTime in", values, "dept3checktime");
            return (Criteria) this;
        }

        public Criteria andDept3checktimeNotIn(List<Date> values) {
            addCriterion("Dept3CheckTime not in", values, "dept3checktime");
            return (Criteria) this;
        }

        public Criteria andDept3checktimeBetween(Date value1, Date value2) {
            addCriterion("Dept3CheckTime between", value1, value2, "dept3checktime");
            return (Criteria) this;
        }

        public Criteria andDept3checktimeNotBetween(Date value1, Date value2) {
            addCriterion("Dept3CheckTime not between", value1, value2, "dept3checktime");
            return (Criteria) this;
        }

        public Criteria andDept3checknoteIsNull() {
            addCriterion("Dept3CheckNote is null");
            return (Criteria) this;
        }

        public Criteria andDept3checknoteIsNotNull() {
            addCriterion("Dept3CheckNote is not null");
            return (Criteria) this;
        }

        public Criteria andDept3checknoteEqualTo(String value) {
            addCriterion("Dept3CheckNote =", value, "dept3checknote");
            return (Criteria) this;
        }

        public Criteria andDept3checknoteNotEqualTo(String value) {
            addCriterion("Dept3CheckNote <>", value, "dept3checknote");
            return (Criteria) this;
        }

        public Criteria andDept3checknoteGreaterThan(String value) {
            addCriterion("Dept3CheckNote >", value, "dept3checknote");
            return (Criteria) this;
        }

        public Criteria andDept3checknoteGreaterThanOrEqualTo(String value) {
            addCriterion("Dept3CheckNote >=", value, "dept3checknote");
            return (Criteria) this;
        }

        public Criteria andDept3checknoteLessThan(String value) {
            addCriterion("Dept3CheckNote <", value, "dept3checknote");
            return (Criteria) this;
        }

        public Criteria andDept3checknoteLessThanOrEqualTo(String value) {
            addCriterion("Dept3CheckNote <=", value, "dept3checknote");
            return (Criteria) this;
        }

        public Criteria andDept3checknoteLike(String value) {
            addCriterion("Dept3CheckNote like", value, "dept3checknote");
            return (Criteria) this;
        }

        public Criteria andDept3checknoteNotLike(String value) {
            addCriterion("Dept3CheckNote not like", value, "dept3checknote");
            return (Criteria) this;
        }

        public Criteria andDept3checknoteIn(List<String> values) {
            addCriterion("Dept3CheckNote in", values, "dept3checknote");
            return (Criteria) this;
        }

        public Criteria andDept3checknoteNotIn(List<String> values) {
            addCriterion("Dept3CheckNote not in", values, "dept3checknote");
            return (Criteria) this;
        }

        public Criteria andDept3checknoteBetween(String value1, String value2) {
            addCriterion("Dept3CheckNote between", value1, value2, "dept3checknote");
            return (Criteria) this;
        }

        public Criteria andDept3checknoteNotBetween(String value1, String value2) {
            addCriterion("Dept3CheckNote not between", value1, value2, "dept3checknote");
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

        public Criteria andDept2checktimeIsNull() {
            addCriterion("Dept2CheckTime is null");
            return (Criteria) this;
        }

        public Criteria andDept2checktimeIsNotNull() {
            addCriterion("Dept2CheckTime is not null");
            return (Criteria) this;
        }

        public Criteria andDept2checktimeEqualTo(Date value) {
            addCriterion("Dept2CheckTime =", value, "dept2checktime");
            return (Criteria) this;
        }

        public Criteria andDept2checktimeNotEqualTo(Date value) {
            addCriterion("Dept2CheckTime <>", value, "dept2checktime");
            return (Criteria) this;
        }

        public Criteria andDept2checktimeGreaterThan(Date value) {
            addCriterion("Dept2CheckTime >", value, "dept2checktime");
            return (Criteria) this;
        }

        public Criteria andDept2checktimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Dept2CheckTime >=", value, "dept2checktime");
            return (Criteria) this;
        }

        public Criteria andDept2checktimeLessThan(Date value) {
            addCriterion("Dept2CheckTime <", value, "dept2checktime");
            return (Criteria) this;
        }

        public Criteria andDept2checktimeLessThanOrEqualTo(Date value) {
            addCriterion("Dept2CheckTime <=", value, "dept2checktime");
            return (Criteria) this;
        }

        public Criteria andDept2checktimeIn(List<Date> values) {
            addCriterion("Dept2CheckTime in", values, "dept2checktime");
            return (Criteria) this;
        }

        public Criteria andDept2checktimeNotIn(List<Date> values) {
            addCriterion("Dept2CheckTime not in", values, "dept2checktime");
            return (Criteria) this;
        }

        public Criteria andDept2checktimeBetween(Date value1, Date value2) {
            addCriterion("Dept2CheckTime between", value1, value2, "dept2checktime");
            return (Criteria) this;
        }

        public Criteria andDept2checktimeNotBetween(Date value1, Date value2) {
            addCriterion("Dept2CheckTime not between", value1, value2, "dept2checktime");
            return (Criteria) this;
        }

        public Criteria andDept2checknoteIsNull() {
            addCriterion("Dept2CheckNote is null");
            return (Criteria) this;
        }

        public Criteria andDept2checknoteIsNotNull() {
            addCriterion("Dept2CheckNote is not null");
            return (Criteria) this;
        }

        public Criteria andDept2checknoteEqualTo(String value) {
            addCriterion("Dept2CheckNote =", value, "dept2checknote");
            return (Criteria) this;
        }

        public Criteria andDept2checknoteNotEqualTo(String value) {
            addCriterion("Dept2CheckNote <>", value, "dept2checknote");
            return (Criteria) this;
        }

        public Criteria andDept2checknoteGreaterThan(String value) {
            addCriterion("Dept2CheckNote >", value, "dept2checknote");
            return (Criteria) this;
        }

        public Criteria andDept2checknoteGreaterThanOrEqualTo(String value) {
            addCriterion("Dept2CheckNote >=", value, "dept2checknote");
            return (Criteria) this;
        }

        public Criteria andDept2checknoteLessThan(String value) {
            addCriterion("Dept2CheckNote <", value, "dept2checknote");
            return (Criteria) this;
        }

        public Criteria andDept2checknoteLessThanOrEqualTo(String value) {
            addCriterion("Dept2CheckNote <=", value, "dept2checknote");
            return (Criteria) this;
        }

        public Criteria andDept2checknoteLike(String value) {
            addCriterion("Dept2CheckNote like", value, "dept2checknote");
            return (Criteria) this;
        }

        public Criteria andDept2checknoteNotLike(String value) {
            addCriterion("Dept2CheckNote not like", value, "dept2checknote");
            return (Criteria) this;
        }

        public Criteria andDept2checknoteIn(List<String> values) {
            addCriterion("Dept2CheckNote in", values, "dept2checknote");
            return (Criteria) this;
        }

        public Criteria andDept2checknoteNotIn(List<String> values) {
            addCriterion("Dept2CheckNote not in", values, "dept2checknote");
            return (Criteria) this;
        }

        public Criteria andDept2checknoteBetween(String value1, String value2) {
            addCriterion("Dept2CheckNote between", value1, value2, "dept2checknote");
            return (Criteria) this;
        }

        public Criteria andDept2checknoteNotBetween(String value1, String value2) {
            addCriterion("Dept2CheckNote not between", value1, value2, "dept2checknote");
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

        public Criteria andPlannertimeIsNull() {
            addCriterion("PlannerTime is null");
            return (Criteria) this;
        }

        public Criteria andPlannertimeIsNotNull() {
            addCriterion("PlannerTime is not null");
            return (Criteria) this;
        }

        public Criteria andPlannertimeEqualTo(Date value) {
            addCriterion("PlannerTime =", value, "plannertime");
            return (Criteria) this;
        }

        public Criteria andPlannertimeNotEqualTo(Date value) {
            addCriterion("PlannerTime <>", value, "plannertime");
            return (Criteria) this;
        }

        public Criteria andPlannertimeGreaterThan(Date value) {
            addCriterion("PlannerTime >", value, "plannertime");
            return (Criteria) this;
        }

        public Criteria andPlannertimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PlannerTime >=", value, "plannertime");
            return (Criteria) this;
        }

        public Criteria andPlannertimeLessThan(Date value) {
            addCriterion("PlannerTime <", value, "plannertime");
            return (Criteria) this;
        }

        public Criteria andPlannertimeLessThanOrEqualTo(Date value) {
            addCriterion("PlannerTime <=", value, "plannertime");
            return (Criteria) this;
        }

        public Criteria andPlannertimeIn(List<Date> values) {
            addCriterion("PlannerTime in", values, "plannertime");
            return (Criteria) this;
        }

        public Criteria andPlannertimeNotIn(List<Date> values) {
            addCriterion("PlannerTime not in", values, "plannertime");
            return (Criteria) this;
        }

        public Criteria andPlannertimeBetween(Date value1, Date value2) {
            addCriterion("PlannerTime between", value1, value2, "plannertime");
            return (Criteria) this;
        }

        public Criteria andPlannertimeNotBetween(Date value1, Date value2) {
            addCriterion("PlannerTime not between", value1, value2, "plannertime");
            return (Criteria) this;
        }

        public Criteria andPlannernoteIsNull() {
            addCriterion("PlannerNote is null");
            return (Criteria) this;
        }

        public Criteria andPlannernoteIsNotNull() {
            addCriterion("PlannerNote is not null");
            return (Criteria) this;
        }

        public Criteria andPlannernoteEqualTo(String value) {
            addCriterion("PlannerNote =", value, "plannernote");
            return (Criteria) this;
        }

        public Criteria andPlannernoteNotEqualTo(String value) {
            addCriterion("PlannerNote <>", value, "plannernote");
            return (Criteria) this;
        }

        public Criteria andPlannernoteGreaterThan(String value) {
            addCriterion("PlannerNote >", value, "plannernote");
            return (Criteria) this;
        }

        public Criteria andPlannernoteGreaterThanOrEqualTo(String value) {
            addCriterion("PlannerNote >=", value, "plannernote");
            return (Criteria) this;
        }

        public Criteria andPlannernoteLessThan(String value) {
            addCriterion("PlannerNote <", value, "plannernote");
            return (Criteria) this;
        }

        public Criteria andPlannernoteLessThanOrEqualTo(String value) {
            addCriterion("PlannerNote <=", value, "plannernote");
            return (Criteria) this;
        }

        public Criteria andPlannernoteLike(String value) {
            addCriterion("PlannerNote like", value, "plannernote");
            return (Criteria) this;
        }

        public Criteria andPlannernoteNotLike(String value) {
            addCriterion("PlannerNote not like", value, "plannernote");
            return (Criteria) this;
        }

        public Criteria andPlannernoteIn(List<String> values) {
            addCriterion("PlannerNote in", values, "plannernote");
            return (Criteria) this;
        }

        public Criteria andPlannernoteNotIn(List<String> values) {
            addCriterion("PlannerNote not in", values, "plannernote");
            return (Criteria) this;
        }

        public Criteria andPlannernoteBetween(String value1, String value2) {
            addCriterion("PlannerNote between", value1, value2, "plannernote");
            return (Criteria) this;
        }

        public Criteria andPlannernoteNotBetween(String value1, String value2) {
            addCriterion("PlannerNote not between", value1, value2, "plannernote");
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

        public Criteria andOqdeptreviewtimeIsNull() {
            addCriterion("OQDeptReviewTime is null");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewtimeIsNotNull() {
            addCriterion("OQDeptReviewTime is not null");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewtimeEqualTo(Date value) {
            addCriterion("OQDeptReviewTime =", value, "oqdeptreviewtime");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewtimeNotEqualTo(Date value) {
            addCriterion("OQDeptReviewTime <>", value, "oqdeptreviewtime");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewtimeGreaterThan(Date value) {
            addCriterion("OQDeptReviewTime >", value, "oqdeptreviewtime");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OQDeptReviewTime >=", value, "oqdeptreviewtime");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewtimeLessThan(Date value) {
            addCriterion("OQDeptReviewTime <", value, "oqdeptreviewtime");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewtimeLessThanOrEqualTo(Date value) {
            addCriterion("OQDeptReviewTime <=", value, "oqdeptreviewtime");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewtimeIn(List<Date> values) {
            addCriterion("OQDeptReviewTime in", values, "oqdeptreviewtime");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewtimeNotIn(List<Date> values) {
            addCriterion("OQDeptReviewTime not in", values, "oqdeptreviewtime");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewtimeBetween(Date value1, Date value2) {
            addCriterion("OQDeptReviewTime between", value1, value2, "oqdeptreviewtime");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewtimeNotBetween(Date value1, Date value2) {
            addCriterion("OQDeptReviewTime not between", value1, value2, "oqdeptreviewtime");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewnoteIsNull() {
            addCriterion("OQDeptReviewNote is null");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewnoteIsNotNull() {
            addCriterion("OQDeptReviewNote is not null");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewnoteEqualTo(String value) {
            addCriterion("OQDeptReviewNote =", value, "oqdeptreviewnote");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewnoteNotEqualTo(String value) {
            addCriterion("OQDeptReviewNote <>", value, "oqdeptreviewnote");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewnoteGreaterThan(String value) {
            addCriterion("OQDeptReviewNote >", value, "oqdeptreviewnote");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewnoteGreaterThanOrEqualTo(String value) {
            addCriterion("OQDeptReviewNote >=", value, "oqdeptreviewnote");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewnoteLessThan(String value) {
            addCriterion("OQDeptReviewNote <", value, "oqdeptreviewnote");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewnoteLessThanOrEqualTo(String value) {
            addCriterion("OQDeptReviewNote <=", value, "oqdeptreviewnote");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewnoteLike(String value) {
            addCriterion("OQDeptReviewNote like", value, "oqdeptreviewnote");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewnoteNotLike(String value) {
            addCriterion("OQDeptReviewNote not like", value, "oqdeptreviewnote");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewnoteIn(List<String> values) {
            addCriterion("OQDeptReviewNote in", values, "oqdeptreviewnote");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewnoteNotIn(List<String> values) {
            addCriterion("OQDeptReviewNote not in", values, "oqdeptreviewnote");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewnoteBetween(String value1, String value2) {
            addCriterion("OQDeptReviewNote between", value1, value2, "oqdeptreviewnote");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewnoteNotBetween(String value1, String value2) {
            addCriterion("OQDeptReviewNote not between", value1, value2, "oqdeptreviewnote");
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

        public Criteria andDept1reviewtimeIsNull() {
            addCriterion("Dept1ReviewTime is null");
            return (Criteria) this;
        }

        public Criteria andDept1reviewtimeIsNotNull() {
            addCriterion("Dept1ReviewTime is not null");
            return (Criteria) this;
        }

        public Criteria andDept1reviewtimeEqualTo(Date value) {
            addCriterion("Dept1ReviewTime =", value, "dept1reviewtime");
            return (Criteria) this;
        }

        public Criteria andDept1reviewtimeNotEqualTo(Date value) {
            addCriterion("Dept1ReviewTime <>", value, "dept1reviewtime");
            return (Criteria) this;
        }

        public Criteria andDept1reviewtimeGreaterThan(Date value) {
            addCriterion("Dept1ReviewTime >", value, "dept1reviewtime");
            return (Criteria) this;
        }

        public Criteria andDept1reviewtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Dept1ReviewTime >=", value, "dept1reviewtime");
            return (Criteria) this;
        }

        public Criteria andDept1reviewtimeLessThan(Date value) {
            addCriterion("Dept1ReviewTime <", value, "dept1reviewtime");
            return (Criteria) this;
        }

        public Criteria andDept1reviewtimeLessThanOrEqualTo(Date value) {
            addCriterion("Dept1ReviewTime <=", value, "dept1reviewtime");
            return (Criteria) this;
        }

        public Criteria andDept1reviewtimeIn(List<Date> values) {
            addCriterion("Dept1ReviewTime in", values, "dept1reviewtime");
            return (Criteria) this;
        }

        public Criteria andDept1reviewtimeNotIn(List<Date> values) {
            addCriterion("Dept1ReviewTime not in", values, "dept1reviewtime");
            return (Criteria) this;
        }

        public Criteria andDept1reviewtimeBetween(Date value1, Date value2) {
            addCriterion("Dept1ReviewTime between", value1, value2, "dept1reviewtime");
            return (Criteria) this;
        }

        public Criteria andDept1reviewtimeNotBetween(Date value1, Date value2) {
            addCriterion("Dept1ReviewTime not between", value1, value2, "dept1reviewtime");
            return (Criteria) this;
        }

        public Criteria andDept1reviewnoteIsNull() {
            addCriterion("Dept1ReviewNote is null");
            return (Criteria) this;
        }

        public Criteria andDept1reviewnoteIsNotNull() {
            addCriterion("Dept1ReviewNote is not null");
            return (Criteria) this;
        }

        public Criteria andDept1reviewnoteEqualTo(String value) {
            addCriterion("Dept1ReviewNote =", value, "dept1reviewnote");
            return (Criteria) this;
        }

        public Criteria andDept1reviewnoteNotEqualTo(String value) {
            addCriterion("Dept1ReviewNote <>", value, "dept1reviewnote");
            return (Criteria) this;
        }

        public Criteria andDept1reviewnoteGreaterThan(String value) {
            addCriterion("Dept1ReviewNote >", value, "dept1reviewnote");
            return (Criteria) this;
        }

        public Criteria andDept1reviewnoteGreaterThanOrEqualTo(String value) {
            addCriterion("Dept1ReviewNote >=", value, "dept1reviewnote");
            return (Criteria) this;
        }

        public Criteria andDept1reviewnoteLessThan(String value) {
            addCriterion("Dept1ReviewNote <", value, "dept1reviewnote");
            return (Criteria) this;
        }

        public Criteria andDept1reviewnoteLessThanOrEqualTo(String value) {
            addCriterion("Dept1ReviewNote <=", value, "dept1reviewnote");
            return (Criteria) this;
        }

        public Criteria andDept1reviewnoteLike(String value) {
            addCriterion("Dept1ReviewNote like", value, "dept1reviewnote");
            return (Criteria) this;
        }

        public Criteria andDept1reviewnoteNotLike(String value) {
            addCriterion("Dept1ReviewNote not like", value, "dept1reviewnote");
            return (Criteria) this;
        }

        public Criteria andDept1reviewnoteIn(List<String> values) {
            addCriterion("Dept1ReviewNote in", values, "dept1reviewnote");
            return (Criteria) this;
        }

        public Criteria andDept1reviewnoteNotIn(List<String> values) {
            addCriterion("Dept1ReviewNote not in", values, "dept1reviewnote");
            return (Criteria) this;
        }

        public Criteria andDept1reviewnoteBetween(String value1, String value2) {
            addCriterion("Dept1ReviewNote between", value1, value2, "dept1reviewnote");
            return (Criteria) this;
        }

        public Criteria andDept1reviewnoteNotBetween(String value1, String value2) {
            addCriterion("Dept1ReviewNote not between", value1, value2, "dept1reviewnote");
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

        public Criteria andReviewercountIsNull() {
            addCriterion("ReviewerCount is null");
            return (Criteria) this;
        }

        public Criteria andReviewercountIsNotNull() {
            addCriterion("ReviewerCount is not null");
            return (Criteria) this;
        }

        public Criteria andReviewercountEqualTo(Integer value) {
            addCriterion("ReviewerCount =", value, "reviewercount");
            return (Criteria) this;
        }

        public Criteria andReviewercountNotEqualTo(Integer value) {
            addCriterion("ReviewerCount <>", value, "reviewercount");
            return (Criteria) this;
        }

        public Criteria andReviewercountGreaterThan(Integer value) {
            addCriterion("ReviewerCount >", value, "reviewercount");
            return (Criteria) this;
        }

        public Criteria andReviewercountGreaterThanOrEqualTo(Integer value) {
            addCriterion("ReviewerCount >=", value, "reviewercount");
            return (Criteria) this;
        }

        public Criteria andReviewercountLessThan(Integer value) {
            addCriterion("ReviewerCount <", value, "reviewercount");
            return (Criteria) this;
        }

        public Criteria andReviewercountLessThanOrEqualTo(Integer value) {
            addCriterion("ReviewerCount <=", value, "reviewercount");
            return (Criteria) this;
        }

        public Criteria andReviewercountIn(List<Integer> values) {
            addCriterion("ReviewerCount in", values, "reviewercount");
            return (Criteria) this;
        }

        public Criteria andReviewercountNotIn(List<Integer> values) {
            addCriterion("ReviewerCount not in", values, "reviewercount");
            return (Criteria) this;
        }

        public Criteria andReviewercountBetween(Integer value1, Integer value2) {
            addCriterion("ReviewerCount between", value1, value2, "reviewercount");
            return (Criteria) this;
        }

        public Criteria andReviewercountNotBetween(Integer value1, Integer value2) {
            addCriterion("ReviewerCount not between", value1, value2, "reviewercount");
            return (Criteria) this;
        }

        public Criteria andReviewerpersonIsNull() {
            addCriterion("ReviewerPerson is null");
            return (Criteria) this;
        }

        public Criteria andReviewerpersonIsNotNull() {
            addCriterion("ReviewerPerson is not null");
            return (Criteria) this;
        }

        public Criteria andReviewerpersonEqualTo(String value) {
            addCriterion("ReviewerPerson =", value, "reviewerperson");
            return (Criteria) this;
        }

        public Criteria andReviewerpersonNotEqualTo(String value) {
            addCriterion("ReviewerPerson <>", value, "reviewerperson");
            return (Criteria) this;
        }

        public Criteria andReviewerpersonGreaterThan(String value) {
            addCriterion("ReviewerPerson >", value, "reviewerperson");
            return (Criteria) this;
        }

        public Criteria andReviewerpersonGreaterThanOrEqualTo(String value) {
            addCriterion("ReviewerPerson >=", value, "reviewerperson");
            return (Criteria) this;
        }

        public Criteria andReviewerpersonLessThan(String value) {
            addCriterion("ReviewerPerson <", value, "reviewerperson");
            return (Criteria) this;
        }

        public Criteria andReviewerpersonLessThanOrEqualTo(String value) {
            addCriterion("ReviewerPerson <=", value, "reviewerperson");
            return (Criteria) this;
        }

        public Criteria andReviewerpersonLike(String value) {
            addCriterion("ReviewerPerson like", value, "reviewerperson");
            return (Criteria) this;
        }

        public Criteria andReviewerpersonNotLike(String value) {
            addCriterion("ReviewerPerson not like", value, "reviewerperson");
            return (Criteria) this;
        }

        public Criteria andReviewerpersonIn(List<String> values) {
            addCriterion("ReviewerPerson in", values, "reviewerperson");
            return (Criteria) this;
        }

        public Criteria andReviewerpersonNotIn(List<String> values) {
            addCriterion("ReviewerPerson not in", values, "reviewerperson");
            return (Criteria) this;
        }

        public Criteria andReviewerpersonBetween(String value1, String value2) {
            addCriterion("ReviewerPerson between", value1, value2, "reviewerperson");
            return (Criteria) this;
        }

        public Criteria andReviewerpersonNotBetween(String value1, String value2) {
            addCriterion("ReviewerPerson not between", value1, value2, "reviewerperson");
            return (Criteria) this;
        }

        public Criteria andDept3managercountIsNull() {
            addCriterion("Dept3ManagerCount is null");
            return (Criteria) this;
        }

        public Criteria andDept3managercountIsNotNull() {
            addCriterion("Dept3ManagerCount is not null");
            return (Criteria) this;
        }

        public Criteria andDept3managercountEqualTo(Integer value) {
            addCriterion("Dept3ManagerCount =", value, "dept3managercount");
            return (Criteria) this;
        }

        public Criteria andDept3managercountNotEqualTo(Integer value) {
            addCriterion("Dept3ManagerCount <>", value, "dept3managercount");
            return (Criteria) this;
        }

        public Criteria andDept3managercountGreaterThan(Integer value) {
            addCriterion("Dept3ManagerCount >", value, "dept3managercount");
            return (Criteria) this;
        }

        public Criteria andDept3managercountGreaterThanOrEqualTo(Integer value) {
            addCriterion("Dept3ManagerCount >=", value, "dept3managercount");
            return (Criteria) this;
        }

        public Criteria andDept3managercountLessThan(Integer value) {
            addCriterion("Dept3ManagerCount <", value, "dept3managercount");
            return (Criteria) this;
        }

        public Criteria andDept3managercountLessThanOrEqualTo(Integer value) {
            addCriterion("Dept3ManagerCount <=", value, "dept3managercount");
            return (Criteria) this;
        }

        public Criteria andDept3managercountIn(List<Integer> values) {
            addCriterion("Dept3ManagerCount in", values, "dept3managercount");
            return (Criteria) this;
        }

        public Criteria andDept3managercountNotIn(List<Integer> values) {
            addCriterion("Dept3ManagerCount not in", values, "dept3managercount");
            return (Criteria) this;
        }

        public Criteria andDept3managercountBetween(Integer value1, Integer value2) {
            addCriterion("Dept3ManagerCount between", value1, value2, "dept3managercount");
            return (Criteria) this;
        }

        public Criteria andDept3managercountNotBetween(Integer value1, Integer value2) {
            addCriterion("Dept3ManagerCount not between", value1, value2, "dept3managercount");
            return (Criteria) this;
        }

        public Criteria andDept2managercountIsNull() {
            addCriterion("Dept2ManagerCount is null");
            return (Criteria) this;
        }

        public Criteria andDept2managercountIsNotNull() {
            addCriterion("Dept2ManagerCount is not null");
            return (Criteria) this;
        }

        public Criteria andDept2managercountEqualTo(Integer value) {
            addCriterion("Dept2ManagerCount =", value, "dept2managercount");
            return (Criteria) this;
        }

        public Criteria andDept2managercountNotEqualTo(Integer value) {
            addCriterion("Dept2ManagerCount <>", value, "dept2managercount");
            return (Criteria) this;
        }

        public Criteria andDept2managercountGreaterThan(Integer value) {
            addCriterion("Dept2ManagerCount >", value, "dept2managercount");
            return (Criteria) this;
        }

        public Criteria andDept2managercountGreaterThanOrEqualTo(Integer value) {
            addCriterion("Dept2ManagerCount >=", value, "dept2managercount");
            return (Criteria) this;
        }

        public Criteria andDept2managercountLessThan(Integer value) {
            addCriterion("Dept2ManagerCount <", value, "dept2managercount");
            return (Criteria) this;
        }

        public Criteria andDept2managercountLessThanOrEqualTo(Integer value) {
            addCriterion("Dept2ManagerCount <=", value, "dept2managercount");
            return (Criteria) this;
        }

        public Criteria andDept2managercountIn(List<Integer> values) {
            addCriterion("Dept2ManagerCount in", values, "dept2managercount");
            return (Criteria) this;
        }

        public Criteria andDept2managercountNotIn(List<Integer> values) {
            addCriterion("Dept2ManagerCount not in", values, "dept2managercount");
            return (Criteria) this;
        }

        public Criteria andDept2managercountBetween(Integer value1, Integer value2) {
            addCriterion("Dept2ManagerCount between", value1, value2, "dept2managercount");
            return (Criteria) this;
        }

        public Criteria andDept2managercountNotBetween(Integer value1, Integer value2) {
            addCriterion("Dept2ManagerCount not between", value1, value2, "dept2managercount");
            return (Criteria) this;
        }

        public Criteria andPlannercountIsNull() {
            addCriterion("PlannerCount is null");
            return (Criteria) this;
        }

        public Criteria andPlannercountIsNotNull() {
            addCriterion("PlannerCount is not null");
            return (Criteria) this;
        }

        public Criteria andPlannercountEqualTo(Integer value) {
            addCriterion("PlannerCount =", value, "plannercount");
            return (Criteria) this;
        }

        public Criteria andPlannercountNotEqualTo(Integer value) {
            addCriterion("PlannerCount <>", value, "plannercount");
            return (Criteria) this;
        }

        public Criteria andPlannercountGreaterThan(Integer value) {
            addCriterion("PlannerCount >", value, "plannercount");
            return (Criteria) this;
        }

        public Criteria andPlannercountGreaterThanOrEqualTo(Integer value) {
            addCriterion("PlannerCount >=", value, "plannercount");
            return (Criteria) this;
        }

        public Criteria andPlannercountLessThan(Integer value) {
            addCriterion("PlannerCount <", value, "plannercount");
            return (Criteria) this;
        }

        public Criteria andPlannercountLessThanOrEqualTo(Integer value) {
            addCriterion("PlannerCount <=", value, "plannercount");
            return (Criteria) this;
        }

        public Criteria andPlannercountIn(List<Integer> values) {
            addCriterion("PlannerCount in", values, "plannercount");
            return (Criteria) this;
        }

        public Criteria andPlannercountNotIn(List<Integer> values) {
            addCriterion("PlannerCount not in", values, "plannercount");
            return (Criteria) this;
        }

        public Criteria andPlannercountBetween(Integer value1, Integer value2) {
            addCriterion("PlannerCount between", value1, value2, "plannercount");
            return (Criteria) this;
        }

        public Criteria andPlannercountNotBetween(Integer value1, Integer value2) {
            addCriterion("PlannerCount not between", value1, value2, "plannercount");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewercountIsNull() {
            addCriterion("OQDeptReviewerCount is null");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewercountIsNotNull() {
            addCriterion("OQDeptReviewerCount is not null");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewercountEqualTo(Integer value) {
            addCriterion("OQDeptReviewerCount =", value, "oqdeptreviewercount");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewercountNotEqualTo(Integer value) {
            addCriterion("OQDeptReviewerCount <>", value, "oqdeptreviewercount");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewercountGreaterThan(Integer value) {
            addCriterion("OQDeptReviewerCount >", value, "oqdeptreviewercount");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewercountGreaterThanOrEqualTo(Integer value) {
            addCriterion("OQDeptReviewerCount >=", value, "oqdeptreviewercount");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewercountLessThan(Integer value) {
            addCriterion("OQDeptReviewerCount <", value, "oqdeptreviewercount");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewercountLessThanOrEqualTo(Integer value) {
            addCriterion("OQDeptReviewerCount <=", value, "oqdeptreviewercount");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewercountIn(List<Integer> values) {
            addCriterion("OQDeptReviewerCount in", values, "oqdeptreviewercount");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewercountNotIn(List<Integer> values) {
            addCriterion("OQDeptReviewerCount not in", values, "oqdeptreviewercount");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewercountBetween(Integer value1, Integer value2) {
            addCriterion("OQDeptReviewerCount between", value1, value2, "oqdeptreviewercount");
            return (Criteria) this;
        }

        public Criteria andOqdeptreviewercountNotBetween(Integer value1, Integer value2) {
            addCriterion("OQDeptReviewerCount not between", value1, value2, "oqdeptreviewercount");
            return (Criteria) this;
        }

        public Criteria andDept1reviewercountIsNull() {
            addCriterion("Dept1ReviewerCount is null");
            return (Criteria) this;
        }

        public Criteria andDept1reviewercountIsNotNull() {
            addCriterion("Dept1ReviewerCount is not null");
            return (Criteria) this;
        }

        public Criteria andDept1reviewercountEqualTo(Integer value) {
            addCriterion("Dept1ReviewerCount =", value, "dept1reviewercount");
            return (Criteria) this;
        }

        public Criteria andDept1reviewercountNotEqualTo(Integer value) {
            addCriterion("Dept1ReviewerCount <>", value, "dept1reviewercount");
            return (Criteria) this;
        }

        public Criteria andDept1reviewercountGreaterThan(Integer value) {
            addCriterion("Dept1ReviewerCount >", value, "dept1reviewercount");
            return (Criteria) this;
        }

        public Criteria andDept1reviewercountGreaterThanOrEqualTo(Integer value) {
            addCriterion("Dept1ReviewerCount >=", value, "dept1reviewercount");
            return (Criteria) this;
        }

        public Criteria andDept1reviewercountLessThan(Integer value) {
            addCriterion("Dept1ReviewerCount <", value, "dept1reviewercount");
            return (Criteria) this;
        }

        public Criteria andDept1reviewercountLessThanOrEqualTo(Integer value) {
            addCriterion("Dept1ReviewerCount <=", value, "dept1reviewercount");
            return (Criteria) this;
        }

        public Criteria andDept1reviewercountIn(List<Integer> values) {
            addCriterion("Dept1ReviewerCount in", values, "dept1reviewercount");
            return (Criteria) this;
        }

        public Criteria andDept1reviewercountNotIn(List<Integer> values) {
            addCriterion("Dept1ReviewerCount not in", values, "dept1reviewercount");
            return (Criteria) this;
        }

        public Criteria andDept1reviewercountBetween(Integer value1, Integer value2) {
            addCriterion("Dept1ReviewerCount between", value1, value2, "dept1reviewercount");
            return (Criteria) this;
        }

        public Criteria andDept1reviewercountNotBetween(Integer value1, Integer value2) {
            addCriterion("Dept1ReviewerCount not between", value1, value2, "dept1reviewercount");
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
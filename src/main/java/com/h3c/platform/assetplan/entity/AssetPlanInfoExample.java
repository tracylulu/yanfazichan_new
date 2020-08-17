package com.h3c.platform.assetplan.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AssetPlanInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssetPlanInfoExample() {
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

        public Criteria andReqarrivaldateIsNull() {
            addCriterion("ReqArrivalDate is null");
            return (Criteria) this;
        }

        public Criteria andReqarrivaldateIsNotNull() {
            addCriterion("ReqArrivalDate is not null");
            return (Criteria) this;
        }

        public Criteria andReqarrivaldateEqualTo(Date value) {
            addCriterionForJDBCDate("ReqArrivalDate =", value, "reqarrivaldate");
            return (Criteria) this;
        }

        public Criteria andReqarrivaldateNotEqualTo(Date value) {
            addCriterionForJDBCDate("ReqArrivalDate <>", value, "reqarrivaldate");
            return (Criteria) this;
        }

        public Criteria andReqarrivaldateGreaterThan(Date value) {
            addCriterionForJDBCDate("ReqArrivalDate >", value, "reqarrivaldate");
            return (Criteria) this;
        }

        public Criteria andReqarrivaldateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ReqArrivalDate >=", value, "reqarrivaldate");
            return (Criteria) this;
        }

        public Criteria andReqarrivaldateLessThan(Date value) {
            addCriterionForJDBCDate("ReqArrivalDate <", value, "reqarrivaldate");
            return (Criteria) this;
        }

        public Criteria andReqarrivaldateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ReqArrivalDate <=", value, "reqarrivaldate");
            return (Criteria) this;
        }

        public Criteria andReqarrivaldateIn(List<Date> values) {
            addCriterionForJDBCDate("ReqArrivalDate in", values, "reqarrivaldate");
            return (Criteria) this;
        }

        public Criteria andReqarrivaldateNotIn(List<Date> values) {
            addCriterionForJDBCDate("ReqArrivalDate not in", values, "reqarrivaldate");
            return (Criteria) this;
        }

        public Criteria andReqarrivaldateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ReqArrivalDate between", value1, value2, "reqarrivaldate");
            return (Criteria) this;
        }

        public Criteria andReqarrivaldateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ReqArrivalDate not between", value1, value2, "reqarrivaldate");
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

        public Criteria andPurchasereportidIsNull() {
            addCriterion("PurchaseReportID is null");
            return (Criteria) this;
        }

        public Criteria andPurchasereportidIsNotNull() {
            addCriterion("PurchaseReportID is not null");
            return (Criteria) this;
        }

        public Criteria andPurchasereportidEqualTo(String value) {
            addCriterion("PurchaseReportID =", value, "purchasereportid");
            return (Criteria) this;
        }

        public Criteria andPurchasereportidNotEqualTo(String value) {
            addCriterion("PurchaseReportID <>", value, "purchasereportid");
            return (Criteria) this;
        }

        public Criteria andPurchasereportidGreaterThan(String value) {
            addCriterion("PurchaseReportID >", value, "purchasereportid");
            return (Criteria) this;
        }

        public Criteria andPurchasereportidGreaterThanOrEqualTo(String value) {
            addCriterion("PurchaseReportID >=", value, "purchasereportid");
            return (Criteria) this;
        }

        public Criteria andPurchasereportidLessThan(String value) {
            addCriterion("PurchaseReportID <", value, "purchasereportid");
            return (Criteria) this;
        }

        public Criteria andPurchasereportidLessThanOrEqualTo(String value) {
            addCriterion("PurchaseReportID <=", value, "purchasereportid");
            return (Criteria) this;
        }

        public Criteria andPurchasereportidLike(String value) {
            addCriterion("PurchaseReportID like", value, "purchasereportid");
            return (Criteria) this;
        }

        public Criteria andPurchasereportidNotLike(String value) {
            addCriterion("PurchaseReportID not like", value, "purchasereportid");
            return (Criteria) this;
        }

        public Criteria andPurchasereportidIn(List<String> values) {
            addCriterion("PurchaseReportID in", values, "purchasereportid");
            return (Criteria) this;
        }

        public Criteria andPurchasereportidNotIn(List<String> values) {
            addCriterion("PurchaseReportID not in", values, "purchasereportid");
            return (Criteria) this;
        }

        public Criteria andPurchasereportidBetween(String value1, String value2) {
            addCriterion("PurchaseReportID between", value1, value2, "purchasereportid");
            return (Criteria) this;
        }

        public Criteria andPurchasereportidNotBetween(String value1, String value2) {
            addCriterion("PurchaseReportID not between", value1, value2, "purchasereportid");
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

        public Criteria andUsagerateIsNull() {
            addCriterion("UsageRate is null");
            return (Criteria) this;
        }

        public Criteria andUsagerateIsNotNull() {
            addCriterion("UsageRate is not null");
            return (Criteria) this;
        }

        public Criteria andUsagerateEqualTo(String value) {
            addCriterion("UsageRate =", value, "usagerate");
            return (Criteria) this;
        }

        public Criteria andUsagerateNotEqualTo(String value) {
            addCriterion("UsageRate <>", value, "usagerate");
            return (Criteria) this;
        }

        public Criteria andUsagerateGreaterThan(String value) {
            addCriterion("UsageRate >", value, "usagerate");
            return (Criteria) this;
        }

        public Criteria andUsagerateGreaterThanOrEqualTo(String value) {
            addCriterion("UsageRate >=", value, "usagerate");
            return (Criteria) this;
        }

        public Criteria andUsagerateLessThan(String value) {
            addCriterion("UsageRate <", value, "usagerate");
            return (Criteria) this;
        }

        public Criteria andUsagerateLessThanOrEqualTo(String value) {
            addCriterion("UsageRate <=", value, "usagerate");
            return (Criteria) this;
        }

        public Criteria andUsagerateLike(String value) {
            addCriterion("UsageRate like", value, "usagerate");
            return (Criteria) this;
        }

        public Criteria andUsagerateNotLike(String value) {
            addCriterion("UsageRate not like", value, "usagerate");
            return (Criteria) this;
        }

        public Criteria andUsagerateIn(List<String> values) {
            addCriterion("UsageRate in", values, "usagerate");
            return (Criteria) this;
        }

        public Criteria andUsagerateNotIn(List<String> values) {
            addCriterion("UsageRate not in", values, "usagerate");
            return (Criteria) this;
        }

        public Criteria andUsagerateBetween(String value1, String value2) {
            addCriterion("UsageRate between", value1, value2, "usagerate");
            return (Criteria) this;
        }

        public Criteria andUsagerateNotBetween(String value1, String value2) {
            addCriterion("UsageRate not between", value1, value2, "usagerate");
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
package com.h3c.platform.assetplan.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssetPlanInfoSearchViewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssetPlanInfoSearchViewExample() {
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

        public Criteria andDept2codeIsNull() {
            addCriterion("Dept2Code is null");
            return (Criteria) this;
        }

        public Criteria andDept2codeIsNotNull() {
            addCriterion("Dept2Code is not null");
            return (Criteria) this;
        }

        public Criteria andDept2codeEqualTo(Integer value) {
            addCriterion("Dept2Code =", value, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeNotEqualTo(Integer value) {
            addCriterion("Dept2Code <>", value, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeGreaterThan(Integer value) {
            addCriterion("Dept2Code >", value, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Dept2Code >=", value, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeLessThan(Integer value) {
            addCriterion("Dept2Code <", value, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeLessThanOrEqualTo(Integer value) {
            addCriterion("Dept2Code <=", value, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeIn(List<Integer> values) {
            addCriterion("Dept2Code in", values, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeNotIn(List<Integer> values) {
            addCriterion("Dept2Code not in", values, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeBetween(Integer value1, Integer value2) {
            addCriterion("Dept2Code between", value1, value2, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeNotBetween(Integer value1, Integer value2) {
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

        public Criteria andDept1codeEqualTo(Integer value) {
            addCriterion("Dept1Code =", value, "dept1code");
            return (Criteria) this;
        }

        public Criteria andDept1codeNotEqualTo(Integer value) {
            addCriterion("Dept1Code <>", value, "dept1code");
            return (Criteria) this;
        }

        public Criteria andDept1codeGreaterThan(Integer value) {
            addCriterion("Dept1Code >", value, "dept1code");
            return (Criteria) this;
        }

        public Criteria andDept1codeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Dept1Code >=", value, "dept1code");
            return (Criteria) this;
        }

        public Criteria andDept1codeLessThan(Integer value) {
            addCriterion("Dept1Code <", value, "dept1code");
            return (Criteria) this;
        }

        public Criteria andDept1codeLessThanOrEqualTo(Integer value) {
            addCriterion("Dept1Code <=", value, "dept1code");
            return (Criteria) this;
        }

        public Criteria andDept1codeIn(List<Integer> values) {
            addCriterion("Dept1Code in", values, "dept1code");
            return (Criteria) this;
        }

        public Criteria andDept1codeNotIn(List<Integer> values) {
            addCriterion("Dept1Code not in", values, "dept1code");
            return (Criteria) this;
        }

        public Criteria andDept1codeBetween(Integer value1, Integer value2) {
            addCriterion("Dept1Code between", value1, value2, "dept1code");
            return (Criteria) this;
        }

        public Criteria andDept1codeNotBetween(Integer value1, Integer value2) {
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
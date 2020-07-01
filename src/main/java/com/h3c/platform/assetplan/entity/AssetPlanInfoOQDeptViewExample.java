package com.h3c.platform.assetplan.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssetPlanInfoOQDeptViewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssetPlanInfoOQDeptViewExample() {
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

        public Criteria andNopasscountIsNull() {
            addCriterion("NoPassCount is null");
            return (Criteria) this;
        }

        public Criteria andNopasscountIsNotNull() {
            addCriterion("NoPassCount is not null");
            return (Criteria) this;
        }

        public Criteria andNopasscountEqualTo(Long value) {
            addCriterion("NoPassCount =", value, "nopasscount");
            return (Criteria) this;
        }

        public Criteria andNopasscountNotEqualTo(Long value) {
            addCriterion("NoPassCount <>", value, "nopasscount");
            return (Criteria) this;
        }

        public Criteria andNopasscountGreaterThan(Long value) {
            addCriterion("NoPassCount >", value, "nopasscount");
            return (Criteria) this;
        }

        public Criteria andNopasscountGreaterThanOrEqualTo(Long value) {
            addCriterion("NoPassCount >=", value, "nopasscount");
            return (Criteria) this;
        }

        public Criteria andNopasscountLessThan(Long value) {
            addCriterion("NoPassCount <", value, "nopasscount");
            return (Criteria) this;
        }

        public Criteria andNopasscountLessThanOrEqualTo(Long value) {
            addCriterion("NoPassCount <=", value, "nopasscount");
            return (Criteria) this;
        }

        public Criteria andNopasscountIn(List<Long> values) {
            addCriterion("NoPassCount in", values, "nopasscount");
            return (Criteria) this;
        }

        public Criteria andNopasscountNotIn(List<Long> values) {
            addCriterion("NoPassCount not in", values, "nopasscount");
            return (Criteria) this;
        }

        public Criteria andNopasscountBetween(Long value1, Long value2) {
            addCriterion("NoPassCount between", value1, value2, "nopasscount");
            return (Criteria) this;
        }

        public Criteria andNopasscountNotBetween(Long value1, Long value2) {
            addCriterion("NoPassCount not between", value1, value2, "nopasscount");
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
            addCriterion("dept2Code is null");
            return (Criteria) this;
        }

        public Criteria andDept2codeIsNotNull() {
            addCriterion("dept2Code is not null");
            return (Criteria) this;
        }

        public Criteria andDept2codeEqualTo(String value) {
            addCriterion("dept2Code =", value, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeNotEqualTo(String value) {
            addCriterion("dept2Code <>", value, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeGreaterThan(String value) {
            addCriterion("dept2Code >", value, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeGreaterThanOrEqualTo(String value) {
            addCriterion("dept2Code >=", value, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeLessThan(String value) {
            addCriterion("dept2Code <", value, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeLessThanOrEqualTo(String value) {
            addCriterion("dept2Code <=", value, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeLike(String value) {
            addCriterion("dept2Code like", value, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeNotLike(String value) {
            addCriterion("dept2Code not like", value, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeIn(List<String> values) {
            addCriterion("dept2Code in", values, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeNotIn(List<String> values) {
            addCriterion("dept2Code not in", values, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeBetween(String value1, String value2) {
            addCriterion("dept2Code between", value1, value2, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2codeNotBetween(String value1, String value2) {
            addCriterion("dept2Code not between", value1, value2, "dept2code");
            return (Criteria) this;
        }

        public Criteria andDept2nameIsNull() {
            addCriterion("dept2Name is null");
            return (Criteria) this;
        }

        public Criteria andDept2nameIsNotNull() {
            addCriterion("dept2Name is not null");
            return (Criteria) this;
        }

        public Criteria andDept2nameEqualTo(String value) {
            addCriterion("dept2Name =", value, "dept2name");
            return (Criteria) this;
        }

        public Criteria andDept2nameNotEqualTo(String value) {
            addCriterion("dept2Name <>", value, "dept2name");
            return (Criteria) this;
        }

        public Criteria andDept2nameGreaterThan(String value) {
            addCriterion("dept2Name >", value, "dept2name");
            return (Criteria) this;
        }

        public Criteria andDept2nameGreaterThanOrEqualTo(String value) {
            addCriterion("dept2Name >=", value, "dept2name");
            return (Criteria) this;
        }

        public Criteria andDept2nameLessThan(String value) {
            addCriterion("dept2Name <", value, "dept2name");
            return (Criteria) this;
        }

        public Criteria andDept2nameLessThanOrEqualTo(String value) {
            addCriterion("dept2Name <=", value, "dept2name");
            return (Criteria) this;
        }

        public Criteria andDept2nameLike(String value) {
            addCriterion("dept2Name like", value, "dept2name");
            return (Criteria) this;
        }

        public Criteria andDept2nameNotLike(String value) {
            addCriterion("dept2Name not like", value, "dept2name");
            return (Criteria) this;
        }

        public Criteria andDept2nameIn(List<String> values) {
            addCriterion("dept2Name in", values, "dept2name");
            return (Criteria) this;
        }

        public Criteria andDept2nameNotIn(List<String> values) {
            addCriterion("dept2Name not in", values, "dept2name");
            return (Criteria) this;
        }

        public Criteria andDept2nameBetween(String value1, String value2) {
            addCriterion("dept2Name between", value1, value2, "dept2name");
            return (Criteria) this;
        }

        public Criteria andDept2nameNotBetween(String value1, String value2) {
            addCriterion("dept2Name not between", value1, value2, "dept2name");
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

        public Criteria andManufacturertypeenumIsNull() {
            addCriterion("ManufacturerTypeEnum is null");
            return (Criteria) this;
        }

        public Criteria andManufacturertypeenumIsNotNull() {
            addCriterion("ManufacturerTypeEnum is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturertypeenumEqualTo(String value) {
            addCriterion("ManufacturerTypeEnum =", value, "manufacturertypeenum");
            return (Criteria) this;
        }

        public Criteria andManufacturertypeenumNotEqualTo(String value) {
            addCriterion("ManufacturerTypeEnum <>", value, "manufacturertypeenum");
            return (Criteria) this;
        }

        public Criteria andManufacturertypeenumGreaterThan(String value) {
            addCriterion("ManufacturerTypeEnum >", value, "manufacturertypeenum");
            return (Criteria) this;
        }

        public Criteria andManufacturertypeenumGreaterThanOrEqualTo(String value) {
            addCriterion("ManufacturerTypeEnum >=", value, "manufacturertypeenum");
            return (Criteria) this;
        }

        public Criteria andManufacturertypeenumLessThan(String value) {
            addCriterion("ManufacturerTypeEnum <", value, "manufacturertypeenum");
            return (Criteria) this;
        }

        public Criteria andManufacturertypeenumLessThanOrEqualTo(String value) {
            addCriterion("ManufacturerTypeEnum <=", value, "manufacturertypeenum");
            return (Criteria) this;
        }

        public Criteria andManufacturertypeenumLike(String value) {
            addCriterion("ManufacturerTypeEnum like", value, "manufacturertypeenum");
            return (Criteria) this;
        }

        public Criteria andManufacturertypeenumNotLike(String value) {
            addCriterion("ManufacturerTypeEnum not like", value, "manufacturertypeenum");
            return (Criteria) this;
        }

        public Criteria andManufacturertypeenumIn(List<String> values) {
            addCriterion("ManufacturerTypeEnum in", values, "manufacturertypeenum");
            return (Criteria) this;
        }

        public Criteria andManufacturertypeenumNotIn(List<String> values) {
            addCriterion("ManufacturerTypeEnum not in", values, "manufacturertypeenum");
            return (Criteria) this;
        }

        public Criteria andManufacturertypeenumBetween(String value1, String value2) {
            addCriterion("ManufacturerTypeEnum between", value1, value2, "manufacturertypeenum");
            return (Criteria) this;
        }

        public Criteria andManufacturertypeenumNotBetween(String value1, String value2) {
            addCriterion("ManufacturerTypeEnum not between", value1, value2, "manufacturertypeenum");
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

        public Criteria andGroupflagIsNull() {
            addCriterion("GroupFlag is null");
            return (Criteria) this;
        }

        public Criteria andGroupflagIsNotNull() {
            addCriterion("GroupFlag is not null");
            return (Criteria) this;
        }

        public Criteria andGroupflagEqualTo(String value) {
            addCriterion("GroupFlag =", value, "groupflag");
            return (Criteria) this;
        }

        public Criteria andGroupflagNotEqualTo(String value) {
            addCriterion("GroupFlag <>", value, "groupflag");
            return (Criteria) this;
        }

        public Criteria andGroupflagGreaterThan(String value) {
            addCriterion("GroupFlag >", value, "groupflag");
            return (Criteria) this;
        }

        public Criteria andGroupflagGreaterThanOrEqualTo(String value) {
            addCriterion("GroupFlag >=", value, "groupflag");
            return (Criteria) this;
        }

        public Criteria andGroupflagLessThan(String value) {
            addCriterion("GroupFlag <", value, "groupflag");
            return (Criteria) this;
        }

        public Criteria andGroupflagLessThanOrEqualTo(String value) {
            addCriterion("GroupFlag <=", value, "groupflag");
            return (Criteria) this;
        }

        public Criteria andGroupflagLike(String value) {
            addCriterion("GroupFlag like", value, "groupflag");
            return (Criteria) this;
        }

        public Criteria andGroupflagNotLike(String value) {
            addCriterion("GroupFlag not like", value, "groupflag");
            return (Criteria) this;
        }

        public Criteria andGroupflagIn(List<String> values) {
            addCriterion("GroupFlag in", values, "groupflag");
            return (Criteria) this;
        }

        public Criteria andGroupflagNotIn(List<String> values) {
            addCriterion("GroupFlag not in", values, "groupflag");
            return (Criteria) this;
        }

        public Criteria andGroupflagBetween(String value1, String value2) {
            addCriterion("GroupFlag between", value1, value2, "groupflag");
            return (Criteria) this;
        }

        public Criteria andGroupflagNotBetween(String value1, String value2) {
            addCriterion("GroupFlag not between", value1, value2, "groupflag");
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

        public Criteria andGroupflagdetailIsNull() {
            addCriterion("GroupflagDetail is null");
            return (Criteria) this;
        }

        public Criteria andGroupflagdetailIsNotNull() {
            addCriterion("GroupflagDetail is not null");
            return (Criteria) this;
        }

        public Criteria andGroupflagdetailEqualTo(String value) {
            addCriterion("GroupflagDetail =", value, "groupflagdetail");
            return (Criteria) this;
        }

        public Criteria andGroupflagdetailNotEqualTo(String value) {
            addCriterion("GroupflagDetail <>", value, "groupflagdetail");
            return (Criteria) this;
        }

        public Criteria andGroupflagdetailGreaterThan(String value) {
            addCriterion("GroupflagDetail >", value, "groupflagdetail");
            return (Criteria) this;
        }

        public Criteria andGroupflagdetailGreaterThanOrEqualTo(String value) {
            addCriterion("GroupflagDetail >=", value, "groupflagdetail");
            return (Criteria) this;
        }

        public Criteria andGroupflagdetailLessThan(String value) {
            addCriterion("GroupflagDetail <", value, "groupflagdetail");
            return (Criteria) this;
        }

        public Criteria andGroupflagdetailLessThanOrEqualTo(String value) {
            addCriterion("GroupflagDetail <=", value, "groupflagdetail");
            return (Criteria) this;
        }

        public Criteria andGroupflagdetailLike(String value) {
            addCriterion("GroupflagDetail like", value, "groupflagdetail");
            return (Criteria) this;
        }

        public Criteria andGroupflagdetailNotLike(String value) {
            addCriterion("GroupflagDetail not like", value, "groupflagdetail");
            return (Criteria) this;
        }

        public Criteria andGroupflagdetailIn(List<String> values) {
            addCriterion("GroupflagDetail in", values, "groupflagdetail");
            return (Criteria) this;
        }

        public Criteria andGroupflagdetailNotIn(List<String> values) {
            addCriterion("GroupflagDetail not in", values, "groupflagdetail");
            return (Criteria) this;
        }

        public Criteria andGroupflagdetailBetween(String value1, String value2) {
            addCriterion("GroupflagDetail between", value1, value2, "groupflagdetail");
            return (Criteria) this;
        }

        public Criteria andGroupflagdetailNotBetween(String value1, String value2) {
            addCriterion("GroupflagDetail not between", value1, value2, "groupflagdetail");
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
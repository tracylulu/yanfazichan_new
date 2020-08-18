package com.h3c.platform.assetplan.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssetRateInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssetRateInfoExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCollectTimeIsNull() {
            addCriterion("collect_time is null");
            return (Criteria) this;
        }

        public Criteria andCollectTimeIsNotNull() {
            addCriterion("collect_time is not null");
            return (Criteria) this;
        }

        public Criteria andCollectTimeEqualTo(Date value) {
            addCriterion("collect_time =", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeNotEqualTo(Date value) {
            addCriterion("collect_time <>", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeGreaterThan(Date value) {
            addCriterion("collect_time >", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("collect_time >=", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeLessThan(Date value) {
            addCriterion("collect_time <", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeLessThanOrEqualTo(Date value) {
            addCriterion("collect_time <=", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeIn(List<Date> values) {
            addCriterion("collect_time in", values, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeNotIn(List<Date> values) {
            addCriterion("collect_time not in", values, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeBetween(Date value1, Date value2) {
            addCriterion("collect_time between", value1, value2, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeNotBetween(Date value1, Date value2) {
            addCriterion("collect_time not between", value1, value2, "collectTime");
            return (Criteria) this;
        }

        public Criteria andAssertNumberIsNull() {
            addCriterion("assert_number is null");
            return (Criteria) this;
        }

        public Criteria andAssertNumberIsNotNull() {
            addCriterion("assert_number is not null");
            return (Criteria) this;
        }

        public Criteria andAssertNumberEqualTo(String value) {
            addCriterion("assert_number =", value, "assertNumber");
            return (Criteria) this;
        }

        public Criteria andAssertNumberNotEqualTo(String value) {
            addCriterion("assert_number <>", value, "assertNumber");
            return (Criteria) this;
        }

        public Criteria andAssertNumberGreaterThan(String value) {
            addCriterion("assert_number >", value, "assertNumber");
            return (Criteria) this;
        }

        public Criteria andAssertNumberGreaterThanOrEqualTo(String value) {
            addCriterion("assert_number >=", value, "assertNumber");
            return (Criteria) this;
        }

        public Criteria andAssertNumberLessThan(String value) {
            addCriterion("assert_number <", value, "assertNumber");
            return (Criteria) this;
        }

        public Criteria andAssertNumberLessThanOrEqualTo(String value) {
            addCriterion("assert_number <=", value, "assertNumber");
            return (Criteria) this;
        }

        public Criteria andAssertNumberLike(String value) {
            addCriterion("assert_number like", value, "assertNumber");
            return (Criteria) this;
        }

        public Criteria andAssertNumberNotLike(String value) {
            addCriterion("assert_number not like", value, "assertNumber");
            return (Criteria) this;
        }

        public Criteria andAssertNumberIn(List<String> values) {
            addCriterion("assert_number in", values, "assertNumber");
            return (Criteria) this;
        }

        public Criteria andAssertNumberNotIn(List<String> values) {
            addCriterion("assert_number not in", values, "assertNumber");
            return (Criteria) this;
        }

        public Criteria andAssertNumberBetween(String value1, String value2) {
            addCriterion("assert_number between", value1, value2, "assertNumber");
            return (Criteria) this;
        }

        public Criteria andAssertNumberNotBetween(String value1, String value2) {
            addCriterion("assert_number not between", value1, value2, "assertNumber");
            return (Criteria) this;
        }

        public Criteria andDeptCodeIsNull() {
            addCriterion("dept_code is null");
            return (Criteria) this;
        }

        public Criteria andDeptCodeIsNotNull() {
            addCriterion("dept_code is not null");
            return (Criteria) this;
        }

        public Criteria andDeptCodeEqualTo(String value) {
            addCriterion("dept_code =", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeNotEqualTo(String value) {
            addCriterion("dept_code <>", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeGreaterThan(String value) {
            addCriterion("dept_code >", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeGreaterThanOrEqualTo(String value) {
            addCriterion("dept_code >=", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeLessThan(String value) {
            addCriterion("dept_code <", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeLessThanOrEqualTo(String value) {
            addCriterion("dept_code <=", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeLike(String value) {
            addCriterion("dept_code like", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeNotLike(String value) {
            addCriterion("dept_code not like", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeIn(List<String> values) {
            addCriterion("dept_code in", values, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeNotIn(List<String> values) {
            addCriterion("dept_code not in", values, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeBetween(String value1, String value2) {
            addCriterion("dept_code between", value1, value2, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeNotBetween(String value1, String value2) {
            addCriterion("dept_code not between", value1, value2, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptNameIsNull() {
            addCriterion("dept_name is null");
            return (Criteria) this;
        }

        public Criteria andDeptNameIsNotNull() {
            addCriterion("dept_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeptNameEqualTo(String value) {
            addCriterion("dept_name =", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotEqualTo(String value) {
            addCriterion("dept_name <>", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameGreaterThan(String value) {
            addCriterion("dept_name >", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameGreaterThanOrEqualTo(String value) {
            addCriterion("dept_name >=", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLessThan(String value) {
            addCriterion("dept_name <", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLessThanOrEqualTo(String value) {
            addCriterion("dept_name <=", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLike(String value) {
            addCriterion("dept_name like", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotLike(String value) {
            addCriterion("dept_name not like", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameIn(List<String> values) {
            addCriterion("dept_name in", values, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotIn(List<String> values) {
            addCriterion("dept_name not in", values, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameBetween(String value1, String value2) {
            addCriterion("dept_name between", value1, value2, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotBetween(String value1, String value2) {
            addCriterion("dept_name not between", value1, value2, "deptName");
            return (Criteria) this;
        }

        public Criteria andAssertClassIsNull() {
            addCriterion("assert_class is null");
            return (Criteria) this;
        }

        public Criteria andAssertClassIsNotNull() {
            addCriterion("assert_class is not null");
            return (Criteria) this;
        }

        public Criteria andAssertClassEqualTo(String value) {
            addCriterion("assert_class =", value, "assertClass");
            return (Criteria) this;
        }

        public Criteria andAssertClassNotEqualTo(String value) {
            addCriterion("assert_class <>", value, "assertClass");
            return (Criteria) this;
        }

        public Criteria andAssertClassGreaterThan(String value) {
            addCriterion("assert_class >", value, "assertClass");
            return (Criteria) this;
        }

        public Criteria andAssertClassGreaterThanOrEqualTo(String value) {
            addCriterion("assert_class >=", value, "assertClass");
            return (Criteria) this;
        }

        public Criteria andAssertClassLessThan(String value) {
            addCriterion("assert_class <", value, "assertClass");
            return (Criteria) this;
        }

        public Criteria andAssertClassLessThanOrEqualTo(String value) {
            addCriterion("assert_class <=", value, "assertClass");
            return (Criteria) this;
        }

        public Criteria andAssertClassLike(String value) {
            addCriterion("assert_class like", value, "assertClass");
            return (Criteria) this;
        }

        public Criteria andAssertClassNotLike(String value) {
            addCriterion("assert_class not like", value, "assertClass");
            return (Criteria) this;
        }

        public Criteria andAssertClassIn(List<String> values) {
            addCriterion("assert_class in", values, "assertClass");
            return (Criteria) this;
        }

        public Criteria andAssertClassNotIn(List<String> values) {
            addCriterion("assert_class not in", values, "assertClass");
            return (Criteria) this;
        }

        public Criteria andAssertClassBetween(String value1, String value2) {
            addCriterion("assert_class between", value1, value2, "assertClass");
            return (Criteria) this;
        }

        public Criteria andAssertClassNotBetween(String value1, String value2) {
            addCriterion("assert_class not between", value1, value2, "assertClass");
            return (Criteria) this;
        }

        public Criteria andAssetCategoryIsNull() {
            addCriterion("asset_category is null");
            return (Criteria) this;
        }

        public Criteria andAssetCategoryIsNotNull() {
            addCriterion("asset_category is not null");
            return (Criteria) this;
        }

        public Criteria andAssetCategoryEqualTo(String value) {
            addCriterion("asset_category =", value, "assetCategory");
            return (Criteria) this;
        }

        public Criteria andAssetCategoryNotEqualTo(String value) {
            addCriterion("asset_category <>", value, "assetCategory");
            return (Criteria) this;
        }

        public Criteria andAssetCategoryGreaterThan(String value) {
            addCriterion("asset_category >", value, "assetCategory");
            return (Criteria) this;
        }

        public Criteria andAssetCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("asset_category >=", value, "assetCategory");
            return (Criteria) this;
        }

        public Criteria andAssetCategoryLessThan(String value) {
            addCriterion("asset_category <", value, "assetCategory");
            return (Criteria) this;
        }

        public Criteria andAssetCategoryLessThanOrEqualTo(String value) {
            addCriterion("asset_category <=", value, "assetCategory");
            return (Criteria) this;
        }

        public Criteria andAssetCategoryLike(String value) {
            addCriterion("asset_category like", value, "assetCategory");
            return (Criteria) this;
        }

        public Criteria andAssetCategoryNotLike(String value) {
            addCriterion("asset_category not like", value, "assetCategory");
            return (Criteria) this;
        }

        public Criteria andAssetCategoryIn(List<String> values) {
            addCriterion("asset_category in", values, "assetCategory");
            return (Criteria) this;
        }

        public Criteria andAssetCategoryNotIn(List<String> values) {
            addCriterion("asset_category not in", values, "assetCategory");
            return (Criteria) this;
        }

        public Criteria andAssetCategoryBetween(String value1, String value2) {
            addCriterion("asset_category between", value1, value2, "assetCategory");
            return (Criteria) this;
        }

        public Criteria andAssetCategoryNotBetween(String value1, String value2) {
            addCriterion("asset_category not between", value1, value2, "assetCategory");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andProviderIsNull() {
            addCriterion("provider is null");
            return (Criteria) this;
        }

        public Criteria andProviderIsNotNull() {
            addCriterion("provider is not null");
            return (Criteria) this;
        }

        public Criteria andProviderEqualTo(String value) {
            addCriterion("provider =", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotEqualTo(String value) {
            addCriterion("provider <>", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderGreaterThan(String value) {
            addCriterion("provider >", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderGreaterThanOrEqualTo(String value) {
            addCriterion("provider >=", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderLessThan(String value) {
            addCriterion("provider <", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderLessThanOrEqualTo(String value) {
            addCriterion("provider <=", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderLike(String value) {
            addCriterion("provider like", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotLike(String value) {
            addCriterion("provider not like", value, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderIn(List<String> values) {
            addCriterion("provider in", values, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotIn(List<String> values) {
            addCriterion("provider not in", values, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderBetween(String value1, String value2) {
            addCriterion("provider between", value1, value2, "provider");
            return (Criteria) this;
        }

        public Criteria andProviderNotBetween(String value1, String value2) {
            addCriterion("provider not between", value1, value2, "provider");
            return (Criteria) this;
        }

        public Criteria andRunFunctionIsNull() {
            addCriterion("run_function is null");
            return (Criteria) this;
        }

        public Criteria andRunFunctionIsNotNull() {
            addCriterion("run_function is not null");
            return (Criteria) this;
        }

        public Criteria andRunFunctionEqualTo(String value) {
            addCriterion("run_function =", value, "runFunction");
            return (Criteria) this;
        }

        public Criteria andRunFunctionNotEqualTo(String value) {
            addCriterion("run_function <>", value, "runFunction");
            return (Criteria) this;
        }

        public Criteria andRunFunctionGreaterThan(String value) {
            addCriterion("run_function >", value, "runFunction");
            return (Criteria) this;
        }

        public Criteria andRunFunctionGreaterThanOrEqualTo(String value) {
            addCriterion("run_function >=", value, "runFunction");
            return (Criteria) this;
        }

        public Criteria andRunFunctionLessThan(String value) {
            addCriterion("run_function <", value, "runFunction");
            return (Criteria) this;
        }

        public Criteria andRunFunctionLessThanOrEqualTo(String value) {
            addCriterion("run_function <=", value, "runFunction");
            return (Criteria) this;
        }

        public Criteria andRunFunctionLike(String value) {
            addCriterion("run_function like", value, "runFunction");
            return (Criteria) this;
        }

        public Criteria andRunFunctionNotLike(String value) {
            addCriterion("run_function not like", value, "runFunction");
            return (Criteria) this;
        }

        public Criteria andRunFunctionIn(List<String> values) {
            addCriterion("run_function in", values, "runFunction");
            return (Criteria) this;
        }

        public Criteria andRunFunctionNotIn(List<String> values) {
            addCriterion("run_function not in", values, "runFunction");
            return (Criteria) this;
        }

        public Criteria andRunFunctionBetween(String value1, String value2) {
            addCriterion("run_function between", value1, value2, "runFunction");
            return (Criteria) this;
        }

        public Criteria andRunFunctionNotBetween(String value1, String value2) {
            addCriterion("run_function not between", value1, value2, "runFunction");
            return (Criteria) this;
        }

        public Criteria andPortNumIsNull() {
            addCriterion("port_num is null");
            return (Criteria) this;
        }

        public Criteria andPortNumIsNotNull() {
            addCriterion("port_num is not null");
            return (Criteria) this;
        }

        public Criteria andPortNumEqualTo(String value) {
            addCriterion("port_num =", value, "portNum");
            return (Criteria) this;
        }

        public Criteria andPortNumNotEqualTo(String value) {
            addCriterion("port_num <>", value, "portNum");
            return (Criteria) this;
        }

        public Criteria andPortNumGreaterThan(String value) {
            addCriterion("port_num >", value, "portNum");
            return (Criteria) this;
        }

        public Criteria andPortNumGreaterThanOrEqualTo(String value) {
            addCriterion("port_num >=", value, "portNum");
            return (Criteria) this;
        }

        public Criteria andPortNumLessThan(String value) {
            addCriterion("port_num <", value, "portNum");
            return (Criteria) this;
        }

        public Criteria andPortNumLessThanOrEqualTo(String value) {
            addCriterion("port_num <=", value, "portNum");
            return (Criteria) this;
        }

        public Criteria andPortNumLike(String value) {
            addCriterion("port_num like", value, "portNum");
            return (Criteria) this;
        }

        public Criteria andPortNumNotLike(String value) {
            addCriterion("port_num not like", value, "portNum");
            return (Criteria) this;
        }

        public Criteria andPortNumIn(List<String> values) {
            addCriterion("port_num in", values, "portNum");
            return (Criteria) this;
        }

        public Criteria andPortNumNotIn(List<String> values) {
            addCriterion("port_num not in", values, "portNum");
            return (Criteria) this;
        }

        public Criteria andPortNumBetween(String value1, String value2) {
            addCriterion("port_num between", value1, value2, "portNum");
            return (Criteria) this;
        }

        public Criteria andPortNumNotBetween(String value1, String value2) {
            addCriterion("port_num not between", value1, value2, "portNum");
            return (Criteria) this;
        }

        public Criteria andOwnerNameIsNull() {
            addCriterion("owner_name is null");
            return (Criteria) this;
        }

        public Criteria andOwnerNameIsNotNull() {
            addCriterion("owner_name is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerNameEqualTo(String value) {
            addCriterion("owner_name =", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotEqualTo(String value) {
            addCriterion("owner_name <>", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameGreaterThan(String value) {
            addCriterion("owner_name >", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameGreaterThanOrEqualTo(String value) {
            addCriterion("owner_name >=", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameLessThan(String value) {
            addCriterion("owner_name <", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameLessThanOrEqualTo(String value) {
            addCriterion("owner_name <=", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameLike(String value) {
            addCriterion("owner_name like", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotLike(String value) {
            addCriterion("owner_name not like", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameIn(List<String> values) {
            addCriterion("owner_name in", values, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotIn(List<String> values) {
            addCriterion("owner_name not in", values, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameBetween(String value1, String value2) {
            addCriterion("owner_name between", value1, value2, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotBetween(String value1, String value2) {
            addCriterion("owner_name not between", value1, value2, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerCodeIsNull() {
            addCriterion("owner_code is null");
            return (Criteria) this;
        }

        public Criteria andOwnerCodeIsNotNull() {
            addCriterion("owner_code is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerCodeEqualTo(String value) {
            addCriterion("owner_code =", value, "ownerCode");
            return (Criteria) this;
        }

        public Criteria andOwnerCodeNotEqualTo(String value) {
            addCriterion("owner_code <>", value, "ownerCode");
            return (Criteria) this;
        }

        public Criteria andOwnerCodeGreaterThan(String value) {
            addCriterion("owner_code >", value, "ownerCode");
            return (Criteria) this;
        }

        public Criteria andOwnerCodeGreaterThanOrEqualTo(String value) {
            addCriterion("owner_code >=", value, "ownerCode");
            return (Criteria) this;
        }

        public Criteria andOwnerCodeLessThan(String value) {
            addCriterion("owner_code <", value, "ownerCode");
            return (Criteria) this;
        }

        public Criteria andOwnerCodeLessThanOrEqualTo(String value) {
            addCriterion("owner_code <=", value, "ownerCode");
            return (Criteria) this;
        }

        public Criteria andOwnerCodeLike(String value) {
            addCriterion("owner_code like", value, "ownerCode");
            return (Criteria) this;
        }

        public Criteria andOwnerCodeNotLike(String value) {
            addCriterion("owner_code not like", value, "ownerCode");
            return (Criteria) this;
        }

        public Criteria andOwnerCodeIn(List<String> values) {
            addCriterion("owner_code in", values, "ownerCode");
            return (Criteria) this;
        }

        public Criteria andOwnerCodeNotIn(List<String> values) {
            addCriterion("owner_code not in", values, "ownerCode");
            return (Criteria) this;
        }

        public Criteria andOwnerCodeBetween(String value1, String value2) {
            addCriterion("owner_code between", value1, value2, "ownerCode");
            return (Criteria) this;
        }

        public Criteria andOwnerCodeNotBetween(String value1, String value2) {
            addCriterion("owner_code not between", value1, value2, "ownerCode");
            return (Criteria) this;
        }

        public Criteria andAssetDescIsNull() {
            addCriterion("asset_desc is null");
            return (Criteria) this;
        }

        public Criteria andAssetDescIsNotNull() {
            addCriterion("asset_desc is not null");
            return (Criteria) this;
        }

        public Criteria andAssetDescEqualTo(String value) {
            addCriterion("asset_desc =", value, "assetDesc");
            return (Criteria) this;
        }

        public Criteria andAssetDescNotEqualTo(String value) {
            addCriterion("asset_desc <>", value, "assetDesc");
            return (Criteria) this;
        }

        public Criteria andAssetDescGreaterThan(String value) {
            addCriterion("asset_desc >", value, "assetDesc");
            return (Criteria) this;
        }

        public Criteria andAssetDescGreaterThanOrEqualTo(String value) {
            addCriterion("asset_desc >=", value, "assetDesc");
            return (Criteria) this;
        }

        public Criteria andAssetDescLessThan(String value) {
            addCriterion("asset_desc <", value, "assetDesc");
            return (Criteria) this;
        }

        public Criteria andAssetDescLessThanOrEqualTo(String value) {
            addCriterion("asset_desc <=", value, "assetDesc");
            return (Criteria) this;
        }

        public Criteria andAssetDescLike(String value) {
            addCriterion("asset_desc like", value, "assetDesc");
            return (Criteria) this;
        }

        public Criteria andAssetDescNotLike(String value) {
            addCriterion("asset_desc not like", value, "assetDesc");
            return (Criteria) this;
        }

        public Criteria andAssetDescIn(List<String> values) {
            addCriterion("asset_desc in", values, "assetDesc");
            return (Criteria) this;
        }

        public Criteria andAssetDescNotIn(List<String> values) {
            addCriterion("asset_desc not in", values, "assetDesc");
            return (Criteria) this;
        }

        public Criteria andAssetDescBetween(String value1, String value2) {
            addCriterion("asset_desc between", value1, value2, "assetDesc");
            return (Criteria) this;
        }

        public Criteria andAssetDescNotBetween(String value1, String value2) {
            addCriterion("asset_desc not between", value1, value2, "assetDesc");
            return (Criteria) this;
        }

        public Criteria andUsageRateIsNull() {
            addCriterion("usage_rate is null");
            return (Criteria) this;
        }

        public Criteria andUsageRateIsNotNull() {
            addCriterion("usage_rate is not null");
            return (Criteria) this;
        }

        public Criteria andUsageRateEqualTo(String value) {
            addCriterion("usage_rate =", value, "usageRate");
            return (Criteria) this;
        }

        public Criteria andUsageRateNotEqualTo(String value) {
            addCriterion("usage_rate <>", value, "usageRate");
            return (Criteria) this;
        }

        public Criteria andUsageRateGreaterThan(String value) {
            addCriterion("usage_rate >", value, "usageRate");
            return (Criteria) this;
        }

        public Criteria andUsageRateGreaterThanOrEqualTo(String value) {
            addCriterion("usage_rate >=", value, "usageRate");
            return (Criteria) this;
        }

        public Criteria andUsageRateLessThan(String value) {
            addCriterion("usage_rate <", value, "usageRate");
            return (Criteria) this;
        }

        public Criteria andUsageRateLessThanOrEqualTo(String value) {
            addCriterion("usage_rate <=", value, "usageRate");
            return (Criteria) this;
        }

        public Criteria andUsageRateLike(String value) {
            addCriterion("usage_rate like", value, "usageRate");
            return (Criteria) this;
        }

        public Criteria andUsageRateNotLike(String value) {
            addCriterion("usage_rate not like", value, "usageRate");
            return (Criteria) this;
        }

        public Criteria andUsageRateIn(List<String> values) {
            addCriterion("usage_rate in", values, "usageRate");
            return (Criteria) this;
        }

        public Criteria andUsageRateNotIn(List<String> values) {
            addCriterion("usage_rate not in", values, "usageRate");
            return (Criteria) this;
        }

        public Criteria andUsageRateBetween(String value1, String value2) {
            addCriterion("usage_rate between", value1, value2, "usageRate");
            return (Criteria) this;
        }

        public Criteria andUsageRateNotBetween(String value1, String value2) {
            addCriterion("usage_rate not between", value1, value2, "usageRate");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNull() {
            addCriterion("data_type is null");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNotNull() {
            addCriterion("data_type is not null");
            return (Criteria) this;
        }

        public Criteria andDataTypeEqualTo(String value) {
            addCriterion("data_type =", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotEqualTo(String value) {
            addCriterion("data_type <>", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThan(String value) {
            addCriterion("data_type >", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThanOrEqualTo(String value) {
            addCriterion("data_type >=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThan(String value) {
            addCriterion("data_type <", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThanOrEqualTo(String value) {
            addCriterion("data_type <=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLike(String value) {
            addCriterion("data_type like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotLike(String value) {
            addCriterion("data_type not like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeIn(List<String> values) {
            addCriterion("data_type in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotIn(List<String> values) {
            addCriterion("data_type not in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeBetween(String value1, String value2) {
            addCriterion("data_type between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotBetween(String value1, String value2) {
            addCriterion("data_type not between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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
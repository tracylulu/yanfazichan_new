package com.h3c.platform.sync.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeptInfo_EOSExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeptInfo_EOSExample() {
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

        public Criteria andDeptCodeIsNull() {
            addCriterion("dept_code is null");
            return (Criteria) this;
        }

        public Criteria andDeptCodeIsNotNull() {
            addCriterion("dept_code is not null");
            return (Criteria) this;
        }

        public Criteria andDeptCodeEqualTo(Integer value) {
            addCriterion("dept_code =", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeNotEqualTo(Integer value) {
            addCriterion("dept_code <>", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeGreaterThan(Integer value) {
            addCriterion("dept_code >", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("dept_code >=", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeLessThan(Integer value) {
            addCriterion("dept_code <", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeLessThanOrEqualTo(Integer value) {
            addCriterion("dept_code <=", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeIn(List<Integer> values) {
            addCriterion("dept_code in", values, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeNotIn(List<Integer> values) {
            addCriterion("dept_code not in", values, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeBetween(Integer value1, Integer value2) {
            addCriterion("dept_code between", value1, value2, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeNotBetween(Integer value1, Integer value2) {
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

        public Criteria andCoaIsNull() {
            addCriterion("coa is null");
            return (Criteria) this;
        }

        public Criteria andCoaIsNotNull() {
            addCriterion("coa is not null");
            return (Criteria) this;
        }

        public Criteria andCoaEqualTo(String value) {
            addCriterion("coa =", value, "coa");
            return (Criteria) this;
        }

        public Criteria andCoaNotEqualTo(String value) {
            addCriterion("coa <>", value, "coa");
            return (Criteria) this;
        }

        public Criteria andCoaGreaterThan(String value) {
            addCriterion("coa >", value, "coa");
            return (Criteria) this;
        }

        public Criteria andCoaGreaterThanOrEqualTo(String value) {
            addCriterion("coa >=", value, "coa");
            return (Criteria) this;
        }

        public Criteria andCoaLessThan(String value) {
            addCriterion("coa <", value, "coa");
            return (Criteria) this;
        }

        public Criteria andCoaLessThanOrEqualTo(String value) {
            addCriterion("coa <=", value, "coa");
            return (Criteria) this;
        }

        public Criteria andCoaLike(String value) {
            addCriterion("coa like", value, "coa");
            return (Criteria) this;
        }

        public Criteria andCoaNotLike(String value) {
            addCriterion("coa not like", value, "coa");
            return (Criteria) this;
        }

        public Criteria andCoaIn(List<String> values) {
            addCriterion("coa in", values, "coa");
            return (Criteria) this;
        }

        public Criteria andCoaNotIn(List<String> values) {
            addCriterion("coa not in", values, "coa");
            return (Criteria) this;
        }

        public Criteria andCoaBetween(String value1, String value2) {
            addCriterion("coa between", value1, value2, "coa");
            return (Criteria) this;
        }

        public Criteria andCoaNotBetween(String value1, String value2) {
            addCriterion("coa not between", value1, value2, "coa");
            return (Criteria) this;
        }

        public Criteria andDeptLevelIsNull() {
            addCriterion("dept_level is null");
            return (Criteria) this;
        }

        public Criteria andDeptLevelIsNotNull() {
            addCriterion("dept_level is not null");
            return (Criteria) this;
        }

        public Criteria andDeptLevelEqualTo(String value) {
            addCriterion("dept_level =", value, "deptLevel");
            return (Criteria) this;
        }

        public Criteria andDeptLevelNotEqualTo(String value) {
            addCriterion("dept_level <>", value, "deptLevel");
            return (Criteria) this;
        }

        public Criteria andDeptLevelGreaterThan(String value) {
            addCriterion("dept_level >", value, "deptLevel");
            return (Criteria) this;
        }

        public Criteria andDeptLevelGreaterThanOrEqualTo(String value) {
            addCriterion("dept_level >=", value, "deptLevel");
            return (Criteria) this;
        }

        public Criteria andDeptLevelLessThan(String value) {
            addCriterion("dept_level <", value, "deptLevel");
            return (Criteria) this;
        }

        public Criteria andDeptLevelLessThanOrEqualTo(String value) {
            addCriterion("dept_level <=", value, "deptLevel");
            return (Criteria) this;
        }

        public Criteria andDeptLevelLike(String value) {
            addCriterion("dept_level like", value, "deptLevel");
            return (Criteria) this;
        }

        public Criteria andDeptLevelNotLike(String value) {
            addCriterion("dept_level not like", value, "deptLevel");
            return (Criteria) this;
        }

        public Criteria andDeptLevelIn(List<String> values) {
            addCriterion("dept_level in", values, "deptLevel");
            return (Criteria) this;
        }

        public Criteria andDeptLevelNotIn(List<String> values) {
            addCriterion("dept_level not in", values, "deptLevel");
            return (Criteria) this;
        }

        public Criteria andDeptLevelBetween(String value1, String value2) {
            addCriterion("dept_level between", value1, value2, "deptLevel");
            return (Criteria) this;
        }

        public Criteria andDeptLevelNotBetween(String value1, String value2) {
            addCriterion("dept_level not between", value1, value2, "deptLevel");
            return (Criteria) this;
        }

        public Criteria andSupDeptCodeIsNull() {
            addCriterion("sup_dept_code is null");
            return (Criteria) this;
        }

        public Criteria andSupDeptCodeIsNotNull() {
            addCriterion("sup_dept_code is not null");
            return (Criteria) this;
        }

        public Criteria andSupDeptCodeEqualTo(String value) {
            addCriterion("sup_dept_code =", value, "supDeptCode");
            return (Criteria) this;
        }

        public Criteria andSupDeptCodeNotEqualTo(String value) {
            addCriterion("sup_dept_code <>", value, "supDeptCode");
            return (Criteria) this;
        }

        public Criteria andSupDeptCodeGreaterThan(String value) {
            addCriterion("sup_dept_code >", value, "supDeptCode");
            return (Criteria) this;
        }

        public Criteria andSupDeptCodeGreaterThanOrEqualTo(String value) {
            addCriterion("sup_dept_code >=", value, "supDeptCode");
            return (Criteria) this;
        }

        public Criteria andSupDeptCodeLessThan(String value) {
            addCriterion("sup_dept_code <", value, "supDeptCode");
            return (Criteria) this;
        }

        public Criteria andSupDeptCodeLessThanOrEqualTo(String value) {
            addCriterion("sup_dept_code <=", value, "supDeptCode");
            return (Criteria) this;
        }

        public Criteria andSupDeptCodeLike(String value) {
            addCriterion("sup_dept_code like", value, "supDeptCode");
            return (Criteria) this;
        }

        public Criteria andSupDeptCodeNotLike(String value) {
            addCriterion("sup_dept_code not like", value, "supDeptCode");
            return (Criteria) this;
        }

        public Criteria andSupDeptCodeIn(List<String> values) {
            addCriterion("sup_dept_code in", values, "supDeptCode");
            return (Criteria) this;
        }

        public Criteria andSupDeptCodeNotIn(List<String> values) {
            addCriterion("sup_dept_code not in", values, "supDeptCode");
            return (Criteria) this;
        }

        public Criteria andSupDeptCodeBetween(String value1, String value2) {
            addCriterion("sup_dept_code between", value1, value2, "supDeptCode");
            return (Criteria) this;
        }

        public Criteria andSupDeptCodeNotBetween(String value1, String value2) {
            addCriterion("sup_dept_code not between", value1, value2, "supDeptCode");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(String value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(String value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(String value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(String value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(String value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLike(String value) {
            addCriterion("type_id like", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotLike(String value) {
            addCriterion("type_id not like", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<String> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<String> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(String value1, String value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(String value1, String value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andDeptTypeIsNull() {
            addCriterion("dept_type is null");
            return (Criteria) this;
        }

        public Criteria andDeptTypeIsNotNull() {
            addCriterion("dept_type is not null");
            return (Criteria) this;
        }

        public Criteria andDeptTypeEqualTo(String value) {
            addCriterion("dept_type =", value, "deptType");
            return (Criteria) this;
        }

        public Criteria andDeptTypeNotEqualTo(String value) {
            addCriterion("dept_type <>", value, "deptType");
            return (Criteria) this;
        }

        public Criteria andDeptTypeGreaterThan(String value) {
            addCriterion("dept_type >", value, "deptType");
            return (Criteria) this;
        }

        public Criteria andDeptTypeGreaterThanOrEqualTo(String value) {
            addCriterion("dept_type >=", value, "deptType");
            return (Criteria) this;
        }

        public Criteria andDeptTypeLessThan(String value) {
            addCriterion("dept_type <", value, "deptType");
            return (Criteria) this;
        }

        public Criteria andDeptTypeLessThanOrEqualTo(String value) {
            addCriterion("dept_type <=", value, "deptType");
            return (Criteria) this;
        }

        public Criteria andDeptTypeLike(String value) {
            addCriterion("dept_type like", value, "deptType");
            return (Criteria) this;
        }

        public Criteria andDeptTypeNotLike(String value) {
            addCriterion("dept_type not like", value, "deptType");
            return (Criteria) this;
        }

        public Criteria andDeptTypeIn(List<String> values) {
            addCriterion("dept_type in", values, "deptType");
            return (Criteria) this;
        }

        public Criteria andDeptTypeNotIn(List<String> values) {
            addCriterion("dept_type not in", values, "deptType");
            return (Criteria) this;
        }

        public Criteria andDeptTypeBetween(String value1, String value2) {
            addCriterion("dept_type between", value1, value2, "deptType");
            return (Criteria) this;
        }

        public Criteria andDeptTypeNotBetween(String value1, String value2) {
            addCriterion("dept_type not between", value1, value2, "deptType");
            return (Criteria) this;
        }

        public Criteria andDeptManagerCodeIsNull() {
            addCriterion("dept_manager_code is null");
            return (Criteria) this;
        }

        public Criteria andDeptManagerCodeIsNotNull() {
            addCriterion("dept_manager_code is not null");
            return (Criteria) this;
        }

        public Criteria andDeptManagerCodeEqualTo(String value) {
            addCriterion("dept_manager_code =", value, "deptManagerCode");
            return (Criteria) this;
        }

        public Criteria andDeptManagerCodeNotEqualTo(String value) {
            addCriterion("dept_manager_code <>", value, "deptManagerCode");
            return (Criteria) this;
        }

        public Criteria andDeptManagerCodeGreaterThan(String value) {
            addCriterion("dept_manager_code >", value, "deptManagerCode");
            return (Criteria) this;
        }

        public Criteria andDeptManagerCodeGreaterThanOrEqualTo(String value) {
            addCriterion("dept_manager_code >=", value, "deptManagerCode");
            return (Criteria) this;
        }

        public Criteria andDeptManagerCodeLessThan(String value) {
            addCriterion("dept_manager_code <", value, "deptManagerCode");
            return (Criteria) this;
        }

        public Criteria andDeptManagerCodeLessThanOrEqualTo(String value) {
            addCriterion("dept_manager_code <=", value, "deptManagerCode");
            return (Criteria) this;
        }

        public Criteria andDeptManagerCodeLike(String value) {
            addCriterion("dept_manager_code like", value, "deptManagerCode");
            return (Criteria) this;
        }

        public Criteria andDeptManagerCodeNotLike(String value) {
            addCriterion("dept_manager_code not like", value, "deptManagerCode");
            return (Criteria) this;
        }

        public Criteria andDeptManagerCodeIn(List<String> values) {
            addCriterion("dept_manager_code in", values, "deptManagerCode");
            return (Criteria) this;
        }

        public Criteria andDeptManagerCodeNotIn(List<String> values) {
            addCriterion("dept_manager_code not in", values, "deptManagerCode");
            return (Criteria) this;
        }

        public Criteria andDeptManagerCodeBetween(String value1, String value2) {
            addCriterion("dept_manager_code between", value1, value2, "deptManagerCode");
            return (Criteria) this;
        }

        public Criteria andDeptManagerCodeNotBetween(String value1, String value2) {
            addCriterion("dept_manager_code not between", value1, value2, "deptManagerCode");
            return (Criteria) this;
        }

        public Criteria andDeptPlannerCodeIsNull() {
            addCriterion("dept_planner_code is null");
            return (Criteria) this;
        }

        public Criteria andDeptPlannerCodeIsNotNull() {
            addCriterion("dept_planner_code is not null");
            return (Criteria) this;
        }

        public Criteria andDeptPlannerCodeEqualTo(String value) {
            addCriterion("dept_planner_code =", value, "deptPlannerCode");
            return (Criteria) this;
        }

        public Criteria andDeptPlannerCodeNotEqualTo(String value) {
            addCriterion("dept_planner_code <>", value, "deptPlannerCode");
            return (Criteria) this;
        }

        public Criteria andDeptPlannerCodeGreaterThan(String value) {
            addCriterion("dept_planner_code >", value, "deptPlannerCode");
            return (Criteria) this;
        }

        public Criteria andDeptPlannerCodeGreaterThanOrEqualTo(String value) {
            addCriterion("dept_planner_code >=", value, "deptPlannerCode");
            return (Criteria) this;
        }

        public Criteria andDeptPlannerCodeLessThan(String value) {
            addCriterion("dept_planner_code <", value, "deptPlannerCode");
            return (Criteria) this;
        }

        public Criteria andDeptPlannerCodeLessThanOrEqualTo(String value) {
            addCriterion("dept_planner_code <=", value, "deptPlannerCode");
            return (Criteria) this;
        }

        public Criteria andDeptPlannerCodeLike(String value) {
            addCriterion("dept_planner_code like", value, "deptPlannerCode");
            return (Criteria) this;
        }

        public Criteria andDeptPlannerCodeNotLike(String value) {
            addCriterion("dept_planner_code not like", value, "deptPlannerCode");
            return (Criteria) this;
        }

        public Criteria andDeptPlannerCodeIn(List<String> values) {
            addCriterion("dept_planner_code in", values, "deptPlannerCode");
            return (Criteria) this;
        }

        public Criteria andDeptPlannerCodeNotIn(List<String> values) {
            addCriterion("dept_planner_code not in", values, "deptPlannerCode");
            return (Criteria) this;
        }

        public Criteria andDeptPlannerCodeBetween(String value1, String value2) {
            addCriterion("dept_planner_code between", value1, value2, "deptPlannerCode");
            return (Criteria) this;
        }

        public Criteria andDeptPlannerCodeNotBetween(String value1, String value2) {
            addCriterion("dept_planner_code not between", value1, value2, "deptPlannerCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeChainIsNull() {
            addCriterion("dept_code_chain is null");
            return (Criteria) this;
        }

        public Criteria andDeptCodeChainIsNotNull() {
            addCriterion("dept_code_chain is not null");
            return (Criteria) this;
        }

        public Criteria andDeptCodeChainEqualTo(String value) {
            addCriterion("dept_code_chain =", value, "deptCodeChain");
            return (Criteria) this;
        }

        public Criteria andDeptCodeChainNotEqualTo(String value) {
            addCriterion("dept_code_chain <>", value, "deptCodeChain");
            return (Criteria) this;
        }

        public Criteria andDeptCodeChainGreaterThan(String value) {
            addCriterion("dept_code_chain >", value, "deptCodeChain");
            return (Criteria) this;
        }

        public Criteria andDeptCodeChainGreaterThanOrEqualTo(String value) {
            addCriterion("dept_code_chain >=", value, "deptCodeChain");
            return (Criteria) this;
        }

        public Criteria andDeptCodeChainLessThan(String value) {
            addCriterion("dept_code_chain <", value, "deptCodeChain");
            return (Criteria) this;
        }

        public Criteria andDeptCodeChainLessThanOrEqualTo(String value) {
            addCriterion("dept_code_chain <=", value, "deptCodeChain");
            return (Criteria) this;
        }

        public Criteria andDeptCodeChainLike(String value) {
            addCriterion("dept_code_chain like", value, "deptCodeChain");
            return (Criteria) this;
        }

        public Criteria andDeptCodeChainNotLike(String value) {
            addCriterion("dept_code_chain not like", value, "deptCodeChain");
            return (Criteria) this;
        }

        public Criteria andDeptCodeChainIn(List<String> values) {
            addCriterion("dept_code_chain in", values, "deptCodeChain");
            return (Criteria) this;
        }

        public Criteria andDeptCodeChainNotIn(List<String> values) {
            addCriterion("dept_code_chain not in", values, "deptCodeChain");
            return (Criteria) this;
        }

        public Criteria andDeptCodeChainBetween(String value1, String value2) {
            addCriterion("dept_code_chain between", value1, value2, "deptCodeChain");
            return (Criteria) this;
        }

        public Criteria andDeptCodeChainNotBetween(String value1, String value2) {
            addCriterion("dept_code_chain not between", value1, value2, "deptCodeChain");
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
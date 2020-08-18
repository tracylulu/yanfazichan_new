package com.h3c.platform.sysmgr.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserInfoExample() {
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

        public Criteria andNotesIdIsNull() {
            addCriterion("notes_ID is null");
            return (Criteria) this;
        }

        public Criteria andNotesIdIsNotNull() {
            addCriterion("notes_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNotesIdEqualTo(String value) {
            addCriterion("notes_ID =", value, "notesId");
            return (Criteria) this;
        }

        public Criteria andNotesIdNotEqualTo(String value) {
            addCriterion("notes_ID <>", value, "notesId");
            return (Criteria) this;
        }

        public Criteria andNotesIdGreaterThan(String value) {
            addCriterion("notes_ID >", value, "notesId");
            return (Criteria) this;
        }

        public Criteria andNotesIdGreaterThanOrEqualTo(String value) {
            addCriterion("notes_ID >=", value, "notesId");
            return (Criteria) this;
        }

        public Criteria andNotesIdLessThan(String value) {
            addCriterion("notes_ID <", value, "notesId");
            return (Criteria) this;
        }

        public Criteria andNotesIdLessThanOrEqualTo(String value) {
            addCriterion("notes_ID <=", value, "notesId");
            return (Criteria) this;
        }

        public Criteria andNotesIdLike(String value) {
            addCriterion("notes_ID like", value, "notesId");
            return (Criteria) this;
        }

        public Criteria andNotesIdNotLike(String value) {
            addCriterion("notes_ID not like", value, "notesId");
            return (Criteria) this;
        }

        public Criteria andNotesIdIn(List<String> values) {
            addCriterion("notes_ID in", values, "notesId");
            return (Criteria) this;
        }

        public Criteria andNotesIdNotIn(List<String> values) {
            addCriterion("notes_ID not in", values, "notesId");
            return (Criteria) this;
        }

        public Criteria andNotesIdBetween(String value1, String value2) {
            addCriterion("notes_ID between", value1, value2, "notesId");
            return (Criteria) this;
        }

        public Criteria andNotesIdNotBetween(String value1, String value2) {
            addCriterion("notes_ID not between", value1, value2, "notesId");
            return (Criteria) this;
        }

        public Criteria andEmpCodeIsNull() {
            addCriterion("emp_code is null");
            return (Criteria) this;
        }

        public Criteria andEmpCodeIsNotNull() {
            addCriterion("emp_code is not null");
            return (Criteria) this;
        }

        public Criteria andEmpCodeEqualTo(String value) {
            addCriterion("emp_code =", value, "empCode");
            return (Criteria) this;
        }

        public Criteria andEmpCodeNotEqualTo(String value) {
            addCriterion("emp_code <>", value, "empCode");
            return (Criteria) this;
        }

        public Criteria andEmpCodeGreaterThan(String value) {
            addCriterion("emp_code >", value, "empCode");
            return (Criteria) this;
        }

        public Criteria andEmpCodeGreaterThanOrEqualTo(String value) {
            addCriterion("emp_code >=", value, "empCode");
            return (Criteria) this;
        }

        public Criteria andEmpCodeLessThan(String value) {
            addCriterion("emp_code <", value, "empCode");
            return (Criteria) this;
        }

        public Criteria andEmpCodeLessThanOrEqualTo(String value) {
            addCriterion("emp_code <=", value, "empCode");
            return (Criteria) this;
        }

        public Criteria andEmpCodeLike(String value) {
            addCriterion("emp_code like", value, "empCode");
            return (Criteria) this;
        }

        public Criteria andEmpCodeNotLike(String value) {
            addCriterion("emp_code not like", value, "empCode");
            return (Criteria) this;
        }

        public Criteria andEmpCodeIn(List<String> values) {
            addCriterion("emp_code in", values, "empCode");
            return (Criteria) this;
        }

        public Criteria andEmpCodeNotIn(List<String> values) {
            addCriterion("emp_code not in", values, "empCode");
            return (Criteria) this;
        }

        public Criteria andEmpCodeBetween(String value1, String value2) {
            addCriterion("emp_code between", value1, value2, "empCode");
            return (Criteria) this;
        }

        public Criteria andEmpCodeNotBetween(String value1, String value2) {
            addCriterion("emp_code not between", value1, value2, "empCode");
            return (Criteria) this;
        }

        public Criteria andDomainAccountIsNull() {
            addCriterion("domain_account is null");
            return (Criteria) this;
        }

        public Criteria andDomainAccountIsNotNull() {
            addCriterion("domain_account is not null");
            return (Criteria) this;
        }

        public Criteria andDomainAccountEqualTo(String value) {
            addCriterion("domain_account =", value, "domainAccount");
            return (Criteria) this;
        }

        public Criteria andDomainAccountNotEqualTo(String value) {
            addCriterion("domain_account <>", value, "domainAccount");
            return (Criteria) this;
        }

        public Criteria andDomainAccountGreaterThan(String value) {
            addCriterion("domain_account >", value, "domainAccount");
            return (Criteria) this;
        }

        public Criteria andDomainAccountGreaterThanOrEqualTo(String value) {
            addCriterion("domain_account >=", value, "domainAccount");
            return (Criteria) this;
        }

        public Criteria andDomainAccountLessThan(String value) {
            addCriterion("domain_account <", value, "domainAccount");
            return (Criteria) this;
        }

        public Criteria andDomainAccountLessThanOrEqualTo(String value) {
            addCriterion("domain_account <=", value, "domainAccount");
            return (Criteria) this;
        }

        public Criteria andDomainAccountLike(String value) {
            addCriterion("domain_account like", value, "domainAccount");
            return (Criteria) this;
        }

        public Criteria andDomainAccountNotLike(String value) {
            addCriterion("domain_account not like", value, "domainAccount");
            return (Criteria) this;
        }

        public Criteria andDomainAccountIn(List<String> values) {
            addCriterion("domain_account in", values, "domainAccount");
            return (Criteria) this;
        }

        public Criteria andDomainAccountNotIn(List<String> values) {
            addCriterion("domain_account not in", values, "domainAccount");
            return (Criteria) this;
        }

        public Criteria andDomainAccountBetween(String value1, String value2) {
            addCriterion("domain_account between", value1, value2, "domainAccount");
            return (Criteria) this;
        }

        public Criteria andDomainAccountNotBetween(String value1, String value2) {
            addCriterion("domain_account not between", value1, value2, "domainAccount");
            return (Criteria) this;
        }

        public Criteria andDisplayNameIsNull() {
            addCriterion("display_name is null");
            return (Criteria) this;
        }

        public Criteria andDisplayNameIsNotNull() {
            addCriterion("display_name is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayNameEqualTo(String value) {
            addCriterion("display_name =", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotEqualTo(String value) {
            addCriterion("display_name <>", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameGreaterThan(String value) {
            addCriterion("display_name >", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameGreaterThanOrEqualTo(String value) {
            addCriterion("display_name >=", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameLessThan(String value) {
            addCriterion("display_name <", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameLessThanOrEqualTo(String value) {
            addCriterion("display_name <=", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameLike(String value) {
            addCriterion("display_name like", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotLike(String value) {
            addCriterion("display_name not like", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameIn(List<String> values) {
            addCriterion("display_name in", values, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotIn(List<String> values) {
            addCriterion("display_name not in", values, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameBetween(String value1, String value2) {
            addCriterion("display_name between", value1, value2, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotBetween(String value1, String value2) {
            addCriterion("display_name not between", value1, value2, "displayName");
            return (Criteria) this;
        }

        public Criteria andEmpNameIsNull() {
            addCriterion("emp_name is null");
            return (Criteria) this;
        }

        public Criteria andEmpNameIsNotNull() {
            addCriterion("emp_name is not null");
            return (Criteria) this;
        }

        public Criteria andEmpNameEqualTo(String value) {
            addCriterion("emp_name =", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotEqualTo(String value) {
            addCriterion("emp_name <>", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameGreaterThan(String value) {
            addCriterion("emp_name >", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameGreaterThanOrEqualTo(String value) {
            addCriterion("emp_name >=", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameLessThan(String value) {
            addCriterion("emp_name <", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameLessThanOrEqualTo(String value) {
            addCriterion("emp_name <=", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameLike(String value) {
            addCriterion("emp_name like", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotLike(String value) {
            addCriterion("emp_name not like", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameIn(List<String> values) {
            addCriterion("emp_name in", values, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotIn(List<String> values) {
            addCriterion("emp_name not in", values, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameBetween(String value1, String value2) {
            addCriterion("emp_name between", value1, value2, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotBetween(String value1, String value2) {
            addCriterion("emp_name not between", value1, value2, "empName");
            return (Criteria) this;
        }

        public Criteria andCoaCodeIsNull() {
            addCriterion("coa_code is null");
            return (Criteria) this;
        }

        public Criteria andCoaCodeIsNotNull() {
            addCriterion("coa_code is not null");
            return (Criteria) this;
        }

        public Criteria andCoaCodeEqualTo(String value) {
            addCriterion("coa_code =", value, "coaCode");
            return (Criteria) this;
        }

        public Criteria andCoaCodeNotEqualTo(String value) {
            addCriterion("coa_code <>", value, "coaCode");
            return (Criteria) this;
        }

        public Criteria andCoaCodeGreaterThan(String value) {
            addCriterion("coa_code >", value, "coaCode");
            return (Criteria) this;
        }

        public Criteria andCoaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("coa_code >=", value, "coaCode");
            return (Criteria) this;
        }

        public Criteria andCoaCodeLessThan(String value) {
            addCriterion("coa_code <", value, "coaCode");
            return (Criteria) this;
        }

        public Criteria andCoaCodeLessThanOrEqualTo(String value) {
            addCriterion("coa_code <=", value, "coaCode");
            return (Criteria) this;
        }

        public Criteria andCoaCodeLike(String value) {
            addCriterion("coa_code like", value, "coaCode");
            return (Criteria) this;
        }

        public Criteria andCoaCodeNotLike(String value) {
            addCriterion("coa_code not like", value, "coaCode");
            return (Criteria) this;
        }

        public Criteria andCoaCodeIn(List<String> values) {
            addCriterion("coa_code in", values, "coaCode");
            return (Criteria) this;
        }

        public Criteria andCoaCodeNotIn(List<String> values) {
            addCriterion("coa_code not in", values, "coaCode");
            return (Criteria) this;
        }

        public Criteria andCoaCodeBetween(String value1, String value2) {
            addCriterion("coa_code between", value1, value2, "coaCode");
            return (Criteria) this;
        }

        public Criteria andCoaCodeNotBetween(String value1, String value2) {
            addCriterion("coa_code not between", value1, value2, "coaCode");
            return (Criteria) this;
        }

        public Criteria andDept1CodeIsNull() {
            addCriterion("dept1_code is null");
            return (Criteria) this;
        }

        public Criteria andDept1CodeIsNotNull() {
            addCriterion("dept1_code is not null");
            return (Criteria) this;
        }

        public Criteria andDept1CodeEqualTo(String value) {
            addCriterion("dept1_code =", value, "dept1Code");
            return (Criteria) this;
        }

        public Criteria andDept1CodeNotEqualTo(String value) {
            addCriterion("dept1_code <>", value, "dept1Code");
            return (Criteria) this;
        }

        public Criteria andDept1CodeGreaterThan(String value) {
            addCriterion("dept1_code >", value, "dept1Code");
            return (Criteria) this;
        }

        public Criteria andDept1CodeGreaterThanOrEqualTo(String value) {
            addCriterion("dept1_code >=", value, "dept1Code");
            return (Criteria) this;
        }

        public Criteria andDept1CodeLessThan(String value) {
            addCriterion("dept1_code <", value, "dept1Code");
            return (Criteria) this;
        }

        public Criteria andDept1CodeLessThanOrEqualTo(String value) {
            addCriterion("dept1_code <=", value, "dept1Code");
            return (Criteria) this;
        }

        public Criteria andDept1CodeLike(String value) {
            addCriterion("dept1_code like", value, "dept1Code");
            return (Criteria) this;
        }

        public Criteria andDept1CodeNotLike(String value) {
            addCriterion("dept1_code not like", value, "dept1Code");
            return (Criteria) this;
        }

        public Criteria andDept1CodeIn(List<String> values) {
            addCriterion("dept1_code in", values, "dept1Code");
            return (Criteria) this;
        }

        public Criteria andDept1CodeNotIn(List<String> values) {
            addCriterion("dept1_code not in", values, "dept1Code");
            return (Criteria) this;
        }

        public Criteria andDept1CodeBetween(String value1, String value2) {
            addCriterion("dept1_code between", value1, value2, "dept1Code");
            return (Criteria) this;
        }

        public Criteria andDept1CodeNotBetween(String value1, String value2) {
            addCriterion("dept1_code not between", value1, value2, "dept1Code");
            return (Criteria) this;
        }

        public Criteria andDept2CodeIsNull() {
            addCriterion("dept2_code is null");
            return (Criteria) this;
        }

        public Criteria andDept2CodeIsNotNull() {
            addCriterion("dept2_code is not null");
            return (Criteria) this;
        }

        public Criteria andDept2CodeEqualTo(String value) {
            addCriterion("dept2_code =", value, "dept2Code");
            return (Criteria) this;
        }

        public Criteria andDept2CodeNotEqualTo(String value) {
            addCriterion("dept2_code <>", value, "dept2Code");
            return (Criteria) this;
        }

        public Criteria andDept2CodeGreaterThan(String value) {
            addCriterion("dept2_code >", value, "dept2Code");
            return (Criteria) this;
        }

        public Criteria andDept2CodeGreaterThanOrEqualTo(String value) {
            addCriterion("dept2_code >=", value, "dept2Code");
            return (Criteria) this;
        }

        public Criteria andDept2CodeLessThan(String value) {
            addCriterion("dept2_code <", value, "dept2Code");
            return (Criteria) this;
        }

        public Criteria andDept2CodeLessThanOrEqualTo(String value) {
            addCriterion("dept2_code <=", value, "dept2Code");
            return (Criteria) this;
        }

        public Criteria andDept2CodeLike(String value) {
            addCriterion("dept2_code like", value, "dept2Code");
            return (Criteria) this;
        }

        public Criteria andDept2CodeNotLike(String value) {
            addCriterion("dept2_code not like", value, "dept2Code");
            return (Criteria) this;
        }

        public Criteria andDept2CodeIn(List<String> values) {
            addCriterion("dept2_code in", values, "dept2Code");
            return (Criteria) this;
        }

        public Criteria andDept2CodeNotIn(List<String> values) {
            addCriterion("dept2_code not in", values, "dept2Code");
            return (Criteria) this;
        }

        public Criteria andDept2CodeBetween(String value1, String value2) {
            addCriterion("dept2_code between", value1, value2, "dept2Code");
            return (Criteria) this;
        }

        public Criteria andDept2CodeNotBetween(String value1, String value2) {
            addCriterion("dept2_code not between", value1, value2, "dept2Code");
            return (Criteria) this;
        }

        public Criteria andDept3CodeIsNull() {
            addCriterion("dept3_code is null");
            return (Criteria) this;
        }

        public Criteria andDept3CodeIsNotNull() {
            addCriterion("dept3_code is not null");
            return (Criteria) this;
        }

        public Criteria andDept3CodeEqualTo(String value) {
            addCriterion("dept3_code =", value, "dept3Code");
            return (Criteria) this;
        }

        public Criteria andDept3CodeNotEqualTo(String value) {
            addCriterion("dept3_code <>", value, "dept3Code");
            return (Criteria) this;
        }

        public Criteria andDept3CodeGreaterThan(String value) {
            addCriterion("dept3_code >", value, "dept3Code");
            return (Criteria) this;
        }

        public Criteria andDept3CodeGreaterThanOrEqualTo(String value) {
            addCriterion("dept3_code >=", value, "dept3Code");
            return (Criteria) this;
        }

        public Criteria andDept3CodeLessThan(String value) {
            addCriterion("dept3_code <", value, "dept3Code");
            return (Criteria) this;
        }

        public Criteria andDept3CodeLessThanOrEqualTo(String value) {
            addCriterion("dept3_code <=", value, "dept3Code");
            return (Criteria) this;
        }

        public Criteria andDept3CodeLike(String value) {
            addCriterion("dept3_code like", value, "dept3Code");
            return (Criteria) this;
        }

        public Criteria andDept3CodeNotLike(String value) {
            addCriterion("dept3_code not like", value, "dept3Code");
            return (Criteria) this;
        }

        public Criteria andDept3CodeIn(List<String> values) {
            addCriterion("dept3_code in", values, "dept3Code");
            return (Criteria) this;
        }

        public Criteria andDept3CodeNotIn(List<String> values) {
            addCriterion("dept3_code not in", values, "dept3Code");
            return (Criteria) this;
        }

        public Criteria andDept3CodeBetween(String value1, String value2) {
            addCriterion("dept3_code between", value1, value2, "dept3Code");
            return (Criteria) this;
        }

        public Criteria andDept3CodeNotBetween(String value1, String value2) {
            addCriterion("dept3_code not between", value1, value2, "dept3Code");
            return (Criteria) this;
        }

        public Criteria andDept4CodeIsNull() {
            addCriterion("dept4_code is null");
            return (Criteria) this;
        }

        public Criteria andDept4CodeIsNotNull() {
            addCriterion("dept4_code is not null");
            return (Criteria) this;
        }

        public Criteria andDept4CodeEqualTo(String value) {
            addCriterion("dept4_code =", value, "dept4Code");
            return (Criteria) this;
        }

        public Criteria andDept4CodeNotEqualTo(String value) {
            addCriterion("dept4_code <>", value, "dept4Code");
            return (Criteria) this;
        }

        public Criteria andDept4CodeGreaterThan(String value) {
            addCriterion("dept4_code >", value, "dept4Code");
            return (Criteria) this;
        }

        public Criteria andDept4CodeGreaterThanOrEqualTo(String value) {
            addCriterion("dept4_code >=", value, "dept4Code");
            return (Criteria) this;
        }

        public Criteria andDept4CodeLessThan(String value) {
            addCriterion("dept4_code <", value, "dept4Code");
            return (Criteria) this;
        }

        public Criteria andDept4CodeLessThanOrEqualTo(String value) {
            addCriterion("dept4_code <=", value, "dept4Code");
            return (Criteria) this;
        }

        public Criteria andDept4CodeLike(String value) {
            addCriterion("dept4_code like", value, "dept4Code");
            return (Criteria) this;
        }

        public Criteria andDept4CodeNotLike(String value) {
            addCriterion("dept4_code not like", value, "dept4Code");
            return (Criteria) this;
        }

        public Criteria andDept4CodeIn(List<String> values) {
            addCriterion("dept4_code in", values, "dept4Code");
            return (Criteria) this;
        }

        public Criteria andDept4CodeNotIn(List<String> values) {
            addCriterion("dept4_code not in", values, "dept4Code");
            return (Criteria) this;
        }

        public Criteria andDept4CodeBetween(String value1, String value2) {
            addCriterion("dept4_code between", value1, value2, "dept4Code");
            return (Criteria) this;
        }

        public Criteria andDept4CodeNotBetween(String value1, String value2) {
            addCriterion("dept4_code not between", value1, value2, "dept4Code");
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

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
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

        public Criteria andDeleteFlagIsNull() {
            addCriterion("delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(String value) {
            addCriterion("delete_flag =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(String value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(String value) {
            addCriterion("delete_flag >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(String value) {
            addCriterion("delete_flag >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(String value) {
            addCriterion("delete_flag <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(String value) {
            addCriterion("delete_flag <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLike(String value) {
            addCriterion("delete_flag like", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotLike(String value) {
            addCriterion("delete_flag not like", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<String> values) {
            addCriterion("delete_flag in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<String> values) {
            addCriterion("delete_flag not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(String value1, String value2) {
            addCriterion("delete_flag between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(String value1, String value2) {
            addCriterion("delete_flag not between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifierIsNull() {
            addCriterion("modifier is null");
            return (Criteria) this;
        }

        public Criteria andModifierIsNotNull() {
            addCriterion("modifier is not null");
            return (Criteria) this;
        }

        public Criteria andModifierEqualTo(String value) {
            addCriterion("modifier =", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotEqualTo(String value) {
            addCriterion("modifier <>", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThan(String value) {
            addCriterion("modifier >", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThanOrEqualTo(String value) {
            addCriterion("modifier >=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThan(String value) {
            addCriterion("modifier <", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThanOrEqualTo(String value) {
            addCriterion("modifier <=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLike(String value) {
            addCriterion("modifier like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotLike(String value) {
            addCriterion("modifier not like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierIn(List<String> values) {
            addCriterion("modifier in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotIn(List<String> values) {
            addCriterion("modifier not in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierBetween(String value1, String value2) {
            addCriterion("modifier between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotBetween(String value1, String value2) {
            addCriterion("modifier not between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifiTimeIsNull() {
            addCriterion("modifi_time is null");
            return (Criteria) this;
        }

        public Criteria andModifiTimeIsNotNull() {
            addCriterion("modifi_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifiTimeEqualTo(Date value) {
            addCriterion("modifi_time =", value, "modifiTime");
            return (Criteria) this;
        }

        public Criteria andModifiTimeNotEqualTo(Date value) {
            addCriterion("modifi_time <>", value, "modifiTime");
            return (Criteria) this;
        }

        public Criteria andModifiTimeGreaterThan(Date value) {
            addCriterion("modifi_time >", value, "modifiTime");
            return (Criteria) this;
        }

        public Criteria andModifiTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modifi_time >=", value, "modifiTime");
            return (Criteria) this;
        }

        public Criteria andModifiTimeLessThan(Date value) {
            addCriterion("modifi_time <", value, "modifiTime");
            return (Criteria) this;
        }

        public Criteria andModifiTimeLessThanOrEqualTo(Date value) {
            addCriterion("modifi_time <=", value, "modifiTime");
            return (Criteria) this;
        }

        public Criteria andModifiTimeIn(List<Date> values) {
            addCriterion("modifi_time in", values, "modifiTime");
            return (Criteria) this;
        }

        public Criteria andModifiTimeNotIn(List<Date> values) {
            addCriterion("modifi_time not in", values, "modifiTime");
            return (Criteria) this;
        }

        public Criteria andModifiTimeBetween(Date value1, Date value2) {
            addCriterion("modifi_time between", value1, value2, "modifiTime");
            return (Criteria) this;
        }

        public Criteria andModifiTimeNotBetween(Date value1, Date value2) {
            addCriterion("modifi_time not between", value1, value2, "modifiTime");
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
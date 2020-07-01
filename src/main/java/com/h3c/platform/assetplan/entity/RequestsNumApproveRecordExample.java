package com.h3c.platform.assetplan.entity;

import java.util.ArrayList;
import java.util.List;

public class RequestsNumApproveRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RequestsNumApproveRecordExample() {
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
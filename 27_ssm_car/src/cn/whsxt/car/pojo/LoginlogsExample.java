package cn.whsxt.car.pojo;

import java.util.ArrayList;
import java.util.List;

public class LoginlogsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LoginlogsExample() {
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

        public Criteria andLoginlogidIsNull() {
            addCriterion("LOGINLOGID is null");
            return (Criteria) this;
        }

        public Criteria andLoginlogidIsNotNull() {
            addCriterion("LOGINLOGID is not null");
            return (Criteria) this;
        }

        public Criteria andLoginlogidEqualTo(Integer value) {
            addCriterion("LOGINLOGID =", value, "loginlogid");
            return (Criteria) this;
        }

        public Criteria andLoginlogidNotEqualTo(Integer value) {
            addCriterion("LOGINLOGID <>", value, "loginlogid");
            return (Criteria) this;
        }

        public Criteria andLoginlogidGreaterThan(Integer value) {
            addCriterion("LOGINLOGID >", value, "loginlogid");
            return (Criteria) this;
        }

        public Criteria andLoginlogidGreaterThanOrEqualTo(Integer value) {
            addCriterion("LOGINLOGID >=", value, "loginlogid");
            return (Criteria) this;
        }

        public Criteria andLoginlogidLessThan(Integer value) {
            addCriterion("LOGINLOGID <", value, "loginlogid");
            return (Criteria) this;
        }

        public Criteria andLoginlogidLessThanOrEqualTo(Integer value) {
            addCriterion("LOGINLOGID <=", value, "loginlogid");
            return (Criteria) this;
        }

        public Criteria andLoginlogidIn(List<Integer> values) {
            addCriterion("LOGINLOGID in", values, "loginlogid");
            return (Criteria) this;
        }

        public Criteria andLoginlogidNotIn(List<Integer> values) {
            addCriterion("LOGINLOGID not in", values, "loginlogid");
            return (Criteria) this;
        }

        public Criteria andLoginlogidBetween(Integer value1, Integer value2) {
            addCriterion("LOGINLOGID between", value1, value2, "loginlogid");
            return (Criteria) this;
        }

        public Criteria andLoginlogidNotBetween(Integer value1, Integer value2) {
            addCriterion("LOGINLOGID not between", value1, value2, "loginlogid");
            return (Criteria) this;
        }

        public Criteria andLoginnameIsNull() {
            addCriterion("LOGINNAME is null");
            return (Criteria) this;
        }

        public Criteria andLoginnameIsNotNull() {
            addCriterion("LOGINNAME is not null");
            return (Criteria) this;
        }

        public Criteria andLoginnameEqualTo(String value) {
            addCriterion("LOGINNAME =", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotEqualTo(String value) {
            addCriterion("LOGINNAME <>", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameGreaterThan(String value) {
            addCriterion("LOGINNAME >", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameGreaterThanOrEqualTo(String value) {
            addCriterion("LOGINNAME >=", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameLessThan(String value) {
            addCriterion("LOGINNAME <", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameLessThanOrEqualTo(String value) {
            addCriterion("LOGINNAME <=", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameLike(String value) {
            addCriterion("LOGINNAME like", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotLike(String value) {
            addCriterion("LOGINNAME not like", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameIn(List<String> values) {
            addCriterion("LOGINNAME in", values, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotIn(List<String> values) {
            addCriterion("LOGINNAME not in", values, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameBetween(String value1, String value2) {
            addCriterion("LOGINNAME between", value1, value2, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotBetween(String value1, String value2) {
            addCriterion("LOGINNAME not between", value1, value2, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginipIsNull() {
            addCriterion("LOGINIP is null");
            return (Criteria) this;
        }

        public Criteria andLoginipIsNotNull() {
            addCriterion("LOGINIP is not null");
            return (Criteria) this;
        }

        public Criteria andLoginipEqualTo(String value) {
            addCriterion("LOGINIP =", value, "loginip");
            return (Criteria) this;
        }

        public Criteria andLoginipNotEqualTo(String value) {
            addCriterion("LOGINIP <>", value, "loginip");
            return (Criteria) this;
        }

        public Criteria andLoginipGreaterThan(String value) {
            addCriterion("LOGINIP >", value, "loginip");
            return (Criteria) this;
        }

        public Criteria andLoginipGreaterThanOrEqualTo(String value) {
            addCriterion("LOGINIP >=", value, "loginip");
            return (Criteria) this;
        }

        public Criteria andLoginipLessThan(String value) {
            addCriterion("LOGINIP <", value, "loginip");
            return (Criteria) this;
        }

        public Criteria andLoginipLessThanOrEqualTo(String value) {
            addCriterion("LOGINIP <=", value, "loginip");
            return (Criteria) this;
        }

        public Criteria andLoginipLike(String value) {
            addCriterion("LOGINIP like", value, "loginip");
            return (Criteria) this;
        }

        public Criteria andLoginipNotLike(String value) {
            addCriterion("LOGINIP not like", value, "loginip");
            return (Criteria) this;
        }

        public Criteria andLoginipIn(List<String> values) {
            addCriterion("LOGINIP in", values, "loginip");
            return (Criteria) this;
        }

        public Criteria andLoginipNotIn(List<String> values) {
            addCriterion("LOGINIP not in", values, "loginip");
            return (Criteria) this;
        }

        public Criteria andLoginipBetween(String value1, String value2) {
            addCriterion("LOGINIP between", value1, value2, "loginip");
            return (Criteria) this;
        }

        public Criteria andLoginipNotBetween(String value1, String value2) {
            addCriterion("LOGINIP not between", value1, value2, "loginip");
            return (Criteria) this;
        }

        public Criteria andLogintimeIsNull() {
            addCriterion("LOGINTIME is null");
            return (Criteria) this;
        }

        public Criteria andLogintimeIsNotNull() {
            addCriterion("LOGINTIME is not null");
            return (Criteria) this;
        }

        public Criteria andLogintimeEqualTo(String value) {
            addCriterion("LOGINTIME =", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeNotEqualTo(String value) {
            addCriterion("LOGINTIME <>", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeGreaterThan(String value) {
            addCriterion("LOGINTIME >", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeGreaterThanOrEqualTo(String value) {
            addCriterion("LOGINTIME >=", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeLessThan(String value) {
            addCriterion("LOGINTIME <", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeLessThanOrEqualTo(String value) {
            addCriterion("LOGINTIME <=", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeLike(String value) {
            addCriterion("LOGINTIME like", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeNotLike(String value) {
            addCriterion("LOGINTIME not like", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeIn(List<String> values) {
            addCriterion("LOGINTIME in", values, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeNotIn(List<String> values) {
            addCriterion("LOGINTIME not in", values, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeBetween(String value1, String value2) {
            addCriterion("LOGINTIME between", value1, value2, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeNotBetween(String value1, String value2) {
            addCriterion("LOGINTIME not between", value1, value2, "logintime");
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
package cn.whsxt.car.pojo;

import java.util.ArrayList;
import java.util.List;

public class CustomersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomersExample() {
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

        public Criteria andIdentityIsNull() {
            addCriterion("IDENTITY is null");
            return (Criteria) this;
        }

        public Criteria andIdentityIsNotNull() {
            addCriterion("IDENTITY is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityEqualTo(String value) {
            addCriterion("IDENTITY =", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotEqualTo(String value) {
            addCriterion("IDENTITY <>", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThan(String value) {
            addCriterion("IDENTITY >", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThanOrEqualTo(String value) {
            addCriterion("IDENTITY >=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThan(String value) {
            addCriterion("IDENTITY <", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThanOrEqualTo(String value) {
            addCriterion("IDENTITY <=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLike(String value) {
            addCriterion("IDENTITY like", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotLike(String value) {
            addCriterion("IDENTITY not like", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityIn(List<String> values) {
            addCriterion("IDENTITY in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotIn(List<String> values) {
            addCriterion("IDENTITY not in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityBetween(String value1, String value2) {
            addCriterion("IDENTITY between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotBetween(String value1, String value2) {
            addCriterion("IDENTITY not between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andCustnameIsNull() {
            addCriterion("CUSTNAME is null");
            return (Criteria) this;
        }

        public Criteria andCustnameIsNotNull() {
            addCriterion("CUSTNAME is not null");
            return (Criteria) this;
        }

        public Criteria andCustnameEqualTo(String value) {
            addCriterion("CUSTNAME =", value, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameNotEqualTo(String value) {
            addCriterion("CUSTNAME <>", value, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameGreaterThan(String value) {
            addCriterion("CUSTNAME >", value, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTNAME >=", value, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameLessThan(String value) {
            addCriterion("CUSTNAME <", value, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameLessThanOrEqualTo(String value) {
            addCriterion("CUSTNAME <=", value, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameLike(String value) {
            addCriterion("CUSTNAME like", value, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameNotLike(String value) {
            addCriterion("CUSTNAME not like", value, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameIn(List<String> values) {
            addCriterion("CUSTNAME in", values, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameNotIn(List<String> values) {
            addCriterion("CUSTNAME not in", values, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameBetween(String value1, String value2) {
            addCriterion("CUSTNAME between", value1, value2, "custname");
            return (Criteria) this;
        }

        public Criteria andCustnameNotBetween(String value1, String value2) {
            addCriterion("CUSTNAME not between", value1, value2, "custname");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("SEX is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("SEX is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("SEX =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("SEX <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("SEX >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("SEX >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("SEX <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("SEX <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("SEX like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("SEX not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("SEX in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("SEX not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("SEX between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("SEX not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("PHONE is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("PHONE =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("PHONE <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("PHONE >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("PHONE <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("PHONE <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("PHONE like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("PHONE not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("PHONE in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("PHONE not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("PHONE between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("PHONE not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andCareerIsNull() {
            addCriterion("CAREER is null");
            return (Criteria) this;
        }

        public Criteria andCareerIsNotNull() {
            addCriterion("CAREER is not null");
            return (Criteria) this;
        }

        public Criteria andCareerEqualTo(String value) {
            addCriterion("CAREER =", value, "career");
            return (Criteria) this;
        }

        public Criteria andCareerNotEqualTo(String value) {
            addCriterion("CAREER <>", value, "career");
            return (Criteria) this;
        }

        public Criteria andCareerGreaterThan(String value) {
            addCriterion("CAREER >", value, "career");
            return (Criteria) this;
        }

        public Criteria andCareerGreaterThanOrEqualTo(String value) {
            addCriterion("CAREER >=", value, "career");
            return (Criteria) this;
        }

        public Criteria andCareerLessThan(String value) {
            addCriterion("CAREER <", value, "career");
            return (Criteria) this;
        }

        public Criteria andCareerLessThanOrEqualTo(String value) {
            addCriterion("CAREER <=", value, "career");
            return (Criteria) this;
        }

        public Criteria andCareerLike(String value) {
            addCriterion("CAREER like", value, "career");
            return (Criteria) this;
        }

        public Criteria andCareerNotLike(String value) {
            addCriterion("CAREER not like", value, "career");
            return (Criteria) this;
        }

        public Criteria andCareerIn(List<String> values) {
            addCriterion("CAREER in", values, "career");
            return (Criteria) this;
        }

        public Criteria andCareerNotIn(List<String> values) {
            addCriterion("CAREER not in", values, "career");
            return (Criteria) this;
        }

        public Criteria andCareerBetween(String value1, String value2) {
            addCriterion("CAREER between", value1, value2, "career");
            return (Criteria) this;
        }

        public Criteria andCareerNotBetween(String value1, String value2) {
            addCriterion("CAREER not between", value1, value2, "career");
            return (Criteria) this;
        }

        public Criteria andCustpwdIsNull() {
            addCriterion("CUSTPWD is null");
            return (Criteria) this;
        }

        public Criteria andCustpwdIsNotNull() {
            addCriterion("CUSTPWD is not null");
            return (Criteria) this;
        }

        public Criteria andCustpwdEqualTo(String value) {
            addCriterion("CUSTPWD =", value, "custpwd");
            return (Criteria) this;
        }

        public Criteria andCustpwdNotEqualTo(String value) {
            addCriterion("CUSTPWD <>", value, "custpwd");
            return (Criteria) this;
        }

        public Criteria andCustpwdGreaterThan(String value) {
            addCriterion("CUSTPWD >", value, "custpwd");
            return (Criteria) this;
        }

        public Criteria andCustpwdGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTPWD >=", value, "custpwd");
            return (Criteria) this;
        }

        public Criteria andCustpwdLessThan(String value) {
            addCriterion("CUSTPWD <", value, "custpwd");
            return (Criteria) this;
        }

        public Criteria andCustpwdLessThanOrEqualTo(String value) {
            addCriterion("CUSTPWD <=", value, "custpwd");
            return (Criteria) this;
        }

        public Criteria andCustpwdLike(String value) {
            addCriterion("CUSTPWD like", value, "custpwd");
            return (Criteria) this;
        }

        public Criteria andCustpwdNotLike(String value) {
            addCriterion("CUSTPWD not like", value, "custpwd");
            return (Criteria) this;
        }

        public Criteria andCustpwdIn(List<String> values) {
            addCriterion("CUSTPWD in", values, "custpwd");
            return (Criteria) this;
        }

        public Criteria andCustpwdNotIn(List<String> values) {
            addCriterion("CUSTPWD not in", values, "custpwd");
            return (Criteria) this;
        }

        public Criteria andCustpwdBetween(String value1, String value2) {
            addCriterion("CUSTPWD between", value1, value2, "custpwd");
            return (Criteria) this;
        }

        public Criteria andCustpwdNotBetween(String value1, String value2) {
            addCriterion("CUSTPWD not between", value1, value2, "custpwd");
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
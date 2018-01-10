package cn.whsxt.car.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarExample() {
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

        public Criteria andCarnumberIsNull() {
            addCriterion("CARNUMBER is null");
            return (Criteria) this;
        }

        public Criteria andCarnumberIsNotNull() {
            addCriterion("CARNUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andCarnumberEqualTo(String value) {
            addCriterion("CARNUMBER =", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberNotEqualTo(String value) {
            addCriterion("CARNUMBER <>", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberGreaterThan(String value) {
            addCriterion("CARNUMBER >", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberGreaterThanOrEqualTo(String value) {
            addCriterion("CARNUMBER >=", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberLessThan(String value) {
            addCriterion("CARNUMBER <", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberLessThanOrEqualTo(String value) {
            addCriterion("CARNUMBER <=", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberLike(String value) {
            addCriterion("CARNUMBER like", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberNotLike(String value) {
            addCriterion("CARNUMBER not like", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberIn(List<String> values) {
            addCriterion("CARNUMBER in", values, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberNotIn(List<String> values) {
            addCriterion("CARNUMBER not in", values, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberBetween(String value1, String value2) {
            addCriterion("CARNUMBER between", value1, value2, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberNotBetween(String value1, String value2) {
            addCriterion("CARNUMBER not between", value1, value2, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCartypeIsNull() {
            addCriterion("CARTYPE is null");
            return (Criteria) this;
        }

        public Criteria andCartypeIsNotNull() {
            addCriterion("CARTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCartypeEqualTo(String value) {
            addCriterion("CARTYPE =", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeNotEqualTo(String value) {
            addCriterion("CARTYPE <>", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeGreaterThan(String value) {
            addCriterion("CARTYPE >", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeGreaterThanOrEqualTo(String value) {
            addCriterion("CARTYPE >=", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeLessThan(String value) {
            addCriterion("CARTYPE <", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeLessThanOrEqualTo(String value) {
            addCriterion("CARTYPE <=", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeLike(String value) {
            addCriterion("CARTYPE like", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeNotLike(String value) {
            addCriterion("CARTYPE not like", value, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeIn(List<String> values) {
            addCriterion("CARTYPE in", values, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeNotIn(List<String> values) {
            addCriterion("CARTYPE not in", values, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeBetween(String value1, String value2) {
            addCriterion("CARTYPE between", value1, value2, "cartype");
            return (Criteria) this;
        }

        public Criteria andCartypeNotBetween(String value1, String value2) {
            addCriterion("CARTYPE not between", value1, value2, "cartype");
            return (Criteria) this;
        }

        public Criteria andColorIsNull() {
            addCriterion("COLOR is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("COLOR is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(String value) {
            addCriterion("COLOR =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(String value) {
            addCriterion("COLOR <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(String value) {
            addCriterion("COLOR >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            addCriterion("COLOR >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(String value) {
            addCriterion("COLOR <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            addCriterion("COLOR <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLike(String value) {
            addCriterion("COLOR like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotLike(String value) {
            addCriterion("COLOR not like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<String> values) {
            addCriterion("COLOR in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<String> values) {
            addCriterion("COLOR not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(String value1, String value2) {
            addCriterion("COLOR between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            addCriterion("COLOR not between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("PRICE is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("PRICE =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("PRICE <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("PRICE >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("PRICE <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("PRICE in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("PRICE not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andRentpriceIsNull() {
            addCriterion("RENTPRICE is null");
            return (Criteria) this;
        }

        public Criteria andRentpriceIsNotNull() {
            addCriterion("RENTPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andRentpriceEqualTo(BigDecimal value) {
            addCriterion("RENTPRICE =", value, "rentprice");
            return (Criteria) this;
        }

        public Criteria andRentpriceNotEqualTo(BigDecimal value) {
            addCriterion("RENTPRICE <>", value, "rentprice");
            return (Criteria) this;
        }

        public Criteria andRentpriceGreaterThan(BigDecimal value) {
            addCriterion("RENTPRICE >", value, "rentprice");
            return (Criteria) this;
        }

        public Criteria andRentpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RENTPRICE >=", value, "rentprice");
            return (Criteria) this;
        }

        public Criteria andRentpriceLessThan(BigDecimal value) {
            addCriterion("RENTPRICE <", value, "rentprice");
            return (Criteria) this;
        }

        public Criteria andRentpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RENTPRICE <=", value, "rentprice");
            return (Criteria) this;
        }

        public Criteria andRentpriceIn(List<BigDecimal> values) {
            addCriterion("RENTPRICE in", values, "rentprice");
            return (Criteria) this;
        }

        public Criteria andRentpriceNotIn(List<BigDecimal> values) {
            addCriterion("RENTPRICE not in", values, "rentprice");
            return (Criteria) this;
        }

        public Criteria andRentpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RENTPRICE between", value1, value2, "rentprice");
            return (Criteria) this;
        }

        public Criteria andRentpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RENTPRICE not between", value1, value2, "rentprice");
            return (Criteria) this;
        }

        public Criteria andDepositIsNull() {
            addCriterion("DEPOSIT is null");
            return (Criteria) this;
        }

        public Criteria andDepositIsNotNull() {
            addCriterion("DEPOSIT is not null");
            return (Criteria) this;
        }

        public Criteria andDepositEqualTo(BigDecimal value) {
            addCriterion("DEPOSIT =", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotEqualTo(BigDecimal value) {
            addCriterion("DEPOSIT <>", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThan(BigDecimal value) {
            addCriterion("DEPOSIT >", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DEPOSIT >=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThan(BigDecimal value) {
            addCriterion("DEPOSIT <", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DEPOSIT <=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositIn(List<BigDecimal> values) {
            addCriterion("DEPOSIT in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotIn(List<BigDecimal> values) {
            addCriterion("DEPOSIT not in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEPOSIT between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEPOSIT not between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andIsrentingIsNull() {
            addCriterion("ISRENTING is null");
            return (Criteria) this;
        }

        public Criteria andIsrentingIsNotNull() {
            addCriterion("ISRENTING is not null");
            return (Criteria) this;
        }

        public Criteria andIsrentingEqualTo(String value) {
            addCriterion("ISRENTING =", value, "isrenting");
            return (Criteria) this;
        }

        public Criteria andIsrentingNotEqualTo(String value) {
            addCriterion("ISRENTING <>", value, "isrenting");
            return (Criteria) this;
        }

        public Criteria andIsrentingGreaterThan(String value) {
            addCriterion("ISRENTING >", value, "isrenting");
            return (Criteria) this;
        }

        public Criteria andIsrentingGreaterThanOrEqualTo(String value) {
            addCriterion("ISRENTING >=", value, "isrenting");
            return (Criteria) this;
        }

        public Criteria andIsrentingLessThan(String value) {
            addCriterion("ISRENTING <", value, "isrenting");
            return (Criteria) this;
        }

        public Criteria andIsrentingLessThanOrEqualTo(String value) {
            addCriterion("ISRENTING <=", value, "isrenting");
            return (Criteria) this;
        }

        public Criteria andIsrentingLike(String value) {
            addCriterion("ISRENTING like", value, "isrenting");
            return (Criteria) this;
        }

        public Criteria andIsrentingNotLike(String value) {
            addCriterion("ISRENTING not like", value, "isrenting");
            return (Criteria) this;
        }

        public Criteria andIsrentingIn(List<String> values) {
            addCriterion("ISRENTING in", values, "isrenting");
            return (Criteria) this;
        }

        public Criteria andIsrentingNotIn(List<String> values) {
            addCriterion("ISRENTING not in", values, "isrenting");
            return (Criteria) this;
        }

        public Criteria andIsrentingBetween(String value1, String value2) {
            addCriterion("ISRENTING between", value1, value2, "isrenting");
            return (Criteria) this;
        }

        public Criteria andIsrentingNotBetween(String value1, String value2) {
            addCriterion("ISRENTING not between", value1, value2, "isrenting");
            return (Criteria) this;
        }

        public Criteria andCarimgIsNull() {
            addCriterion("CARIMG is null");
            return (Criteria) this;
        }

        public Criteria andCarimgIsNotNull() {
            addCriterion("CARIMG is not null");
            return (Criteria) this;
        }

        public Criteria andCarimgEqualTo(String value) {
            addCriterion("CARIMG =", value, "carimg");
            return (Criteria) this;
        }

        public Criteria andCarimgNotEqualTo(String value) {
            addCriterion("CARIMG <>", value, "carimg");
            return (Criteria) this;
        }

        public Criteria andCarimgGreaterThan(String value) {
            addCriterion("CARIMG >", value, "carimg");
            return (Criteria) this;
        }

        public Criteria andCarimgGreaterThanOrEqualTo(String value) {
            addCriterion("CARIMG >=", value, "carimg");
            return (Criteria) this;
        }

        public Criteria andCarimgLessThan(String value) {
            addCriterion("CARIMG <", value, "carimg");
            return (Criteria) this;
        }

        public Criteria andCarimgLessThanOrEqualTo(String value) {
            addCriterion("CARIMG <=", value, "carimg");
            return (Criteria) this;
        }

        public Criteria andCarimgLike(String value) {
            addCriterion("CARIMG like", value, "carimg");
            return (Criteria) this;
        }

        public Criteria andCarimgNotLike(String value) {
            addCriterion("CARIMG not like", value, "carimg");
            return (Criteria) this;
        }

        public Criteria andCarimgIn(List<String> values) {
            addCriterion("CARIMG in", values, "carimg");
            return (Criteria) this;
        }

        public Criteria andCarimgNotIn(List<String> values) {
            addCriterion("CARIMG not in", values, "carimg");
            return (Criteria) this;
        }

        public Criteria andCarimgBetween(String value1, String value2) {
            addCriterion("CARIMG between", value1, value2, "carimg");
            return (Criteria) this;
        }

        public Criteria andCarimgNotBetween(String value1, String value2) {
            addCriterion("CARIMG not between", value1, value2, "carimg");
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
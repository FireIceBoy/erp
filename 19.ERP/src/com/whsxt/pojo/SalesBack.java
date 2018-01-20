package com.whsxt.pojo;

import java.sql.Timestamp;

/**
 * 商品退货
 * 
 * @author pc
 */
public class SalesBack {
	private int id;
	private Customer customer;
	private String paytype;
	private Timestamp salesbacktime;
	private Operator operator;
	private int number;
	private String comment;
	private Goods goods;

	public SalesBack() {
		super();
	}

	public SalesBack(int id) {
		super();
		this.id = id;
	}

	public SalesBack(Customer customer, String paytype,
			Timestamp salesbacktime, Operator operator, int number,
			String comment, Goods goods) {
		super();
		this.customer = customer;
		this.paytype = paytype;
		this.salesbacktime = salesbacktime;
		this.operator = operator;
		this.number = number;
		this.comment = comment;
		this.goods = goods;
	}

	public SalesBack(int id, Customer customer, String paytype,
			Timestamp salesbacktime, Operator operator, int number,
			String comment, Goods goods) {
		super();
		this.id = id;
		this.customer = customer;
		this.paytype = paytype;
		this.salesbacktime = salesbacktime;
		this.operator = operator;
		this.number = number;
		this.comment = comment;
		this.goods = goods;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getPaytype() {
		return paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	public Timestamp getSalesbacktime() {
		return salesbacktime;
	}

	public void setSalesbacktime(Timestamp salesbacktime) {
		this.salesbacktime = salesbacktime;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	@Override
	public String toString() {
		return "SalesBack [id=" + id + ", customer=" + customer + ", paytype="
				+ paytype + ", salesbacktime=" + salesbacktime + ", operator="
				+ operator + ", number=" + number + ", comment=" + comment
				+ ", goods=" + goods + "]";
	}

}

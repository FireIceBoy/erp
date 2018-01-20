package com.whsxt.pojo;

import java.sql.Timestamp;

public class Sales {

	private int id;
	private Customer customer;
	private String paytype;
	private Timestamp salestime;
	private Operator operator;
	private int number;
	private String comment;
	private Goods goods;

	public Sales() {
		super();
	}

	public Sales(int id) {
		super();
		this.id = id;
	}

	public Sales(int id, Customer customer, String paytype,
			Timestamp salestime, Operator operator, int number, String comment,
			Goods goods) {
		super();
		this.id = id;
		this.customer = customer;
		this.paytype = paytype;
		this.salestime = salestime;
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

	public Timestamp getSalestime() {
		return salestime;
	}

	public void setSalestime(Timestamp salestime) {
		this.salestime = salestime;
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
		return "Sales [id=" + id + ", customer=" + customer + ", paytype="
				+ paytype + ", salestime=" + salestime + ", operator="
				+ operator + ", number=" + number + ", comment=" + comment
				+ ", goods=" + goods + "]";
	}

}

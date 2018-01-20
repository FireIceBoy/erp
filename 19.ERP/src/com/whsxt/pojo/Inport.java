package com.whsxt.pojo;

import java.sql.Timestamp;

public class Inport {
	private int id;
	// private int providerid;//供应商编号
	private int paytype;// 支付类型
	private Timestamp inporttime;// 进货时间
	private String operateperson;// 操作员(管理员表的name)
	private int number;
	private String comment;// 注释
	// private int goodsid;//商品编号
	private Provider provider;
	private Goods goods;

	public Inport() {
		super();
	}

	public Inport(int id, Timestamp inporttime, int number) {
		super();
		this.id = id;
		this.inporttime = inporttime;
		this.number = number;
	}

	public Inport(int id, int paytype, Timestamp inporttime,
			String operateperson, int number, String comment,
			Provider provider, Goods goods) {
		super();
		this.id = id;
		this.paytype = paytype;
		this.inporttime = inporttime;
		this.operateperson = operateperson;
		this.number = number;
		this.comment = comment;
		this.provider = provider;
		this.goods = goods;
	}

	public Inport(int id, Timestamp inporttime, String operateperson,
			int number, Goods goods) {
		super();
		this.id = id;
		this.inporttime = inporttime;
		this.operateperson = operateperson;
		this.number = number;
		this.goods = goods;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPaytype() {
		return paytype;
	}

	public void setPaytype(int paytype) {
		this.paytype = paytype;
	}

	public Timestamp getInporttime() {
		return inporttime;
	}

	public void setInporttime(Timestamp inporttime) {
		this.inporttime = inporttime;
	}

	public String getOperateperson() {
		return operateperson;
	}

	public void setOperateperson(String operateperson) {
		this.operateperson = operateperson;
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

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

}

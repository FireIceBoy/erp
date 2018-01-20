package com.whsxt.pojo;

public class Goods {

	private int gid;
	private String goodsname;
	private String produceplace;
	private String size;
	private String gpackage;
	private String productcode;
	private String promitcode;
	private String description;
	private double price;
	private Provider provider;
	private int available = 8;
	private int number;

	public Goods() {
		super();
	}

	public Goods(String goodsname) {
		super();
		this.goodsname = goodsname;
	}

	public Goods(int gid) {
		super();
		this.gid = gid;
	}

	public Goods(int gid, String goodsname) {
		super();
		this.gid = gid;
		this.goodsname = goodsname;
	}

	public Goods(int gid, int number) {
		super();
		this.gid = gid;
		this.number = number;
	}

	public Goods(String goodsname, String produceplace, String size,
			String gpackage, String productcode, String promitcode,
			String description, double price, Provider provider, int available,
			int number) {
		super();
		this.goodsname = goodsname;
		this.produceplace = produceplace;
		this.size = size;
		this.gpackage = gpackage;
		this.productcode = productcode;
		this.promitcode = promitcode;
		this.description = description;
		this.price = price;
		this.provider = provider;
		this.available = available;
		this.number = number;
	}

	public Goods(int gid, String goodsname, String produceplace, String size,
			String gpackage, String productcode, String promitcode,
			String description, double price, Provider provider, int available,
			int number) {
		super();
		this.gid = gid;
		this.goodsname = goodsname;
		this.produceplace = produceplace;
		this.size = size;
		this.gpackage = gpackage;
		this.productcode = productcode;
		this.promitcode = promitcode;
		this.description = description;
		this.price = price;
		this.provider = provider;
		this.available = available;
		this.number = number;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getProduceplace() {
		return produceplace;
	}

	public void setProduceplace(String produceplace) {
		this.produceplace = produceplace;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getGpackage() {
		return gpackage;
	}

	public void setGpackage(String gpackage) {
		this.gpackage = gpackage;
	}

	public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public String getPromitcode() {
		return promitcode;
	}

	public void setPromitcode(String promitcode) {
		this.promitcode = promitcode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", goodsname=" + goodsname
				+ ", produceplace=" + produceplace + ", size=" + size
				+ ", gpackage=" + gpackage + ", productcode=" + productcode
				+ ", promitcode=" + promitcode + ", description=" + description
				+ ", price=" + price + ", provider=" + provider
				+ ", available=" + available + ", number=" + number + "]";
	}

}

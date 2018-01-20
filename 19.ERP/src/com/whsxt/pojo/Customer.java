package com.whsxt.pojo;

/**
 * 客户，po
 * @author 金诚
 */
public class Customer {

	private int cid; // 客户编号
	private String customername; // 客户全称
	private String zip; // 客户邮编
	private String address; // 客户公司地址
	private String telephone; // 客户公司电话
	private String connectionperson; // 联系人
	private String phone; // 联系电话
	private String bank; // 卡户银行
	private String account; // 银行账号
	private String email; // 联系人信箱
	private String fax;  // 客户传真
	private int available = 8; // 客户状态，1可用，0不可用

	public Customer() {
		super();
	}

	public Customer(int cid) {
		super();
		this.cid = cid;
	}

	
	
	public Customer(int cid, String customername) {
		super();
		this.cid = cid;
		this.customername = customername;
	}

	public Customer(String customername, String zip, String address,
			String telephone, String connectionperson, String phone,
			String bank, String account, String email, String fax, int available) {
		super();
		this.customername = customername;
		this.zip = zip;
		this.address = address;
		this.telephone = telephone;
		this.connectionperson = connectionperson;
		this.phone = phone;
		this.bank = bank;
		this.account = account;
		this.email = email;
		this.fax = fax;
		this.available = available;
	}

	public Customer(int cid, String customername, String zip, String address,
			String telephone, String connectionperson, String phone,
			String bank, String account, String email, String fax, int available) {
		super();
		this.cid = cid;
		this.customername = customername;
		this.zip = zip;
		this.address = address;
		this.telephone = telephone;
		this.connectionperson = connectionperson;
		this.phone = phone;
		this.bank = bank;
		this.account = account;
		this.email = email;
		this.fax = fax;
		this.available = available;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getConnectionperson() {
		return connectionperson;
	}

	public void setConnectionperson(String connectionperson) {
		this.connectionperson = connectionperson;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", customername=" + customername
				+ ", zip=" + zip + ", address=" + address + ", telephone="
				+ telephone + ", connectionperson=" + connectionperson
				+ ", phone=" + phone + ", bank=" + bank + ", account="
				+ account + ", email=" + email + ", fax=" + fax
				+ ", available=" + available + "]";
	}
	
	
	

}

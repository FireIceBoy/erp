package com.whsxt.pojo;

public class Provider {
	private int pid;
	private String providername;// 供应商全称
	private String zip;// 供应商邮编
	private String address;
	private String telephone;
	private String connectionperson;// 联系人
	private String phone;
	private String bank;// 开户银行
	private String account;// 银行账号
	private String email;
	private String fax;// 公司传真
	private int available = 8;// 状态0不可用,1可用

	public Provider() {
		super();
	}

	public Provider(String providername) {
		super();
		this.providername = providername;
	}

	public Provider(int pid) {
		super();
		this.pid = pid;
	}

	public Provider(int pid, String providername) {
		super();
		this.pid = pid;
		this.providername = providername;
	}

	public Provider(String providername, String zip, String address,
			String telephone, String connectionperson, String phone,
			String bank, String account, String email, String fax, int available) {
		super();
		this.providername = providername;
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

	public Provider(int pid, String providername, String zip, String address,
			String telephone, String connectionperson, String phone,
			String bank, String account, String email, String fax, int available) {
		super();
		this.pid = pid;
		this.providername = providername;
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

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProvidername() {
		return providername;
	}

	public void setProvidername(String providername) {
		this.providername = providername;
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
		return "Provider [pid=" + pid + ", providername=" + providername
				+ ", zip=" + zip + ", address=" + address + ", telephone="
				+ telephone + ", connectionperson=" + connectionperson
				+ ", phone=" + phone + ", bank=" + bank + ", account="
				+ account + ", email=" + email + ", fax=" + fax
				+ ", available=" + available + "]";
	}

}

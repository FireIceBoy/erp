package com.whsxt.pojo;

public class Operator {

	private int uid;
	private String username;
	private String password;
	private String name;
	private String power;

	public Operator() {
		super();
	}

	public Operator(int uid) {
		super();
		this.uid = uid;
	}
	
	
	

	public Operator(String name) {
		super();
		this.name = name;
	}

	public Operator(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	

	public Operator(int uid, String username, String password, String name,
			String power) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.name = name;
		this.power = power;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	@Override
	public String toString() {
		return "Operator [uid=" + uid + ", username=" + username
				+ ", password=" + password + ", name=" + name + ", power="
				+ power + "]";
	}
	
	
	

}

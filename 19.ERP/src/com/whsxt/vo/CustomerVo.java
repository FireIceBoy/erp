package com.whsxt.vo;

import com.whsxt.pojo.Customer;

public class CustomerVo extends Customer {

	private String keywords;

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
		super.setPhone(keywords);
		super.setTelephone(keywords);
		super.setConnectionperson(keywords);
	}

}

package com.whsxt.vo;

import com.whsxt.pojo.Operator;

public class OperatorVo extends Operator {
	/**
	 * 判断是否一周免登陆
	 */
	private String memory;
	private String code;
	
	
	
	

	

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}

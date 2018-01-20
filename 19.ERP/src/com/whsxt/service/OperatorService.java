package com.whsxt.service;

import com.whsxt.pojo.Operator;

public interface OperatorService {

	// 查询
	Operator query(Operator operator);

	// 修改
	void update(Operator operator);

}

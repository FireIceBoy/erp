package com.whsxt.dao;

import com.whsxt.pojo.Operator;

/**
 * 管理员，操作数据库，接口
 * @author 金诚
 */
public interface OperatorDao {

	// 查询
	Operator query(Operator operator);

	// 修改
	void update(Operator operator);
	
}

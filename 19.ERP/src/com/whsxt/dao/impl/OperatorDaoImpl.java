package com.whsxt.dao.impl;

/**
 * 管理员，操作数据库，实现类
 * @author 金诚
 */

import com.whsxt.dao.OperatorDao;
import com.whsxt.pojo.Operator;
import com.whsxt.utils.DBUtils;

public class OperatorDaoImpl extends BaseDaoImpl<Operator> implements
		OperatorDao {

	public Operator query(Operator operator) {
		String sql = "select * from tb_operator where username=? and password=?";
		Object[] objs = {operator.getUsername(),operator.getPassword()};
		return this.getBean(sql, objs, Operator.class);
	}

	@Override
	public void update(Operator operator) {
		String sql = "update tb_operator set username=?,password=?,name=?,power=? where uid=?";
		Object[] objs = {operator.getUsername(),operator.getPassword(),operator.getName(),operator.getPower(),operator.getUid()};
		DBUtils.executeUpdate(sql, objs);
	}

}

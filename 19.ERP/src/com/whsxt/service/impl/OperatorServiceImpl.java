package com.whsxt.service.impl;

import com.whsxt.dao.OperatorDao;
import com.whsxt.dao.impl.OperatorDaoImpl;
import com.whsxt.pojo.Operator;
import com.whsxt.service.OperatorService;

public class OperatorServiceImpl implements OperatorService {

	// dao
	OperatorDao operatorDao = new OperatorDaoImpl();

	public Operator query(Operator operator) {

		return operatorDao.query(operator);
	}

	@Override
	public void update(Operator operator) {
		operatorDao.update(operator);
	}

}

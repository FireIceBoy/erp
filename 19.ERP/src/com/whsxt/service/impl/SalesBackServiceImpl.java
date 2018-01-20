package com.whsxt.service.impl;

import java.util.List;

import com.whsxt.dao.SalesBackDao;
import com.whsxt.dao.impl.SalesBackDaoImpl;
import com.whsxt.pojo.Sales;
import com.whsxt.pojo.SalesBack;
import com.whsxt.service.SalesBackService;
import com.whsxt.utils.bean.PageBean;
import com.whsxt.vo.SalesBackVo;

public class SalesBackServiceImpl implements SalesBackService {

	//
	SalesBackDao salesBackDao = new SalesBackDaoImpl();

	@Override
	public List<SalesBack> query(PageBean pageBean, SalesBackVo salesBackVo) {
		// 判断当前页是否为0
		if (0 == pageBean.getCurrentPage()) {
			pageBean.setCurrentPage(1);
		}

		if (null == salesBackVo.getPaytype()) {
			salesBackVo.setPaytype("");
		}

		if (null == salesBackVo.getStime()) {
			salesBackVo.setStime("");
		}

		if (null == salesBackVo.getEtime()) {
			salesBackVo.setEtime("");
		}
		return salesBackDao.query(pageBean, salesBackVo);
	}

	@Override
	public void add(SalesBack salesBack) {

		salesBackDao.add(salesBack);
	}

	

}

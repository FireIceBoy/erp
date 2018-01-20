package com.whsxt.service.impl;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.whsxt.dao.SalesDao;
import com.whsxt.dao.impl.SalesDaoImpl;
import com.whsxt.pojo.Sales;
import com.whsxt.service.SalesService;
import com.whsxt.utils.bean.PageBean;
import com.whsxt.vo.SalesVo;

public class SalesServiceImpl implements SalesService {

	//
	SalesDao salesDao = new SalesDaoImpl();

	@Override
	public List<Sales> query(PageBean pageBean, SalesVo salesVo) {
		// 判断当前页是否为0
		if (0 == pageBean.getCurrentPage()) {
			pageBean.setCurrentPage(1);
		}

		/**
		if (null == salesVo.getPaytype()) {
			salesVo.setPaytype("");
		}
		 **/
		if (null == salesVo.getStime()) {
			salesVo.setStime("");
		}

		if (null == salesVo.getEtime()) {
			salesVo.setEtime("");
		}
		return salesDao.query(pageBean, salesVo);
	}

	@Override
	public void add(Sales sales) {

		salesDao.add(sales);
	}

	@Override
	public SalesVo queryById(int id) {
		Sales sales = salesDao.queryById(id);
		SalesVo salesVo = new SalesVo();
		try {
			BeanUtils.copyProperties(salesVo, sales);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return salesVo;
	}

	@Override
	public void update(Sales sales) {
		salesDao.update(sales);
		
	}

}
